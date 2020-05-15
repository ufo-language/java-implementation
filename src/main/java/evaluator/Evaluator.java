package main.java.evaluator;

import main.java.data.D_Binding;
import main.java.data.D_Exception;
import main.java.data.D_HashTable;
import main.java.data.D_List;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.expr.E_Identifier;
import main.java.namespace.Load;
import main.java.show.Show;
import main.java.thread.MessageQueue;
import main.java.util.UFOException;

public class Evaluator extends Obj {

  // Static variables ===============================================

  public static final D_HashTable GLOBALS = D_HashTable.create();
  public static final D_HashTable SUPER_GLOBALS = D_HashTable.create();
  public static boolean showDebug;

  private static int _nextId = 0;
  private static final int N_STEPS = 1;

  // Instance variables =============================================

  public EvaluatorStatus status;

  private int _id;
  private D_List _env = D_List.EMPTY;
  private D_List _objStack = D_List.EMPTY;
  private D_List _exprStack = D_List.EMPTY;
  private D_Queue _messageQ = D_Queue.create();
  private int _nSteps = N_STEPS;
  private MessageQueue _resMsgQ;
  private RunQueue _runQ;
  private D_Queue _waitingForValue = D_Queue.create();
  private Obj _finalValue = null;

  // Static inner classes ===========================================

  public enum EvaluatorStatus { READY, RUNNING, BLOCKED, SLEEPING, FINISHED, ERROR };

  // Static methods =================================================

  public static Evaluator create() {
    return new Evaluator(null, null);
  }

  public static Evaluator create(RunQueue runQ) {
    return new Evaluator(null, runQ);
  }

  public static Evaluator create(MessageQueue resMsgQ, RunQueue runQ) {
    return new Evaluator(resMsgQ, runQ);
  }

  // Constructors ===================================================

  private Evaluator(MessageQueue resMsgQ, RunQueue runQ) {
    _id = _nextId++;
    _resMsgQ = resMsgQ;
    _runQ = runQ;
    setupEnv();
  }

  // Instance methods ===============================================

  public void bind(E_Identifier ident, Obj value) {
    _env = _env.bind(ident, value);
  }

  public void blockOn(Object obj) {
    _runQ.blockOn(this, obj);
  }

  public void blockOnReceive() {
    _runQ.blockOn(this, this._messageQ);
  }

  public D_List getEnv() {
    return _env;
  }

  public D_List getExprStack() {
    return _exprStack;
  }

  public Obj getFinalValue() {
    return _finalValue;
  }

  public D_List getObjStack() {
    return _objStack;
  }

  public int getId() {
    return _id;
  }

  public RunQueue getRunQueue() {
    return _runQ;
  }

  public Obj lookup(E_Identifier ident) {
    Obj value = _env.lookup(ident);
    if(value == null) {
      value = GLOBALS.get(ident);
      if(value == null)
        value = SUPER_GLOBALS.get(ident);
    }
    return value;
  }

  public Obj popExpr() {
    D_List pair = (D_List)_exprStack.first();
    Obj expr = pair.first();
    Obj envObj = pair.rest();
    if(envObj instanceof D_List) {
      _env = (D_List)envObj;
    }
    _exprStack = (D_List)_exprStack.rest();
    return expr;
  }

  public Obj popObj() {
    if(_objStack.isEmpty())
      throw UFOException.evaluatorObjectStackEmpty(this);
    Obj obj = _objStack.first();
    _objStack = (D_List)_objStack.rest();
    return obj;
  }

  public void pushExpr(Obj expr) {
    pushExpr(expr, _env);
  }

  public void pushExpr(Obj expr, Obj env) {
    D_List pair = D_List.create(expr, env);
    _exprStack = D_List.create(pair, _exprStack);
  }

  public void pushObj(Obj obj) {
    _objStack = D_List.create(obj, _objStack);
  }

  public boolean rebind(D_Binding binding) {
    return rebind((E_Identifier)binding.key, binding.value);
  }

  public boolean rebind(E_Identifier ident, Obj value) {
    return _env.rebind(ident, value);
  }

  public Obj receiveMessage_noWait() {
    return _messageQ.deq();
  }

  public Obj receiveMessage_noWait(Obj pattern) {
    if(pattern == null)
      return _messageQ.deq();
    return _messageQ.deq(pattern);
  }

  public Obj receiveMessage_wait() {
    Obj msg = null;
    while(true) {
      msg = _messageQ.deq();
      if(msg != null)
        break;
      this.blockOn(_messageQ);
    }
    return msg;
  }

  public Obj receiveMessage_wait(Obj pattern) {
    Obj msg = null;
    Show.showln("Evaluator.receiveMessage_wait(pattern) not finished");
    while(msg == null) {
      break;
    }
    return msg;
  }

  public void reset(D_List env) {
    _objStack = D_List.EMPTY;
    _exprStack = D_List.EMPTY;
    _env = env;
    status = EvaluatorStatus.READY;
  }

  public void resume() {
    _runQ.resumeEvaluator(this);
  }

  public void run() {
    while(!_exprStack.isEmpty())
      step();
  }
  
  public void runTimeslice() {
    try {
      runTimeslice_aux();
    }
    catch(Throwable cause) {
      D_Exception exn = D_Exception.create(cause);
      status = EvaluatorStatus.ERROR;
      _resMsgQ.enq(exn);
    }
  }

  public void runTimeslice_aux() {
    int n = _nSteps;
    while(status == EvaluatorStatus.RUNNING) {
      if(_exprStack.isEmpty()) {
        _onThreadFinished();
        break;
      }
      if(n-- <= 0)
        break;
      step();
    }
  }

  public void sendMessage(Obj msg) {
    _messageQ.enq(msg);
    _runQ.resumeEvaluators(_messageQ);
  }

  public void setEnv(D_List bindings) {
    _env = bindings;
  }

  public void setupEnv() {
    Load.allPrims();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_id).append(", ");
    if(_exprStack.isEmpty())
      _exprStack.show(sb);
    else
      ((D_List)_exprStack.first()).first().show(sb);
    sb.append('}');
  }

  public void step() {
    Obj expr = popExpr();
    if(showDebug)
      Show.showln("[", String.format("%04X", _id), "] Evaluating ",
          expr, " :: ", expr.typeName(),
          ", oStack = ", _objStack,
          ", eStack = ", _exprStack.count());
    expr.eval(this);
  }

  public void terminate() {
    this.status = EvaluatorStatus.FINISHED;
    this._runQ.terminateEvaluator(this);
  }

  public Obj topObj() {
    if(_objStack.isEmpty())
      throw UFOException.evaluatorObjectStackEmpty(this);
    return _objStack.first();
  }

  public void waitForValue(Evaluator etor) {
    _waitingForValue.enq(etor);
    etor.status = EvaluatorStatus.BLOCKED;
  }

  private void _onThreadFinished() {
    status = EvaluatorStatus.FINISHED;
    _finalValue = popObj();
    if(_resMsgQ != null)
      _resMsgQ.enq(_finalValue);
    while(!_waitingForValue.isEmpty()) {
      Evaluator etor = (Evaluator)_waitingForValue.deq();
      etor.pushObj(_finalValue);
      etor.resume();
    }
  }

}

package main.java.main.rep;

import main.java.data.D_Exception;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.RunQueue;
import main.java.expr.E_Identifier;
import main.java.io.StdIn;
import main.java.parser.ParserEntry;
import main.java.show.Show;
import main.java.thread.MessageQueue;
import main.java.util.UFOException;

public class REPLoop implements Runnable {

  // Static variables ===============================================

  private static final String _PROMPT = About.appName() + "> ";
  private static final E_Identifier _IT = E_Identifier.create("it");

  // Instance variables =============================================

  private String _inputString = "";
  private D_List _exprs;
  private Obj _expr;
  private Obj _res = D_Nil.NIL;
  private MessageQueue _resMsgQ = new MessageQueue();
  private MessageQueue _stdInMsgQ = new MessageQueue();
  private RunQueue _runQ;
  private Evaluator _etor;
  private D_List _savedEnv;
  private boolean _contin = true;
  private Thread _thread;
  private Throwable _exn;

  // Constructors ===================================================

  public REPLoop(RunQueue runQueue) {
    super();
    _runQ = runQueue;
    _etor = Evaluator.create(_resMsgQ, _runQ);
  }

  // Instance methods ===============================================

  public Throwable getLastException() {
    return _exn;
  }

  public Obj getLastExpr() {
    return _expr;
  }

  public void join() {
    try {
      _thread.join();
    }
    catch(InterruptedException exn) {
      exn.printStackTrace();
    }
  }

  public String read() {
    StringBuilder sb = new StringBuilder();
    String prompt = _PROMPT;
    while(true) {
      Show.show(prompt);
      String s;
      try {
        s = StdIn.STDIN.readLine(_stdInMsgQ);
      }
      catch(Exception exn) {
        s = null;
      }
      if(s == null)
        return null;
      if(!s.endsWith("\\")) {
        sb.append(s);
        break;
      }
      sb.append(s.subSequence(0, s.length() - 1));
      sb.append('\n');
      prompt = "...> ";
    }
    return sb.toString();
  }

  public void repLoop() {
    while(_contin) {
      String inputString = read();
      if(inputString == null)
        break;
      inputString = inputString.strip();
      if(inputString.isBlank())
        continue;
      if(inputString.startsWith(":")) {
        String res = _handleColonCommand(inputString);
        if(res == null)
          continue;
        inputString = res;
      }
      _inputString = inputString.strip();
      _parse();
      if(_exprs != null) {
        _evalEach();
        _print();
      }
    }
  }

  @Override
  public void run() {
    Logo.logo();
    repLoop();
    Show.nl();
  }

  public void start() {
    _thread = new Thread(this);
    _thread.start();
  }

  public void terminate() {
    _contin = false;
    _thread.interrupt();
  }

  private void _evalEach() {
    for(Obj expr : _exprs) {
      _expr = expr;
      if(!_eval())
        break;
    }
  }

  private boolean _eval() {
    _etor.pushExpr(_expr);
    _savedEnv = _etor.getEnv();
    _runQ.enqEvaluator(_etor);
    _res = _resMsgQ.deq();
    if(_res instanceof D_Exception) {
      _etor.setEnv(_savedEnv);
      _exn = ((D_Exception)_res).getCause();
      return false;
    }
    Evaluator.SUPER_GLOBALS.set(_IT, _res);
    return true;
  }

  private String _handleColonCommand(String cmd) {
    try {
      return HandleColonCommands.activate(cmd, this, _etor);
    }
    catch(UFOException exn) {
      exn.show();
      return null;
    }
  }

  private void _parse() {
    try {
      _exprs = null;
      _exprs = ParserEntry.parse(_inputString);
    }
    catch(UFOException exn) {
      exn.show();
      _expr = null;
    }
    catch(Exception exn) {
      Show.showln("Error:");
      Show.showln(exn.getMessage());
      exn.printStackTrace();
      _expr = null;
    }
  }

  private void _print() {
    if(_res instanceof D_Exception) {
      D_Exception exn = (D_Exception)_res;
      Throwable cause = exn.getCause();
      if(cause instanceof UFOException)
        ((UFOException)cause).show();
      else {
        Show.showln("ERROR");
        Show.showln(cause.getMessage());
      }
      _etor.reset(_savedEnv);
    }
    else if(_res == null) {
      System.err.println("REPLoop._res == null; this should not happen");
      _res = D_Nil.NIL;
    }
    else if(_res != D_Nil.NIL)
      Show.showln(_res, " :: ", _res.typeName());
  }

}

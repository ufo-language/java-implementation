package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Closure;
import main.java.data.D_HashTable;
import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable.EvaluationOrder;

public class E_Abstraction extends Obj {

  // Instance variables =============================================

  private D_List _params;
  private Obj[] _body;
  private EvaluationOrder _evalOrder;
  private E_Abstraction _next;
  private D_HashTable _memoHash;

  // Static methods =================================================

  public static E_Abstraction create(D_List params, Obj[] body) {
    return new E_Abstraction(params, body, EvaluationOrder.APPLICATIVE);
  }

  public static E_Abstraction createMacro(D_List params, Obj[] body) {
    return new E_Abstraction(params, body, EvaluationOrder.NORMAL);
  }

  // Constructors ===================================================

  protected E_Abstraction(D_List params, Obj[] body, EvaluationOrder evalOrder) {
    _params = params;
    _body = body;
    _evalOrder = evalOrder;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_Closure closure = D_Closure.create(this);
    closure.close(etor);
    etor.pushObj(closure);
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj obj : _body)
      obj.freeVars(vars);
    D_Set paramVars = D_Set.create();
    _params.freeVars(paramVars);
    vars.removeEach(paramVars);
    if(_next != null)
      _next.freeVars(vars);
  }

  public Obj[] getBody() {
    return _body;
  }

  public E_Abstraction getNext() {
    return _next;
  }

  public D_List getParams() {
    return _params;
  }

  public EvaluationOrder getEvalOrder() {
    return _evalOrder;
  }

  public Obj getMemo(Obj args) {
    Obj res = null;
    if(_memoHash != null)
      res = _memoHash.getKey(args, null);
    return res;
  }

  public D_HashTable getMemoHash() {
    return _memoHash;
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Abstraction.class, _params, _body, _next);
  }

  public void saveMemo(Obj args, Obj value) {
    if(_memoHash != null)
      _memoHash.set(args, value);
  }

  public void setMemoized(boolean b) {
    if(b)
      _memoHash = D_HashTable.create();
    else
      _memoHash = null;
  }

  public void setNext(E_Abstraction rule) {
    _next = rule;
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("fun");
    showAux(sb, this);
    sb.append(" end");
  }
  
  private void showAux(StringBuilder sb, E_Abstraction abstr) {
    abstr._params.show(sb, "(", ")");
    D_Array.show(sb, abstr._body, " = ", "", "; ");
    if(abstr._next != null) {
      sb.append(" | ");
      showAux(sb, abstr._next);
    }
  }

}

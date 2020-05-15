package main.java.expr.contin;

import main.java.data.D_Array;
import main.java.data.D_Nil;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Do;

public  class C_While extends Obj {

  // Instance variables =============================================

  private Obj _cond;
  private E_Do _body;
  private Obj _lastValue = D_Nil.NIL;
  private boolean _firstIter = true;

  // Constructors ===================================================

  public C_While(Obj cond, E_Do body) {
    _cond = cond;
    _body = body;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj condVal = etor.popObj();
    if(_firstIter)
      _firstIter = false;
    else
      _lastValue = etor.popObj();
    if(condVal.boolValue()) {
      etor.pushExpr(this);;
      etor.pushExpr(_cond);
      etor.pushExpr(_body);
    }
    else
      etor.pushObj(_lastValue);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName());
    D_Array.show(sb, _body.getExprs(), "{", "}");
  }

}

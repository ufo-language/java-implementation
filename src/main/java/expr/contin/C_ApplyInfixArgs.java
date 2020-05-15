package main.java.expr.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;

public class C_ApplyInfixArgs extends Obj {

  // Instance variables =============================================

  private Applyable _oper;

  // Constructors ===================================================

  public C_ApplyInfixArgs(Applyable oper) {
    _oper = oper;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj rhs = etor.popObj();
    Obj lhs = etor.popObj();
    D_List args = D_List.createN(lhs, rhs);
    _oper.apply(etor, args);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_oper).append('}');
  }

}

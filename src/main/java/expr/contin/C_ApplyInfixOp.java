package main.java.expr.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.Applyable.EvaluationOrder;
import main.java.util.UFOException;

public class C_ApplyInfixOp extends Obj {

  // Instance variables =============================================

  private Obj _lhs, _rhs;

  // Constructors ===================================================

  public C_ApplyInfixOp(Obj lhs, Obj rhs) {
    _lhs = lhs;
    _rhs = rhs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj oper = etor.popObj();
    if(!(oper instanceof Applyable))
      throw UFOException.notAnAbstraction(oper);
    Applyable abstr = (Applyable)oper;
    if(abstr.getEvaluationOrder() == EvaluationOrder.NORMAL) {
      D_List args = D_List.createN(_lhs, _rhs);
      abstr.apply(etor, args);
    }
    else {
      etor.pushExpr(new C_ApplyInfixArgs((Applyable)oper));
      etor.pushExpr(_rhs);
      etor.pushExpr(_lhs);
    }
  }

}

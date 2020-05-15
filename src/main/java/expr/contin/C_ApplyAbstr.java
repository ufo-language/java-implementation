package main.java.expr.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.Applyable.EvaluationOrder;
import main.java.util.UFOException;

/**
 * This is the first phase of applying an abstraction to arguments.
 * This continuation is called after evaluating the abstraction.
 * If the abstraction value is a function, then the arguments are evaluated.
 * If the abstraction value is a macro, then the arguments are not evaluated.
 */
public class C_ApplyAbstr extends Obj {

  // Instance variables =============================================

  private D_List _args;

  // Static methods =================================================

  public static C_ApplyAbstr create(D_List args) {
    return new C_ApplyAbstr(args);
  }

  // Constructors ===================================================

  private C_ApplyAbstr(D_List args) {
    _args = args;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj abstrObj = etor.popObj();
    if(!(abstrObj instanceof Applyable))
      throw UFOException.notAnAbstraction(abstrObj);
    Applyable abstr = (Applyable)abstrObj;
    if(abstr.getEvaluationOrder() == EvaluationOrder.NORMAL)
      abstr.apply(etor, _args);
    else {
      etor.pushExpr(C_ApplyArgs.create(abstr));
      etor.pushExpr(_args);
    }
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append("{}");
  }

}

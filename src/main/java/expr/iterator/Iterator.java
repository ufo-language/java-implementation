package main.java.expr.iterator;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;

public abstract class Iterator extends Obj implements Applyable {

  // Static variables ===============================================

  private static final D_List[] _PARAMS = { D_List.EMPTY };

  // Instance methods ===============================================

  public void apply(Evaluator eval, D_List args) {
    apply(eval);
  }

  public abstract void apply(Evaluator eval);

  @Override
  public EvaluationOrder getEvaluationOrder() {
    return EvaluationOrder.APPLICATIVE;
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

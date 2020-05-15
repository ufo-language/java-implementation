package main.java.expr;

import main.java.data.D_List;
import main.java.evaluator.Evaluator;

public interface Applyable {

  // Static inner classes ===========================================

  public static enum EvaluationOrder {
    APPLICATIVE,  // arguments are evaluated before the function is evaluated
    NORMAL        // arguments are not evaluated
  };

  // Instance methods ===============================================

  void apply(Evaluator etor, D_List args);
  EvaluationOrder getEvaluationOrder();
  D_List[] getParameters();

}

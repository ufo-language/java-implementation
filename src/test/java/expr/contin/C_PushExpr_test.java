package test.java.expr.contin;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_PushExpr;

public class C_PushExpr_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_withAnIdentifier_bindsRhsToIdentifier() {
    // setup
    D_Integer expr = D_Integer.create(100);
    C_PushExpr pushExpr = C_PushExpr.create(expr);
    _evaluator.pushObj(pushExpr);

    // test
    pushExpr.eval(_evaluator);

    // validate
    Object expr1 = _evaluator.popExpr();
    assertEquals(expr, expr1);
  }

}

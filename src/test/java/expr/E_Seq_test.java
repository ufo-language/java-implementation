package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.data.D_Nil;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Do;
import main.java.expr.contin.C_Drop;

public class E_Seq_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_withNoExpressions_pushesNothing() {
    // setup
    E_Do seq = E_Do.create();

    // test
    seq.eval(_evaluator);

    // validate
    Obj obj = _evaluator.popObj();
    assertEquals(D_Nil.NIL, obj);
  }

  @Test
  public void eval_withOneExpression_pushesTheExpression() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    E_Do seq = E_Do.create(i100);

    // test
    seq.eval(_evaluator);

    // validate
    Obj obj1 = _evaluator.popExpr();
    assertEquals(i100, obj1);
  }

  @Test
  public void eval_withTwoExpressions_pushesExpressionsAndDrop() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    E_Do seq = E_Do.create(i100, i200);

    // test
    seq.eval(_evaluator);

    // validate
    assertEquals(_evaluator.popExpr(), i100);
    assertTrue(_evaluator.popExpr() instanceof C_Drop);
    assertEquals(_evaluator.popExpr(), i200);
  }

}

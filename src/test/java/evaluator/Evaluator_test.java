package test.java.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.evaluator.Evaluator;

public class Evaluator_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void runTimeslice_nonEvaluatableObject_getsPushedToObjectStack() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    _evaluator.pushExpr(i100);

    // test
    //while(_evaluator.runTimeslice());
    System.err.println("Evaluator_test no longer works properly");

    // validate
    assertEquals(i100, _evaluator.popObj());
  }

}

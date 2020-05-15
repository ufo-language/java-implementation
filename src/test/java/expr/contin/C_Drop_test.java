package test.java.expr.contin;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_Drop;

public class C_Drop_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void create() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    C_Drop drop = C_Drop.create();
    _evaluator.pushObj(i100);
    _evaluator.pushObj(i200);

    // test
    drop.eval(_evaluator);

    // validate
    assertEquals(i100, _evaluator.popObj());
  }

}

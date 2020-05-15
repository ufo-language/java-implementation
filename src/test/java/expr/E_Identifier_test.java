package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.i18n.Strings;
import main.java.util.UFOException;

public class E_Identifier_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }
  
  @Test
  public void create() {
    // test
    E_Identifier x1 = E_Identifier.create("x");
    E_Identifier x2 = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");

    // validate
    assertTrue(x1 == x2);
    assertFalse(x1 == y);
  }

  @Test
  public void eval_boundIdentifier_returnsValue() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    _evaluator.bind(x, i100);

    // test
    x.eval(_evaluator);

    // validate
    assertEquals(i100, _evaluator.popObj());
  }

  @Test
  public void eval_unboundIdentifier_throwsException() {
    // setup
    E_Identifier x = E_Identifier.create("x");

    // test
    Exception exception = assertThrows(UFOException.class, () -> {
      x.eval(_evaluator);
    });

    // validate
    String expected = Strings.format("UnboundIdentifier", x);
    assertEquals(expected, exception.getMessage());
  }

}

package test.java.expr;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.expr.E_Quote;

public class E_Quote_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_pushesQuotedExpr() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Quote quote = E_Quote.create(x);

    // test
    quote.eval(_evaluator);

    // validate
    Obj obj1 = _evaluator.popObj();
    assertEquals(x, obj1);
  }

}

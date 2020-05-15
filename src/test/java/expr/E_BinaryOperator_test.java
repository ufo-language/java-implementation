package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_InfixExpr;
import main.java.expr.E_Identifier;
import main.java.expr.contin.C_ApplyAbstr;

public class E_BinaryOperator_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier plus = E_Identifier.create("+");
    E_Identifier y = E_Identifier.create("y");
    E_InfixExpr op = E_InfixExpr.create(x, plus, y);

    // test
    op.eval(_evaluator);

    // validate
    Obj obj = _evaluator.popExpr();
    assertTrue(obj instanceof D_List);
    D_List args = (D_List)obj;
    assertEquals(x, args.first());
    assertEquals(y, args.rest());
    obj = _evaluator.popExpr();
    assertEquals(plus, obj);
    obj = _evaluator.popExpr();
    assertTrue(obj instanceof C_ApplyAbstr);
  }

}

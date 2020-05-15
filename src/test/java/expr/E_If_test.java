package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Boolean;
import main.java.data.D_Integer;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_If;
import main.java.expr.contin.C_Select;

public class E_If_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_pushesCondAndSelect() {
    // setup
    D_Boolean cond = D_Boolean.create(true);
    Obj[] conseq = new Obj[] { D_Integer.create(100) };
    Obj[] alt = new Obj[] { D_Integer.create(200) };
    E_If if1 = E_If.create(cond, conseq, alt);

    // test
    if1.eval(_evaluator);

    // validate
    Obj obj1 = _evaluator.popExpr();
    Obj obj2 = _evaluator.popExpr();
    assertEquals(cond, obj1);
    assertTrue(obj2 instanceof C_Select);
  }

}

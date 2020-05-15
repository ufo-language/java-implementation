package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.expr.E_Let;
import main.java.expr.contin.C_MatchBind;

public class E_Let_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_pushesMatchBinds() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_Binding binding1 = D_Binding.create(x, i100);
    D_Binding binding2 = D_Binding.create(y, i200);
    E_Let let = E_Let.create(binding1, binding2);

    // test
    let.eval(_evaluator);

    // validate
    Obj e1 = _evaluator.popExpr();
    Obj e2 = _evaluator.popExpr();
    Obj e3 = _evaluator.popExpr();
    Obj e4 = _evaluator.popExpr();

    assertEquals(i100, e1);
    assertTrue(e2 instanceof C_MatchBind);
    assertEquals(x, ((C_MatchBind)e2).lhs);

    assertEquals(i200, e3);
    assertTrue(e4 instanceof C_MatchBind);
    assertEquals(y, ((C_MatchBind)e4).lhs);
  }

  @Test
  public void run_bindsValuesToIdents() {
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_Binding binding1 = D_Binding.create(x, i100);
    D_Binding binding2 = D_Binding.create(y, i200);
    E_Let let = E_Let.create(binding1, binding2);
    _evaluator.pushExpr(let);

    // test
    _evaluator.run();
    
    // validate
    Obj val1 = _evaluator.lookup(x);
    assertEquals(i100, val1);
    Obj val2 = _evaluator.lookup(y);
    assertEquals(i200, val2);
  }

}

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
import main.java.expr.E_LetIn;
import main.java.expr.contin.C_MatchBind;
import main.java.expr.contin.C_PushExpr;

public class E_LetIn_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_pushesMatchBindsAndBody() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_Binding binding1 = D_Binding.create(x, i100);
    D_Binding binding2 = D_Binding.create(y, i200);
    E_Identifier body = E_Identifier.create("z");
    E_LetIn letIn = E_LetIn.create(new D_Binding[] { binding1, binding2 }, new Obj[] { body });

    // test
    letIn.eval(_evaluator);

    // validate
    assertEquals(i200, _evaluator.popExpr());
    Obj mbObj2 = _evaluator.popExpr();
    assertTrue(mbObj2 instanceof C_MatchBind);
    assertEquals(y, ((C_MatchBind)mbObj2).lhs);

    assertEquals(i100, _evaluator.popExpr());
    Obj mbObj1 = _evaluator.popExpr();
    assertTrue(mbObj1 instanceof C_MatchBind);
    assertEquals(x, ((C_MatchBind)mbObj1).lhs);
    
    Obj bodyObj = _evaluator.popExpr();
    assertTrue(bodyObj instanceof C_PushExpr);
    assertEquals(body, ((C_PushExpr)bodyObj).expr);
  }

  @Test
  public void run_bindsValuesToIdentsAndEvalsBody() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    D_Binding binding = D_Binding.create(x, i100);
    E_LetIn letIn = E_LetIn.create(new D_Binding[] { binding }, new Obj[] { x });
    _evaluator.pushExpr(letIn);

    // test
    //while(_evaluator.runTimeslice());
    System.err.println("E_LetIn_test no longer runs properly");

    // validate
    Obj val1 = _evaluator.lookup(x);
    assertEquals(i100, val1);
    Obj res1 = _evaluator.popObj();
    assertEquals(val1, res1);
  }

}

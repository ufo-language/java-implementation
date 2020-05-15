package test.java.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Closure;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Abstraction;
import main.java.expr.E_Application;
import main.java.expr.E_Identifier;
import main.java.expr.contin.C_ApplyAbstr;

public class E_Application_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);

    D_List params = D_List.create(x);
    D_List body = D_List.create(x, y);
    E_Abstraction abstr = E_Abstraction.create(params, body.asRawArray());

    D_Binding yBinding = D_Binding.create(y, i200);
    D_List lexEnv = D_List.create(yBinding);
    D_Closure closure = D_Closure.create(abstr, lexEnv);

    D_List args = D_List.create(i100);
    E_Application app = E_Application.create(closure, args);

    // test
    app.eval(_evaluator);

    // validate
    Obj obj = _evaluator.popExpr();
    assertEquals(args, obj);
    obj = _evaluator.popExpr();
    assertEquals(closure, obj);
    obj = _evaluator.popExpr();
    assertTrue(obj instanceof C_ApplyAbstr);
  }

}

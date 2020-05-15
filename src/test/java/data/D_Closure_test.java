package test.java.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Closure;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.Obj;
import main.java.expr.E_Abstraction;
import main.java.expr.E_Identifier;

public class D_Closure_test {

  @Test
  public void create_whenClosing_collectsOnlyNeededIdents() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_List params = D_List.EMPTY;
    E_Identifier body = x;
    E_Abstraction abstr = E_Abstraction.create(params, new Obj[] { body });
    D_Binding xBinding = D_Binding.create(x, i100);
    D_Binding yBinding = D_Binding.create(y, i200);
    D_List lexEnv = D_List.createN(xBinding, yBinding);

    // test
    D_Closure closure = D_Closure.create(abstr, lexEnv);

    // validate
    D_List closureEnv = closure.getLexEnv();
    assertEquals("[x=100]", closureEnv.toString());
  }

}

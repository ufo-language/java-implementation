package test.java.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.contin.C_MakeBinding;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;

public class D_Binding_test {

  @Test
  public void create() {
    // setup
    E_Identifier key = E_Identifier.create("x");
    D_Integer value = D_Integer.create(100);

    // test
    D_Binding binding = D_Binding.create(key, value);

    // validate
    assertEquals(key, binding.key);
    assertEquals(value, binding.value);
  }

  @Test
  public void eval() {
    // setup
    Evaluator etor = Evaluator.create();
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    D_Binding binding = D_Binding.create(x, i100);

    // test
    binding.eval(etor);

    // validate
    assertEquals(x, etor.popExpr());
    assertEquals(i100, etor.popExpr());
    assertEquals(C_MakeBinding.create(), etor.popExpr());
  }

  @Test
  public void show() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    E_Identifier x = E_Identifier.create("x");
    D_Binding binding = D_Binding.create(x, i100);
    StringBuilder sb = new StringBuilder();
    
    // test
    binding.show(sb);

    // validate
    assertEquals("x=100", sb.toString());
  }

}

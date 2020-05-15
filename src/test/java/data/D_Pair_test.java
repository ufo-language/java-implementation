package test.java.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.Obj;
import main.java.data.contin.C_MakePair;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;

public class D_Pair_test {

  @Test
  public void create() {
    // setup
    D_Integer first = D_Integer.create(100);
    D_Integer rest = D_Integer.create(200);

    // test
    D_List pair = D_List.create(first, rest);

    // validate
    assertEquals(first, pair.first());
    assertEquals(rest, pair.rest());
  }

  @Test
  public void eval() {
    // setup
    Evaluator etor = Evaluator.create();
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    D_List pair = D_List.create(x, i100);

    // test
    pair.eval(etor);

    // validate
    assertEquals(x, etor.popExpr());
    assertEquals(i100, etor.popExpr());
    assertEquals(C_MakePair.create(), etor.popExpr());
  }

  @Test
  public void iterator() {
    // setup
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_Integer i300 = D_Integer.create(300);
    D_List list = D_List.createN(i100, i200, i300);
    D_Integer[] ints = new D_Integer[] { i100, i200, i300 };

    // test & validate
    int n = 0;
    for(Obj obj : list) {
      assertEquals(ints[n], obj);
      n++;
    }
  }

  @Test
  public void lookup_withIdent_returnsValue() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    E_Identifier y = E_Identifier.create("y");
    E_Identifier z = E_Identifier.create("z");
    D_Integer i100 = D_Integer.create(100);
    D_Integer i200 = D_Integer.create(200);
    D_Binding xBinding = D_Binding.create(x, i100);
    D_Binding yBinding = D_Binding.create(y, i200);
    D_List bindings = D_List.createN(xBinding, yBinding);

    // test
    Obj res1 = bindings.lookup(x);
    Obj res2 = bindings.lookup(y);
    Obj res3 = bindings.lookup(z);

    //validate
    assertEquals(i100, res1);
    assertEquals(i200, res2);
    assertEquals(null, res3);
  }

  @Test
  public void show_improperList() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    D_List pair = D_List.create(x, i100);
    StringBuilder sb = new StringBuilder();

    // test
    pair.show(sb);

    // validate
    assertEquals("[x | 100]", sb.toString());
  }

  @Test
  public void show_properList() {
    // setup
    E_Identifier x = E_Identifier.create("x");
    D_Integer i100 = D_Integer.create(100);
    D_List pair = D_List.createN(x, i100);
    StringBuilder sb = new StringBuilder();

    // test
    pair.show(sb);

    // validate
    assertEquals("[x, 100]", sb.toString());
  }

}

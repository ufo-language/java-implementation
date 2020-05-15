package test.java.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.data.contin.C_MakeArray;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;

public class D_Array_test {

  private D_Integer _i100 = D_Integer.create(100);
  private D_Integer _i200 = D_Integer.create(200);
  private D_Integer _i300 = D_Integer.create(300);

  private E_Identifier _x = E_Identifier.create("x");
  private E_Identifier _y = E_Identifier.create("y");
  private E_Identifier _z = E_Identifier.create("z");

  @Test
  public void create() {
    // test
    D_Array ary = D_Array.create(_i100, _i200, _i300);

    // validate
    assertEquals(_i100, ary.getRaw(0));
    assertEquals(_i200, ary.getRaw(1));
    assertEquals(_i300, ary.getRaw(2));
  }

  @Test
  public void eval() {
    // setup
    Evaluator etor = Evaluator.create();
    D_Array ary = D_Array.create(_x, _i100, _y);

    // test
    ary.eval(etor);

    // validate
    assertEquals(_y, etor.popExpr());
    assertEquals(_i100, etor.popExpr());
    assertEquals(_x, etor.popExpr());
    assertTrue(etor.popExpr() instanceof C_MakeArray);
  }

  @Test
  public void get_withObj_returnsAssociatedValue() {
    // setup
    D_Binding binding1 = D_Binding.create(_x, _i100);
    D_Binding binding2 = D_Binding.create(_y, _i200);
    D_Binding binding3 = D_Binding.create(_z, _i300);
    D_Array ary = D_Array.create(binding1, binding2, binding3);

    // test
    Obj obj1 = ary.get(_x);
    Obj obj2 = ary.get(_y);
    Obj obj3 = ary.get(_z);
    Obj obj4 = ary.get(D_Symbol.create("a"));

    // validate
    assertEquals(_i100, obj1);
    assertEquals(_i200, obj2);
    assertEquals(_i300, obj3);
    assertEquals(null, obj4);
  }

  @Test
  public void show() {
    // setup
    D_Array ary = D_Array.create(_i100, _i200, _i300);
    StringBuilder sb = new StringBuilder();
    
    // test
    ary.show(sb);

    // validate
    assertEquals("{100, 200, 300}", sb.toString());
  }

}

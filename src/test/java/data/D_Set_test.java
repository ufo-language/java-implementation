package test.java.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.data.D_Set;
import main.java.data.contin.C_MakeSet;
import main.java.evaluator.Evaluator;

public class D_Set_test {

  @Test
  public void eval() {
    // setup
    Evaluator etor = Evaluator.create();
    D_Integer i100 = D_Integer.create(100);
    D_Set set = D_Set.create(i100);

    // test
    set.eval(etor);

    // validate
    assertEquals(i100, etor.popExpr());
    assertTrue(etor.popExpr() instanceof C_MakeSet);
  }

}

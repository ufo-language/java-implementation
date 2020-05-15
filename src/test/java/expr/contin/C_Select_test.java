package test.java.expr.contin;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Boolean;
import main.java.data.D_Integer;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_Select;

public class C_Select_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_whenTrue_pushesConseq() {
    // setup
    D_Boolean cond = D_Boolean.TRUE;
    _evaluator.pushObj(cond);
    Obj[] conseq = new Obj[] { D_Integer.create(100) };
    Obj[] alt = new Obj[] { D_Integer.create(200) };
    C_Select select = C_Select.create(conseq, alt);

    // test
    select.eval(_evaluator);

    // validate
    Obj obj1 = _evaluator.popExpr();
    assertEquals(conseq[0], obj1);
  }

  @Test
  public void eval_whenFalse_pushesAlt() {
    // setup
    D_Boolean cond = D_Boolean.FALSE;
    _evaluator.pushObj(cond);
    Obj[] conseq = new Obj[] { D_Integer.create(100) };
    Obj[] alt = new Obj[] { D_Integer.create(200) };
    C_Select select = C_Select.create(conseq, alt);

    // test
    select.eval(_evaluator);

    // validate
    Obj obj1 = _evaluator.popExpr();
    assertEquals(alt[0], obj1);
  }

}

package test.java.expr.contin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.contin.C_ApplyAbstr;
import main.java.i18n.Strings;
import main.java.util.UFOException;

public class C_Apply_test {

  private Evaluator _evaluator;
  
  private class TestApplyable extends Obj implements Applyable {

    D_List args;

    @Override
    public void apply(Evaluator etor, D_List args) {
      this.args = args;
    }

    @Override
    public void show(StringBuilder sb) {}

    @Override
    public EvaluationOrder getEvaluationOrder() {
      return EvaluationOrder.APPLICATIVE;
    }

    @Override
    public D_List[] getParameters() {
      return null;
    }
  }
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval() {
    // setup
    TestApplyable testApp = new TestApplyable();
    D_List args = D_List.EMPTY;
    C_ApplyAbstr apply = C_ApplyAbstr.create(args);
    //_evaluator.pushObj(args);
    _evaluator.pushObj(testApp);

    // test
    apply.eval(_evaluator);

    // validate
    assertEquals(D_List.EMPTY, testApp.args);
  }

  @Test
  public void eval_whenAbstrIsNotApplyable_throwsException() {
    D_List args = D_List.EMPTY;
    C_ApplyAbstr apply = C_ApplyAbstr.create(args);
    //_evaluator.pushObj(args);
    _evaluator.pushObj(D_Nil.NIL);

    // test
    Exception exception = assertThrows(UFOException.class, () -> {
      apply.eval(_evaluator);
    });

    // validate
    String expected = Strings.format("NotAnAbstraction", D_Nil.NIL);
    assertEquals(expected, exception.getMessage());
  }

}

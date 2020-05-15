package test.java.expr.contin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.expr.contin.C_MatchBind;
import main.java.i18n.Strings;
import main.java.util.UFOException;

public class C_MatchBind_test {

  private Evaluator _evaluator;
  
  @BeforeEach
  public void beforeEach() {
    _evaluator = Evaluator.create();
  }

  @Test
  public void eval_withAnIdentifier_bindsRhsToIdentifier() {
    // setup
    E_Identifier lhs = E_Identifier.create("x");
    D_Integer rhs = D_Integer.create(100);
    _evaluator.pushObj(rhs);
    C_MatchBind matchBind = C_MatchBind.create(lhs);

    // test
    matchBind.eval(_evaluator);

    // validate
    D_List env = _evaluator.getEnv();
    assertFalse(env.isEmpty());
    D_Binding binding = (D_Binding)env.first();
    assertEquals(lhs, binding.key);
    assertEquals(rhs, binding.value);
  }

  @Test
  public void eval_withAMismatch_throwsAnException() {
    // setup
    D_Integer lhs = D_Integer.create(100);
    D_Integer rhs = D_Integer.create(200);
    _evaluator.pushObj(rhs);
    C_MatchBind matchBind = C_MatchBind.create(lhs);

    // test
    Exception exception = assertThrows(UFOException.class, () -> {
      matchBind.eval(_evaluator);
    });

    // validate
    String expected = String.format(Strings.get("BindingMismatch"), lhs, rhs);
    assertEquals(expected, exception.getMessage());
  }

}

package main.java.expr;

import java.util.Objects;

import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class E_Quote extends Obj {

  // Instance variables =============================================
  
  private Obj _expr;

  // Static methods =================================================
  
  public static E_Quote create(Obj expr) {
    return new E_Quote(expr);
  }

  // Constructors ===================================================

  public E_Quote(Obj expr) {
    _expr = expr;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor)
  {
    etor.pushObj(_expr);
  }

  @Override
  public void freeVars(D_Set vars) {
    _expr.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Quote.class, _expr);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append('\'');
    _expr.show(sb);
    sb.append('\'');
  }

}

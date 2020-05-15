package main.java.data.contin;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_PushObj extends Obj {

  // Instance variables =============================================

  public Obj expr;

  // Constructors ===================================================

  public C_PushObj(Obj expr) {
    this.expr = expr;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushObj(expr);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{');
    expr.show(sb);
    sb.append('}');
  }

}

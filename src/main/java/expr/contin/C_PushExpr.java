package main.java.expr.contin;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_PushExpr extends Obj {

  // Instance variables =============================================

  public Obj expr;

  // Static methods =================================================

  public static C_PushExpr create(Obj expr) {
    return new C_PushExpr(expr);
  }

  // Constructors ===================================================

  private C_PushExpr(Obj expr) {
    this.expr = expr;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(expr);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_PushExpr{");
    expr.show(sb);
    sb.append('}');
  }

}

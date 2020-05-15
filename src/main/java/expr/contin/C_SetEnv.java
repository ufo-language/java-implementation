package main.java.expr.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_SetEnv extends Obj {

  // Instance variables =============================================

  private D_List _env;

  // Static methods =================================================

  public static C_SetEnv create(D_List env) {
    return new C_SetEnv(env);
  }

  // Constructors ===================================================

  private C_SetEnv(D_List env) {
    _env = env;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.setEnv(_env);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_env).append('}');
  }

}

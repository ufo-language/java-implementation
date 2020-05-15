package main.java.expr.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;

public class C_ApplyArgs extends Obj {

  // Instance variables =============================================

  private Applyable _applyable;

  // Static methods =================================================

  public static C_ApplyArgs create(Applyable applyable) {
    return new C_ApplyArgs(applyable);
  }

  // Constructors ===================================================

  private C_ApplyArgs(Applyable applyable) {
    _applyable = applyable;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_List args = (D_List)etor.popObj();
    _applyable.apply(etor, args);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_applyable).append('}');
  }

}

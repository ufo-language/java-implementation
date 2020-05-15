package main.java.data.contin;

import main.java.data.D_Binding;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeBinding extends Obj {

  // Static variables ===============================================

  private static final C_MakeBinding MAKE_BINDING = new C_MakeBinding();

  // Static methods =================================================

  public static C_MakeBinding create() {
    return MAKE_BINDING;
  }

  // Constructors ===================================================

  private C_MakeBinding() {
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj key = etor.popObj();
    Obj value = etor.popObj();
    D_Binding binding = D_Binding.create(key, value);
    etor.pushObj(binding);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_MakeBinding{}");
  }

}

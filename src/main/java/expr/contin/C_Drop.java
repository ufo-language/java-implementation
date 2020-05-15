package main.java.expr.contin;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_Drop extends Obj {

  // Static variables ===============================================

  private static final C_Drop DROP = new C_Drop();

  // Static methods =================================================

  public static C_Drop create() {
    return DROP;
  }

  // Constructors ===================================================

  private C_Drop() {
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.popObj();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_Drop{}");
  }

}

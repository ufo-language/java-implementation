package main.java.data.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakePair extends Obj {

  // Static variables ===============================================

  private static final C_MakePair MAKE_PAIR = new C_MakePair();

  // Static methods =================================================

  public static C_MakePair create() {
    return MAKE_PAIR;
  }

  // Constructors ===================================================

  private C_MakePair() {
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj first = etor.popObj();
    Obj rest = etor.popObj();
    D_List pair = D_List.create(first, rest);
    etor.pushObj(pair);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_MakePair{}");
  }

}

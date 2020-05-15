package main.java.expr.contin;

import main.java.data.D_Integer;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_Subscript extends Obj {

  // Static variables ===============================================

  private static C_Subscript DO_INDEX = new C_Subscript();

  // Static methods =================================================

  public static C_Subscript create() {
    return DO_INDEX;
  }

  // Constructors ===================================================

  public C_Subscript() {}

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj indexObj = etor.popObj();
    Obj collection = etor.popObj();
    if(indexObj instanceof D_Integer) {
      int index = ((D_Integer)indexObj).getValue();
      Obj elem = collection.get(index);
      etor.pushObj(elem);
    }
    else {
      Obj elem = collection.get(indexObj);
      etor.pushObj(elem);
    }
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_DoIndex{}");
  }
  
}

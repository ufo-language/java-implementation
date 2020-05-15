package main.java.evaluator;

import main.java.data.D_Symbol;
import main.java.data.Obj;

public class TypeCheck {

  // Static methods =================================================

  /**
   * Called from E_BinaryOperator.match
   */
  public static boolean hasType(Obj obj, Obj type) {
    if(type instanceof D_Symbol) {
      return obj.typeName().equals(type.toString());
    }
    return false;
  }

}

package main.java.data;

import main.java.util.UFOException;

public class D_Boolean extends Obj {

  // Static variables ===============================================

  public static final D_Boolean TRUE = new D_Boolean();
  public static final D_Boolean FALSE = new D_Boolean();
  
  // Static methods =================================================

  public static D_Boolean create(boolean value) {
    return value ? TRUE : FALSE;
  }

  // Instance methods ===============================================

  private D_Boolean() {}

  // Instance methods ===============================================

  @Override
  public boolean boolValue() {
    return this == TRUE;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Boolean))
      throw UFOException.unableToCompare(this, other);
    D_Boolean bln = (D_Boolean)other;
    return Boolean.compare(boolValue(), bln.boolValue());
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(this == TRUE ? "true" : "false");
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Boolean":
        newObj = this;
        break;
      case "Integer":
        newObj = D_Integer.create(this == FALSE ? 0 : 1);
        break;
      case "Real":
        newObj = D_Real.create(this == FALSE ? 0.0f : 1.0f);
        break;
      case "String":
        newObj = D_String.create(this.boolValue() ? "true" : "false");
        break;
      case "Symbol":
        newObj = D_Symbol.create(this.boolValue() ? "True" : "False");
        break;
    }
    return newObj;
  }

}

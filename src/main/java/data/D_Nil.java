package main.java.data;

public class D_Nil extends Obj {

  // Static variables ===============================================

  public static final D_Nil NIL = new D_Nil();

  // Instance variables =============================================

  public Obj first, rest;

  // Static methods =================================================

  public static D_Nil create() {
    return NIL;
  }
  
  // Constructors ===================================================

  private D_Nil() {}

  // Instance methods ===============================================

  @Override
  public boolean boolValue() {
    return false;
  }

  @Override
  public int compareTo(Obj other) {
    return other == this ? 0 : -1;
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("nil");
  }

}

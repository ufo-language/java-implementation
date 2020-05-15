package main.java.expr.contin;

import main.java.data.D_Array;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Do;

public class C_Select extends Obj {

  // Instance variables =============================================

  private Obj[] _conseq, _alt;

  // Static methods =================================================

  public static C_Select create(Obj[] conseq, Obj[] alt) {
    return new C_Select(conseq, alt);
  }

  // Constructors ===================================================

  private C_Select(Obj[] conseq, Obj[] alt) {
    _conseq = conseq;
    _alt = alt;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj condObj = etor.popObj();
    E_Do.eval(etor, condObj.boolValue() ? _conseq : _alt);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_Select{");
   D_Array.show(sb, _conseq, "{", "}");
   sb.append(", ");
   D_Array.show(sb, _alt, "{", "}");
    sb.append('}');
  }

}

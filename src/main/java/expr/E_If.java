package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Nil;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_Select;

public class E_If extends Obj {

  // Instance variables =============================================

  private Obj _cond;
  private Obj[] _conseq, _alt;

  // Static methods =================================================

  public static E_If create(Obj cond, Obj[] conseq, Obj[] alt) {
    return new E_If(cond, conseq, alt);
  }

  // Constructors ===================================================
  
  private E_If(Obj cond, Obj[] conseq, Obj[] alt) {
    _cond = cond;
    _conseq = conseq;
    _alt = alt;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    C_Select sel = C_Select.create(_conseq, _alt);
    etor.pushExpr(sel);
    etor.pushExpr(_cond);
  }

  @Override
  public void freeVars(D_Set vars) {
    _cond.freeVars(vars);
    D_Array.freeVars(_conseq, vars);
    D_Array.freeVars(_alt, vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_If.class, _cond, _conseq, _alt);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("if ");
    _cond.show(sb);
    sb.append(" then ");
    D_Array.show(sb, _conseq, "", "", "; ");
    if(!(_alt.length == 1 && _alt[0] == D_Nil.NIL)) {
      sb.append(" else " );
      D_Array.show(sb, _alt, "", "", "; ");
    }
    sb.append(" end");
  }

}

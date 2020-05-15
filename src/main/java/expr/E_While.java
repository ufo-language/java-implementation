package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_While;

public class E_While extends Obj {

  // Instance variables =============================================

  private Obj _cond;
  private E_Do _body;
  private C_While _cWhile;

  // Static methods =================================================

  public static E_While create(Obj cond, Obj[] exprs) {
    return new E_While(cond, exprs);
  }

  // Static inner classes ===========================================


  // Constructors ===================================================
  
  private E_While(Obj cond, Obj[] exprs) {
    _cond = cond;
    _body = E_Do.create(exprs);
    _cWhile = new C_While(_cond, _body);
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(_cWhile);
    etor.pushExpr(_cond);
  }

  @Override
  public void freeVars(D_Set vars) {
    _cond.freeVars(vars);
    _body.freeVars(vars);
    }

  @Override
  public int hashCode() {
    return Objects.hash(E_While.class, _cond, _body);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("while ");
    _cond.show(sb);
    D_Array.show(sb, _body.getExprs(), " ", "", "; ");
    sb.append(" end");
  }

}

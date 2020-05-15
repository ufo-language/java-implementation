package main.java.expr;

import java.util.Objects;

import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_ApplyAbstr;

public class E_PrefixExpr extends Obj {

  // Instance variables =============================================

  private E_Identifier _oper;
  private Obj _expr;

  // Static methods =================================================

  public static E_PrefixExpr create(E_Identifier oper, Obj expr) {
    return new E_PrefixExpr(oper, expr);
  }

  // Constructors ===================================================

  private E_PrefixExpr(E_Identifier oper, Obj expr) {
    _oper = oper;
    _expr = expr;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_List args = D_List.create(_expr);
    etor.pushExpr(C_ApplyAbstr.create(args));
    etor.pushExpr(_oper);
  }
  
  @Override
  public void freeVars(D_Set vars) {
    _oper.freeVars(vars);
    _expr.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_PrefixExpr.class, _oper, _expr);
  }

  @Override
  public void show(StringBuilder sb) {
    _oper.show(sb);
    if(_expr instanceof E_InfixExpr ||
       _expr instanceof E_PrefixExpr) {
      sb.append('(');
      _expr.show(sb);
      sb.append(')');
    }
    else
      _expr.show(sb);;
  }

}

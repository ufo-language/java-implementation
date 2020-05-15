package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Nil;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_Drop;
import main.java.expr.contin.C_SetEnv;

public class E_Do extends Obj {

  // Instance variables =============================================

  private Obj[] _exprs;

  // Static methods =================================================

  public static E_Do create(Obj ... exprs) {
    return new E_Do(exprs);
  }


  public static void eval(Evaluator etor, Obj[] exprs) {
    eval(etor, exprs, D_Nil.NIL);
  }

  // TODO this needs to be fixed.
  // (but is it broken?)
  public static void eval(Evaluator etor, Obj[] exprs, Obj lexEnv) {
    switch(exprs.length) {
      case 0:
        etor.pushObj(D_Nil.NIL);
        break;
      case 1:
        etor.pushExpr(exprs[0], lexEnv);
        break;
      default:
        boolean firstIter = true;
        for(int n=exprs.length-1; n>=0; n--) {
          if(firstIter)
            firstIter = false;
          else
            etor.pushExpr(C_Drop.create(), D_Nil.NIL);
          // The top expression gets pushed with a lexical environment. The
          // remaining expressions use the dynamic environment after that.
          etor.pushExpr(exprs[n], n == 0 ? lexEnv : D_Nil.NIL);
        }
    }
  }

  // Constructors ===================================================

  private E_Do(Obj[] exprs) {
    _exprs = exprs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_SetEnv.create(etor.getEnv()));
    E_Do.eval(etor, _exprs);
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj expr : _exprs)
      expr.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Do.class, _exprs);
  }

  public Obj[] getExprs() {
    return _exprs;
  }

  @Override
  public void show(StringBuilder sb) {
    D_Array.show(sb, _exprs, "do ", " end", "; ");
  }

}

package main.java.expr;

import java.util.Objects;

import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Evaluator.EvaluatorStatus;
import main.java.expr.contin.C_Cobegin;

public class E_Cobegin extends Obj {

  // Instance variables =============================================

  private Obj[] _exprs;

  // Static methods =================================================

  public static E_Cobegin create(Obj ... exprs) {
    return new E_Cobegin(exprs);
  }

  // Constructors ===================================================
  
  private E_Cobegin(Obj[] exprs) {
    _exprs = exprs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    int nExprs = _exprs.length;
    Obj[] results = new Obj[nExprs];
    int[] count = new int[] { nExprs };
    Evaluator[] evaluators = new Evaluator[nExprs];
    Obj[] exprs = new Obj[nExprs];
    D_List env = E_Async.bindNamedExpressions(_exprs, exprs, evaluators, etor.getEnv(), etor.getRunQueue());
    // spawn each evaluator
    for(int n=0; n<nExprs; n++) {
      C_Cobegin cobeginContin = C_Cobegin.create(n, etor, count, results);
      Evaluator etor1 = evaluators[n];
      etor1.pushExpr(cobeginContin);
      etor1.pushExpr(exprs[n], env);
      etor.getRunQueue().enqEvaluator(etor1);
    }
    etor.status = EvaluatorStatus.BLOCKED;
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj expr : _exprs)
      expr.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Cobegin.class, _exprs);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("cobegin ");
    boolean firstIter = true;
    for(Obj expr : _exprs) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(", ");
      expr.show(sb);
    }
    sb.append(" end");
  }

}

package main.java.expr;

import java.util.Objects;

import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Evaluator.EvaluatorStatus;
import main.java.expr.contin.C_Nondet;

public class E_Nondet extends Obj {

  // Instance variables =============================================

  private Obj[] _exprs;

  // Static methods =================================================

  public static E_Nondet create(Obj ... exprs) {
    return new E_Nondet(exprs);
  }

  // Constructors ===================================================
  
  private E_Nondet(Obj[] exprs) {
    _exprs = exprs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    int nExprs = _exprs.length;
    Evaluator[] evaluators = new Evaluator[nExprs];
    Obj[] exprs = new Obj[nExprs];
    D_List env = E_Async.bindNamedExpressions(_exprs, exprs, evaluators, etor.getEnv(), etor.getRunQueue());
    // spawn each evaluator
    for(int n=0; n<nExprs; n++) {
      C_Nondet nondetContin = C_Nondet.create(n, etor, evaluators);
      Evaluator etor1 = evaluators[n];
      etor1.pushExpr(nondetContin);
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
    return Objects.hash(E_Nondet.class, this._exprs);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("nondet ");
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

package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.RunQueue;

public class E_Async extends Obj {

  // Instance variables =============================================

  private Obj[] _exprs;

  // Static methods =================================================

  public static D_List bindNamedExpressions(Obj[] exprsIn, Obj[] exprsOut, Evaluator[] etorsOut, D_List env, RunQueue runQ) {
    for(int n=0; n<exprsIn.length; n++) {
      etorsOut[n] = Evaluator.create(null, runQ);
      Obj expr = exprsIn[n];
      if(expr instanceof D_Binding) {
        D_Binding bindingExpr = (D_Binding)expr;
        if(bindingExpr.key instanceof E_Identifier) {
          E_Identifier ident = (E_Identifier)bindingExpr.key;
          D_Binding newBinding = D_Binding.create(ident, etorsOut[n]);
          env = D_List.create(newBinding, env);
          exprsOut[n] = bindingExpr.value;
        }
      }
      else
        exprsOut[n] = expr;
    }
    return env;
  }

  public static E_Async create(Obj ... exprs) {
    return new E_Async(exprs);
  }

  // Constructors ===================================================
  
  private E_Async(Obj[] exprs) {
    _exprs = exprs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    int nExprs = _exprs.length;
    Evaluator[] evaluators = new Evaluator[nExprs];
    Obj[] exprs = new Obj[nExprs];
    D_List env = bindNamedExpressions(_exprs, exprs, evaluators, etor.getEnv(), etor.getRunQueue());
    // spawn each evaluator
    for(int n=0; n<nExprs; n++) {
      Evaluator etor1 = evaluators[n];
      etor1.pushExpr(exprs[n], env);
      etor.getRunQueue().enqEvaluator(etor1);
    }
    D_Array etorArray = D_Array.create(evaluators);
    etor.pushObj(etorArray);
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj expr : _exprs)
      expr.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Async.class, _exprs);
  }
  
  @Override
  public void show(StringBuilder sb) {
    sb.append("async ");
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

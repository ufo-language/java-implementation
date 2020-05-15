package main.java.data;

import java.util.Objects;

import main.java.data.contin.C_StoreMemo;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.E_Abstraction;
import main.java.expr.E_Identifier;
import main.java.expr.contin.C_SetEnv;
import main.java.expr.E_Do;
import main.java.util.UFOException;

public class D_Closure extends Obj implements Applyable {

  // Instance variables =============================================

  private E_Abstraction _abstr;
  private D_List _lexEnv;
  private D_List[] _allParams;
  private D_Set _freeVars;

  // Static methods =================================================

  public static D_Closure create(E_Abstraction abstr) {
    return new D_Closure(abstr, D_List.EMPTY);
  }

  public static D_Closure create(E_Abstraction abstr, D_List lexEnv) {
    return new D_Closure(abstr, lexEnv);
  }

  // Constructors ===================================================

  /**
   * The lexEnv parameter has no use in production because normally the closure
   * is closed with an explicit call to the close() method below, and
   * that replaces the _lexEnv list.
   * This parameter is used in testing.
   */
  private D_Closure(E_Abstraction abstr, D_List lexEnv) {
    _abstr = abstr;
    _lexEnv = lexEnv;
    E_Abstraction abstr1 = abstr;
    D_Queue paramsQ = D_Queue.create();
    while(abstr1 != null) {
      paramsQ.enq(abstr1.getParams());
      abstr1 = abstr1.getNext();
    }
    _allParams = new D_List[paramsQ.count()];
    for(int n=0; n<_allParams.length; n++)
      _allParams[n] = (D_List)paramsQ.deq();
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    if(_freeVars != null)
      // re-close from dynamic env
      close(etor, _freeVars);
    E_Abstraction abstr = _abstr;
    Obj val = abstr.getMemo(args);
    if(val != null)
      etor.pushObj(val);
    else {
      etor.pushExpr(new C_StoreMemo(abstr, args));
      while(abstr != null) {
        D_List params = abstr.getParams();
        D_List lexEnv = params.match(args, _lexEnv);
        if(lexEnv != null) {
          etor.pushExpr(C_SetEnv.create(etor.getEnv()));
          E_Do.eval(etor, abstr.getBody(), lexEnv);
          return;
        }
        abstr = abstr.getNext();
      }
      throw UFOException.argumentMismatch(this, _allParams, args);
    }
  }

  public void close(Evaluator etor) {
    _freeVars = D_Set.create();
    close(etor, _freeVars);
  }

  public void close(Evaluator etor, D_Set freeVars) {
    freeVars(freeVars);
    D_Queue fvq = D_Queue.copyFrom(freeVars);
    for(Obj freeVar : fvq) {
      E_Identifier ident = (E_Identifier)freeVar;
      Obj value = etor.lookup(ident);
      if(value != null) {
        D_Binding binding = D_Binding.create(ident, value);
        _lexEnv = D_List.create(binding, _lexEnv);
        freeVars.remove(ident);
      }
    }
    if(freeVars.isEmpty())
      _freeVars = null;
  }

  @Override
  public void freeVars(D_Set vars) {
    E_Abstraction abstr = _abstr;
    while(abstr != null) {
      abstr.freeVars(vars);
      abstr = abstr.getNext();
    }
  }

  @Override
  public EvaluationOrder getEvaluationOrder() {
    return _abstr.getEvalOrder();
  }

  public D_List getLexEnv() {
    return _lexEnv;
  }

  @Override
  public D_List[] getParameters() {
    return _allParams;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._abstr, this._lexEnv, this._allParams);
  }


  @Override
  public void show(StringBuilder sb) {
    _abstr.show(sb);
  }

}

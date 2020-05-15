package main.java.expr.contin;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_Nondet extends Obj {

  // Instance variables =============================================

  private int _n;
  private Evaluator _etor;
  private Evaluator[] _etors;

  // Static methods =================================================

  public static C_Nondet create(int n, Evaluator etor, Evaluator[] etors) {
    return new C_Nondet(n, etor, etors);
  }

  // Constructors ===================================================

  private C_Nondet(int n, Evaluator etor, Evaluator[] etors) {
    _n = n;
    _etor = etor;
    _etors = etors;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    // kill other evaluators
    for(int n=0; n<_etors.length; n++)
      if(n != _n)
        _etors[n].terminate();
    // resume parent evaluator
    Obj res = etor.topObj();
    _etor.pushObj(res);
    _etor.resume();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_Cobegin{").append(_n);
    sb.append('}');
  }

}

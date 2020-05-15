package main.java.expr.contin;

import main.java.data.D_Array;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_Cobegin extends Obj {

  // Instance variables =============================================

  private int _n;
  private Evaluator _etor;
  private int[] _count;
  private Obj[] _results;

  // Static methods =================================================

  public static C_Cobegin create(int n, Evaluator etor, int[] count, Obj[] results) {
    return new C_Cobegin(n, etor, count, results);
  }

  // Constructors ===================================================

  private C_Cobegin(int n, Evaluator etor, int[] count, Obj[] results) {
    _n = n;
    _etor = etor;
    _count = count;
    _results = results;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj res = etor.topObj();
    _results[_n] = res;
    _count[0]--;
    if(_count[0] == 0) {
      D_Array resAry = D_Array.create(_results);
      _etor.pushObj(resAry);
      _etor.resume();
    }
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_Cobegin{").append(_n).append(", ").append(_count[0]).append(", ");
    _etor.show(sb);
    sb.append('}');
  }

}

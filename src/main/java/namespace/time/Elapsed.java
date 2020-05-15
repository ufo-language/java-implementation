package main.java.namespace.time;

import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Elapsed extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "elapsed";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null)
  };

  // Static inner classes ===========================================

  private static final class C_ElapsedTime extends Obj {

    private long _startTime;

    public C_ElapsedTime(long startTime) {
      _startTime = startTime;
    }

    @Override
    public void eval(Evaluator etor) {
      long endTime = System.nanoTime();
      etor.popObj();
      long diff = endTime - _startTime;
      long ns = diff % 1_000_000_000;
      long s = diff / 1_000_000_000;
      D_Array res = D_Array.create(D_Integer.create((int)s), D_Integer.create((int)ns));
      etor.pushObj(res);
    }

  }

  // Constructors ===================================================

  public Elapsed() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj expr = args.first();
    long startTime = System.nanoTime();
    etor.pushExpr(new C_ElapsedTime(startTime));
    etor.pushExpr(expr);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

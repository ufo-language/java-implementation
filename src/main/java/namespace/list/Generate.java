package main.java.namespace.list;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.namespace.Params;

public class Generate extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "generate";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("f", Applyable.class, "n", D_Integer.class)
  };

  // Static inner classes ===========================================

  private static final class C_Generate extends Obj {
  
    private D_Queue _q = D_Queue.create();
    private int _n, _max;
    private Applyable _f;

    public C_Generate(int n, int max, Applyable f) {
      _n = n;
      _max = max;
      _f = f;
    }
 
    @Override
    public void eval(Evaluator etor) {
      Obj elem = etor.popObj();
      _q.enq(elem);
      if(++_n < _max) {
        etor.pushExpr(this);
        D_List args = D_List.create(D_Integer.create(_n));
        _f.apply(etor, args);
      }
      else
        etor.pushObj(_q.asList());
    }

  }

  // Constructors ===================================================

  public Generate() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Applyable f = (Applyable)args.first();
    D_Integer max = (D_Integer)args.getSecond();
    int iMax = max.asInt();
    if(iMax < 1)
      etor.pushObj(D_List.EMPTY);
    else {
      etor.pushExpr(new C_Generate(0, iMax, f));
      D_Integer n = D_Integer.create(0);
      D_List args2 = D_List.create(n);
      ((Applyable)f).apply(etor, args2);
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

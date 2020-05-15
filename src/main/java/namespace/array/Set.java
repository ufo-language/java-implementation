package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Set extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "set!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("ary", D_Array.class, "n", D_Integer.class, "value", null)
  };

  // Constructors ===================================================

  public Set() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    int n = ((D_Integer)args.getSecond()).getValue();
    Obj value = args.getThird();
    ary.set(n, value);
    etor.pushObj(ary);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

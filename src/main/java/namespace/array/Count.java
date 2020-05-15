package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Count extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "count";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_Array.class)
  };

  // Constructors ===================================================

  public Count() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    etor.pushObj(D_Integer.create(ary.count()));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

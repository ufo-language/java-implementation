package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Contains extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "contains?";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_Array.class, "any", null)
  };

  // Constructors ===================================================

  public Contains() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array a = (D_Array)args.first();
    Obj other = args.getSecond();
    etor.pushObj(a.contains(other));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

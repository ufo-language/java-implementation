package main.java.namespace.any;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Compare extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "compare";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("obj1", null, "obj2", null)
  };

  // Constructors ===================================================

  public Compare() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj1 = args.first();
    Obj obj2 = args.getSecond();
    int res = obj1.compareTo(obj2);
    etor.pushExpr(D_Integer.create(res));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

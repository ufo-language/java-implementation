package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class IndexOf extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "indexOf";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "value", null)
  };

  // Constructors ===================================================

  public IndexOf() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List lst = (D_List)args.first();
    Obj value = args.getSecond();
    Obj res = lst.indexOf(value);
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

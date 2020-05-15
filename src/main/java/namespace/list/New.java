package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class New extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "new";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("first", null, "rest", null)
  };

  // Constructors ===================================================

  public New() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj first = args.first();
    Obj rest = args.getSecond();
    D_List list = D_List.create(first, rest);
    etor.pushObj(list);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

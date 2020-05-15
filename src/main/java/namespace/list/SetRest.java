package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class SetRest extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "setRest!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "any", null)
  };

  // Constructors ===================================================

  public SetRest() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    Obj obj = args.getSecond();
    list.rest(obj);
    etor.pushObj(list);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

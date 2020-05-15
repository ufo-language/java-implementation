package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Stack;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Reverse extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "reverse";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class)
  };

  // Constructors ===================================================

  public Reverse() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    D_Stack stk = D_Stack.create();
    for(Obj obj : list)
      stk.push(obj);
    etor.pushObj(stk.asList());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

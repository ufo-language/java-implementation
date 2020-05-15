package main.java.namespace.stack;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Stack;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Push extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "push!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("stk", D_Stack.class, "...", null)
  };

  // Constructors ===================================================

  public Push() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Stack stk = (D_Stack)args.first();
    D_List rest = args.getRest();
    for(Obj obj : rest)
      stk.push(obj);
    etor.pushObj(stk);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

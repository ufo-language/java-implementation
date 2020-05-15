package main.java.namespace.stack;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Stack;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class New extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "new";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Constructors ===================================================

  public New() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Stack stkTemp = D_Stack.create();
    for(Obj arg : args)
      stkTemp.push(arg);
    D_Stack stk = D_Stack.create();
    while(!stkTemp.isEmpty())
      stk.push(stkTemp.pop());
    etor.pushObj(stk);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

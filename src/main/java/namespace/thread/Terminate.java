package main.java.namespace.thread;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Terminate extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "terminate";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("thd", Evaluator.class)
  };

  // Constructors ===================================================

  public Terminate() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Evaluator thread = (Evaluator)args.first();
    thread.terminate();
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

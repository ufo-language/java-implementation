package main.java.namespace.thread;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Self extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "self";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY
  };

  // Constructors ===================================================

  public Self() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    etor.pushObj(etor);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

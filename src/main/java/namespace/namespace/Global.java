package main.java.namespace.namespace;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Global extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "global";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params()
  };

  // Constructors ===================================================

  public Global() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    etor.pushObj(Evaluator.GLOBALS);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

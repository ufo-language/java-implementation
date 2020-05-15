package main.java.namespace.closure;

import main.java.data.D_Closure;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class LexicalEnv extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "lexEnv";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("c", D_Closure.class)
  };

  // Constructors ===================================================

  public LexicalEnv() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Closure closure = (D_Closure)args.first();
    etor.pushObj(closure.getLexEnv());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.evaluator;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Eval extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "eval";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null)
  };

  // Constructors ===================================================

  public Eval() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    etor.pushExpr(args.first());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.set;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Set;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Add extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "add!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s", D_Set.class, "...", null)
  };

  // Constructors ===================================================

  public Add() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Set set = (D_Set)args.first();
    set.add(args.getRest().asRawArray());
    etor.pushObj(set);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

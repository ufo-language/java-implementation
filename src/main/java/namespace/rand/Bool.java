package main.java.namespace.rand;

import main.java.data.D_Boolean;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Bool extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "bool";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY
  };

  // Constructors ===================================================

  public Bool() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    boolean b = Seed.GENERATOR.nextBoolean();
    etor.pushObj(D_Boolean.create(b));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.term;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Term;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Name extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "name";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("t", D_Term.class)
  };

  // Constructors ===================================================

  public Name() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Term trm = (D_Term)args.first();
    etor.pushObj(trm.name());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

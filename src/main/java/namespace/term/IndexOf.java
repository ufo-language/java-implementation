package main.java.namespace.term;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Term;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class IndexOf extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "indexOf";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("t", D_Term.class, "value", null)
  };

  // Constructors ===================================================

  public IndexOf() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Term t = (D_Term)args.first();
    Obj value = args.getSecond();
    Obj res = t.indexOf(value);
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

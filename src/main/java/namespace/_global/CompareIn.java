package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class CompareIn extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "in";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", null, "rhs", null)
  };

  // Constructors ===================================================

  public CompareIn() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj value = args.first();
    Obj coll = args.getSecond();
    Obj res = coll.contains(value);
    if(res == null)
      throw UFOException.objectNotCollection(coll);
    etor.pushObj(coll.contains(value));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

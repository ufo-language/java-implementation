package main.java.namespace._global;

import main.java.data.D_Boolean;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class CompareEQ extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "==";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", null, "rhs", null)
  };

  // Constructors ===================================================

  public CompareEQ() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj lhs = args.first();
    Obj rhs = args.getSecond();
    etor.pushObj(D_Boolean.create(lhs.equals(rhs)));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

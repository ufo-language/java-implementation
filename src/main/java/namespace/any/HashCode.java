package main.java.namespace.any;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class HashCode extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "hashCode";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null)
  };

  // Constructors ===================================================

  public HashCode() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    D_Integer hashCode = D_Integer.create(obj.hashCode());
    etor.pushExpr(hashCode);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

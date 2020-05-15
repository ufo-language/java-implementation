package main.java.namespace._global;

import main.java.data.D_Boolean;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class LogicAnd extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "and";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("p", null, "p", null)
  };

  // Constructors ===================================================

  public LogicAnd() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj p = args.first();
    Obj q = args.getSecond();
    etor.pushObj(D_Boolean.create(p.boolValue() && q.boolValue()));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

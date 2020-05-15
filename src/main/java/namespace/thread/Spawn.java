package main.java.namespace.thread;

import main.java.data.D_Closure;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Application;
import main.java.namespace.Params;

public class Spawn extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "spawn";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null)
  };

  // Constructors ===================================================

  public Spawn() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj expr = args.first();
    if(expr instanceof D_Closure)
      expr = E_Application.create(expr, D_List.EMPTY);
    Evaluator etor1 = Evaluator.create(null, etor.getRunQueue());
    etor1.pushExpr(expr);
    etor.getRunQueue().enqEvaluator(etor1);
    etor.pushObj(etor1);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

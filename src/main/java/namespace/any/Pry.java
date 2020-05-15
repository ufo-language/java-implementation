package main.java.namespace.any;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.E_Application;
import main.java.expr.contin.C_Drop;
import main.java.namespace.Params;

public class Pry extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "pry";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null, "fun", Applyable.class)
  };

  // Constructors ===================================================

  public Pry() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    Obj fun = args.getSecond();
    etor.pushObj(obj);
    etor.pushExpr(C_Drop.create());
    E_Application app = E_Application.create(fun, D_List.create(obj));
    etor.pushExpr(app);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

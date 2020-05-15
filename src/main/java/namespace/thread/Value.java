package main.java.namespace.thread;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Value extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "value";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("thd", Evaluator.class)
  };

  // Constructors ===================================================

  public Value() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Evaluator thread = (Evaluator)args.first();
    switch(thread.status) {
      case FINISHED:
        Obj obj = thread.getFinalValue();
        etor.pushObj(obj);
        break;
      case ERROR:
        throw UFOException.threadError(thread);
      default:
        thread.waitForValue(etor);
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

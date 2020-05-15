package main.java.namespace.thread;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Symbol;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Status extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "status";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("thd", Evaluator.class)
  };

  // Constructors ===================================================

  public Status() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Evaluator thread = (Evaluator)args.first();
    D_Symbol statusSym = null;
    switch(thread.status) {
      case READY:
        statusSym = D_Symbol.create("Ready");
        break;
      case RUNNING:
        statusSym = D_Symbol.create("Running");
        break;
      case BLOCKED:
        statusSym = D_Symbol.create("Blocked");
        break;
      case SLEEPING:
        statusSym = D_Symbol.create("Sleeping");
        break;
      case FINISHED:
        statusSym = D_Symbol.create("Finished");
        break;
      case ERROR:
        statusSym = D_Symbol.create("Error");
        break;
    }
    etor.pushObj(statusSym);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

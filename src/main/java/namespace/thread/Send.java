package main.java.namespace.thread;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Send extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "send";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("thd", Evaluator.class, "msg", null)
  };

  // Constructors ===================================================

  public Send() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Evaluator thd = (Evaluator)args.first();
    Obj msg = ((D_List)args.rest()).first();
    thd.sendMessage(msg);
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

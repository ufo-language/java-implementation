package main.java.namespace.thread;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Poll extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "poll";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY,
      D_PrimFunction.params("dflt", null),
      D_PrimFunction.params("pat", null, "dflt", null)
  };

  // Constructors ===================================================

  public Poll() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Obj deflt = D_Nil.NIL;
    Obj msg = null;
    switch(ruleNum) {
      case 0:
        msg = etor.receiveMessage_noWait();
        break;
      case 1:
        deflt = args.first();
        msg = etor.receiveMessage_noWait();
        break;
      case 2:
        Obj pattern = args.first();
        deflt = args.getSecond();
        msg = etor.receiveMessage_noWait(pattern);
        break;
    }
    if(msg == null)
      msg = deflt;
    etor.pushObj(msg);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

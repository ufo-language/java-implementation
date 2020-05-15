package main.java.namespace.queue;

import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Deq extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "deq!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("q", D_Queue.class),
      D_PrimFunction.params("q", D_Queue.class, "pat", null),
      D_PrimFunction.params("q", D_Queue.class, "pat", null, "deflt", null)
  };

  // Constructors ===================================================

  public Deq() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_Queue queue = (D_Queue)args.first();
    Obj elem = null;
    Obj deflt = D_Nil.NIL;
    switch(ruleNum) {
      case 0:
        elem = queue.deq();
        if(elem == null)
          throw UFOException.emptyQueue();
        break;
      case 2:
        deflt = args.getThird();
      case 1:
        Obj pattern = args.getSecond();
        elem = queue.deq(pattern);
        if(elem == null)
          elem = deflt;
        break;
    }
    etor.pushObj(elem);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

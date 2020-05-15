package main.java.namespace.queue;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Enq extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "enq!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("q", D_Queue.class, "...", null)
  };

  // Constructors ===================================================

  public Enq() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Queue queue = (D_Queue)args.first();
    D_List rest = (D_List)args.rest();
    for(Obj obj : rest)
      queue.enq(obj);
    etor.pushObj(queue);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

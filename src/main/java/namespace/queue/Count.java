package main.java.namespace.queue;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Count extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "count";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("q", D_Queue.class)
  };

  // Constructors ===================================================

  public Count() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Queue queue = (D_Queue)args.first();
    etor.pushObj(D_Integer.create(queue.count()));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

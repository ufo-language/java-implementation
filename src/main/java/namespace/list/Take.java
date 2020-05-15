package main.java.namespace.list;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Take extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "take";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "n", D_Integer.class)
  };

  // Constructors ===================================================

  public Take() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    int n = ((D_Integer)args.getSecond()).getValue();
    D_Queue q = D_Queue.create();
    for(int m=0; m<n; m++) {
      if(list.isEmpty())
        break;
      q.enq(list.first());
      list = list.getRest();
    }
    etor.pushObj(q.asList());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

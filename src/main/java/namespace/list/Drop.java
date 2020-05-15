package main.java.namespace.list;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Drop extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "drop";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "n", D_Integer.class)
  };

  // Constructors ===================================================

  public Drop() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    int n = ((D_Integer)args.getSecond()).getValue();
    for(int m=0; m<n; m++) {
      if(list.isEmpty())
        break;
      list = list.getRest();
    }
    etor.pushObj(list);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

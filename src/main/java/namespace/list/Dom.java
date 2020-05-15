package main.java.namespace.list;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Dom extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "dom";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class)
  };

  // Constructors ===================================================

  public Dom() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List lst = (D_List)args.first();
    int to = lst.count() - 1;
    D_Seq dom = D_Seq.create(D_Integer.create(0), D_Integer.create(to));
    etor.pushObj(dom);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.array;

import main.java.data.D_Array;
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
      D_PrimFunction.params("a", D_Array.class)
  };

  // Constructors ===================================================

  public Dom() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array a = (D_Array)args.first();
    int from = a.getBase();
    int to = a.count() + from - 1;
    D_Seq dom = D_Seq.create(D_Integer.create(from), D_Integer.create(to));
    etor.pushObj(dom);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

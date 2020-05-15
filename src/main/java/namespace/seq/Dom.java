package main.java.namespace.seq;

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
      D_PrimFunction.params("s", D_Seq.class)
  };

  // Constructors ===================================================

  public Dom() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Seq seq = (D_Seq)args.first();
    int to = seq.count() - 1;
    D_Seq dom = D_Seq.create(D_Integer.create(0), D_Integer.create(to));
    etor.pushObj(dom);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

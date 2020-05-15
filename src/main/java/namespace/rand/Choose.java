package main.java.namespace.rand;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Choose extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "choose";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("ary", D_Array.class)
  };

  // Constructors ===================================================

  public Choose() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    int len = ary.count();
    int index = Seed.GENERATOR.nextInt(len);
    Obj elem = ary.getRaw(index);
    etor.pushObj(elem);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

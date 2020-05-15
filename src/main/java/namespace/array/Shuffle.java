package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.namespace.rand.Seed;

public class Shuffle extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "shuffle!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("ary", D_Array.class)
  };

  // Constructors ===================================================

  public Shuffle() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    int len = ary.count();
    for(int n=0; n<len; n++) {
      int m = Seed.GENERATOR.nextInt(len);
      Obj temp = ary.getRaw(n);
      ary.setRaw(n, ary.getRaw(m));
      ary.setRaw(m, temp);
    }
    etor.pushObj(ary);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

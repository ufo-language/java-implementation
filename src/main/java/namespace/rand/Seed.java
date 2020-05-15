package main.java.namespace.rand;

import java.util.Random;

import main.java.data.D_Integer;
import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Seed extends D_PrimFunction {

  // Static variables ===============================================

  public static final Random GENERATOR = new Random();

  private static final String _NAME = "seed!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s", D_Integer.class)
  };

  // Constructors ===================================================

  public Seed() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Integer seedInt = (D_Integer)args.first();
    GENERATOR.setSeed(seedInt.getValue());
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

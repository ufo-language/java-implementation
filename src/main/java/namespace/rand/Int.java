package main.java.namespace.rand;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Int extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "int";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY,
      D_PrimFunction.params("hi", D_Integer.class),
      D_PrimFunction.params("lo", D_Integer.class, "hi", D_Integer.class)
  };

  // Constructors ===================================================

  public Int() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    int r = 0;
    switch(ruleNum) {
      case 0:
        r = Seed.GENERATOR.nextInt();
        break;
      case 1: {
          D_Integer hiInt = (D_Integer)args.first();
          r = Seed.GENERATOR.nextInt(hiInt.getValue());
        }
        break;
      case 2: {
          D_Integer loInt = (D_Integer)args.first();
          D_Integer hiInt = (D_Integer)((D_List)args.rest()).first();
          int diff = (int)(hiInt.getValue() - loInt.getValue()) + 1;
          r = Seed.GENERATOR.nextInt(diff) + loInt.getValue();
        }
        break;
    }
    D_Integer r1 = D_Integer.create(r);
    etor.pushObj(r1);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

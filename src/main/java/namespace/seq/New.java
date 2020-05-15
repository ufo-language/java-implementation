package main.java.namespace.seq;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class New extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "new";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("to", Numeric.class),
      D_PrimFunction.params("from", Numeric.class, "to", Numeric.class),
      D_PrimFunction.params("from", Numeric.class, "to", Numeric.class, "by", Numeric.class)
  };

  // Constructors ===================================================

  public New() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_Seq seq = null;
    Numeric from, to, by;
    switch(ruleNum) {
      case 0:
        from = (Numeric)args.first();
        seq = D_Seq.create(from);
        break;
      case 1:
        from = (Numeric)args.first();
        to = (Numeric)args.getSecond();
        seq = D_Seq.create(from, to);
        break;
      case 2:
        from = (Numeric)args.first();
        to = (Numeric)args.getSecond();
        by = (Numeric)args.getThird();
        seq = D_Seq.create(from, to, by);
        break;
    }
    etor.pushObj(seq);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

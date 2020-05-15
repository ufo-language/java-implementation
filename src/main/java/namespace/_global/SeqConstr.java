package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class SeqConstr extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "..";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("from", Numeric.class, "to", Numeric.class)
  };

  // Constructors ===================================================

  public SeqConstr() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Numeric from = (Numeric)args.first();
    Numeric to = (Numeric)args.getSecond();
    D_Seq seq = D_Seq.create(from, to);
    etor.pushObj(seq);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

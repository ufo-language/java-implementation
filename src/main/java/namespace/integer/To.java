package main.java.namespace.integer;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class To extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "to";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("from", D_Integer.class, "to", D_Integer.class),
      D_PrimFunction.params("from", D_Integer.class, "to", D_Integer.class, "by", D_Integer.class)
  };

  // Constructors ===================================================

  public To() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_Integer by = D_Integer.create(1);
    if(ruleNum == 1)
      by = (D_Integer)args.getThird();
    D_Integer from = (D_Integer)args.first();
    D_Integer to = (D_Integer)args.getSecond();
    D_Seq seq = D_Seq.create(from, to, by);
    etor.pushObj(seq);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

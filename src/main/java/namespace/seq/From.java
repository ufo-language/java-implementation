package main.java.namespace.seq;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class From extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "from";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("r", D_Seq.class)
  };

  // Constructors ===================================================

  public From() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Seq seq = (D_Seq)args.first();
    etor.pushObj((Obj)seq.getFrom());
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class New extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "new";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("n", D_Integer.class),
      D_PrimFunction.params("n", D_Integer.class, "any", null)
  };

  // Constructors ===================================================

  public New() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    int nElems = ((D_Integer)args.first()).getValue();
    Obj elem = D_Nil.NIL;
    if(ruleNum == 1)
      elem = args.getSecond();
    D_Array ary = D_Array.createN(nElems, elem);
    etor.pushObj(ary);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

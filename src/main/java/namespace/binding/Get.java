package main.java.namespace.binding;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Get extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "get";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_Binding.class, "n", D_Integer.class),
      D_PrimFunction.params("a", D_Binding.class, "any", null)
  };

  // Constructors ===================================================

  public Get() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_Binding ary = (D_Binding)args.first();
    Obj key = args.getSecond();
    Obj elem = null;
    switch(ruleNum) {
      case 0:
        int n = ((D_Integer)key).getValue();
        elem = ary.get(n);
        break;
      case 1:
        elem = ary.get(key);
        break;
    }
    etor.pushObj(elem);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

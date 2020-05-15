package main.java.namespace.binding;

import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class SetValue extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "set!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("b", D_Binding.class, "val", null)
  };

  // Constructors ===================================================

  public SetValue() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Binding binding = (D_Binding)args.first();
    Obj val = args.getSecond();
    binding.value = val;
    etor.pushObj(binding);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

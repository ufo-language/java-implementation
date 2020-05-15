package main.java.namespace.type;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Convert extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "convert";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null, "typeName", D_Symbol.class)
  };

  // Constructors ===================================================

  public Convert() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    D_Symbol typeName = (D_Symbol)args.getSecond();
    Obj newObj = main.java.type.Convert.convert(obj, typeName);
    etor.pushObj(newObj);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

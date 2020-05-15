package main.java.namespace.type;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Check extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "check";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null, "typeName", D_Symbol.class)
  };

  // Constructors ===================================================

  public Check() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    D_Symbol typeSym = (D_Symbol)args.getSecond();
    if(obj.typeName().equals(typeSym.toString()))
      etor.pushObj(obj);
    else
      throw UFOException.wrongType("type:check", typeSym.toString(), obj);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

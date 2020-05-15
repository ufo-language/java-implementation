package main.java.namespace._global;

import main.java.data.D_Boolean;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class TypePredicate extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = ":?";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("obj", null, "typeName", D_Symbol.class)
  };

  // Constructors ===================================================

  public TypePredicate() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    D_Symbol typeSym = (D_Symbol)args.getSecond();
    String typeName = obj.typeName();
    D_Boolean res = D_Boolean.create(typeSym.toString().equals(typeName));
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

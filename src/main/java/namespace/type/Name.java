package main.java.namespace.type;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Name extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "name";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("any", null)
  };

  // Constructors ===================================================

  public Name() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj obj = args.first();
    //String typeNameStr = obj.typeName();
    //D_Symbol typeNameSym = D_Symbol.create(typeNameStr);
    D_Symbol typeName = obj.typeSymbol();
    etor.pushObj(typeName);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

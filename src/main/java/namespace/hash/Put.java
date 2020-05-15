package main.java.namespace.hash;

import main.java.data.D_Binding;
import main.java.data.D_HashTable;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Put extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "put!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_HashTable.class, "binding", D_Binding.class),
      D_PrimFunction.params("a", D_HashTable.class, "key", null, "value", null)
  };

  // Constructors ===================================================

  public Put() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_HashTable hash = (D_HashTable)args.first();
    if(ruleNum == 0) {
      D_Binding binding = (D_Binding)args.getSecond();
      hash.set(binding);
    }
    else {
      Obj key = args.getSecond();
      Obj value = args.getThird();
      hash.set(key, value);
    }
    etor.pushObj(hash);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

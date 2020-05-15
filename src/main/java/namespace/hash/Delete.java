package main.java.namespace.hash;

import main.java.data.D_HashTable;
import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Delete extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "delete!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("h", D_HashTable.class, "key", null),
      D_PrimFunction.params("h", D_HashTable.class, "key", null, "deflt", null)
  };

  // Constructors ===================================================

  public Delete() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    D_HashTable hash = (D_HashTable)args.first();
    Obj key = args.getSecond();
    Obj value = hash.delete(key);
    if(value == null) {
      if(ruleNum == 1)
        value = args.getThird();
      else
        value = D_Nil.NIL;
    }
    etor.pushObj(value);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace._global;

import main.java.data.Collection;
import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.D_Term;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.type.Convert;

public class CollectionJoin extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "++";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", Collection.class, "rhs", Collection.class)
  };

  // Constructors ===================================================

  public CollectionJoin() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj lhsObj = args.first();
    Collection lhs = (Collection)lhsObj;
    Collection rhs = (Collection)args.getSecond();
    D_Queue q = D_Queue.copyFrom(lhs);
    q.enqEach(rhs);
    Obj res;
    if(lhsObj instanceof D_Term) {
      D_Term term = (D_Term)lhsObj;
      res = D_Term.create(term.name(), D_Array.copyFrom(q), term.attribVis(), term.attrib());
    }
    else {
      res = Convert.convert(q, lhsObj.typeSymbol());
    }
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

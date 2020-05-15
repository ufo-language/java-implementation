package main.java.namespace._global;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.CheckIntegerize;

public class ArithTimes extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "*";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", Numeric.class, "rhs", Numeric.class)
  };

  // Constructors ===================================================

  public ArithTimes() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Numeric lhs = (Numeric)args.first();
    Numeric rhs = (Numeric)args.getSecond();
    if(lhs instanceof D_Integer && rhs instanceof D_Integer) {
      int i1 = lhs.asInt();
      int i2 = rhs.asInt();
      int iProd = i1 * i2;
      etor.pushObj(D_Integer.create(iProd));
    }
    else {
      float f1 = lhs.asReal();
      float f2 = rhs.asReal();
      float fProd = f1 * f2;
      etor.pushObj(CheckIntegerize.flt(fProd));
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

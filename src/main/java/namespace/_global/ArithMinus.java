package main.java.namespace._global;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Real;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.CheckIntegerize;

public class ArithMinus extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "-";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", Numeric.class),
      D_PrimFunction.params("lhs", Numeric.class, "rhs", Numeric.class)
  };

  // Constructors ===================================================

  public ArithMinus() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Numeric lhs = (Numeric)args.first();
    if(ruleNum == 0) {
      negate(etor, lhs);
      return;
    }
    Numeric rhs = (Numeric)args.getSecond();
    if(lhs instanceof D_Integer && rhs instanceof D_Integer) {
      int i1 = lhs.asInt();
      int i2 = rhs.asInt();
      int iDiff = i1 - i2;
      etor.pushObj(D_Integer.create(iDiff));
    }
    else {
      float f1 = lhs.asReal();
      float f2 = rhs.asReal();
      float fDiff = f1 - f2;
      etor.pushObj(CheckIntegerize.flt(fDiff));
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

  private void negate(Evaluator etor, Numeric lhs) {
    if(lhs instanceof D_Integer) {
      int i = lhs.asInt();
      etor.pushObj(D_Integer.create(-i));
    }
    else {
      float r = lhs.asReal();
      etor.pushObj(D_Real.create(-r));
    }
  }

}

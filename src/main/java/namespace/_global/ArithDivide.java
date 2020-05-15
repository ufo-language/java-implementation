package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.CheckIntegerize;

public class ArithDivide extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "/";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", Numeric.class, "rhs", Numeric.class)
  };

  // Constructors ===================================================

  public ArithDivide() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Numeric lhs = (Numeric)args.first();
    Numeric rhs = (Numeric)args.getSecond();
    float f1 = lhs.asReal();
    float f2 = rhs.asReal();
    float fQuot = f1 / f2;
    etor.pushObj(CheckIntegerize.flt(fQuot));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

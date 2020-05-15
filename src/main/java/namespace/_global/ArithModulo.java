package main.java.namespace._global;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Seq;
import main.java.data.Numeric;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.CheckIntegerize;

public class ArithModulo extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "%";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("seq", D_Seq.class, "step", Numeric.class),
      D_PrimFunction.params("n", Numeric.class, "mod", Numeric.class)
  };

  // Constructors ===================================================

  public ArithModulo() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    if(ruleNum == 0) {
      D_Seq seq = (D_Seq)args.first();
      Numeric from = seq.getFrom();
      Numeric to = seq.getTo();
      Numeric by = (Numeric)args.getSecond();
      D_Seq seq1 = D_Seq.create(from, to, by);
      etor.pushObj(seq1);
    }
    else {
      Numeric lhs = (Numeric)args.first();
      Numeric rhs = (Numeric)args.getSecond();
      if(lhs instanceof D_Integer && rhs instanceof D_Integer) {
        int i1 = lhs.asInt();
        int i2 = rhs.asInt();
        int iMod = i1 % i2;
        etor.pushObj(D_Integer.create(iMod));
      }
      else {
        float f1 = lhs.asReal();
        float f2 = rhs.asReal();
        float fMod = f1 % f2;
        etor.pushObj(CheckIntegerize.flt(fMod));
      }
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

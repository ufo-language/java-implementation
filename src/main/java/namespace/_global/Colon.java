package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_PrimMacro;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Colon extends D_PrimMacro {

  // Static variables ===============================================

  public static final String NAME = ":";

  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", null, "rhs", null)
  };

  // Static inner classes ===========================================

  private static class C_Colon extends Obj {
    private Obj _rhs;

    public C_Colon(Obj rhs) {
      _rhs = rhs;
    }

    @Override
    public void eval(Evaluator etor) {
      Obj lhs = etor.popObj();
      Obj elem = lhs.get(_rhs);
      etor.pushObj(elem);
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append("C_Colon{");
      _rhs.show(sb);
      sb.append('}');
    }

  }

  // Constructors ===================================================

  public Colon() {
    super(NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(NAME, _PARAMS, args);
    Obj lhs = args.first();
    Obj rhs = args.getSecond();
    C_Colon cDot = new C_Colon(rhs);
    etor.pushExpr(cDot);
    etor.pushExpr(lhs);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

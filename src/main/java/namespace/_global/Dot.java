package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_Method;
import main.java.data.D_PrimFunction;
import main.java.data.D_PrimMacro;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Methods;
import main.java.expr.E_Identifier;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Dot extends D_PrimMacro {

  // Static variables ===============================================

  public static final String NAME = ".";

  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("obj", null, "method", E_Identifier.class)
  };

  // Static inner classes ===========================================

  private static class C_Dot extends Obj {
    private E_Identifier _rhs;

    public C_Dot(E_Identifier rhs) {
      _rhs = rhs;
    }

    @Override
    public void eval(Evaluator etor) {
      Obj lhs = etor.popObj();
      D_Symbol typeSym = lhs.typeSymbol();
      Obj res = Methods.lookup(typeSym, _rhs);
      if(res == null)
        throw UFOException.methodNotFound(typeSym, _rhs);
      if(res instanceof D_PrimFunction) {
        D_PrimFunction prim = (D_PrimFunction)res;
        res = D_Method.create(prim, lhs);
      }
      etor.pushObj(res);
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append("C_Dot{");
      _rhs.show(sb);
      sb.append('}');
    }

  }

  // Constructors ===================================================

  public Dot() {
    super(NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(NAME, _PARAMS, args);
    Obj lhs = args.first();
    E_Identifier method = (E_Identifier)args.getSecond();
    C_Dot cDot = new C_Dot(method);
    etor.pushExpr(cDot);
    etor.pushExpr(lhs);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

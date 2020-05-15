package main.java.namespace._global;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_PrimMacro;
import main.java.data.IndexAssignable;
import main.java.data.Obj;
import main.java.data.contin.C_PushObj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.expr.E_InfixExpr;
import main.java.expr.E_Subscript;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Assign extends D_PrimMacro {

  // Static variables ===============================================

  private static final String _NAME = ":=";
  private static final D_List _PARAMS[] = new D_List[] {
      D_PrimFunction.params("lhs", null, "rhs", null)
  };

  // Static inner classes ===========================================

  private static class C_AssignIdent extends Obj {
    private Obj _lhs;
    
    public C_AssignIdent(Obj lhs) {
      _lhs = lhs;
    }

    @Override
    public void eval(Evaluator etor) {
      Obj rhs = etor.popObj();
      if(_lhs instanceof E_Identifier) {
        _assignIdent(etor, (E_Identifier)_lhs, rhs);
        return;
      }
      throw UFOException.objectNotAssignable(this, _lhs);
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append(typeName()).append('{');
      _lhs.show(sb);
      sb.append('}');
    }

    private void _assignIdent(Evaluator etor, E_Identifier ident, Obj value) {
      if(!etor.rebind(ident, value))
        etor.bind(ident, value);
      etor.pushObj(value);
    }

  }
  
  private static class C_AssignSubscript extends Obj {
    
    @Override
    public void eval(Evaluator etor) {
      Obj value = etor.popObj();
      Obj indexer = etor.popObj();
      Obj coll = etor.popObj();
      if(coll instanceof IndexAssignable) {
        IndexAssignable ia = (IndexAssignable)coll;
        ia.set(indexer, value);
        etor.pushObj(coll);
      }
      else
        throw UFOException.objectNotAssignable(this, coll);
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append(typeName()).append("{}");
    }

  }

  // Constructors ===================================================

  public Assign() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    Obj lhs = args.first();
    Obj rhs = args.getSecond();
    if(lhs instanceof E_Subscript) {
      E_Subscript subscr = (E_Subscript)lhs;
      etor.pushExpr(new C_AssignSubscript());
      etor.pushExpr(rhs);
      etor.pushExpr(subscr.getIndexer());
      etor.pushExpr(subscr.getCollection());
      return;
    }
    if(lhs instanceof E_Identifier) {
      etor.pushExpr(new C_AssignIdent(lhs));
      etor.pushExpr(rhs);
      return;
    }
    if(lhs instanceof E_InfixExpr) {
      E_InfixExpr infixExpr = (E_InfixExpr)lhs;
      if(infixExpr.getOper().toString().equals(":")) {
        etor.pushExpr(new C_AssignSubscript());
        etor.pushExpr(rhs);
        etor.pushExpr(new C_PushObj(infixExpr.getRhs()));
        etor.pushExpr(infixExpr.getLhs());
        return;
      }
    }
    throw UFOException.objectNotAssignable(this, lhs);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

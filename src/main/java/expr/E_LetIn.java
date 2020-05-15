package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_Nil;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_MatchBind;
import main.java.expr.contin.C_PushExpr;
import main.java.expr.contin.C_SetEnv;

public class E_LetIn extends Obj {

  // Instance variables =============================================

  private D_Binding[] _bindings;
  private E_Do _body;

  // Static methods =================================================

  public static E_LetIn create(Obj[] bindingObjs, Obj[] body) {
    D_Binding[] bindings = new D_Binding[bindingObjs.length];
    for(int n=0; n<bindingObjs.length; n++)
      bindings[n] = (D_Binding)bindingObjs[n];
    return create(bindings, body);
  }

  public static E_LetIn create(D_Binding[] bindings, Obj[] body) {
    return new E_LetIn(bindings, body);
  }

  // Constructors ===================================================
  
  private E_LetIn(D_Binding[] bindings, Obj[] body) {
    _bindings = bindings;
    _body = E_Do.create(body);
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_SetEnv.create(etor.getEnv()));
    etor.pushExpr(C_PushExpr.create(_body), null);
    for(int n=_bindings.length-1; n>=0; n--) {
      D_Binding binding = _bindings[n];
      Obj lhs = binding.key;
      Obj rhs = binding.value;
      etor.pushExpr(C_MatchBind.create(lhs), D_Nil.NIL);
      etor.pushExpr(rhs, D_Nil.NIL);
    }
  }

  @Override
  public void freeVars(D_Set vars) {
    D_Set boundVars = D_Set.create();
    for(D_Binding binding : _bindings) {
      binding.key.freeVars(boundVars);
      binding.value.freeVars(vars);
    }
    _body.freeVars(vars);
    vars.removeEach(boundVars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_LetIn.class, _bindings, _body);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("let ");
    boolean firstIter = true;
    for(D_Binding binding : _bindings) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(", ");
      binding.show(sb, " = ");
    }
    sb.append(" in ");
    D_Array.show(sb, _body.getExprs(), "", "", "; ");
    sb.append(" end");
  }

}

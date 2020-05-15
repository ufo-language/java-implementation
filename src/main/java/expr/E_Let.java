package main.java.expr;

import java.util.Objects;

import main.java.data.D_Binding;
import main.java.data.D_Nil;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_MatchBind;

public class E_Let extends Obj {

  // Instance variables =============================================

  private D_Binding[] _bindings;

  // Static methods =================================================

  public static E_Let create(Obj ... bindingObjs) {
    D_Binding[] bindings = new D_Binding[bindingObjs.length];
    for(int n=0; n<bindingObjs.length; n++)
      bindings[n] = (D_Binding)bindingObjs[n];
    return create(bindings);
  }

  public static E_Let create(D_Binding ... bindings) {
    return new E_Let(bindings);
  }

  // Constructors ===================================================
  
  private E_Let(D_Binding ... bindings) {
    _bindings = bindings;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushObj(D_Nil.NIL);
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
    vars.removeEach(boundVars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Let.class, _bindings);
  }

  public D_Binding[] getBindings() {
    return _bindings;
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
  }

}

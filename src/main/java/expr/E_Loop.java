package main.java.expr;

import java.util.Objects;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_EvalLoopCollection;

public class E_Loop extends Obj {

  // Instance variables =============================================

  private Obj _iter;
  private E_Do _body;

  // Static methods =================================================

  public static E_Loop create(Obj iter, Obj[] exprs) {
    return new E_Loop(iter, exprs);
  }

  // Constructors ===================================================
  
  private E_Loop(Obj iter, Obj[] exprs) {
    _iter = iter;
    _body = E_Do.create(exprs);
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj key;
    Obj value;
    if(_iter instanceof D_Binding) {
      D_Binding binding = (D_Binding)_iter;
      key = binding.key;
      value = binding.value;
    }
    else {
      key = E_Identifier.create("_");
      value = _iter;
    }
    etor.pushExpr(new C_EvalLoopCollection(key, _body));
    etor.pushExpr(value);
  }

  @Override
  public void freeVars(D_Set vars) {
    D_Set boundVars = D_Set.create();
    if(_iter instanceof D_Binding) {
      D_Binding binding = (D_Binding)_iter;
      binding.key.freeVars(boundVars);
      binding.value.freeVars(vars);
    }
    else
      _iter.freeVars(vars);
    _body.freeVars(vars);
    vars.removeEach(boundVars);
    }

  @Override
  public int hashCode() {
    return Objects.hash(E_Loop.class, _iter, _body);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("loop ");
    _iter.show(sb);
    D_Array.show(sb, _body.getExprs(), " do ", "", "; ");
    sb.append(" end");
  }

}

package main.java.expr;

import java.util.Objects;

import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_ApplyAbstr;
import main.java.util.UFOException;

public class E_Application extends Obj {

  // Instance variables =============================================

  private Obj _abstr;
  private D_List _args;

  // Static methods =================================================
  
  public static E_Application create(Obj abstr, D_List args) {
    return new E_Application(abstr, args);
  }

  // Constructors ===================================================

  private E_Application(Obj abstr, D_List args) {
    _abstr = abstr;
    _args = args;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_ApplyAbstr.create(_args));
    etor.pushExpr(_abstr);
  }

  @Override
  public void freeVars(D_Set vars) {
    _abstr.freeVars(vars);
    _args.freeVars(vars);
  }

  public Obj getAbstr() {
    return _abstr;
  }

  public D_List getArgs() {
    return _args;
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Application.class, this._abstr, this._args);
  }

  @Override
  public D_List match(Obj obj, D_List bindings) {
    throw UFOException.featureMissing("Application.match");
  }

  @Override
  public void show(StringBuilder sb) {
    if(_abstr instanceof E_Identifier || _abstr instanceof E_InfixExpr)
      _abstr.show(sb);
    else {
      sb.append('(');
      _abstr.show(sb);
      sb.append(')');
    }
    _args.show(sb, "(", ")");
  }

}

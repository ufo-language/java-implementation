package main.java.expr;

import java.util.HashMap;
import java.util.Objects;

import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.TypeCheck;
import main.java.expr.contin.C_ApplyInfixOp;
import main.java.show.Show;

public class E_InfixExpr extends Obj {

  // Static variables ===============================================

  private static E_Identifier _DOUBLECOLON = E_Identifier.create("::");
  
  private static HashMap<String, Integer> _PREC = new HashMap<>();
  
  static {
    _PREC.put(".", 5);
    _PREC.put(":", 5); 

    _PREC.put("^", 4);
    
    _PREC.put("*", 3);
    _PREC.put("/", 3);
    _PREC.put("%", 3);

    _PREC.put("+", 2);
    _PREC.put("-", 2);
    _PREC.put("::", 2);
    _PREC.put(":>", 2);
    _PREC.put(":?", 2);
    _PREC.put("++", 2);
    //_PREC.put("+++", 2);
    _PREC.put("..", 2);

    _PREC.put(":=", 1);
    _PREC.put("=~", 1);
    _PREC.put("==", 1);
    _PREC.put("!=", 1);
    _PREC.put("<", 1);
    _PREC.put(">", 1);
    _PREC.put("<=", 1);
    _PREC.put(">=", 1);
    //_PREC.put("##", 1);
    _PREC.put("//", 1);
    _PREC.put("in", 1);
    _PREC.put("is", 1);
    _PREC.put("isnot", 1);
    _PREC.put("and", 1);
    _PREC.put("or", 1);
    _PREC.put("xor", 1);
  }

  // Instance variables =============================================

  private Obj _lhs, _rhs;
  private E_Identifier _oper;

  // Static methods =================================================

  public static E_InfixExpr create(Obj lhs, E_Identifier oper, Obj rhs) {
    return new E_InfixExpr(lhs, oper, rhs);
  }

  // Constructors ===================================================

  private E_InfixExpr(Obj lhs, E_Identifier oper, Obj rhs) {
    _lhs = lhs;
    _oper = oper;
    _rhs = rhs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(new C_ApplyInfixOp(_lhs, _rhs));
    etor.pushExpr(_oper);
  }
  
  @Override
  public void freeVars(D_Set vars) {
    _lhs.freeVars(vars);
    _oper.freeVars(vars);
    _rhs.freeVars(vars);
  }

  public Obj getLhs() {
    return _lhs;
  }

  public E_Identifier getOper() {
    return _oper;
  }

  public Obj getRhs() {
    return _rhs;
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_InfixExpr.class, _lhs, _oper, _rhs);
  }

  /**
   * This is used during checking of a typed function parameter.
   */
  @Override
  public D_List match(Obj obj, D_List bindings) {
    if(_oper == _DOUBLECOLON) {
      if(TypeCheck.hasType(obj, _rhs)) {
        D_Binding binding = D_Binding.create(_lhs, obj);
        return D_List.create(binding, bindings);
      }
    }
    return null;
  }

  @Override
  public void show(StringBuilder sb) {
    if(_lhs instanceof E_InfixExpr) {
      E_InfixExpr lhsOper = (E_InfixExpr)_lhs;
      int thisPrecedence = _PREC.get(_oper.toString());
      int lhsPrecedence = _PREC.get(lhsOper._oper.toString());
      if(lhsPrecedence <= thisPrecedence)
        Show.show(sb, '(', _lhs, ')');
      else
        Show.show(sb, _lhs);
    }
    else
      Show.show(sb, _lhs);
    
    String operStr = _oper.toString();
    if(operStr.equals(".") || operStr.equals(":"))
      Show.show(sb, operStr);
    else
      Show.show(sb, ' ', operStr, ' ');

    if(_rhs instanceof E_InfixExpr) {
      E_InfixExpr rhsOper = (E_InfixExpr)_rhs;
      int thisPrecedence = _PREC.get(_oper.toString());
      int rhsPrecedence = _PREC.get(rhsOper._oper.toString());
      if(rhsPrecedence <= thisPrecedence)
        Show.show(sb, '(', _rhs, ')');
      else
        Show.show(sb, _rhs);
    }
    else
      Show.show(sb, _rhs);
  }

}

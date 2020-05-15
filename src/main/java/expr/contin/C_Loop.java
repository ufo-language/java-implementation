package main.java.expr.contin;

import java.util.Iterator;

import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.expr.E_Do;

public class C_Loop extends Obj {

  // Instance variables =============================================

  private Iterator<Obj> _iter;
  private Obj _varPattern;
  private E_Do _body;
  private D_List _env;
  private Obj _elem = D_Nil.NIL;
  private boolean _firstIter = true;
  private Obj _lastValue = D_Nil.NIL;

  // Constructors ===================================================

  public C_Loop(Iterator<Obj> iter, Obj varPattern, E_Do body, D_List env) {
    _iter = iter;
    _varPattern = varPattern;
    _body = body;
    D_Set freeVars = D_Set.create();
    varPattern.freeVars(freeVars);
    for(Obj varObj : freeVars) {
      E_Identifier var = (E_Identifier)varObj;
      env = env.bind(var,  D_Nil.NIL);
    }
    _env = env;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    if(_firstIter)
      _firstIter = false;
    else
      _lastValue = etor.popObj();
    if(_iter.hasNext()) {
      _elem = _iter.next();
      D_List match = _varPattern.match(_elem);
      for(Obj bindingObj : match) {
        D_Binding binding = (D_Binding)bindingObj;
        _env.rebind(binding);
      }
      etor.pushExpr(this);
      //etor.pushExpr(C_Drop.create());
      etor.pushExpr(_body, _env);
    }
    else
      etor.pushObj(_lastValue);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{');
    _elem.show(sb);
    sb.append(", ");
    _body.show(sb);
    sb.append('}');
  }

}

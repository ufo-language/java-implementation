package main.java.expr.contin;

import main.java.data.D_Binding;
import main.java.data.D_Closure;
import main.java.data.D_List;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.util.UFOException;

public class C_MatchBind extends Obj {

  // Instance variables =============================================

  public Obj lhs;

  // Static methods =================================================

  public static C_MatchBind create(Obj lhs) {
    return new C_MatchBind(lhs);
  }

  // Constructors ===================================================

  private C_MatchBind(Obj lhs) {
    this.lhs = lhs;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj value = etor.popObj();
    D_List bindings = this.lhs.match(value);
    if(bindings == null)
      throw UFOException.bindingMismatch(lhs, value);
    D_Queue closures = D_Queue.create();
    for(Obj bindingObj : bindings) {
      D_Binding binding = (D_Binding)bindingObj;
      E_Identifier ident = (E_Identifier)binding.key;
      if(ident.isAnonymous())
        continue;
      value = binding.value;
      etor.bind(ident, value);
      if(value instanceof D_Closure)
        closures.enq(value);
    }
    // close any closures that were found
    for(Obj closureObj : closures) {
      D_Closure closure = (D_Closure)closureObj;
      closure.close(etor);
    }
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_MatchBind{");
    lhs.show(sb);
    sb.append('}');
  }

}

package main.java.data.contin;

import main.java.data.D_List;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Abstraction;

public class C_StoreMemo extends Obj {

  // Instance variables =============================================

  private E_Abstraction _abstr;
  private D_List _args;

  // Constructors ===================================================

  public C_StoreMemo(E_Abstraction abstr, D_List args) {
    _abstr = abstr;
    _args = args;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj val = etor.getObjStack().first();
    _abstr.saveMemo(_args, val);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{');
    _abstr.show(sb);
    sb.append(", ");
    _args.show(sb);
    sb.append('}');
  }

}

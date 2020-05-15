package main.java.evaluator;

import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.Obj;
import main.java.expr.E_Identifier;
import main.java.i18n.Strings;

public class TypedParam extends Obj {

  // Instance variables =============================================

  private E_Identifier _name;
  private Class<? extends Obj> _clss;

  // Constructors ===================================================

  public TypedParam(String name, Class<? extends Obj> clss) {
    _name = E_Identifier.create(name);
    _clss = clss;
  }

  // Instance methods ===============================================

  @Override
  public D_List match(Obj obj, D_List bindings) {
    if(_clss == null || _clss.isAssignableFrom(obj.getClass()))
      return D_List.create(D_Binding.create(_name, obj), bindings);
    return null;
  }

  @Override
  public void show(StringBuilder sb) {
    _name.show(sb);
    if(_clss != null)
      sb.append(" :: ").append(Strings.get(_clss.getSimpleName()));
  }
}
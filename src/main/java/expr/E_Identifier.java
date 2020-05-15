package main.java.expr;

import java.util.HashMap;
import java.util.Objects;

import main.java.data.D_Binding;
import main.java.data.D_List;
import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.util.UFOException;

public class E_Identifier extends Obj {

  // Static variables ===============================================
  
  private static HashMap<String, E_Identifier> _internedIdents =
      new HashMap<String, E_Identifier>();

  // Instance variables =============================================
  
  private String _name;

  // Static methods =================================================
  
  public static E_Identifier create(String name) {
    E_Identifier ident = _internedIdents.get(name);
    if(ident == null) {
      ident = new E_Identifier(name);
      _internedIdents.put(name, ident);
    }
    return ident;
  }

  // Constructors ===================================================

  private E_Identifier(String name) {
    _name = name;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor)
  {
    Obj obj = etor.lookup(this);
    if(obj == null)
      throw UFOException.unboundIdentifier(this);
    etor.pushObj(obj);
  }

  @Override
  public boolean equals(Object other) {
    return this == other;
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Identifier.class, _name);
  }

  public boolean isAnonymous() {
    return _name.charAt(0) == '_';
  }

  @Override
  public void freeVars(D_Set vars) {
    vars.add(this);
  }

  @Override
  public D_List match(Obj obj, D_List bindings) {
    D_Binding binding = D_Binding.create(this, obj);
    bindings = D_List.create(binding, bindings);
    return bindings;
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(_name);
  }

}

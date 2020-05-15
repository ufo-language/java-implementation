package main.java.data;

import java.util.Objects;

import main.java.data.contin.C_MakeBinding;
import main.java.evaluator.Evaluator;
import main.java.show.Show;
import main.java.util.UFOException;

public class D_Binding extends Obj {

  // Instance variables =============================================

  public Obj key, value;

  // Static methods =================================================

  public static D_Binding create(Obj key, Obj value) {
    return new D_Binding(key, value);
  }

  // Constructors ===================================================

  private D_Binding(Obj key, Obj value) {
    this.key = key;
    this.value = value;
  }

  // Instance methods ===============================================

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Binding))
      throw UFOException.unableToCompare(this, other);
    D_Binding bnd = (D_Binding)other;
    int res = key.compareTo(bnd.key);
    if(res != 0)
      return res;
    return value.compareTo(bnd.value);
  }

  @Override
  public boolean equals(Obj other) {
    if(other instanceof D_Binding) {
      D_Binding binding = (D_Binding)other;
      return key.equals(binding.key) && value.equals(binding.value);
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_MakeBinding.create());
    etor.pushExpr(key);
    etor.pushExpr(value);
  }

  @Override
  public void freeVars(D_Set vars) {
    value.freeVars(vars);
    D_Set boundVars = D_Set.create();
    key.freeVars(boundVars);
    vars.removeEach(boundVars);
  }

  @Override
  public Obj getIndex(int index) {
    switch(index) {
      case 0: return this.key;
      case 1: return value;
    }
    return null;
  }

  @Override
  public Obj getKey(Obj key) {
    return this.key.equals(key) ? value : null;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public D_List match(Obj other, D_List bindings) {
    if(this == other)
      return bindings;
    if(other instanceof D_Binding) {
      D_Binding binding = (D_Binding)other;
      bindings = key.match(binding.key, bindings);
      if(bindings != null)
        return value.match(binding.value, bindings);
    }
    return null;
  }

  @Override
  public void show(StringBuilder sb) {
    show(sb, "=");
  }

  public void show(StringBuilder sb, String equals) {
    if(key instanceof D_Binding)
      Show.show(sb, "(", key, ")");
    else
      key.show(sb);
    sb.append(equals);
    if(value instanceof D_Binding)
      Show.show(sb, "(", value, ")");
    else
      value.show(sb);
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = D_Array.create(key, value);
        break;
      case "Binding":
        newObj = D_Binding.create(key, value);
        break;
      case "HashTable":
        newObj = D_HashTable.create(this);
        break;
      case "List":
        newObj = D_List.create(key, value);
        break;
      case "Queue":
        newObj = D_Queue.create(key, value);
        break;
      case "Set":
        newObj = D_Set.create(key, value);
        break;
    }
    return newObj;
  }

}

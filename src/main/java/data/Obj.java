package main.java.data;

import main.java.evaluator.Evaluator;
import main.java.evaluator.Methods;
import main.java.expr.E_Identifier;
import main.java.i18n.Strings;
import main.java.util.UFOException;

public abstract class Obj implements Comparable<Obj> {

  // Instance variables =============================================
  
  protected D_Symbol _typeSymbol;

  // Constructors ===================================================

  protected Obj() {
    _typeSymbol = D_Symbol.create(Strings.get(this.getClass().getSimpleName()));
  }

  /**
   * Used by the D_Symbol class to avoid unbounded recursion.
   */
  protected Obj(D_Symbol typeSym) {
    _typeSymbol = typeSym;
  }

  // Instance methods ===============================================

  public boolean boolValue() {
    return false;
  }

  public int compareTo(Obj other) {
    throw UFOException.unableToCompare(this, other);
  }

  public D_Boolean contains(Obj other) {
    Obj res = indexOf(other);
    if(res != null)
      return res == D_Nil.NIL ? D_Boolean.FALSE : D_Boolean.TRUE;
    return null;
  }

  public void display(StringBuilder sb) {
    show(sb);
  }

  @Override
  public boolean equals(Object other) {
    if(this == other)
      return true;
    if(other instanceof Obj)
      return this.equals((Obj)other);
    return false;
  }

  /**
   * Subclasses should override.
   */
  public boolean equals(Obj obj) {
    return this == obj;
  }
  
  public void eval(Evaluator etor) {
    etor.pushObj(this);
  }
  
  public void freeVars(D_Set vars) {}

  public final Obj get(int index) {
    Obj value = getIndex(index);
    if(value == null)
      throw UFOException.indexOutOfBounds((Indexable)this, index);
    return value;
  }

  public final Obj get(E_Identifier method) {
    Obj value = Methods.lookup(typeSymbol(), method);
    if(value == null)
      value = getKey(method);
    return value;
  }

  public final Obj get(Obj key) {
    if(key instanceof D_Integer)
      return getIndex(((D_Integer)key).asInt());
    Obj value = getKey(key);
    if(value == null)
      throw UFOException.keyNotFound(this, key);
    return value;
  }

  public Obj getIndex(int index) {
    throw UFOException.objectNotIndexable(this);
  }

  public Obj getKey(Obj key) {
    throw UFOException.objectNotCollection(this);
  }

  public Obj indexOf(Obj other) {
    return null;
  }

  public D_List match(Obj obj) {
    return match(obj, D_List.EMPTY);
  }

  public D_List match(Obj obj, D_List bindings) {
    if(this.equals(obj))
      return bindings;
    return null;
  }

  public void show(StringBuilder sb) {
    sb.append(typeName()).append("{}");
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    show(sb);
    return sb.toString();
  }

  public Obj typeConvert(String typeName) {
    return null;
  }

  public String typeName() {
    return _typeSymbol.getName();
  }

  public D_Symbol typeSymbol() {
    return _typeSymbol;
  }

}

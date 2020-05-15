package main.java.data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import main.java.data.contin.C_MakeTerm;
import main.java.evaluator.Evaluator;
import main.java.util.UFOException;

public class D_Term extends Obj implements Collection, Indexable, IndexAssignable {

  // Instance variables =============================================

  private D_Symbol _name;
  private D_Array _elems;
  private boolean _attribVisible;
  private Obj _attrib;

  // Static methods =================================================

  public static D_Term create(String name) {
    return D_Term.create(D_Symbol.create(name));
  }

  public static D_Term create(D_Symbol name) {
    return D_Term.create(name, D_Array.EMPTY);
  }

  public static D_Term create(String name, D_Array args) {
    return D_Term.create(D_Symbol.create(name), args);
  }

  public static D_Term create(D_Symbol name, D_Array args) {
    return D_Term.create(name, args, false, D_Nil.NIL);
  }

  public static D_Term create(D_Symbol name, D_Array args, boolean attribVisible, Obj attrib) {
    return new D_Term(name, args, attribVisible, attrib);
  }

  // Constructors ===================================================

  private D_Term(D_Symbol name, D_Array args, boolean attribVisible, Obj attrib) {
    this._name = name;
    this._elems = args;
    this._attribVisible = attribVisible;
    this._attrib = attrib;
  }

  // Instance methods ===============================================

  // Property methods
  
  public D_Symbol name() { return _name; }
  public D_Symbol name(D_Symbol name) { _name = name; return name; }
  public D_Array elems() { return _elems; }
  public D_Array elems(D_Array elems) { _elems = elems; return elems; }
  public boolean attribVis() { return _attribVisible; }
  public void attribVis(boolean vis) { _attribVisible = vis; }
  public Obj attrib() { return _attrib; }
  public Obj attrib(Obj attrib) { _attrib = attrib; return attrib; }
  
  // Other methods
  
  public int count() {
    return _elems.count();
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Term))
      throw UFOException.unableToCompare(this, other);
    D_Term trm = (D_Term)other;
    return Arrays.compare(new Obj[] {_name, _elems, _attrib},
                          new Obj[] {trm._name, trm._elems, trm._attrib});
  }

  @Override
  public Collection dom() {
    return _elems.dom();
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Term) {
      D_Term term = (D_Term)other;
      return _name.equals(term._name)
          && _elems.equals(term._elems)
          && _attrib.equals(term._attrib);
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    C_MakeTerm cMakeTerm = C_MakeTerm.create(_name, _attribVisible);
    etor.pushExpr(cMakeTerm);
    etor.pushExpr(_elems);
    etor.pushExpr(_attrib);
  }

  public Obj getIndex(int index) {
    return _elems.getIndex(index);
  }

  public Obj getKey(Obj key) {
    return _elems.getKey(key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_name, _elems, _attribVisible, _attrib);
  }

  @Override
  public Obj indexOf(Obj other) {
    return _elems.indexOf(other);
  }

  @Override
  public Iterator<Obj> iterator() {
    return _elems.iterator();
  }

  @Override
  public D_List match(Obj other, D_List bindings) {
    if(this == other)
      return bindings;
    D_List result = null;
    if(other instanceof D_Term) {
      D_Term term = (D_Term)other;
      bindings = _name.match(term._name, bindings);
      if(bindings != null) {
        bindings = _elems.match(term._elems, bindings);
        if(bindings != null) {
          // If the current attribute is Nothing, then it's a wildcard that
          // automatically matches anyting.
          if(_attrib != D_Nil.NIL) 
            bindings = _attrib.match(term._attrib, bindings);
          result = bindings;
        }
      }
    }
    return result;
  }

  public void set(int n, Obj obj) {
    _elems.setRaw(n, obj);
  }

  public void set(Obj key, Obj value) {
    _elems.set(key, value);
  }

  @Override
  public void show(StringBuilder sb) {
    _name.show(sb);
    _elems.show(sb);
    if(_attribVisible) {
      sb.append('%');
      _attrib.show(sb);
    }
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        D_Array ary = D_Array.createN(4);
        ary.setRaw(0, _name);
        ary.setRaw(1, _elems);
        ary.setRaw(2, D_Boolean.create(_attribVisible));
        ary.setRaw(3, _attrib);
        newObj = ary;
        break;
      case "List":
        D_Queue q1 = D_Queue.create();
        q1.enq(_name);
        q1.enq(_elems);
        q1.enq(D_Boolean.create(_attribVisible));
        q1.enq(_attrib);
        newObj = q1.asList();
        break;
      case "Queue":
        D_Queue q2 = D_Queue.create();
        q2.enq(_name);
        q2.enq(_elems);
        q2.enq(D_Boolean.create(_attribVisible));
        q2.enq(_attrib);
        newObj = q2;
        break;
      case "Term":
        newObj = new D_Term(_name, _elems, _attribVisible, _attrib);
        break;
    }
    return newObj;
  }

}

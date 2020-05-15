package main.java.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import main.java.data.contin.C_MakePair;
import main.java.data.iterator.ListIterator;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.util.UFOException;

public class D_List extends Obj implements Collection, Indexable, IndexAssignable {

  // Static variables ===============================================

  public static final D_List EMPTY = new D_List(null, null);

  // Instance variables =============================================

  private Obj _first, _rest;
  private D_Integer _hashCode = null;

  // Static initializer =============================================

  static {
    EMPTY._first = null;
    EMPTY._rest = null;
  }

  // Static methods =================================================

  public static D_List copyFrom(Iterable<Obj> iter) {
    D_Queue q = D_Queue.copyFrom(iter);
    return q.asList();
  }

  public static D_List create() {
    return EMPTY;
  }

  public static D_List create(Obj first) {
    return create(first, D_List.EMPTY);
  }

  public static D_List create(Obj first, Obj rest) {
    return new D_List(first, rest);
  }

  public static D_List createN(Obj ... objs) {
    D_List list = D_List.create();
    for(int n=objs.length - 1; n>=0; n--)
      list = D_List.create(objs[n], list);
    return list;
  }

  // Constructors ===================================================

  private D_List(Obj first, Obj rest) {
    this._first = first;
    this._rest = rest;
  }

  // Instance methods ===============================================

  // Property methods
  public Obj first() {
    if(this == EMPTY)
      throw UFOException.listEmpty();
    return _first;
  }

  public Obj first(Obj first) {
    if(this == EMPTY)
      throw UFOException.listEmpty();
    _first = first;
    _hashCode = null;
    return first;
  }

  public Obj rest() {
    return _rest;
  }

  public Obj rest(Obj rest) {
    if(this == EMPTY)
      throw UFOException.listEmpty();
    _rest = rest;
    _hashCode = null;
    return rest;
  }

  // Other methods

  public Obj[] asRawArray() {
    ArrayList<Obj> al = new ArrayList<>();
    for(Obj obj : this)
      al.add(obj);
    Obj[] objs = new Obj[al.size()];
    return al.toArray(objs);
  }

  public D_List bind(E_Identifier ident, Obj value) {
    if(ident.isAnonymous())
      return this;
    return new D_List(D_Binding.create(ident, value), this);
  }

  public boolean boolValue() {
    return this != EMPTY;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_List))
      throw UFOException.unableToCompare(this, other);
    if(this == EMPTY && other == EMPTY)
      return 0;
    if(this == EMPTY)
      return -1;
    if(other == EMPTY)
      return 1;
    D_List lst = (D_List)other;
    int res = _first.compareTo(lst._first);
    if(res != 0)
      return res;
    return _rest.compareTo(lst._rest);
  }

  public int count() {
    int count = 0;
    for(@SuppressWarnings("unused") Obj obj : this)
      count++;
    return count;
  }

  public D_List copy() {
    D_Queue q = D_Queue.create(this);
    return q.asList();
  }

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_List) {
      D_List list = (D_List)other;
      return _first.equals(list._first) && _rest.equals(list._rest);
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    if(this == EMPTY)
      etor.pushObj(this);
    else {
      etor.pushExpr(C_MakePair.create());
      etor.pushExpr(_first);
      etor.pushExpr(_rest);
    }
  }

  @Override
  public void freeVars(D_Set vars) {
    if(this != EMPTY) {
      _first.freeVars(vars);
      _rest.freeVars(vars);
    }
  }

  public Obj getIndex(int index) {
    D_List lst = this;
    while(!lst.isEmpty()) {
      if(index-- == 0)
        return lst._first;
      lst = lst.getRest();
    }
    return null;
  }

  public Obj getKey(Obj key) {
    for(Obj obj1 : this) {
      if(obj1 instanceof D_Binding) {
        D_Binding binding = (D_Binding)obj1;
        if(binding.key.equals(key))
          return binding.value;
      }
    }
    return null;
  }

  public D_List getRest() {
    if(_rest instanceof D_List)
      return (D_List)_rest;
    return D_List.create(_rest);
  }

  public Obj getSecond() {
    return ((D_List)_rest)._first;
  }

  public Obj getThird() {
    return ((D_List)((D_List)_rest)._rest)._first;
  }

  @Override
  public int hashCode() {
    if(_hashCode == null)
      rehash();
    return _hashCode.asInt();
  }

  @Override
  public Obj indexOf(Obj other) {
    int n = 0;
    for(Obj elem : this) {
      if(other.equals(elem))
         return D_Integer.create(n);
      n++;
    }
    return D_Nil.NIL;
  }

  public boolean isEmpty() {
    return this == EMPTY;
  }

  @Override
  public Iterator<Obj> iterator() {
    return new ListIterator(this);
  }

  public D_Binding locate(Obj key) {
    D_List list = this;
    while(!list.isEmpty()) {
      if(list._first instanceof D_Binding) {
        D_Binding binding = (D_Binding)list._first;
        if(binding.key == key)
          return binding;
      }
      if(list._rest instanceof D_List)
        list = (D_List)list._rest;
      else
        list = D_List.create(list._rest);
    }
    return null;
  }

  public Obj lookup(Obj key) {
    D_Binding binding = locate(key);
    if(binding != null)
      return binding.value;
    return null;
  }

  public D_List match(Obj other, D_List bindings) {
    if(this == other)
      return bindings;
    if(this == EMPTY || other == EMPTY)
      return null;
    if(other instanceof D_List) {
      D_List list = (D_List)other;
      bindings = _first.match(list._first, bindings);
      if(bindings != null)
        return _rest.match(list._rest, bindings);
    }
    return null;
  }

  public boolean rebind(D_Binding binding) {
    return rebind(binding.key, binding.value);
  }

  public boolean rebind(Obj key, Obj value) {
    if(key instanceof E_Identifier) {
      if(((E_Identifier)key).isAnonymous())
        return true; 
    }
    D_Binding binding = locate(key);
    if(binding == null)
      return false;
    binding.value = value;
    rehash();
    return true;
  }

  public void rehash() {
    if(this == EMPTY)
      _hashCode = D_Integer.create(Objects.hash(D_List.class));
    else {
      _hashCode = D_Integer.create(0); // stops unbounded recursion
      _hashCode = D_Integer.create(Objects.hash(D_List.class, _first, _rest));
    }
  }

  public D_List reverse() {
    D_Stack stk = D_Stack.create();
    for(Obj elem : this)
      stk.push(elem);
    return stk.asList();
  }

  @Override
  public void set(Obj key, Obj value) {
    if(key instanceof D_Integer)
      setIndex(((D_Integer)key).asInt(), value);
    else
      setKey(key, value);
  }

  public void setIndex(int index, Obj value) {
    D_List lst = this;
    for(int n=0; n<index; n++) {
      lst = lst.getRest();
      if(lst.isEmpty())
        throw UFOException.indexOutOfBounds(this, index);
    }
    lst.first(value);
  }

  public void setKey(Obj key, Obj value) {
    rebind(key, value);
  }

  @Override
  public void show(StringBuilder sb) {
    show(sb, "[", "]");
  }

  public void show(StringBuilder sb, String open, String close) {
    sb.append(open);
    boolean firstIter = true;
    D_List list = this;
    while(list != EMPTY) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(", ");
      list._first.show(sb);
      Obj rest = list._rest;
      if(rest instanceof D_List)
        list = (D_List)rest;
      else {
        sb.append(" | ");
        rest.show(sb);
        break;
      }
    }
    sb.append(close);
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        D_Array ary = D_Array.copyFrom(this, count());
        newObj = ary;
        break;
      case "Binding":
        newObj = D_Binding.create(_first, _rest);
        break;
      case "HashTable":
        newObj = D_HashTable.copyFrom(this);
        break;
      case "List":
        newObj = copy();
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Set":
        newObj = D_Set.copyFrom(this);
        break;
      case "Stack":
        newObj = D_Stack.copyFrom(this);
        break;
      case "String":
        StringBuilder sb = new StringBuilder();
        for(Obj elem : this)
          elem.display(sb);
        newObj = D_String.create(sb.toString());
        break;
    }
    return newObj;
  }

}

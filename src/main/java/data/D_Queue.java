package main.java.data;

import java.util.Iterator;
import java.util.Objects;

import main.java.data.contin.C_MakeQueue;
import main.java.data.iterator.ListIterator;
import main.java.evaluator.Evaluator;
import main.java.util.UFOException;

public class D_Queue extends Obj implements Collection, Indexable {

  // Static variables ===============================================

  static private D_List _recycledPairs = D_List.EMPTY;

  // Instance variables =============================================

  private D_List _first, _last;
  private int _count;

  // Static methods =================================================

  public static D_Queue copyFrom(Iterable<Obj> iter) {
    D_Queue q = D_Queue.create();
    for(Obj obj : iter)
      q.enq(obj);
    return q;
  }

  public static D_Queue create(Obj ... objs) {
    return new D_Queue(objs);
  }

  // Constructors ===================================================

  private D_Queue(Obj ... objs) {
    _first = D_List.EMPTY;
    _last = D_List.EMPTY;
    _count = 0;
    for(Obj obj : objs)
      enq(obj);
  }

  // Instance methods ===============================================

  public D_List asList() {
    return _first;
  }

  public Obj[] asRawArray() {
    Obj[] objs = new Obj[_count];
    D_List elem = _first;
    for(int n=0; n<_count; n++) {
      objs[n] = elem.first();
      elem = (D_List)elem.rest();
    }
    return objs;
  }

  @Override
  public boolean boolValue() {
    return _count > 0;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Queue))
      throw UFOException.unableToCompare(this, other);
    D_Queue q = (D_Queue)other;
    return _first.compareTo(q._first);
  }

  public int count() {
    return _count;
  }

  public Obj deq() {
    Obj value = null;
    if(_count > 0) {
      value = _first.first();
      D_List rest = (D_List)_first.rest();
      // recycle the node
      _first.first(null);
      _first.rest(_recycledPairs);
      _recycledPairs = _first;
      _first = rest;
      _count--;
    }
    return value;
  }

  public Obj deq(Obj pattern) {
    D_List prev = null;
    D_List node = _first;
    D_List bindings = null;
    Obj res = null;
    while(!node.isEmpty()) {
      bindings = pattern.match(node.first());
      if(bindings != null) {
        res = node.first();
        D_List rest = (D_List)node.rest();
        // recycle the node
        node.first(null);
        node.rest(_recycledPairs);
        _recycledPairs = node;
        if(prev != null)
          prev.rest(rest);
        else
          _first = rest;
        _count--;
        break;
      }
      prev = node;
      node = (D_List)node.rest();
    }
    if(res == null)
      return null;
    return D_List.create(res, bindings);
  }

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  public void enq(Obj obj) {
    D_List node;
    if(_recycledPairs.isEmpty())
      node = D_List.create(obj);
    else {
      // use a recycled node
      node = _recycledPairs;
      node.first(obj);
      _recycledPairs = _recycledPairs.getRest();
      node.rest(D_List.EMPTY);
    }
    if(_count > 0)
      _last.rest(node);
    else
      _first = node;
    _last = node;
    _count++;
  }

  public void enqEach(Collection coll) {
    for(Obj obj : coll)
      enq(obj);
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Queue) {
      D_Queue q = (D_Queue)other;
      return _first.equals(q._first);
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_MakeQueue.create(_count));
    for(Obj obj : _first)
      etor.pushExpr(obj);
  }

  @Override
  public void freeVars(D_Set vars) {
    assert(false);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object[])_first.asRawArray());
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
    return _count == 0;
  }

  @Override
  public Iterator<Obj> iterator() {
    return new ListIterator(_first);
  }

  /**
   * @return a D_Pair of [the-element-matched | list-of-match-bindings]
   */
  public D_List removeMatching(Obj pattern) {
    D_List prev = D_List.EMPTY;
    D_List node = _first;
    D_List bindings = D_List.EMPTY;
    while(!node.isEmpty()) {
      D_List matchRes = pattern.match(node.first(), bindings);
      if(matchRes != null) {
        if(node == _first)
          _first = (D_List)node.rest();
        else
          prev.rest(node.rest());
        if(node == _last)
          _last = prev;
        return D_List.create(node.first(), matchRes);
      }
      prev = node;
      node = (D_List)node.rest();
    }
    return null;
  }

  public void setLast(Obj obj) {
    _last.rest(obj);
  }

  @Override
  public void show(StringBuilder sb) {
    show(sb, "~[", "]");
  }

  public void show(StringBuilder sb, String open, String close) {
    _first.show(sb, open, close);
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = D_Array.copyFrom(this, count());
        break;
      case "Binding":
        newObj = D_Binding.create(_first.first(), _first.rest());
        break;
      case "HashTable":
        newObj = D_HashTable.copyFrom(this);
        break;
      case "List":
        newObj = D_List.copyFrom(this);;
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Set":
        newObj = D_Set.copyFrom(this);
        break;
      case "String":
        StringBuilder sb = new StringBuilder();
        for(Obj elem : this._first)
          elem.display(sb);
        newObj = D_String.create(sb.toString());
        break;
    }
    return newObj;
  }

}

package main.java.data;

import java.util.Iterator;

import main.java.data.iterator.ListIterator;
import main.java.util.UFOException;

public class D_Stack extends Obj implements Collection, Indexable {

  // Instance variables =============================================

  private D_List _elems = D_List.EMPTY;
  private int _count;

  // Static methods =================================================

  public static D_Stack copyFrom(Iterable<Obj> iter) {
    D_Stack stkTemp = D_Stack.create();
    for(Obj obj : iter)
      stkTemp.push(obj);
    D_Stack stk = D_Stack.create();
    for(Obj obj : stkTemp)
      stk.push(obj);
    return stk;
  }

  public static D_Stack create(Obj ... elems) {
    return new D_Stack(elems);
  }

  // Constructors ===================================================

  private D_Stack(Obj ... elems) {
    for(int n=elems.length - 1; n>=0; n--)
      push(elems[n]);
  }

  // Instance methods ===============================================

  public D_List asList() {
    return _elems;
  }

  @Override
  public boolean boolValue() {
    return _count > 0;
  }

  public D_Stack copy() {
    D_Queue q = D_Queue.copyFrom(this);
    D_Stack stk = new D_Stack();
    stk._elems = q.asList();
    stk._count = _count;
    return stk;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Stack))
      throw UFOException.unableToCompare(this, other);
    D_Stack stk = (D_Stack)other;
    return _elems.compareTo(stk._elems);
  }

  public int count() {
    return _count;
  }

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  public boolean isEmpty() {
    return _count == 0;
  }

  @Override
  public int hashCode() {
    return _elems.hashCode();
  }

  @Override
  public Iterator<Obj> iterator() {
    return new ListIterator(_elems);
  }

  public Obj pop() {
    if(_count == 0)
      throw UFOException.emptyStack();
    Obj elem = _elems.first();
    _elems = _elems.getRest();
    _count--;
    return elem;
  }

  public void push(Obj obj) {
    _elems = D_List.create(obj, _elems);
    _count++;
  }

  @Override
  public void show(StringBuilder sb) {
    _elems.show(sb, "$[", "]");
  }

  public Obj top() {
    if(_elems.isEmpty())
      throw UFOException.emptyStack();
    return _elems.first();
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = D_Array.copyFrom(this, _count);
        break;
      case "Boolean":
        newObj = D_Boolean.create(_count != 0);
        break;
      case "HashTable":
        D_HashTable hash = D_HashTable.create();
        for(Obj elem : _elems) {
          if(elem instanceof D_Binding)
            hash.set((D_Binding)elem);
          else
            return null;
        }
        newObj = hash;
        break;
      case "List":
        newObj = D_List.copyFrom(this);
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Stack":
        newObj = copy();
        break;
      case "String":
        StringBuilder sb = new StringBuilder();
        for(Obj elem : _elems)
          elem.display(sb);
        newObj = D_String.create(sb.toString());
        break;
    }
    return newObj;
  }

}

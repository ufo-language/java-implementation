package main.java.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import main.java.data.contin.C_MakeHashTable;
import main.java.data.iterator.HashIterator;
import main.java.evaluator.Evaluator;

public class D_HashTable extends Obj implements Collection, Indexable, IndexAssignable {

  // Instance variables =============================================

  private HashMap<Obj, Obj> _hash = new HashMap<Obj, Obj>();

  // Static methods =================================================

  public static D_HashTable copyFrom(Iterable<Obj> iter) {
    D_HashTable hash = D_HashTable.create();
    for(Obj obj : iter)
      if(obj instanceof D_Binding)
        hash.set((D_Binding)obj);
    return hash;
  }

  public static D_HashTable create(D_Binding ... bindings) {
    return new D_HashTable(bindings);
  }

  // Constructors ===================================================

  private D_HashTable(D_Binding[] bindings) {
    for(D_Binding binding : bindings)
      _hash.put(binding.key, binding.value);
  }

  // Instance methods ===============================================

  public D_HashTable add(Obj key, Obj value) {
    this.set(key, value);
    return this;
  }

  public D_Boolean contains(Obj key) {
    return D_Boolean.create(_hash.containsKey(key));
  }

  public D_HashTable copy() {
    D_HashTable hash = D_HashTable.create();
    for(Obj key : _hash.keySet())
      hash.set(key, _hash.get(key));
    return hash;
  }

  public int count() {
    return _hash.size();
  }

  public Obj delete(Obj key) {
    return _hash.remove(key);
  }

  @Override
  public Collection dom() {
    return keys();
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_HashTable) {
      D_HashTable hash = (D_HashTable)other;
      if(count() == hash.count()) {
        for(Obj key : this._hash.keySet()) {
          Obj thisVal = _hash.get(key);
          Obj otherVal = hash._hash.get(key);
          if(!thisVal.equals(otherVal))
            return false;
        }
        return true;
      }
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_MakeHashTable.create(_hash.size()));
    for(Obj key : _hash.keySet()) {
      etor.pushExpr(key);
      etor.pushExpr(_hash.get(key));
    }
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj key : _hash.keySet()) {
      key.freeVars(vars);
      Obj value = _hash.get(key);
      value.freeVars(vars);
    }
  }

  @Override
  public Obj getIndex(int index) {
    return getKey(D_Integer.create(index));
  }

  @Override
  public Obj getKey(Obj key) {
    return _hash.get(key);
  }

  public Obj getKey(Obj key, Obj deflt) {
    return _hash.getOrDefault(key, deflt);
  }

  @Override
  public int hashCode() {
    return _hash.hashCode();
  }

  @Override
  public Iterator<Obj> iterator() {
    return new HashIterator(this);
  }

  public D_Set keys() {
    Set<Obj> keySet = _hash.keySet();
    return D_Set.copyFrom(keySet);
  }

  public void set(D_Binding binding) {
    _hash.put(binding.key, binding.value);
  }

  @Override
  public void set(Obj key, Obj value) {
    _hash.put(key, value);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("#{");
    boolean firstIter = true;
    for(Obj key : _hash.keySet()) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(", ");
      Obj value = _hash.get(key);
      sb.append(key).append('=').append(value);
    }
    sb.append('}');
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        D_Array ary = D_Array.createN(_hash.size());
        int n = 0;
        for(Obj binding : this)
          ary.setRaw(n++, binding);
        newObj = ary;
        break;
      case "HashTable":
        newObj = copy();
        break;
      case "List":
        D_Queue q1 = D_Queue.create();
        for(Obj binding : this)
          q1.enq(binding);
        newObj = q1.asList();
        break;
      case "Queue":
        D_Queue q2 = D_Queue.create();
        for(Obj binding : this)
          q2.enq(binding);
        newObj = q2;
        break;
      case "Set":
        D_Set set = D_Set.create();
        for(Obj binding : this)
          set.add(binding);
        newObj = set;
        break;
    }
    return newObj;
  }

}

package main.java.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import main.java.data.contin.C_MakeSet;
import main.java.evaluator.Evaluator;
import main.java.util.UFOException;

public class D_Set extends Obj implements Collection, Indexable {

  // Instance variables =============================================

  private HashSet<Obj> _set = new HashSet<Obj>();

  // Static methods =================================================

  public static D_Set copyFrom(Iterable<Obj> iter) {
    D_Set set = D_Set.create();
    for(Obj obj : iter)
      set.add(obj);
    return set;
  }

  public static D_Set create(Obj ... objs) {
    return new D_Set(objs);
  }

  // Constructors ===================================================

  private D_Set(Obj ... objs) {
    for(Obj obj : objs)
      _set.add(obj);
  }

  // Instance methods ===============================================

  public void add(Obj ...objs) {
    for(Obj obj : objs)
      _set.add(obj);
  }

  @Override
  public boolean boolValue() {
    return _set.size() > 0;
  }

  @Override
  public D_Boolean contains(Obj obj) {
    return D_Boolean.create(_set.contains(obj));
  }

  public boolean contains_raw(Obj obj) {
    return _set.contains(obj);
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Set))
      throw UFOException.unableToCompare(this, other);
    D_Set set = (D_Set)other;
    Obj[] objs1 = _set.toArray(new Obj[] {});
    Obj[] objs2 = set._set.toArray(new Obj[] {});
    Arrays.sort(objs1);
    Arrays.sort(objs2);
    return Arrays.compare(objs1, objs2);
  }

  public int count() {
    return _set.size();
  }

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Set) {
      D_Set set = (D_Set)other;
      return _set.equals(set._set);
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_MakeSet.create(_set.size()));
    for(Obj obj : _set)
      etor.pushExpr(obj);
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj obj : _set)
      obj.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return _set.hashCode();
  }

  public D_Set intersect(D_Set otherSet) {
    D_Set newSet = D_Set.create();
    for(Obj obj : _set) {
      if(this.contains_raw(obj) && otherSet.contains_raw(obj))
        newSet.add(obj);
    }
    return newSet;
  }

  public boolean isEmpty() {
    return _set.isEmpty();
  }

  @Override
  public Iterator<Obj> iterator()
  {
    return _set.iterator();
  }

  public void remove(Obj ... objs) {
    for(Obj obj : objs)
      _set.remove(obj);
  }

  public void removeEach(Iterable<Obj> iter) {
    for(Obj obj : iter)
      _set.remove(obj);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("${");
    boolean firstIter = true;
    for(Obj obj : _set) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(", ");
      obj.show(sb);
    }
    sb.append('}');
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = D_Array.copyFrom(this, count());
        break;
      case "Boolean":
        newObj = D_Boolean.create(_set.size() != 0);
        break;
      case "HashTable":
        D_HashTable hash = D_HashTable.create();
        for(Obj elem : this) {
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
      case "String":
        StringBuilder sb = new StringBuilder();
        for(Obj elem : _set)
          elem.display(sb);
        newObj = D_String.create(sb.toString());
        break;
    }
    return newObj;
  }

  public D_Set union(D_Set otherSet) {
    D_Set newSet = D_Set.create();
    for(Obj obj : _set)
      newSet.add(obj);
    for(Obj obj : otherSet._set)
      newSet.add(obj);
    return newSet;
  }


}

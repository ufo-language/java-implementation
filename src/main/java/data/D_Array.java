package main.java.data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import main.java.data.contin.C_MakeArray;
import main.java.evaluator.Evaluator;
import main.java.show.Show;
import main.java.util.UFOException;

public class D_Array extends Obj implements Collection, Indexable, IndexAssignable {

  // Static variables ===============================================

  public static final D_Array EMPTY = new D_Array(new Obj[] {});

  private static final int _STANDARD_BASE = 0;

  // Instance variables =============================================

  private Obj[] _elems;
  private int _base;

  // Static methods =================================================

  public static D_Array copyFrom(Collection coll) {
    return copyFrom(coll, coll.count());
  }

  public static D_Array copyFrom(Collection coll, int count) {
    D_Array ary = D_Array.createN(count);
    int n = 0;
    for(Obj obj : coll)
      ary._elems[n++] = obj;
    return ary;
  }

  public static D_Array create(Obj ... objs) {
    if(objs.length == 0)
      return EMPTY;
    return new D_Array(objs);
  }

  public static D_Array createN(int count) {
    if(count == 0)
      return EMPTY;
    Obj[] objs = new Obj[count];
    for(int n=0; n<count; n++)
      objs[n] = D_Nil.create();
    return new D_Array(objs);
  }

  public static D_Array createN(int count, Obj elem) {
    D_Array ary = createN(count);
    for(int n=0; n<count; n++)
      ary._elems[n] = elem;
    return ary;
  }

  public static void freeVars(Obj[] objs, D_Set vars) {
    for(Obj obj : objs)
      obj.freeVars(vars);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object[])_elems);
  }

  public static void show(StringBuilder sb, Obj[] objs, String open, String close) {
    show(sb, objs, open, close, ", ");
  }

  public static void show(StringBuilder sb, Obj[] objs, String open, String close, String sep) {
    sb.append(open);
    boolean firstIter = true;
    for(Object obj : objs) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(sep);
      Show.show(sb, obj);
    }
    sb.append(close);
  }

  // Constructors ===================================================

  private D_Array(Obj[] objs) {
    _elems = objs;
    _base = _STANDARD_BASE;
  }

  // Instance methods ===============================================

  @Override
  public boolean boolValue() {
    return _elems.length > 0;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Array))
      throw UFOException.unableToCompare(this, other);
    D_Array ary = (D_Array)other;
    return Arrays.compare(_elems, ary._elems);
  }

  public int count() {
    return _elems.length;
  }

  public D_Array copy() {
    D_Array ary = D_Array.createN(_elems.length);
    for(int n=0; n<_elems.length; n++)
      ary._elems[n] = _elems[n];
    return ary;
  }

  @Override
  public Collection dom() {
    return D_Seq.create(_base, _elems.length - 1);
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Array) {
      D_Array ary = (D_Array)other;
      if(_elems.length == ary._elems.length) {
        for(int n=0; n<_elems.length; n++) {
          Obj thisElem = _elems[n];
          Obj otherElem = ary._elems[n];
          if(!thisElem.equals(otherElem))
            return false;
        }
        return true;
      }
    }
    return false;
  }

  @Override
  public void eval(Evaluator etor) {
    etor.pushExpr(C_MakeArray.create(_elems.length));
    for(Obj obj : _elems)
      etor.pushExpr(obj);
  }

  @Override
  public void freeVars(D_Set vars) {
    for(Obj obj : _elems)
      obj.freeVars(vars);
  }

  public int getBase() {
    return _base;
  }

  public Obj getIndex(int n) {
    int m = n - _base;
    if(m < 0 || m >= _elems.length)
      return null;
    return _elems[m];
  }

  public Obj getKey(Obj key) {
    for(Obj obj1 : _elems) {
      if(obj1 instanceof D_Binding) {
        D_Binding binding = (D_Binding)obj1;
        if(binding.key.equals(key))
          return binding.value;
      }
    }
    return null;
  }

  public Obj getRaw(int n) {
    return _elems[n];
  }

  @Override
  public Obj indexOf(Obj other) {
    int n = 0;
    for(Obj elem : _elems) {
      if(other.equals(elem))
         return D_Integer.create(n + _base);
      n++;
    }
    return D_Nil.NIL;
  }

  @Override
  public D_List match(Obj other, D_List bindings) {
    if(other instanceof D_Array) {
      D_Array ary = (D_Array)other;
      if(_elems.length == ary._elems.length) {
        for(int n=0; n<_elems.length; n++) {
          Obj param = _elems[n];
          Obj arg = ary._elems[n];
          bindings = param.match(arg, bindings);
          if(bindings == null)
            return null;
        }
        return bindings;
      }
    }
    return null;
  }

  @Override
  public Iterator<Obj> iterator() {
    return Arrays.stream(_elems).iterator();
  }

  public void reverse() {
    int len = _elems.length;
    for(int n=0; n<len / 2; n++) {
      int end = len - n - 1;
      Obj temp = _elems[n];
      _elems[n] = _elems[end];
      _elems[end] = temp;
    }
  }


  public void set(int n, Obj obj) {
    _elems[n - _base] = obj;
  }

  public void setRaw(int n, Obj obj) {
    _elems[n] = obj;
  }

  public void set(D_Integer index, Obj value) {
    set(index.asInt(), value);
  }

  @Override
  public void set(Obj key, Obj value) {
    if(key instanceof D_Integer) {
      set(((D_Integer)key).asInt(), value);
      return;
    }
    for(Obj obj1 : _elems) {
      if(obj1 instanceof D_Binding) {
        D_Binding binding = (D_Binding)obj1;
        if(key.equals(binding.key)) {
          binding.value = value;
          return;
        }
      }
    }
    throw UFOException.keyNotFound(this, key);
  }

  public void sort() {
    Arrays.sort(_elems);
  }

  @Override
  public void show(StringBuilder sb) {
    D_Array.show(sb, _elems, "{", "}");
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = copy();
        break;
      case "Binding":
        if(_elems.length == 2)
          newObj = D_Binding.create(_elems[0], _elems[1]);
        break;
      case "HashTable":
        newObj = D_HashTable.copyFrom(this);
        break;
      case "List":
        newObj = D_List.copyFrom(this);
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Set":
        newObj = D_Set.copyFrom(this);
        break;
      case "String":
        StringBuilder sb = new StringBuilder();
        for(Obj obj : _elems)
          obj.display(sb);
        newObj = D_String.create(sb.toString());
        break;
      case "Stack":
        newObj = D_Stack.copyFrom(this);
        break;
    }
    return newObj;
  }

}

package main.java.data.iterator;

import java.util.Iterator;

import main.java.data.D_Binding;
import main.java.data.D_HashTable;
import main.java.data.Obj;

public class HashIterator implements Iterator<Obj> {

  private D_Binding[] _bindings;
  private int _count, _n;

  public HashIterator(D_HashTable hash) {
    _count = hash.count();
    _bindings = new D_Binding[_count];
    int n = 0;
    for(Obj key : hash.keys())
      _bindings[n++] = D_Binding.create(key, hash.get(key));
    _n = 0;
  }

  @Override
  public boolean hasNext() {
    return _n < _count;
  }

  @Override
  public D_Binding next() {
    return _bindings[_n++];
  }

}


package main.java.data.iterator;

import java.util.Iterator;

import main.java.data.D_List;
import main.java.data.Obj;

public class ListIterator implements Iterator<Obj> {

  private D_List _list;

  public ListIterator(D_List list) {
    _list = list;
  }

  @Override
  public boolean hasNext() {
    return _list != D_List.EMPTY;
  }

  @Override
  public Obj next() {
    Obj nextElem = _list.first();
    Obj restObj = _list.rest();
    if(!(restObj instanceof D_List))
      restObj = D_List.create(restObj);
    _list = (D_List)restObj;
    return nextElem;
  }
}


package main.java.expr.iterator;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class IteratorCounted extends Iterator {

  // Instance variables =============================================

  private int _maxCount;
  private int _count;

  // Constructors ===================================================

  public IteratorCounted(int count) {
    _maxCount = count;
    _count = 0;
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor) {
    Obj obj;
    if(_count < _maxCount)
      obj = D_List.create(D_Integer.create(++_count));
    else
      obj = D_Nil.NIL;
    etor.pushObj(obj);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(_maxCount);
    sb.append(" times");
  }

}

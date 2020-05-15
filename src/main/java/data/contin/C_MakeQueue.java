package main.java.data.contin;

import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeQueue extends Obj {

  // Instance variables =============================================

  private int _count;

  // Static methods =================================================

  public static C_MakeQueue create(int count) {
    return new C_MakeQueue(count);
  }

  // Constructors ===================================================

  private C_MakeQueue(int count) {
    _count = count;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_Queue q = D_Queue.create();
    for(int n=0; n<_count; n++) {
      Obj obj = etor.popObj();
      q.enq(obj);
    }
    etor.pushObj(q);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_count).append("}");
  }

}

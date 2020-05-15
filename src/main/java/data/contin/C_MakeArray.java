package main.java.data.contin;

import main.java.data.D_Array;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeArray extends Obj {

  // Instance variables =============================================

  private int _count;

  // Static methods =================================================

  public static C_MakeArray create(int count) {
    return new C_MakeArray(count);
  }

  // Constructors ===================================================

  private C_MakeArray(int count) {
    _count = count;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj[] objs = new Obj[_count];
    for(int n=0; n<_count; n++)
      objs[n] = etor.popObj();
    D_Array ary = D_Array.create(objs);
    etor.pushObj(ary);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_count).append('}');
  }

}

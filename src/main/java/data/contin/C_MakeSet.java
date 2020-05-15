package main.java.data.contin;

import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeSet extends Obj {

  // Instance variables =============================================

  private int _count;

  // Static methods =================================================

  public static C_MakeSet create(int count) {
    return new C_MakeSet(count);
  }

  // Constructors ===================================================

  private C_MakeSet(int count) {
    _count = count;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_Set set = D_Set.create();
    for(int n=0; n<_count; n++) {
      Obj obj = etor.popObj();
      set.add(obj);
    }
    etor.pushObj(set);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_MakeSet{").append(_count).append("}");
  }

}

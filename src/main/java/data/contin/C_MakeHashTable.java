package main.java.data.contin;

import main.java.data.D_HashTable;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeHashTable extends Obj {

  // Instance variables =============================================

  private int _count;

  // Static methods =================================================

  public static C_MakeHashTable create(int count) {
    return new C_MakeHashTable(count);
  }

  // Constructors ===================================================

  private C_MakeHashTable(int count) {
    _count = count;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_HashTable hash = D_HashTable.create();
    for(int n=0; n<_count; n++) {
      Obj key = etor.popObj();
      Obj value = etor.popObj();
      hash.set(key, value);
    }
    etor.pushObj(hash);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append('{').append(_count).append('}');
  }

}

package main.java.evaluator;

import main.java.data.D_HashTable;
import main.java.data.D_Set;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.expr.E_Identifier;

public class Methods {

  // Static variables ===============================================

  private static final D_HashTable _HASH = D_HashTable.create();

  // Static methods =================================================

  public static void define(String typeStr, D_HashTable namespace) {
    D_Symbol typeSym = D_Symbol.create(typeStr);
    define(typeSym, namespace);
  }

  public static void define(D_Symbol typeSym, D_HashTable namespace) {
    _HASH.set(typeSym, namespace);
  }

  public static void define(D_Symbol type, E_Identifier key, Obj value) {
    D_HashTable typeHash = (D_HashTable)_HASH.get(type);
    if(typeHash == null) {
      typeHash = D_HashTable.create();
      _HASH.set(type, typeHash);
    }
    typeHash.set(key, value);
  }

  public static D_Set keys() {
    return _HASH.keys();
  }
  public static Obj lookup(D_Symbol type, E_Identifier key) {
    D_HashTable typeHash = (D_HashTable)_HASH.getKey(type);
    Obj val = null;
    if(typeHash != null)
      val = typeHash.getKey(key);
    return val;
  }

}

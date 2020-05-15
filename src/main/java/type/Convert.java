package main.java.type;

import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.util.UFOException;

public class Convert {

  // Static methods =================================================

  public static Obj convert(Obj obj, D_Symbol typeName) {
    Obj newObj = obj.typeConvert(typeName.toString());
    if(newObj == null)
      throw UFOException.typeConversion(obj, typeName);
    return newObj;
  }

}

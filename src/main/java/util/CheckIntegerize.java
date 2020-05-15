package main.java.util;

import main.java.data.D_Integer;
import main.java.data.D_Real;
import main.java.data.Obj;

public class CheckIntegerize {
  
  // Static methods =================================================
  
  public static Obj flt(float f) {
    int i = (int)f;
    if((float)i == f)
      return D_Integer.create(i);
    return D_Real.create(f);
  }

}

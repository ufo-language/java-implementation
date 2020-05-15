package main.java.namespace.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.parser.ParserEntry;

public class It extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "it";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params()
  };

  // Constructors ===================================================

  public It() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Obj obj = D_Nil.NIL;
    try {
      String s = br.readLine();
      System.out.println("test:it got string [" + s + "]");
      Obj res = ParserEntry.parse(s);
      System.out.println("test:it got obj " + res);
      etor.pushExpr(res);
    }
    catch(IOException exn) {
      exn.printStackTrace();
    }
    etor.pushObj(obj);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

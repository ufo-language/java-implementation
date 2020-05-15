package main.java.namespace.io;

import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Fmt extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "fmt";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("fmtStr", D_String.class, "bindings", null)
  };

  // Constructors ===================================================

  public Fmt() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_String str = (D_String)args.first();
    Obj bindings = args.getSecond();
    String s = str.interpolate(bindings);
    main.java.show.Show.disp(s);
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

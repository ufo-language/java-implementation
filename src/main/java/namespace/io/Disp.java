package main.java.namespace.io;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class Disp extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "disp";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Constructors ===================================================

  public Disp() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Obj[] argAry = args.asRawArray();
    main.java.show.Show.disp((Object[])argAry);
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.io;

import main.java.data.D_Nil;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Nl extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "nl";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY
  };

  // Constructors ===================================================

  public Nl() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    main.java.show.Show.showln();
    etor.pushObj(D_Nil.NIL);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

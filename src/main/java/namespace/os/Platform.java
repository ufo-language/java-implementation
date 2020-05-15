package main.java.namespace.os;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Platform extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "platform";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params()
  };

  // Constructors ===================================================

  public Platform() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    String osName = System.getProperty("os.name");
    etor.pushObj(D_String.create(osName));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.set;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Set;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Union extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "union";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s1", D_Set.class, "s2", D_Set.class)
  };

  // Constructors ===================================================

  public Union() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Set s1 = (D_Set)args.first();
    D_Set s2 = (D_Set)args.getSecond();
    etor.pushObj(s1.union(s2));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

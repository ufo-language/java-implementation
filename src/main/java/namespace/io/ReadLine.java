package main.java.namespace.io;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.io.StdIn;

public class ReadLine extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "readLine";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Constructors ===================================================

  public ReadLine() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Obj[] argAry = args.asRawArray();
    main.java.show.Show.disp((Object[])argAry);
    StdIn.STDIN.readLine(etor);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

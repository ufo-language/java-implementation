package main.java.namespace.os.mac;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.show.Show;

public class Script extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "script";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Static methods =================================================

  public static D_Array doScript(Obj[] args) {
    String[] strings = new String[args.length];
    for(int n=0; n<args.length; n++)
      strings[n] = Show.displayString(args[n]);
    return doScript(strings);
  }

  public static D_Array doScript(String ... args) {
    boolean firstIter = true;
    StringBuilder sb = new StringBuilder();
    for(String arg : args) {
      if(firstIter)
        firstIter = false;
      else
        sb.append(' ');
      sb.append(arg);
    }
    String[] cmd = {"osascript", "-e", sb.toString()};
    D_Array res = Cmd.doCmd(cmd);
    return res;
  }

  // Constructors ===================================================

  public Script() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    D_Array res = doScript(args.asRawArray());
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.evaluator;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class EvalString extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "evalString";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s", D_String.class)
  };

  // Static methods =================================================

  public static void eval(String source, String s, Evaluator etor) {
    Obj res =  main.java.parser.ParserEntry.parse(s);
    etor.pushExpr(res);
  }

  // Constructors ===================================================

  public EvalString() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_String str = (D_String)args.first();
    eval(toString(), str.getStr(), etor);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

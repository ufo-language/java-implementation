package main.java.namespace.parser;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Parse extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "parse";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("str", D_String.class)
  };

  // Constructors ===================================================

  public Parse() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_String strObj = (D_String)args.first();
    String str = strObj.getStr();
    if(str.length() == 0) {
      throw UFOException.stringEmpty("parser:parse");
    }
    Obj res = main.java.parser.ParserEntry.parse(str);
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

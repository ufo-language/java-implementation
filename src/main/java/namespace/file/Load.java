package main.java.namespace.file;

import main.java.data.D_Binding;
import main.java.data.D_File;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Load extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "load";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params(),
      D_PrimFunction.params("fileName", D_String.class),
      D_PrimFunction.params("file", D_File.class)
  };

  public static final D_Binding TYPE_BINDING = D_Binding.create(D_Symbol.create("Type"),
                                                                D_String.create("ufo"));

  // Static methods =================================================

  private static void _load(D_List exprs, Evaluator etor) {
    for(Obj expr : exprs)
      etor.pushExpr(expr);
  }

  public static void load(Evaluator etor) {
    Obj res = Read.read(TYPE_BINDING);
    if(res instanceof D_List) {
      D_List exprs = (D_List)res;
      _load(exprs.reverse(), etor);
    }
    else
      etor.pushObj(res);
  }

  public static void load(String fileName, Evaluator etor) {
    Obj res = Read.read(fileName);
    if(res instanceof D_List) {
      D_List exprs = (D_List)res;
      _load(exprs.reverse(), etor);
    }
    else
      etor.pushObj(res);
  }

  public static void load(D_File file, Evaluator etor) {
    Obj res = Read.read(file);
    if(res instanceof D_List) {
      D_List exprs = (D_List)res;
      _load(exprs.reverse(), etor);
    }
    else
      etor.pushObj(res);
  }

  // Constructors ===================================================

  public Load() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Obj res = D_Nil.NIL;
    switch(ruleNum) {
      case 0:
        load(etor);
        break;
      case 1:
        D_String fileName = (D_String)args.first();
        load(fileName.getStr(), etor);
        break;
      case 2:
        D_File file = (D_File)args.first();
        load(file, etor);
        break;
    }
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

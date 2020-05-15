package main.java.namespace.file;

import main.java.data.D_File;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.parser.ParserEntry;

public class Read extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "read";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params(),
      D_PrimFunction.params("fileName", D_String.class),
      D_PrimFunction.params("file", D_File.class)
  };

  // Static methods =================================================

  public static Obj read(Obj ... options) {
    String s = ReadString.readString(options);
    Obj res = D_Nil.NIL;
    if(s != null)
      res = ParserEntry.parse(s);
    return res;
  }

  public static Obj read(String fileName) {
    String s = ReadString.readString(fileName);
    Obj obj = ParserEntry.parse(s);
    return obj;
  }

  public static Obj read(D_File file) {
    String s = ReadString.readString(file);
    Obj obj = ParserEntry.parse(s);
    return obj;
  }

  // Constructors ===================================================

  public Read() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Obj res = D_Nil.NIL;
    switch(ruleNum) {
      case 0:
        res = read();
        break;
      case 1:
        D_String fileName = (D_String)args.first();
        res = read(fileName.getStr());
        break;
      case 2:
        D_File file = (D_File)args.first();
        res = read(file);
        break;
    }
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.file;

import java.nio.file.Path;

import main.java.data.D_File;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;
import main.java.namespace.os.mac.ChooseInputFile;

public class ReadLines extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "readLines";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params(),
      D_PrimFunction.params("fileName", D_String.class),
      D_PrimFunction.params("file", D_File.class)
  };

  // Static methods =================================================

  public static D_List readLines(Obj ... options) {
    Path path = ChooseInputFile.chooseInputFile(options);
    if(path == null)
      return null;
    return readLines(path.toString());
  }

  public static D_List readLines(String fileName) {
    D_File file = D_File.create_read(fileName);
    D_List lines = readLines(file);
    file.close();
    return lines;
  }

  public static D_List readLines(D_File file) {
    return file.readLines();
  }

  // Constructors ===================================================

  public ReadLines() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Obj res = D_Nil.NIL;
    switch(ruleNum) {
      case 0:
        res = readLines();
        break;
      case 1:
        D_String fileName = (D_String)args.first();
        res = readLines(fileName.getStr());
        break;
      case 2:
        D_File file = (D_File)args.first();
        res = readLines(file);
        break;
    }
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

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

public class ReadString extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "readString";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params(),
      D_PrimFunction.params("fileName", D_String.class),
      D_PrimFunction.params("file", D_File.class)
  };

  // Static methods =================================================

  public static String readString(Obj ... options) {
    Path path = ChooseInputFile.chooseInputFile(options);
    if(path == null)
      return null;
    return readString(path.toString());
  }

  public static String readString(String fileName) {
    D_File file = D_File.create_read(fileName);
    String s = readString(file);
    file.close();
    return s;
  }

  public static String readString(D_File file) {
    return file.readString();
  }

  // Constructors ===================================================

  public ReadString() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    String fileString;
    Obj res = D_Nil.NIL;
    switch(ruleNum) {
      case 0:
        fileString = readString();
        res = D_String.create(fileString);
        break;
      case 1:
        D_String fileName = (D_String)args.first();
        fileString = readString(fileName.getStr());
        res = D_String.create(fileString);
        break;
      case 2:
        D_File file = (D_File)args.first();
        fileString = readString(file);
        res = D_String.create(fileString);
        break;
    }
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

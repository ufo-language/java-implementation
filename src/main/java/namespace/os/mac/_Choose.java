package main.java.namespace.os.mac;

import java.nio.file.Path;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_File;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public abstract class _Choose extends D_PrimFunction {

  // Static variables ===============================================

  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("options", null)
  };

  // Static methods =================================================

  public static Path choose(String script, Obj ... options) {
    if(options.length > 0) {
      D_Queue types = D_Queue.create();
      for(Obj opt : options) {
        if(opt instanceof D_Binding) {
          D_Binding binding = (D_Binding)opt;
          if(binding.key.toString().equals("Type"))
            types.enq(binding.value);
        }
      }
      if(types.count() > 0) {
        StringBuilder sb = new StringBuilder();
        sb.append(" of type ");
        types.asList().show(sb, "{", "}");
        script += sb.toString();
      }
    }
    D_Array resAry = Script.doScript(script);
    int resCode = ((D_Integer)resAry.get(0)).asInt();
    if(resCode == 0) {
      String pathStr = ((D_String)((D_List)resAry.get(1)).first()).getStr();
      Path path = D_File.appleScriptToPosixPath(pathStr);
      return path;
    }
    return null;
  }

  // Constructors ===================================================

  public _Choose(String name) {
    super(name);
  }

  // Instance methods ===============================================

  public abstract String scriptCmd();

  @Override
  public void apply(Evaluator etor, D_List args) {
    Path path = choose(scriptCmd(), args.asRawArray());
    etor.pushObj(D_String.create(path.toString()));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

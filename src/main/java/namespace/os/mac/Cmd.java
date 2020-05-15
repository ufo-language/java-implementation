package main.java.namespace.os.mac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.show.Show;

public class Cmd extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "cmd";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Static methods =================================================

  public static D_Array doCmd(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    D_Queue stdOutQ = D_Queue.create();
    D_Queue stdErrQ = D_Queue.create();
    int resultCode = -1;
    try {
      Process process = runtime.exec(args);
      resultCode = process.waitFor();
      BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while((line = br.readLine()) != null)
        stdOutQ.enq(D_String.create(line));
      br.close();
      br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      while((line = br.readLine()) != null)
        stdOutQ.enq(D_String.create(line));
      br.close();
    }
    catch(IOException exn) {
      exn.printStackTrace();
    }
    catch(InterruptedException exn) {
      exn.printStackTrace();
    }
    D_Array res = D_Array.create(D_Integer.create(resultCode), stdOutQ.asList(), stdErrQ.asList());
    return res;
  }

  // Constructors ===================================================

  public Cmd() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int count = args.count();
    String[] argAry = new String[count];
    int n = 0;
    for(Obj obj : args)
      argAry[n++] = Show.displayString(obj);
    D_Array res = doCmd(argAry);
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

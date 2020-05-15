package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;

public class CmdTraceback extends AbstractColonCommand {

  public CmdTraceback()
  {
    commandString = "tb";
    helpString = "  :tb           show traceback from last exception";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    Throwable exn = repThread.getLastException();
    exn.printStackTrace();
    return null;
  }

}

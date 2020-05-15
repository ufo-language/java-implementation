package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.data.D_List;
import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdObjStack extends AbstractColonCommand {

  public CmdObjStack() {
    commandString = "os";
    helpString = "  :os           show the object stack";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    D_List ostack = etor.getObjStack();
    Show.showln(ostack);
    return null;
  }

}

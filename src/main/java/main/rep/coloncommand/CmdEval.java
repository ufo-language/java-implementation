package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdEval extends AbstractColonCommand {

  public CmdEval() {
    commandString = "eval";
    helpString = "  :eval         show evaluator";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    Show.showln(etor);
    return null;
  }

}

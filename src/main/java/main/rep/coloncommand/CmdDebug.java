package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdDebug extends AbstractColonCommand {

  public CmdDebug() {
    commandString = "d";
    helpString = "  :d            toggle debug";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    Evaluator.showDebug = !Evaluator.showDebug;
    Show.displn("debugging is now ", (Evaluator.showDebug ? "on" : "off"));
    return null;
  }

}

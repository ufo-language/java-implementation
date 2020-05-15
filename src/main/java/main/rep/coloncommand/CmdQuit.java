package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;

public class CmdQuit extends AbstractColonCommand {

  public CmdQuit() {
    commandString = "q";
    helpString = "  :q            quit UFO";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    repThread.terminate();
    return null;
  }

}

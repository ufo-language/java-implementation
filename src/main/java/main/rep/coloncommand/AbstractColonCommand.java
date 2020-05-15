package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;

public abstract class AbstractColonCommand {

  public String commandString = "";
  public String helpString    = "";
  public abstract String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands);

}

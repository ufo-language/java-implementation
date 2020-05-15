package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.io.StdIn;
import main.java.main.rep.REPLoop;

public class CmdEdit extends AbstractColonCommand {

  public CmdEdit() {
    commandString = "e";
    helpString = "  :e            enter multipl lines (enter blank line when finished)";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    StringBuilder sb = new StringBuilder();
    while(true) {
      String line = StdIn.STDIN.readLine_direct();
      if(line.length() == 0)
        break;
      sb.append(line).append("\n");
    }
    return sb.toString();
  }

}

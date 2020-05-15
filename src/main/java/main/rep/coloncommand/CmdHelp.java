package main.java.main.rep.coloncommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdHelp extends AbstractColonCommand {

  public CmdHelp() {
    commandString = "?";
    helpString = "  :?            show this help";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    Set<String> keySet = commands.keySet();
    String[] keyAry = keySet.toArray(new String[]{});
    Arrays.sort(keyAry);
    for(String key : keyAry) {
      AbstractColonCommand cmd = (AbstractColonCommand)commands.get(key);
      Show.showln(cmd.helpString);
    }
    return null;
  }

}

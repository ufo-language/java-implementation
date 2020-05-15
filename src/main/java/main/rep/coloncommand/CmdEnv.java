package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.data.D_List;
import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdEnv extends AbstractColonCommand {

  public CmdEnv() {
    commandString = "env";
    helpString = "  :env          show environment";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    D_List environment = etor.getEnv();
    Show.showln(environment);
    return null;
  }

}

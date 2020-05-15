package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;

public class CmdCaveats extends AbstractColonCommand {

  public CmdCaveats() {
    commandString = "cav";
    helpString = "  :cav          lists issues of which the user should be aware";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    String[] caveats = {
        "This is pre-release software. Particular issues of which you should be aware:",
        "",
        " * Some features you might expect to find have not been implemented yet: e.g., OOP, networking, exception handling.",
        " * Many other features are partially implemented: e.g, file I/O.",
        "",
        "See About > Releases in the UFO documentation file for additional information about this release."
    };
    for(String s : caveats)
      System.out.println(s);
    return null;
  }

}

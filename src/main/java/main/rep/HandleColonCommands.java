package main.java.main.rep;

import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.coloncommand.AbstractColonCommand;
import main.java.main.rep.coloncommand.CmdCaveats;
import main.java.main.rep.coloncommand.CmdDebug;
import main.java.main.rep.coloncommand.CmdEdit;
import main.java.main.rep.coloncommand.CmdEnv;
import main.java.main.rep.coloncommand.CmdEval;
import main.java.main.rep.coloncommand.CmdExpr;
import main.java.main.rep.coloncommand.CmdHelp;
import main.java.main.rep.coloncommand.CmdRun;
import main.java.main.rep.coloncommand.CmdObjStack;
import main.java.main.rep.coloncommand.CmdQuit;
import main.java.main.rep.coloncommand.CmdTraceback;
import main.java.show.Show;

public class HandleColonCommands {

  // Static variables ===============================================

  public static final String ESCAPE_SEQUENCE = ":";

  private static HashMap<String, AbstractColonCommand> _colonCommands = new HashMap<>();

  // Static initializer =============================================

  static {
    _addColonCommand(new CmdCaveats());
    _addColonCommand(new CmdDebug());
    _addColonCommand(new CmdEdit());
    _addColonCommand(new CmdEnv());
    _addColonCommand(new CmdEval());
    _addColonCommand(new CmdExpr());
    _addColonCommand(new CmdHelp());
    _addColonCommand(new CmdObjStack());
    _addColonCommand(new CmdQuit());
    _addColonCommand(new CmdRun());
    _addColonCommand(new CmdTraceback());
  }

  // Instance methods ===============================================

  public static String activate(String cmdStr, REPLoop repThread, Evaluator etor) {
    cmdStr = cmdStr.substring(ESCAPE_SEQUENCE.length());
    String[] parts = cmdStr.split(" ");
    String cmdName = parts[0];
    AbstractColonCommand cmd = (AbstractColonCommand)_colonCommands.get(cmdName);
    if(cmd != null)
      return cmd.activate(parts, repThread, etor, _colonCommands);
    Show.showln(ESCAPE_SEQUENCE, "? for help");
    return null;
  }

  private static void _addColonCommand(AbstractColonCommand cmd) {
    String commandString = cmd.commandString;
    _colonCommands.put(commandString, cmd);
  }


}

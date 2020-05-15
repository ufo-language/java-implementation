package main.java.main.rep.coloncommand;

import java.util.HashMap;

import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.show.Show;

public class CmdExpr extends AbstractColonCommand {

  public CmdExpr() {
    commandString = "expr";
    helpString = "  :expr         show expression from last parse";
    //              ^             ^
  }

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    Obj expr = repThread.getLastExpr();
    if(expr != null)
      Show.showln(expr, " :: ", expr.typeName());
    return null;
  }

}

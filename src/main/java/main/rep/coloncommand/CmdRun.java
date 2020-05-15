package main.java.main.rep.coloncommand;

import java.nio.file.Path;
import java.util.HashMap;

import main.java.evaluator.Evaluator;
import main.java.main.rep.REPLoop;
import main.java.namespace.file.Load;
import main.java.namespace.file.ReadString;
import main.java.namespace.os.mac.ChooseInputFile;

public class CmdRun extends AbstractColonCommand {

  // Instance variables =============================================

  private String _fileName = null;

  // Constructors ===================================================

  public CmdRun() {
    commandString = "r";
    helpString = "  :r [fileName] runs a program file";
    //              ^             ^
  }

  // Instance methods ===============================================

  @Override
  public String activate(String[] cmdParts, REPLoop repThread, Evaluator etor, HashMap<String, AbstractColonCommand> commands) {
    String s = null;
    switch(cmdParts.length) {
      case 1:
        if(_fileName == null) {
          Path path = ChooseInputFile.chooseInputFile(Load.TYPE_BINDING);
          if(path != null) {
            _fileName = path.toString();
            s = ReadString.readString(_fileName);
          }
        }
        break;
      case 2:
        _fileName = cmdParts[1];
        s = ReadString.readString(_fileName);
        break;
    }
    return s;
  }

}

package main.java.namespace.os.mac;

import java.nio.file.Path;

import main.java.data.Obj;

public class ChooseOutputFile extends _Choose {

  // Static variables ===============================================

  private static final String _NAME = "chooseOutputFile";
  private static final String _SCRIPT_CMD = "choose file name";

  // Static methods =================================================

  public static Path chooseOutputFile(Obj ... options) {
    return choose(_SCRIPT_CMD, options);
  }

  // Constructors ===================================================

  public ChooseOutputFile() {
    super(_NAME);
  }

  // Instance methods ===============================================

  public String scriptCmd() {
    return _SCRIPT_CMD;
  }

}

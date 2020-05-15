package main.java.namespace.os.mac;

import java.nio.file.Path;

import main.java.data.Obj;

public class ChooseInputFile extends _Choose {

  // Static variables ===============================================

  private static final String _NAME = "chooseInputFile";
  private static final String _SCRIPT_CMD = "choose file";

  // Static methods =================================================

  public static Path chooseInputFile(Obj ... options) {
    return choose(_SCRIPT_CMD, options);
  }

  // Constructors ===================================================

  public ChooseInputFile() {
    super(_NAME);
  }

  // Instance methods ===============================================

  public String scriptCmd() {
    return _SCRIPT_CMD;
  }

}

package main.java.namespace.os.mac;

import java.nio.file.Path;

import main.java.data.Obj;

public class ChooseFolder extends _Choose {

  // Static variables ===============================================

  private static final String _NAME = "chooseFolder";
  private static final String _SCRIPT_CMD = "choose folder";

  // Static methods =================================================

  public static Path chooseFolder(Obj ... options) {
    return choose(_SCRIPT_CMD, options);
  }

  // Constructors ===================================================

  public ChooseFolder() {
    super(_NAME);
  }

  // Instance methods ===============================================

  public String scriptCmd() {
    return _SCRIPT_CMD;
  }

}

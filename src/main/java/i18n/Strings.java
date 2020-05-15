package main.java.i18n;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

public class Strings {

  // Static variables ===============================================

  private static final HashMap<String, Properties> _STRINGS = new HashMap<>();
  private static final String _DEFAULT_LOCALE = "en";
  
  private static final Path _I18N_DIR = Paths.get("res", "i18n");
  private static final String _STRINGS_FILE_NAME = "strings.props";

  private static String _activeLocale = _DEFAULT_LOCALE;

  // Static initializer =============================================

  static {
    loadLocale(_activeLocale);
  }

  // Static methods =================================================

  public static void loadLocale(String localeName) {
    Path propsFilePath = Paths.get(_I18N_DIR.toString(), localeName, _STRINGS_FILE_NAME);
    try(InputStream is = new FileInputStream(propsFilePath.toFile())) {
      Properties props = new Properties();
      props.load(is);
      _STRINGS.put(localeName, props);
    }
    catch(IOException exn) {
      System.err.println("Props file not found: " + propsFilePath.toAbsolutePath());
      //System.err.println(exn);
    }
  }

  public static String format(String name, Object ... args) {
    return String.format(Strings.get(name), args);
  }

  public static String get(String name) {
    Properties localizedStrings = _STRINGS.get(_activeLocale);
    if(localizedStrings != null) {
      String s = localizedStrings.getProperty(name);
      if(s != null)
        return s;
    }
    return name;
  }

}

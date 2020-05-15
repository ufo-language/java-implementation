package main.java.main.rep;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import main.java.UFO;

public class About {

  // Static variables ===============================================

  private static String _appVersion = null;

  // Static methods =================================================

  public static String appName() {
    return "UFO";
  }

  public static String appUrl() {
    return "http://github.com/ufo-language";
  }

  public static String appVersion() {
    if(_appVersion != null)
      return _appVersion;

    String version = "unknown";

    try {
      String className = UFO.class.getSimpleName() + ".class";
      String classPath = UFO.class.getResource(className).toString();
      if(classPath.startsWith("jar")) {
        URL url = new URL(classPath);
        JarURLConnection jarConnection = (JarURLConnection)url.openConnection();
        Manifest manifest = jarConnection.getManifest();
        Attributes attributes = manifest.getMainAttributes();
        version = attributes.getValue("Implementation-Version");
      }
    }
    catch(Exception exn) {
      exn.printStackTrace();
    }

    _appVersion = version;
    return _appVersion;
  }

}

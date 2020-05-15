package main.java.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import main.java.util.UFOException;

public class D_File extends Obj {

  // Instance variables =============================================

  private String _fileName;
  private File _file;

  // Static methods =================================================

  public static D_File create_read(String str) {
    return new D_File(str);
  }

  public static Path appleScriptToPosixPath(String pathStr) {
    if(pathStr.startsWith("alias "))
      pathStr = pathStr.substring(6);
    String[] parts = pathStr.split(":");
    int len = parts.length;
    String root = File.separator + parts[1];
    String[] segments = new String[len - 2];
    for(int n = 2; n<len; n++)
      segments[n - 2] = parts[n];
    Path path = Paths.get(root, segments);
    return path;
  }

  // Constructors ===================================================

  private D_File(String fileName) {
    _fileName = fileName;
    _file = new File(_fileName);
  }

  // Instance methods ===============================================

  @Override
  public boolean boolValue() {
    return false;
  }

  public void close() {
  }

  public D_List readLines() {
    D_Queue lineQ = D_Queue.create();
    Scanner sc = null;
    try {
      sc = new Scanner(_file);
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        lineQ.enq(D_String.create(line));
      }
      sc.close();
    }
    catch(IOException exn) {
      exn.printStackTrace();
    }
    finally {
      sc.close();
    }
    return lineQ.asList();
  }

  public String readString() {
    if(!_file.exists()) {
      throw UFOException.fileNotFound(_fileName);
    }
    StringBuilder sb = new StringBuilder();
    Scanner sc = null;
    try {
      sc = new Scanner(_file);
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        sb.append(line).append('\n');
      }
    }
    catch(IOException exn) {
      exn.printStackTrace();
    }
    finally {
      sc.close();
    }
    return sb.toString();
  }

}

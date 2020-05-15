package main.java.util;

import java.util.Scanner;

import main.java.show.Show;

public class PressEnter {
  
  private static Scanner _sc = null;

  public static void toContinue() {
    while(true) {
      Show.show("Press Enter to continue (enter ! for stack trace) ");
      if(_sc == null)
        _sc = new Scanner(System.in);
      String line = _sc.nextLine();
      if(line.equals(""))
        break;
      if(line.equals("!")) {
        try {
          throw new Exception();
        }
        catch(Exception exn) {
          exn.printStackTrace();
        }
      }
    }
  }

}

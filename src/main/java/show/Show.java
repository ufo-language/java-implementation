package main.java.show;

import java.io.PrintStream;

import main.java.data.Obj;

public class Show {

  // Static methods =================================================

  public static void disp(Object ... objs) {
    disp(System.out, objs);
  }

  public static void disp(PrintStream out, Object ... objs) {
    StringBuilder sb = new StringBuilder();
    disp(sb, objs);
    out.print(sb.toString());
    out.flush();
  }
  
  public static void disp(StringBuilder sb, Object ... objs) {
    for(Object obj : objs) {
      if(obj == null)
        sb.append("NULL");
      else if(obj instanceof Obj)
        ((Obj)obj).display(sb);
      else
        sb.append(obj);
    }
  }

  public static void displn(Object ... objs) {
    displn(System.out, objs);
  }

  public static void displn(PrintStream out, Object ... objs) {
    disp(out, objs);
    out.println();
  }

  public static String displayString(Object ... objs) {
    StringBuilder sb = new StringBuilder();
    disp(sb, objs);
    return sb.toString();
  }

  public static void nl() {
    nl(System.out);
  }
  
  public static void nl(PrintStream out) {
    out.println();
  }

  public static void show(Object ... objs) {
    show(System.out, objs);
  }

  public static void show(PrintStream out, Object ... objs) {
    StringBuilder sb = new StringBuilder();
    show(sb, objs);
    out.print(sb.toString());
    out.flush();
  }
  
  public static void show(StringBuilder sb, Object ... objs) {
    for(Object obj : objs) {
      if(obj == null)
        sb.append("NULL");
      else if(obj instanceof Obj)
        ((Obj)obj).show(sb);
      else
        sb.append(obj.toString());
    }
  }

  public static void showln(Object ... objs) {
    showln(System.out, objs);
  }

  public static void showln(PrintStream out, Object ... objs) {
    show(out, objs);
    out.println();
  }

  public static String showString(Object ... objs) {
    StringBuilder sb = new StringBuilder();
    show(sb, objs);
    return sb.toString();
  }

}

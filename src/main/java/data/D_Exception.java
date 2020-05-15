package main.java.data;

import java.util.Objects;

import main.java.i18n.Strings;

public class D_Exception extends Obj {

  // Instance variables =============================================

  private Throwable _cause;
  private Obj[] _args;

  // Static methods =================================================

  public static D_Exception create(Throwable cause, Obj ... args) {
    return new D_Exception(cause, args);
  }

  // Constructors ===================================================

  private D_Exception(Throwable cause, Obj ... args) {
    _cause = cause;
    _args = args;
  }

  // Instance methods ===============================================

  public Obj[] getArgs() {
    return _args;
  }

  public Throwable getCause() {
    return _cause;
  }

  @Override
  public int hashCode() {
    return Objects.hash(_cause, _args);
  }


  @Override
  public void show(StringBuilder sb) {
    sb.append(Strings.get(this.typeName())).append("{\"");
    sb.append(_cause.getMessage());
    sb.append("\"}");
  }

}

package main.java.data;

import java.util.Iterator;

import main.java.util.UFOException;

public class D_String extends Obj implements Collection, Indexable {

  // Instance variables =============================================

  private String _str;

  // Static methods =================================================

  public static D_String create(char c) {
    return new D_String(Character.toString(c));
  }

  public static D_String create(String str) {
    return new D_String(str);
  }

  public static String escapify(String s) {
    StringBuilder sb = new StringBuilder();
    for(int n=0; n<s.length(); n++) {
      char c = s.charAt(n);
      switch(c) {
        //case '\'': sb.append("\\'"); break;
        case '"' : sb.append("\\\""); break;
        case '\\': sb.append("\\\\"); break;
        case '\b': sb.append("\\b"); break;
        case '\f': sb.append("\\f"); break;
        case '\n': sb.append("\\n"); break;
        case '\r': sb.append("\\r"); break;
        case '\t': sb.append("\\t"); break;
        default:   sb.append(c);
      }
    }
    return sb.toString();
  }

  public static String unescapify(String s) {
    StringBuilder sb = new StringBuilder();
    boolean escaped = false;
    for(int n=0; n<s.length(); n++) {
      char c = s.charAt(n);
      if(escaped) {
        switch(c) {
          //case '\'': sb.append('\''); break;
          case '\"': sb.append('\"'); break;
          case '\\': sb.append('\\'); break;
          case 'b' : sb.append('\b'); break;
          case 'f' : sb.append('\f'); break;
          case 'n' : sb.append('\n'); break;
          case 'r' : sb.append('\r'); break;
          case 't' : sb.append('\t'); break;
          default:
            sb.append(c);
        }
        escaped = false;
      }
      else if(c == '\\')
        escaped = true;
      else
        sb.append(c);
    }
    return sb.toString();
  }
  
  public static String titleize(String s) {
    StringBuilder sb = new StringBuilder();
    boolean isWs = true;
    for(char c : s.toCharArray()) {
      if(Character.isWhitespace(c))
        isWs = true;
      else {
        if(isWs) {
          c = Character.toUpperCase(c);
          isWs = false;
        }
        else
          c = Character.toLowerCase(c);
      }
      sb.append(c);
    }
    return sb.toString();
  }

  // Constructors ===================================================

  private D_String(String str) {
    _str = str;
  }

  // Instance methods ===============================================

  public D_Array asArray() {
    int len = _str.length();
    D_Array ary = D_Array.createN(len);
    for(int n=0; n<len; n++)
      ary.setRaw(n, D_String.create(_str.charAt(n)));
    return ary;
  }

  @Override
  public boolean boolValue() {
    return _str.length() > 0;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_String))
      throw UFOException.unableToCompare(this, other);
    D_String str = (D_String)other;
    return _str.compareTo(str._str);
  }

  public int count() {
    return _str.length();
  }

  @Override
  public void display(StringBuilder sb) {
    sb.append(_str);
  }

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_String) {
      D_String str = (D_String)other;
      return _str.equals(str._str);
    }
    return false;
  }

  public String escapify() {
    return D_String.escapify(_str);
  }

  public Obj getIndex(int index) {
    if(index >= 0 && index < _str.length())
      return D_String.create(_str.charAt(index));
    return null;
  }

  public String getStr() {
    return _str;
  }

  @Override
  public int hashCode() {
    return _str.hashCode();
  }

  public String interpolate(Obj bindings) {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while(true) {
      int openIdx = _str.indexOf("#{", idx);
      if(openIdx != -1) {
        int closeIdx = _str.indexOf('}', openIdx);
        sb.append(_str.substring(idx, openIdx));
        String keyStr = _str.substring(openIdx + 2, closeIdx);
        D_Symbol keySym = D_Symbol.create(keyStr);
        Obj insert = bindings.get(keySym);
        if(insert != null)
          insert.display(sb);
        else
          sb.append("#{").append(keyStr).append('}');
        idx = closeIdx + 1;
      }
      else
        break;
    }
    sb.append(_str.substring(idx, _str.length()));
    return sb.toString();
  }

  @Override
  public Iterator<Obj> iterator() {
    D_Array ary = asArray();
    return ary.iterator();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append('"').append(escapify(_str)).append('"');
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = asArray();
        break;
      case "Boolean":
        newObj = D_Boolean.create(_str.length() != 0);
        break;
      case "List":
        newObj = D_List.copyFrom(this);
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Set":
        newObj = D_Set.copyFrom(this);
        break;
      case "String":
        newObj = this;
        break;
      case "Symbol":
        newObj = D_Symbol.create(_str);
        break;
    }
    return newObj;
  }

  public String unescapify() {
    return D_String.unescapify(_str);
  }

}

package main.java.data;

import java.util.HashMap;

import main.java.util.UFOException;

public class D_Symbol extends Obj {

  // Static variables ===============================================
  
  private static HashMap<String, D_Symbol> _internedSymbols =
      new HashMap<String, D_Symbol>();

  private static D_Symbol _SYMBOL = new D_Symbol("Symbol");
  
  static {
    _SYMBOL._typeSymbol = _SYMBOL;
  }

  // Instance variables =============================================
  
  private String _name;

  // Static methods =================================================
  
  public static D_Symbol create(String name) {
    D_Symbol ident = _internedSymbols.get(name);
    if(ident == null) {
      ident = new D_Symbol(name);
      _internedSymbols.put(name, ident);
    }
    return ident;
  }

  // Constructors ===================================================

  private D_Symbol(String name) {
    super(_SYMBOL);
    _name = name;
  }

  // Instance methods ===============================================

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_Symbol))
      throw UFOException.unableToCompare(this, other);
    D_Symbol sym = (D_Symbol)other;
    return _name.compareTo(sym._name);
  }

  @Override
  public boolean equals(Object other) {
    return this == other;
  }

  public String getName() {
    return _name;
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(_name);
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Boolean":
        if(_name.equals("True"))
          newObj = D_Boolean.TRUE;
        else if(_name.equals("False"))
          newObj = D_Boolean.FALSE;
        break;
      case "String":
        newObj = D_String.create(_name);
        break;
    }
    return newObj;
  }

}

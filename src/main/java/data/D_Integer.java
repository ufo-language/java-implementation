package main.java.data;

import main.java.util.UFOException;

public class D_Integer extends Obj implements Numeric {

  // Instance variables =============================================

  private int _value;

  // Static methods =================================================

  public static D_Integer create(int value) {
    return new D_Integer(value);
  }

  // Constructors ===================================================

  private D_Integer(int value) {
    _value = value;
  }

  // Instance methods ===============================================

  public D_Integer add1() {
    return D_Integer.create(_value + 1);
  }

  public float asReal() {
    return (float)_value;
  }

  public int asInt() {
    return _value;
  }

  @Override
  public boolean boolValue() {
    return _value != 0;
  }

  @Override
  public int compareTo(Obj other) {
    if(other instanceof D_Integer) {
      D_Integer i = (D_Integer)other;
      return Integer.compare(_value, i._value);
    }
    if(other instanceof D_Real) {
      D_Real r = D_Real.create(this.asReal());
      return r.compareTo(other);
    }
    throw UFOException.unableToCompare(this, other);
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Integer) {
      D_Integer i = (D_Integer)other;
      return _value == i._value;
    }
    return false;
  }

  public int getValue() {
    return _value;
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(_value);
  }

  public void show(StringBuilder sb) {
    sb.append(Long.toString(_value));
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Boolean":
        newObj = D_Boolean.create(_value != 0);
        break;
      case "Integer":
        newObj = this;
        break;
      case "Real":
        newObj = D_Real.create(_value);
        break;
      case "String":
        newObj = D_String.create(Long.toString(_value));
        break;
    }
    return newObj;
  }

}

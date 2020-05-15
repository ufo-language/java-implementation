package main.java.data;

import main.java.util.UFOException;

public class D_Real extends Obj implements Numeric {

  // Instance variables =============================================

  private float _value;

  // Static methods =================================================

  public static D_Real create(float value) {
    return new D_Real(value);
  }

  // Constructors ===================================================

  private D_Real(float value) {
    _value = value;
  }

  // Instance methods ===============================================

  public float asReal() {
    return _value;
  }

  public int asInt() {
    return (int)_value;
  }

  @Override
  public boolean boolValue() {
    return _value != 0.0;
  }

  @Override
  public int compareTo(Obj other) {
    if(other instanceof D_Real) {
      D_Real i = (D_Real)other;
      return Float.compare(_value, i._value);
    }
    if(other instanceof D_Integer) {
      float f = ((D_Integer)other).asReal();
      return Float.compare(_value, f);
    }
    throw UFOException.unableToCompare(this, other);
  }  

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_Real) {
      D_Real real = (D_Real)other;
      return _value == real._value;
    }
    return false;
  }

  public double getValue() {
    return _value;
  }

  @Override
  public int hashCode() {
    return Float.hashCode(_value);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(Double.toString(_value));
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Boolean":
        newObj = D_Boolean.create(_value != 0);
        break;
      case "Integer":
        newObj = D_Integer.create((int)_value);
        break;
      case "Real":
        newObj = this;
        break;
      case "String":
        newObj = D_String.create(Double.toString(_value));
        break;
    }
    return newObj;
  }

}

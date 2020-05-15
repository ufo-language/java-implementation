package main.java.data;

import java.util.Objects;

import main.java.i18n.Strings;

public abstract class D_PrimMacro extends D_PrimFunction {

  // Constructors ===================================================

  protected D_PrimMacro(String name) {
    super(name);
  }

  // Instance methods ===============================================

  @Override
  public EvaluationOrder getEvaluationOrder() {
    return EvaluationOrder.NORMAL;
  }

  @Override
  public int hashCode() {
    return Objects.hash(D_PrimMacro.class, _name);
  }

  @Override
  public String typeName() {
    return Strings.get(D_PrimFunction.class.getSimpleName());
  }

}

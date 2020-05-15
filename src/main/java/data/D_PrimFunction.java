package main.java.data;

import java.util.Objects;

import main.java.evaluator.TypedParam;
import main.java.expr.Applyable;
import main.java.expr.E_Identifier;
import main.java.i18n.Strings;

public abstract class D_PrimFunction extends Obj implements Applyable {

  // Instance variables =============================================

  protected String _name;

  // Static inner classes ===========================================

  public static class ParamBuilder {
    private D_Queue _paramQ = D_Queue.create();
    public ParamBuilder() {}
    public ParamBuilder param(String name, Class<? extends Obj> clss) {
      _paramQ.enq(new TypedParam(name, clss));
      return this;
    }
    public D_List build() {
      return _paramQ.asList();
    }
  }

  // Static methods =================================================

  public static ParamBuilder paramBuilder() {
    return new ParamBuilder();
  }

  public static Obj param(String name, Class<? extends Obj> type) {
    Obj param = null;
    if(type == null)
      param = E_Identifier.create(name);
    else
      param = new TypedParam(name, type);
    return param;
  }

  public static D_List params(Object ... objs) {
    D_Queue params = D_Queue.create();
    for(int n=0; n<objs.length; n+=2) {
      String paramName = (String)objs[n];
      @SuppressWarnings("unchecked")
      Class<? extends Obj> paramType = (Class<? extends Obj>)objs[n+1];
      params.enq(param(paramName, paramType));
    }
    return params.asList();
  }

  public static D_List pair(String lhsName, Class<? extends Obj>lhsType, String rhsName, Class<? extends Obj> rhsType) {
    Obj lhs = param(lhsName, lhsType);
    Obj rhs = param(rhsName, rhsType);
    D_List pair = D_List.create(lhs, rhs);
    return pair;
  }

  // Constructors ===================================================

  protected D_PrimFunction(String name) {
    _name = name;
  }

  // Instance methods ===============================================

  @Override
  public EvaluationOrder getEvaluationOrder() {
    return EvaluationOrder.APPLICATIVE;
  }

  public String getName() {
    return _name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(D_PrimFunction.class, _name);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(_name);
    D_List[] params = getParameters();
    boolean firstIter = true;
    for(D_List pattern : params) {
      if(firstIter)
        firstIter = false;
      else
        sb.append("|");
      pattern.show(sb, "(", ")");
    }
  }

  @Override
  public String typeName() {
    return Strings.get(D_PrimFunction.class.getSimpleName());
  }

}

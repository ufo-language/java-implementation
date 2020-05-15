package main.java.data;

import java.util.Objects;

import main.java.data.contin.C_MakePair;
import main.java.data.contin.C_PushObj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.contin.C_ApplyArgs;
import main.java.show.Show;

public class D_Method extends Obj implements Applyable {

  // Instance variables =============================================

  private Applyable _prim;
  private Obj _receiver;

  // Static methods =================================================
  
  public static D_Method create(Applyable prim, Obj receiver) {
    return new D_Method(prim, receiver);
  }

  // Constructors ===================================================

  private D_Method(Applyable prim, Obj receiver) {
    _prim = prim;
    _receiver = receiver;
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    etor.pushExpr(C_ApplyArgs.create(_prim));
    etor.pushExpr(C_MakePair.create());
    // the receiver has already been evaluated and must not be evaluated again
    etor.pushExpr(new C_PushObj(_receiver));
    etor.pushExpr(args);
  }

  @Override
  public EvaluationOrder getEvaluationOrder() {
    return EvaluationOrder.APPLICATIVE;
  }

  @Override
  public D_List[] getParameters() {
    return _prim.getParameters();
  }

  @Override
  public int hashCode() {
    return Objects.hash(_receiver, _prim);
  }

  @Override
  public void show(StringBuilder sb) {
    Show.show(sb, _receiver, ".", _prim);
  }

}

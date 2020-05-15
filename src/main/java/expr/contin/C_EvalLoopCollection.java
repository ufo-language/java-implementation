package main.java.expr.contin;

import main.java.data.Collection;
import main.java.data.D_Array;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Seq;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Do;

public class C_EvalLoopCollection extends Obj {

  // Instance variables =============================================

  private Obj _varPattern;
  private E_Do _body;

  // Constructors ===================================================

  public C_EvalLoopCollection(Obj varPattern, E_Do body) {
    _varPattern = varPattern;
    _body = body;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    Obj collObj = etor.popObj();
    Collection coll;
    if(collObj instanceof D_Integer) {
      D_Integer intg = (D_Integer)collObj;
      coll = D_Seq.create(0, intg.getValue() - 1, 1);
    }
    else if(!(collObj instanceof Collection))
      coll = D_List.create(collObj);
    else
      coll = (Collection)collObj;
    C_Loop cLoop = new C_Loop(coll.iterator(), _varPattern, _body, etor.getEnv());
    etor.pushExpr(cLoop);
  }

  @Override
  public void show(StringBuilder sb) {
    D_Array.show(sb, _body.getExprs(), typeName() + "{", "}");
  }

}

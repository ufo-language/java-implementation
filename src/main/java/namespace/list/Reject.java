package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.namespace.Params;

public class Reject extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "reject";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "f", Applyable.class)
  };

  // Static inner classes ===========================================
  
  private static class C_Accept extends Obj {

    private Applyable _f;
    private D_List _list;
    private D_Queue _q;

    public C_Accept(Applyable f, D_List list) {
      _f = f;
      _list = list;
      _q = D_Queue.create();
    }

    @Override
    public void eval(Evaluator etor) {
      Obj res = etor.popObj();
      Obj elem = _list.first();
      if(!res.boolValue())
        _q.enq(elem);
      _list = _list.getRest();
      if(_list.isEmpty())
        etor.pushObj(_q.asList());
      else {
        etor.pushExpr(this);
        D_List args = D_List.create(_list.first());
        _f.apply(etor, args);
      }
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append("C_Reject{");
      ((Obj)_f).show(sb);
      sb.append(", ");
      _list.show(sb);
      sb.append('}');
    }
  }

  // Constructors ===================================================

  public Reject() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    Applyable f = (Applyable)args.getSecond();
    if(list.isEmpty())
      etor.pushObj(list);
    else {
      C_Accept cMap = new C_Accept(f, list);
      etor.pushExpr(cMap);
      D_List args2 = D_List.create(list.first());
      f.apply(etor, args2);
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

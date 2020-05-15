package main.java.namespace.list;

import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.expr.E_Application;
import main.java.namespace.Params;
import main.java.util.UFOException;

public class Apply extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "apply";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("lst", D_List.class, "f", Applyable.class)
  };

  // Static inner classes ===========================================
  
  private static class C_Map extends Obj {

    private Obj _abstrObj;
    private D_List _list;

    public C_Map(Obj abstrObj, D_List list) {
      _abstrObj = abstrObj;
      _list = list;
    }

    @Override
    public void eval(Evaluator etor) {
      etor.popObj();
      if(_list.isEmpty())
        etor.pushObj(D_Nil.NIL);
      else {
        etor.pushExpr(this);
        D_List arg = D_List.create(_list.first());
        _list = _list.getRest();
        E_Application app = E_Application.create(_abstrObj, arg);
        etor.pushExpr(app);
      }
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append("C_Map{");
      _abstrObj.show(sb);
      sb.append(", ");
      _list.show(sb);
      sb.append('}');
    }
  }

  // Constructors ===================================================

  public Apply() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List list = (D_List)args.first();
    Obj abstrObj = args.getSecond();
    if(list.isEmpty())
      etor.pushObj(list);
    else if(abstrObj instanceof Applyable) {
      C_Map cMap = new C_Map(abstrObj, list.getRest());
      etor.pushExpr(cMap);
      E_Application app = E_Application.create(abstrObj, D_List.create(list.first()));
      etor.pushExpr(app);
    }
    else
      throw UFOException.notAnAbstraction(abstrObj);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

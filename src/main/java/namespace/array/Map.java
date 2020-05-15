package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.Applyable;
import main.java.namespace.Params;

public class Map extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "map";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_Array.class, "f", Applyable.class)
  };

  // Static inner classes ===========================================
  
  private static class C_ArrayMap extends Obj {

    private D_Array _srcAry;
    private D_Array _destAry;
    private Applyable _f;
    private int _count;
    private int _index;

    public C_ArrayMap(D_Array srcAry, Applyable f) {
      _srcAry = srcAry;
      _f = f;
      _count = _srcAry.count();
      _destAry = D_Array.createN(_count);
    }

    @Override
    public void eval(Evaluator etor) {
      Obj res = etor.popObj();
      _destAry.setRaw(_index++, res);
      if(_index == _count)
        etor.pushObj(_destAry);
      else {
        etor.pushExpr(this);
        D_List args = D_List.create(_srcAry.getRaw(_index));
        _f.apply(etor, args);
      }
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append(typeName()).append('{');
      _srcAry.show(sb);
      sb.append(", ");
      ((Obj)_f).show(sb);
      sb.append(", ").append(_index).append('}');
    }
  }

  // Constructors ===================================================

  public Map() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    Applyable f = (Applyable)args.getSecond();
    if(ary.count() == 0)
      etor.pushObj(ary);
    else {
      C_ArrayMap cMap = new C_ArrayMap(ary, f);
      etor.pushExpr(cMap);
      D_List args2 = D_List.create(ary.getRaw(0));
      f.apply(etor, args2);
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

package main.java.namespace.thread;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Receive extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "receive";
  private static final D_List[] _PARAMS = new D_List[] {
    D_List.EMPTY,
    D_PrimFunction.params("pat", null)
  };

  // Static inner classes ===========================================

  private static class C_ReadMsgQ extends Obj {

    private Obj _pattern;

    public C_ReadMsgQ(Obj pattern) {
      _pattern = pattern;
    }

    @Override
    public void eval(Evaluator etor) {
      Obj msg = etor.receiveMessage_noWait(_pattern);
      if(msg != null)
        etor.pushObj(msg);
      else {
        etor.pushExpr(this);
        etor.blockOnReceive();
      }
    }

    @Override
    public void show(StringBuilder sb) {
      sb.append("C_ReadMsgQ{");
      _pattern.show(sb);
      sb.append('}');
    }
  }

  // Constructors ===================================================

  public Receive() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    int ruleNum = Params.check(_NAME, _PARAMS, args);
    Obj pattern = null;
    Obj msg = null;
    switch(ruleNum) {
      case 0:
        msg = etor.receiveMessage_noWait();
        break;
      case 1:
        pattern = args.first();
        msg = etor.receiveMessage_noWait(pattern);
        break;
    }
    if(msg != null)
      etor.pushObj(msg);
    else {
      etor.pushExpr(new C_ReadMsgQ(pattern));
      etor.blockOnReceive();
    }
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

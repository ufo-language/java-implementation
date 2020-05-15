package main.java.namespace.thread;

import java.util.Timer;
import java.util.TimerTask;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Evaluator.EvaluatorStatus;
import main.java.namespace.Params;

public class Sleep extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "sleep";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("ms", D_Integer.class)
  };

  // Static inner classes ===========================================

  public static class Wakeup extends TimerTask {

    private Evaluator _etor;
    private Timer _timer;

    public Wakeup(Evaluator etor, Timer timer) {
      _etor = etor;
      _timer = timer;
    }

    @Override
    public void run() {
      _etor.pushObj(D_Nil.NIL);
      _etor.resume();
      _timer.cancel(); // needed, otherwise UFO app won't terminate
    }
  }

  // Constructors ===================================================

  public Sleep() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    int delay = ((D_Integer)args.first()).asInt();
    Timer timer = new Timer();
    Wakeup wakeup = new Wakeup(etor, timer);
    timer.schedule(wakeup, delay);
    etor.status = EvaluatorStatus.SLEEPING;
    etor.blockOn(timer);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

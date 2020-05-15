package main.java.evaluator;

import java.util.HashMap;
import java.util.Timer;

import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.Evaluator.EvaluatorStatus;
import main.java.show.Show;
import main.java.thread.MessageQueue;

public class RunQueue implements Runnable {

  // Instance variables =============================================

  private boolean _contin = true;
  private D_Queue _running = D_Queue.create();
  private Thread _thread;
  
  private HashMap<Evaluator, Object> _blockingObjects = new HashMap<>();
  private HashMap<Object, D_Queue> _blockedEvaluators = new HashMap<>();

  // Instance methods ===============================================

  public void blockOn(Evaluator etor, Object obj) {
    etor.status = EvaluatorStatus.BLOCKED;
    _blockingObjects.put(etor, obj);
    if(obj != null) {
      D_Queue q = _blockedEvaluators.get(obj);
      if(q == null) {
        q = D_Queue.create();
        _blockedEvaluators.put(obj, q);
      }
      q.enq(etor);
    }
  }

  public void enqEvaluator(Evaluator etor) {
    synchronized(_running) {
      etor.status = EvaluatorStatus.RUNNING;
      _running.enq(etor);
      if(_running.count() == 1)
        _running.notify();
    }
  }

  public void resumeEvaluator(Evaluator etor) {
    Object blockingObject = _blockingObjects.remove(etor);
    if(blockingObject != null)
      _blockedEvaluators.remove(blockingObject);
    etor.status = EvaluatorStatus.RUNNING;
    enqEvaluator(etor);
  }

  public void resumeEvaluators(Object blockingObject) {
    D_Queue q = _blockedEvaluators.get(blockingObject);
    if(q != null) {
      while(true) {
        Evaluator etor = (Evaluator)q.deq();
        if(etor == null)
          break;
        _blockingObjects.remove(etor);
        etor.status = EvaluatorStatus.RUNNING;
        enqEvaluator(etor);
      }
    }
  }

  @Override
  public void run() {
    OUTER_LOOP:
    while(_contin) {
      Evaluator etor;
      synchronized(_running) {
        etor = (Evaluator)_running.deq();
      }
      if(etor == null)
        try {
          synchronized(_running) {
            _running.wait(5000);
          }
        }
        catch(InterruptedException exn) {
          break OUTER_LOOP;
        }
      else {
        etor.runTimeslice();
        switch(etor.status) {
          case RUNNING:
            synchronized(_running) {
              _running.enq(etor);
            }
          case BLOCKED:
            //_blocked.add(etor);
            break;
          case SLEEPING:
            // TODO Does anything need to be done here?
            break;
          case FINISHED:
            // TODO Does anything need to be done here?
            break;
          case READY:
            // TODO Does anything need to be done here?
            break;
          case ERROR:
            // TODO Does anything need to be done here?
            break;
        }
      }
    }
  }

  public MessageQueue spawn(Obj expr) {
    MessageQueue msgq = new MessageQueue();
    spawn(expr, msgq);
    return msgq;
  }
  
  public void spawn(Obj expr, MessageQueue msgq) {
    Evaluator etor = Evaluator.create(msgq, this);
    enqEvaluator(etor);
  }

  public void start() {
    _thread = new Thread(this);
    _thread.start();
  }

  public void terminate() {
    _contin = false;
    _thread.interrupt();
    try {
      _thread.join();
    }
    catch(InterruptedException exn) {
      exn.printStackTrace();
    }
  }

  public void terminateEvaluator(Evaluator etor) {
    Object blockingObject = _blockingObjects.remove(etor);
    etor.status = EvaluatorStatus.FINISHED;
    if(blockingObject instanceof Timer) {
      Timer timer = (Timer)blockingObject;
      timer.cancel();
    }
    else if(blockingObject != null)
      Show.showln("ReunQueue.terminateEvaluator blockingObject not handled: ", blockingObject);
    if(blockingObject != null)
      _blockedEvaluators.remove(blockingObject);
  }

}

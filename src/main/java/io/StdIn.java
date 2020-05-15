package main.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.data.D_Array;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Evaluator.EvaluatorStatus;
import main.java.thread.MessageQueue;

public class StdIn implements Runnable {

  // Static variables ===============================================

  public static final StdIn STDIN = new StdIn();
  public static final D_Symbol READLINE = D_Symbol.create("ReadLine");

  // Instance variables =============================================

  private MessageQueue _msgq = new MessageQueue();
  private BufferedReader _kbd = new BufferedReader(new InputStreamReader(System.in));
  private boolean _contin = true;
  private Thread _thread;

  // Constructors ===================================================

  private StdIn() {
    this.start();
  }

  // Instance methods ===============================================

  public void request(D_Array request) {
    _msgq.enq(request);
  }

  @Override
  public void run() {
    while(_contin) {
      D_Array request = (D_Array)_msgq.deq();
      if(request != null) {
        D_Symbol command = (D_Symbol)request.getRaw(0);
        if(command == READLINE) {
          //String s = _kbd.nextLine();
          String s = readLine_direct();
          D_String str = D_String.create(s);
          Obj obj1 = request.getRaw(1);
          if(obj1 instanceof Evaluator) {
            Evaluator etor = (Evaluator)obj1;
            etor.pushObj(str);
            etor.resume();
          }
          else if(obj1 instanceof MessageQueue) {
            MessageQueue msgq = (MessageQueue)obj1;
            msgq.enq(str);
          }
        }
        else {
          System.err.println("StdIn.run got unknown command " + command);
        }
      }
    }
  }

  public void readLine(Evaluator etor) {
    D_Array request = D_Array.create(StdIn.READLINE, etor);
    etor.status = EvaluatorStatus.BLOCKED;
    StdIn.STDIN.request(request);
  }

  public String readLine(MessageQueue msgq) {
    D_Array request = D_Array.create(StdIn.READLINE, msgq);
    this.request(request);
    D_String str = (D_String)msgq.deq();
    return str.getStr();
  }

  public String readLine_direct() {
    String s = null;
    try {
      s = _kbd.readLine();
    }
    catch(IOException exn) {}
    return s;
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
      System.err.println(this.getClass() + " interrupted wating for thread,join");
    }
  }

}

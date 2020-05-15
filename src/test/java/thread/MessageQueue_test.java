package test.java.thread;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.data.Obj;
import main.java.thread.MessageQueue;

public class MessageQueue_test
{

  private static final D_Integer _i100 = D_Integer.create(100);
  private static final D_Integer _i200 = D_Integer.create(200);
  private static final D_Integer _i300 = D_Integer.create(300);

  @Test
  public void enqAndDeq() {
    // setup
    MessageQueue msgq = new MessageQueue();

    // test & validate
    assertEquals(0, msgq.count());
    msgq.enq(_i100);
    assertEquals(1, msgq.count());
    msgq.enq(_i200);
    assertEquals(2, msgq.count());
    
    assertEquals(_i100, msgq.deq());
    Obj res = msgq.deq(_i200);
    System.err.println("res = " + res);
  }

  @Test
  public void deqNoBlock_shouldNoBlock() {
    // setup
    MessageQueue msgq = new MessageQueue();

    // test
    msgq.deqNoBlock();
    assertTrue(true);
  }

  @Test
  public void synchronization() {
    // setup
    MessageQueue readThreadMsgQ = new MessageQueue();
    MessageQueue writeThreadMsgQ = new MessageQueue();
    Thread readThread = new Thread() {
      @Override
      public void run() {
        Obj obj = readThreadMsgQ.deq();
        Thread.yield();
        if(obj == _i100)
          writeThreadMsgQ.enq(_i200);
        else
          writeThreadMsgQ.enq(_i300);
      }
    };

    // test & validate
    readThread.start();
    Thread.yield();
    readThreadMsgQ.enq(_i100);
    Thread.yield();
    Obj obj = writeThreadMsgQ.deq();
    assertEquals(_i200, obj);
  }

}

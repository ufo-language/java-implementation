package main.java.thread;

import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.i18n.Strings;

public class MessageQueue extends Obj {

  // Static variables ===============================================

  private static final int _WAIT_TIMEOUT = 5000;

  // Instance variables =============================================

  private D_Queue _q = D_Queue.create();

  // Constructors ===================================================

  public MessageQueue() {}

  // Instance methods ===============================================

  public int count() {
    return _q.count();
  }

  public Obj deq() {
    return deq(null);
  }

  public synchronized Obj deq(Obj pattern) {
    while(true) {
      while(_q.isEmpty()) {
        try {
          this.wait(_WAIT_TIMEOUT);
        }
        catch(InterruptedException exn) {
          return null;
        }
      }
      if(pattern == null)
        return _q.deq();
      Obj matched = _q.removeMatching(pattern);
      if(matched != null)
        return matched;
    }
  }

  public Obj deqNoBlock() {
    return deqNoBlock(null);
  }

  public synchronized Obj deqNoBlock(Obj pattern) {
    if(isEmpty())
      return null;
    return deq(pattern);
  }

  public synchronized void enq(Obj message) {
    _q.enq(message);
    this.notify();
  }

  public boolean isEmpty() {
    return _q.isEmpty();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(Strings.get(this.typeName())).append('{');
    _q.show(sb);
    sb.append('}');
  }

}

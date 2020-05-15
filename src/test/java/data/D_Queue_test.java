package test.java.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.data.contin.C_MakeQueue;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;

public class D_Queue_test {

  private D_Integer _i100 = D_Integer.create(100);
  private D_Integer _i200 = D_Integer.create(200);
  private D_Integer _i300 = D_Integer.create(300);

  @Test
  public void count() {
    // setup
    D_Queue q = D_Queue.create();
    
    // test & validate
    assertEquals(0, q.count());
    q.enq(_i100);
    assertEquals(1, q.count());
    q.enq(_i100);
    assertEquals(2, q.count());
    q.deq();
    assertEquals(1, q.count());
    q.deq();
    assertEquals(0, q.count());
  }

  @Test
  public void enqAndDeq_workInTheRightOrder() {
    // setup
    D_Queue q = D_Queue.create();
    
    // test
    q.enq(_i100);
    q.enq(_i200);
    Obj obj1 = q.deq();
    Obj obj2 = q.deq();

    // validate
    assertEquals(_i100, obj1);
    assertEquals(_i200, obj2);
  }

  @Test
  public void enqAndDeq_recyclingNodes() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);

    // test & validate
    assertEquals(_i100, q.deq());
    assertEquals(_i200, q.deq());
    assertEquals(_i300, q.deq());
    q.enq(_i100);
    q.enq(_i200);
    q.enq(_i300);
    assertEquals(_i100, q.deq());
    assertEquals(_i200, q.deq());
    assertEquals(_i300, q.deq());
  }

  @Test
  public void eval() {
    // setup
    Evaluator etor = Evaluator.create();
    D_Queue q = D_Queue.create(_i100);

    // test
    q.eval(etor);

    // validate
    assertEquals(_i100, etor.popExpr());
    assertTrue(etor.popExpr() instanceof C_MakeQueue);
  }

  @Test
  public void removeMatching_emptyQueue() {
    // setup
    D_Queue q = D_Queue.create();

    // test
    D_List res = q.removeMatching(_i100);

    // validate
    assertEquals(null, res);
    assertEquals("~[]", q.toString());
  }

  @Test
  public void removeMatching_firstElement() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);

    // test
    D_List res = q.removeMatching(_i100);

    // validate
    assertEquals("[100]", res.toString());
    assertEquals("~[200, 300]", q.toString());
  }

  @Test
  public void removeMatching_midElement() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);

    // test
    D_List res = q.removeMatching(_i200);

    // validate
    assertEquals("[200]", res.toString());
    assertEquals("~[100, 300]", q.toString());
  }

  @Test
  public void removeMatching_lastElement() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);

    // test
    D_List res = q.removeMatching(_i300);

    // validate
    assertEquals("[300]", res.toString());
    assertEquals("~[100, 200]", q.toString());
  }

  @Test
  public void removeMatching_missingElement() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);

    // test
    D_List res = q.removeMatching(D_Integer.create(400));

    // validate
    assertEquals(null, res);
    assertEquals("~[100, 200, 300]", q.toString());
  }

  @Test
  public void removeMatching_bindings() {
    // setup
    D_Queue q = D_Queue.create(_i100, _i200, _i300);
    E_Identifier x = E_Identifier.create("x");

    // test
    D_List res = q.removeMatching(x);

    // validate
    assertEquals("[100, x=100]", res.toString());
    assertEquals("~[200, 300]", q.toString());
  }
  

  @Test
  public void typeName_returnsSimpleTypeName() {
    // setup
    D_Queue q = D_Queue.create();

    // test
    String typeName = q.typeName();

    // validate
    assertEquals("Queue", typeName);
  }

}

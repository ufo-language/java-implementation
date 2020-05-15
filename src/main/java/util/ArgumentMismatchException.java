package main.java.util;

import main.java.data.D_List;
import main.java.data.D_Queue;
import main.java.data.Obj;
import main.java.evaluator.TypedParam;

public class ArgumentMismatchException extends UFOException {

  // Static variables ===============================================

  private static final long serialVersionUID = 1L;

  // Static inner classes ===========================================

  private class ParenList extends Obj {

    private D_List _lst;

    public ParenList(D_List lst) {
      _lst = lst;
    }
 
    @Override
    public void show(StringBuilder sb) {
      _lst.show(sb, "(", ")");
    }
  }

  // Constructors ===================================================

  public ArgumentMismatchException(Obj function, D_List[] allParams, D_List args) {
    super("ArgumentMismatch");
    D_Queue typedArgs = D_Queue.create();
    for(Obj arg : args)
      typedArgs.enq(new TypedParam(arg.toString(), arg.getClass()));
    field_disp("Function", function);
    boolean firstIter = true;
    for(D_List params : allParams) {
      String fieldName = firstIter ? "Parameters" : "Or";
      firstIter = false;
      field(fieldName, new ParenList(params));
    }
    field("Arguments", new ParenList(typedArgs.asList()));
  }

}

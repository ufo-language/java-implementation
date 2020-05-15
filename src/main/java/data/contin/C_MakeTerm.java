package main.java.data.contin;

import main.java.data.D_Array;
import main.java.data.D_Symbol;
import main.java.data.D_Term;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class C_MakeTerm extends Obj {

  // Instance variables =============================================
 
  private D_Symbol _name;
  private boolean _attribVisible;
  
  // Static methods =================================================

  public static C_MakeTerm create(D_Symbol name, boolean attribVisible) {
    return new C_MakeTerm(name, attribVisible);
  }

  // Constructors ===================================================

  private C_MakeTerm(D_Symbol name, boolean attribVisible) {
    _name = name;
    _attribVisible = attribVisible;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    D_Array args = (D_Array)etor.popObj();
    Obj attrib = etor.popObj();
    D_Term term = D_Term.create(_name, args, _attribVisible, attrib);
    etor.pushObj(term);
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append("C_MakeTerm{");
    _name.show(sb);
    sb.append(", ").append(_attribVisible);
  }

}

package main.java.expr;

import java.util.Objects;

import main.java.data.D_Set;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.contin.C_Subscript;

public class E_Subscript extends Obj {

  // Instance variables =============================================

  private Obj _collection, _indexer;
  
  // Static methods =================================================

  public static E_Subscript create(Obj collection, Obj indexer) {
    return new E_Subscript(collection, indexer);
  }

  // Constructors ===================================================

  private E_Subscript(Obj collection, Obj indexer) {
    _collection = collection;
    _indexer = indexer;
  }

  // Instance methods ===============================================

  @Override
  public void eval(Evaluator etor) {
    C_Subscript cSub = C_Subscript.create();
    etor.pushExpr(cSub);
    etor.pushExpr(_indexer);
    etor.pushExpr(_collection);
  }
  
  @Override
  public void freeVars(D_Set vars) {
    _collection.freeVars(vars);
    _indexer.freeVars(vars);
  }

  public Obj getCollection() {
    return _collection;
  }

  @Override
  public int hashCode() {
    return Objects.hash(E_Subscript.class, _collection, _indexer);
  }

  public Obj getIndexer() {
    return _indexer;
  }

  @Override
  public void show(StringBuilder sb) {
    _collection.show(sb);
    sb.append('[');
    _indexer.show(sb);
    sb.append(']');
  }

}

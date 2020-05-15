package main.java.data;

public abstract class D_Seq extends Obj implements Collection, Indexable {

  // Static variables ===============================================
  
  protected static final String _TO    = "..";
  protected static final String _BY    = "%";

  // Static methods =================================================

  public static D_Seq create(Numeric to) {
    if(to instanceof D_Integer)
      return new D_SeqInteger(1, to.asInt(), 1);
    return new D_SeqReal(1.0f, to.asReal(), 1.0f);
  }

  public static D_Seq create(Numeric from, Numeric to) {
    if(from instanceof D_Integer && to instanceof D_Integer)
      return new D_SeqInteger(from.asInt(), to.asInt(), 1);
    return new D_SeqReal(from.asReal(), to.asReal(), 1.0f);
  }

  public static D_Seq create(Numeric from, Numeric to, Numeric by) {
    if(from instanceof D_Integer && to instanceof D_Integer && by instanceof D_Integer)
      return new D_SeqInteger(from.asInt(), to.asInt(), by.asInt());
    return new D_SeqReal(from.asReal(), to.asReal(), by.asReal());
  }

  public static D_Seq create(int to) {
    return new D_SeqInteger(0, to - 1, 1);
  }

  public static D_Seq create(int from, int to) {
    return new D_SeqInteger(from, to, 1);
  }

  public static D_Seq create(int from, int to, int by) {
    return new D_SeqInteger(from, to, by);
  }

  // Constructors ===================================================

  // Instance methods ===============================================

  public abstract int count();

  @Override
  public Collection dom() {
    return D_Seq.create(count());
  }

  public abstract Obj getIndex(int index);

  public abstract Numeric getBy();

  public abstract Numeric getFrom();

  public abstract Numeric getTo();

  public abstract void setBy(Numeric by);

}

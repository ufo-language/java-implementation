package main.java.data;

import main.java.show.Show;
import main.java.util.CommonSymbols;

@Deprecated
public class D_StringReader extends Obj
{

  // Instance variables =============================================

  private int _line = 1;
  private int _col  = 0;
  private int _pos  = 0;
  
  private String _s;
  private String _name;
  private int _len;

  private D_List _savedNewlines = D_List.EMPTY;

  // Static methods =================================================

  public static D_StringReader create(String name, String s) {
    return new D_StringReader(name, s);
  }

  // Constructors ===================================================

  private D_StringReader(String name, String s) {
    _name = name;
    _s    = s;
    _len  = _s.length();
  }

  // Instance methods ===============================================

  public int getCol() {
    return _col;
  }

  public int getLine() {
    return _line;
  }

  public int getPos() {
    return _pos;
  }

  public D_Array getPosition() {
    // the parser relies on the absolute ordering of these bindings
    D_Binding name = D_Binding.create(CommonSymbols.NAME, D_String.create(_name));
    D_Binding pos  = D_Binding.create(CommonSymbols.POS , D_Integer.create(_pos));
    D_Binding line = D_Binding.create(CommonSymbols.LINE, D_Integer.create(_line));
    D_Binding col  = D_Binding.create(CommonSymbols.COL , D_Integer.create(_col));
    return D_Array.create(name, pos, line, col);
  }

  public Object[] getRawPosition() {
    return new Object[] { _name, _pos, _line, _col };
  }

  public int next() {
    if(_pos == _len)
      return -1;
    char c = _s.charAt(_pos++);
    _col++;
    if(c == '\n') {
      _savedNewlines = D_List.create(D_Integer.create(_col-1), _savedNewlines);
      _line++;
      _col = 0;
    }
    return c;
  }

  public void setName(String name) {
    _name = name;
  }

  /**
   * Splits the string at the current position and returns both halves.
   * @return
   */
  public D_Array split() {
    return splitAt(_pos);
  }

  public D_Array splitAt(D_Array location) {
    int pos = ((D_Integer)location.get(CommonSymbols.POS)).getValue();
    return splitAt(pos);
  }

  public D_Array splitAt(int pos) {
    String part1 = _s.substring(0, pos);
    String part2 = _s.substring(pos);
    return D_Array.create(D_String.create(part1), D_String.create(part2));
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(typeName()).append("{\"");
    Show.show(sb, D_String.escapify(_s));
    sb.append("\", ");
    Show.show(sb, getPosition());
    sb.append('}');
  }

  public void unget() {
    if(_pos > 0) {
      _pos--;
      _col--;
      if(_s.charAt(_pos) == '\n') {
        _line--;
        _col = ((D_Integer)_savedNewlines.first()).getValue();
        _savedNewlines = (D_List)_savedNewlines.rest();
      }
    }
  }

}

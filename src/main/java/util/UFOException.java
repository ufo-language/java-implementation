package main.java.util;

import main.java.data.D_Binding;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Queue;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.data.Indexable;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.expr.E_Identifier;
import main.java.show.Show;

public class UFOException extends RuntimeException {

  // Static variables ===============================================

  private static final long serialVersionUID = 1L;

  //private static final String _PREFIX = "| ";
  private static final String _PREFIX = " ║ ";

  private static final D_Symbol _DISPLAY = D_Symbol.create("Display");
  private static final D_Symbol _SHOW = D_Symbol.create("Show");

  // Instance variables =============================================

  private String _name;
  private D_Queue _fields = D_Queue.create();

  // Static methods =================================================

  public static UFOException argumentMismatch(Obj function, D_List[] allParams, D_List args) {
    return new ArgumentMismatchException(function, allParams, args);
  }

  public static UFOException bindingMismatch(Obj lhs, Obj rhs) {
    return new UFOException("BindingMismatch")
        .field("LHS", lhs)
        .field("RHS", rhs);
  }

  public static UFOException emptyQueue() {
    return new UFOException("QueueEmpty");
  }

  public static UFOException emptyStack() {
    return new UFOException("StackEmpty");
  }

  public static UFOException evaluatorObjectStackEmpty(Evaluator etor) {
    return new UFOException("EvaluatorObjectStackEmpty")
        .field("ShouldNotHappen", etor);
  }

  public static UFOException featureMissing(String what) {
    return new UFOException("FeatureMissing")
        .field("Feature", D_String.create(what));
  }

  public static UFOException fileNotFound(String fileName) {
    return new UFOException("FileNotFound")
        .field("FileName", D_String.create(fileName));
  }

  public static UFOException indexOutOfBounds(Indexable idx, int index) {
    Obj obj = (Obj)idx;
    return new UFOException("IndexOutOfBounds")
        .field("Collection", obj)
        .field("Type", obj.typeSymbol())
        .field("Domain", (Obj)idx.dom())
        .field("Index", D_Integer.create(index));
  }

  public static UFOException keyNotFound(Obj obj, Obj key) {
    return new UFOException("KeyNotFound")
        .field("Collection",  obj)
        .field("Type", obj.typeSymbol())
        .field("Key", key)
        .field("KeyType", key.typeSymbol());
  }

  public static UFOException listEmpty() {
    return new UFOException("ListIsEmpty");
   }

  public static UFOException methodNotFound(Obj type, Obj method) {
    return new UFOException("MethodNotFound")
        .field("ReceiverType", type)
        .field("Method", method);
   }

  public static UFOException notAnAbstraction(Obj obj) {
    return new UFOException("NotAnAbstraction")
        .field("Object", obj)
        .field("Type", obj.typeSymbol());
  }

  public static UFOException objectNotAssignable(Obj expr, Obj lhs) {
    return new UFOException("ObjectNotAssignable")
        .field("Expression", expr)
        .field("LHS", lhs)
        .field("Type", lhs.typeSymbol());
  }

  public static UFOException objectNotCollection(Obj obj) {
    return new UFOException("ObjectNotCollection")
        .field("Object", obj)
        .field("Type", obj.typeSymbol());
  }

  public static UFOException objectNotIndexable(Obj obj) {
    return new UFOException("ObjectNotIndexable")
        .field("Object", obj)
        .field("Type", obj.typeSymbol());
  }

  public static UFOException parseError(String message, String srcName, int line, int col) {
    return new UFOException("ParseError")
        .field_disp("Reason", D_String.create(message))
        .field_disp("SourceName", D_String.create(srcName))
        .field("LineNum", D_Integer.create(line))
        .field("ColumnNum", D_Integer.create(col + 1));
  }

  public static UFOException stringEmpty(String where) {
    return new UFOException("StringEmpty")
        .field("CalledFrom", D_String.create(where));
  }

  public static UFOException threadError(Evaluator thread) {
    return new UFOException("ThreadError")
        .field("Thread", thread);
  }

  public static UFOException typeConversion(Obj obj, D_Symbol type) {
    return new UFOException("TypeConversionError")
        .field("Object", obj)
        .field("DesiredType", type);
  }

  public static UFOException unableToCompare(Obj obj1, Obj obj2) {
    return new UFOException("UnableToCompare")
        .field("Obj1", obj1)
        .field("Obj2", obj2);
  }

  public static UFOException unboundIdentifier(E_Identifier ident) {
    return new UFOException("UnboundIdentifier")
        .field("Identifier", ident);
  }

  public static UFOException unsupportedOS(String osName, String what) {
    return new UFOException("UnsupportedOS")
        .field_disp("OS", D_String.create(osName))
        .field_disp("What", D_String.create(what));
  }

  public static UFOException wrongType(Object where, String typeName, Obj obj) {
    return new UFOException("WrongType")
        .field_disp("CalledFrom", D_String.create(where.toString()))
        .field("Expected", D_Symbol.create(typeName))
        .field("Found", obj)
        .field("Type", obj.typeSymbol());
  }

  // Constructors ===================================================

  protected UFOException(String name) {
    this._name = name;
  }

  // Instance methods ===============================================

  public UFOException name(String name) {
    this._name = name;
    return this;
  }
  
  public UFOException field(String name, Obj value) {
    _fields.enq(D_Binding.create(D_String.create(name), D_List.create(value, _SHOW)));
    return this;
  }

  public UFOException field_disp(String name, Obj value) {
    _fields.enq(D_Binding.create(D_String.create(name), D_List.create(value, _DISPLAY)));
    return this;
  }

  public String getName() {
    return _name;
  }

  public Obj getField(String fieldName) {
    D_String field = D_String.create(fieldName);
    D_List fieldPair = (D_List)_fields.asList().get(field);
    return fieldPair.first();
  }

  public void show() {
    Show.displn(_PREFIX, "Error: ", _name);
    int maxLen = 0;
    for(Object obj : _fields) {
      D_Binding binding = (D_Binding)obj;
      int len = Show.showString(binding.key).length();
      if(len > maxLen)
        maxLen = len;
    }
    for(Object obj : _fields) {
      D_Binding binding = (D_Binding)obj;
      Obj key = binding.key;
      D_List valPair = (D_List)binding.value;
      Obj val = valPair.first();
      D_Symbol dispOrShow = (D_Symbol)valPair.rest();
      int lenDiff = maxLen - Show.showString(binding.key).length();
      Show.disp(_PREFIX, " ", " ".repeat(lenDiff), key, " : ");
      if(dispOrShow == _DISPLAY)
        Show.displn(val);
      else
        Show.showln(val);
    }
  }

}

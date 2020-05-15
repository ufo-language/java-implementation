package main.java.namespace;

import main.java.data.D_Binding;
import main.java.data.D_HashTable;
import main.java.data.D_PrimFunction;
import main.java.data.D_Real;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.evaluator.Methods;
import main.java.expr.E_Identifier;

public class Load {

  // Static methods =================================================

  public static void allPrims() {
    D_HashTable ns;
    _bindGlobals(
        // arithmetic
        "^",   new main.java.namespace._global.ArithPower(),
        "-",   new main.java.namespace._global.ArithMinus(),
        "%",   new main.java.namespace._global.ArithModulo(),
        "+",   new main.java.namespace._global.ArithPlus(),
        "/",   new main.java.namespace._global.ArithDivide(),
        "//",  new main.java.namespace._global.ArithIntDivide(),
        "*",   new main.java.namespace._global.ArithTimes(),
        // comparison
        "==",  new main.java.namespace._global.CompareEQ(),
        ">",   new main.java.namespace._global.CompareGT(),
        ">=",  new main.java.namespace._global.CompareGTE(),
        "<",   new main.java.namespace._global.CompareLT(),
        "<=",  new main.java.namespace._global.CompareLTE(),
        "!=",  new main.java.namespace._global.CompareNEQ(),
        "in",  new main.java.namespace._global.CompareIn(),
        "is",  new main.java.namespace._global.CompareIs(),
        "isnot", new main.java.namespace._global.CompareIsNot(),
        // logic
        "and", new main.java.namespace._global.LogicAnd(),
        "not", new main.java.namespace._global.LogicNot(),
        "or",  new main.java.namespace._global.LogicOr(),
        "xor", new main.java.namespace._global.LogicXor(),
        // types
        ":?",  new main.java.namespace._global.TypePredicate(),
        "::",  new main.java.namespace.type.Check(),
        ":>",  new main.java.namespace.type.Convert(),
        // element resolution
        ":",   new main.java.namespace._global.Colon(),
        ".",   new main.java.namespace._global.Dot(),
        // other
        ":=",  new main.java.namespace._global.Assign(),
        "++",  new main.java.namespace._global.CollectionJoin(),
        "..",  new main.java.namespace._global.SeqConstr()
        );
    ns = _buildNamespace("any",
        new main.java.namespace.any.Compare(),
        new main.java.namespace.any.HashCode(),
        new main.java.namespace.any.Pry()
        );
    Methods.define("Obj", ns);

    ns = _buildNamespace("array",
        new main.java.namespace.array.Contains(),
        new main.java.namespace.array.Count(),
        new main.java.namespace.array.Dom(),
        new main.java.namespace.array.Get(),
        new main.java.namespace.array.IndexOf(),
        new main.java.namespace.array.Map(),
        new main.java.namespace.array.New(),
        new main.java.namespace.array.Reverse(),
        new main.java.namespace.array.Shuffle(),
        new main.java.namespace.array.Sort(),
        new main.java.namespace.array.Set()
        );
    Methods.define("Array", ns);

    ns = _buildNamespace("binding",
        new main.java.namespace.binding.Get(),
        new main.java.namespace.binding.Key(),
        new main.java.namespace.binding.New(),
        new main.java.namespace.binding.SetValue(),
        new main.java.namespace.binding.Value()
        );
    Methods.define("Binding", ns);

    ns = _buildNamespace("closure",
        new main.java.namespace.closure.LexicalEnv()
        );
    Methods.define("Closure", ns);

    ns = _buildNamespace("evaluator",
        new main.java.namespace.evaluator.CurrentContin(),
        new main.java.namespace.evaluator.Eval(),
        new main.java.namespace.evaluator.EvalString()
        );
    Methods.define("Evaluator", ns);

    ns = _buildNamespace("file",
        new main.java.namespace.file.Load(),
        new main.java.namespace.file.Read(),
        new main.java.namespace.file.ReadLines(),
        new main.java.namespace.file.ReadString()
        );
    Methods.define("File", ns);

    ns = _buildNamespace("hash",
        new main.java.namespace.hash.Contains(),
        new main.java.namespace.hash.Count(),
        new main.java.namespace.hash.Delete(),
        new main.java.namespace.hash.Dom(),
        new main.java.namespace.hash.Get(),
        new main.java.namespace.hash.Keys(),
        new main.java.namespace.hash.Put()
        );
    Methods.define("HashTable", ns);

    ns = _buildNamespace("i18n",
        new main.java.namespace.i18n.Locale()
        );

    ns = _buildNamespace("integer",
        new main.java.namespace.integer.To()
        );
    Methods.define("Integer", ns);

    _buildNamespace("io",
        new main.java.namespace.io.Disp(),
        new main.java.namespace.io.DispLn(),
        new main.java.namespace.io.DispString(),
        new main.java.namespace.io.Fmt(),
        new main.java.namespace.io.Nl(),
        new main.java.namespace.io.ReadLine(),
        new main.java.namespace.io.Show(),
        new main.java.namespace.io.ShowLn(),
        new main.java.namespace.io.ShowString()
        );

    ns = _buildNamespace("list",
        new main.java.namespace.list.Accept(),
        new main.java.namespace.list.Apply(),
        new main.java.namespace.list.Contains(),
        new main.java.namespace.list.Count(),
        new main.java.namespace.list.Dom(),
        new main.java.namespace.list.Drop(),
        new main.java.namespace.list.First(),
        new main.java.namespace.list.Generate(),
        new main.java.namespace.list.IndexOf(),
        new main.java.namespace.list.Get(),
        new main.java.namespace.list.Map(),
        new main.java.namespace.list.New(),
        new main.java.namespace.list.Rest(),
        new main.java.namespace.list.Reject(),
        new main.java.namespace.list.Reverse(),
        new main.java.namespace.list.SetFirst(),
        new main.java.namespace.list.SetRest(),
        new main.java.namespace.list.Take()
        );
    Methods.define("List", ns);

    D_HashTable math = _buildNamespace("math");
        math.set(E_Identifier.create("pi"), D_Real.create((float)Math.PI));
        math.set(E_Identifier.create("e"), D_Real.create((float)Math.E));

    _buildNamespace("parser",
        new main.java.namespace.parser.Parse()
        );

    _buildNamespace("namespace",
        new main.java.namespace.namespace.Global(),
        new main.java.namespace.namespace.Methods()
        );

    ns = _buildNamespace("os",
        new main.java.namespace.os.ChooseInputFile(),
        new main.java.namespace.os.ChooseFolder(),
        new main.java.namespace.os.ChooseOutputFile(),
        new main.java.namespace.os.Platform()
        );

    _buildNamespaceIn(ns, "mac",
        new main.java.namespace.os.mac.Cmd(),
        new main.java.namespace.os.mac.ChooseInputFile(),
        new main.java.namespace.os.mac.ChooseFolder(),
        new main.java.namespace.os.mac.ChooseOutputFile(),
        new main.java.namespace.os.mac.Script()
        );

    ns = _buildNamespace("queue",
        new main.java.namespace.queue.Contains(),
        new main.java.namespace.queue.Count(),
        new main.java.namespace.queue.Deq(),
        new main.java.namespace.queue.Enq(),
        new main.java.namespace.queue.IndexOf(),
        new main.java.namespace.queue.New()
        );
    Methods.define("Queue", ns);

    _buildNamespace("rand",
        new main.java.namespace.rand.Bool(),
        new main.java.namespace.rand.Choose(),
        new main.java.namespace.rand.Int(),
        new main.java.namespace.rand.Seed()
        );

    ns = _buildNamespace("seq",
        new main.java.namespace.seq.By(),
        new main.java.namespace.seq.Contains(),
        new main.java.namespace.seq.Count(),
        new main.java.namespace.seq.Dom(),
        new main.java.namespace.seq.From(),
        new main.java.namespace.seq.IndexOf(),
        new main.java.namespace.seq.New(),
        new main.java.namespace.seq.To()
        );
    Methods.define("Seq", ns);

    ns = _buildNamespace("set",
        new main.java.namespace.set.Add(),
        new main.java.namespace.set.Contains(),
        new main.java.namespace.set.Count(),
        new main.java.namespace.set.Intersect(),
        new main.java.namespace.set.Remove(),
        new main.java.namespace.set.Union()
        );
    Methods.define("Set", ns);

    ns = _buildNamespace("stack",
        new main.java.namespace.stack.Contains(),
        new main.java.namespace.stack.Count(),
        new main.java.namespace.stack.IndexOf(),
        new main.java.namespace.stack.New(),
        new main.java.namespace.stack.Pop(),
        new main.java.namespace.stack.Push(),
        new main.java.namespace.stack.Top()
        );
    Methods.define("Stack", ns);

    ns = _buildNamespace("string",
        new main.java.namespace.string.Contains(),
        new main.java.namespace.string.Count(),
        new main.java.namespace.string.LowerCase(),
        new main.java.namespace.string.Fmt(),
        new main.java.namespace.string.TitleCase(),
        new main.java.namespace.string.UpperCase()
        );
    Methods.define("String", ns);

    _buildNamespace("test",
        new main.java.namespace.test.It()
        );

    ns = _buildNamespace("term",
        new main.java.namespace.term.Attrib(),
        new main.java.namespace.term.Contains(),
        new main.java.namespace.term.Dom(),
        new main.java.namespace.term.Get(),
        new main.java.namespace.term.IndexOf(),
        new main.java.namespace.term.Name(),
        new main.java.namespace.term.Set(),
        new main.java.namespace.term.SetAttrib(),
        new main.java.namespace.term.SetAttribVis(),
        new main.java.namespace.term.SetElems()
        );
    Methods.define("Term", ns);

    ns = _buildNamespace("thread",
        new main.java.namespace.thread.Poll(),
        new main.java.namespace.thread.Receive(),
        new main.java.namespace.thread.Spawn(),
        new main.java.namespace.thread.Self(),
        new main.java.namespace.thread.Send(),
        new main.java.namespace.thread.Sleep(),
        new main.java.namespace.thread.Status(),
        new main.java.namespace.thread.Terminate(),
        new main.java.namespace.thread.Value()
        );
    // Methods.define("Thread", ns);

    _buildNamespace("time",
        new main.java.namespace.time.Elapsed(),
        new main.java.namespace.time.Now()
        );

    _buildNamespace("type",
        new main.java.namespace.type.Check(),
        new main.java.namespace.type.Convert(),
        new main.java.namespace.type.Name()
        );
  }

  private static void _bindGlobals(Object ... objs) {
    for(int n=0; n<objs.length; n+=2) {
      String sKey = (String)objs[n];
      Obj value = (Obj)objs[n+1];
      E_Identifier ident = E_Identifier.create(sKey);
      Evaluator.GLOBALS.set(ident, value);
    }
  }
  private static D_HashTable _buildNamespaceIn(D_HashTable ns, String nsName, Obj ... values) {
    D_HashTable nsHash = D_HashTable.create();
    for(Obj val : values) {
      if(val instanceof D_PrimFunction) {
        D_PrimFunction prim = (D_PrimFunction)val;
        E_Identifier ident = E_Identifier.create(prim.getName());
        nsHash.set(ident, prim);
      }
      else if(val instanceof D_Binding) {
        D_Binding binding = (D_Binding)val;
        nsHash.set(binding.key, binding.value);
      }
    }
    E_Identifier ident = E_Identifier.create(nsName);
    ns.set(ident, nsHash);
    return ns;
  }

  private static D_HashTable _buildNamespace(String nsName, Obj ... values) {
    D_HashTable nsHash = D_HashTable.create();
    for(Obj val : values) {
      if(val instanceof D_PrimFunction) {
        D_PrimFunction prim = (D_PrimFunction)val;
        E_Identifier ident = E_Identifier.create(prim.getName());
        nsHash.set(ident, prim);
      }
      else if(val instanceof D_Binding) {
        D_Binding binding = (D_Binding)val;
        nsHash.set(binding.key, binding.value);
      }
    }
    E_Identifier ident = E_Identifier.create(nsName);
    Evaluator.GLOBALS.set(ident, nsHash);
    return nsHash;
  }

}

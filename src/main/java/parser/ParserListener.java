package main.java.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import main.java.data.D_Array;
import main.java.data.D_Binding;
import main.java.data.D_Boolean;
import main.java.data.D_HashTable;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_Queue;
import main.java.data.D_Real;
import main.java.data.D_Set;
import main.java.data.D_Stack;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.data.D_Term;
import main.java.data.Obj;
import main.java.expr.E_Abstraction;
import main.java.expr.E_Application;
import main.java.expr.E_Async;
import main.java.expr.E_Cobegin;
import main.java.expr.E_Identifier;
import main.java.expr.E_If;
import main.java.expr.E_InfixExpr;
import main.java.expr.E_Let;
import main.java.expr.E_LetIn;
import main.java.expr.E_Loop;
import main.java.expr.E_Nondet;
import main.java.expr.E_PrefixExpr;
import main.java.expr.E_Quote;
import main.java.expr.E_Do;
import main.java.expr.E_Subscript;
import main.java.expr.E_While;
import main.java.parser.UFOParser.ABooleanContext;
import main.java.parser.UFOParser.AIdentContext;
import main.java.parser.UFOParser.AIntegerContext;
import main.java.parser.UFOParser.ANilContext;
import main.java.parser.UFOParser.ARealContext;
import main.java.parser.UFOParser.AStringContext;
import main.java.parser.UFOParser.ASymbolContext;
import main.java.parser.UFOParser.ApplicationRuleContext;
import main.java.parser.UFOParser.AtomContext;
import main.java.parser.UFOParser.AtomRuleContext;
import main.java.parser.UFOParser.BindingOpContext;
import main.java.parser.UFOParser.BindingOpRuleContext;
import main.java.parser.UFOParser.BindingSeqContext;
import main.java.parser.UFOParser.CArrayContext;
import main.java.parser.UFOParser.CBindingContext;
import main.java.parser.UFOParser.CBindingLhsContext;
import main.java.parser.UFOParser.CHashContext;
import main.java.parser.UFOParser.CListContext;
import main.java.parser.UFOParser.CQueueContext;
import main.java.parser.UFOParser.CSetContext;
import main.java.parser.UFOParser.CStackContext;
import main.java.parser.UFOParser.CTermAttribContext;
import main.java.parser.UFOParser.CTermContext;
import main.java.parser.UFOParser.CollectionContext;
import main.java.parser.UFOParser.CollectionRuleContext;
import main.java.parser.UFOParser.CommaSepExprsContext;
import main.java.parser.UFOParser.EAsyncContext;
import main.java.parser.UFOParser.EBackQuoteContext;
import main.java.parser.UFOParser.ECobeginContext;
import main.java.parser.UFOParser.EFunContext;
import main.java.parser.UFOParser.EFunRulesContext;
import main.java.parser.UFOParser.EIfContext;
import main.java.parser.UFOParser.ELetContext;
import main.java.parser.UFOParser.ELoopContext;
import main.java.parser.UFOParser.ENondetContext;
import main.java.parser.UFOParser.EQuoteContext;
import main.java.parser.UFOParser.ESeqContext;
import main.java.parser.UFOParser.EWhileContext;
import main.java.parser.UFOParser.ExprContext;
import main.java.parser.UFOParser.ExprRuleContext;
import main.java.parser.UFOParser.ExprSeqContext;
import main.java.parser.UFOParser.InfixOpRuleContext;
import main.java.parser.UFOParser.Level1opsContext;
import main.java.parser.UFOParser.Level2opsContext;
import main.java.parser.UFOParser.Level3opsContext;
import main.java.parser.UFOParser.Level4opsContext;
import main.java.parser.UFOParser.Level5opsContext;
import main.java.parser.UFOParser.ParenListContext;
import main.java.parser.UFOParser.PrefixOpsContext;
import main.java.parser.UFOParser.PrefixRuleContext;
import main.java.parser.UFOParser.ProgContext;
import main.java.parser.UFOParser.SubscriptRuleContext;
import main.java.show.Show;

public class ParserListener implements UFOListener {
  
  public boolean DEBUG_ON = false;

  private D_Stack _contexts = D_Stack.create();
  private D_Stack _context = D_Stack.create();

  // Support methods ================================================

  public void enterContext() {
    _contexts.push(_context);
    _context = D_Stack.create();
  }

  public void exitContext(Obj value) {
    _context = (D_Stack)_contexts.pop();
    push(value);
  }

  public Obj pop() {
    Obj obj = _context.pop();
    return obj;
  }

  public void push(Obj obj) {
    _context.push(obj);
  }

  public void debug(Object ... objs) {
    if(DEBUG_ON)
      Show.displn(objs);
  }

  // Antlr handlers =================================================

  @Override
  public void enterEveryRule(ParserRuleContext arg0) {}

  @Override
  public void exitEveryRule(ParserRuleContext arg0) {
    debug("Parser: ", _context, ", ", _contexts);
  }

  @Override
  public void visitErrorNode(ErrorNode arg0) {}

  @Override
  public void visitTerminal(TerminalNode arg0) {}

  @Override
  public void enterProg(ProgContext ctx) {
    enterContext();
  }

  @Override
  public void exitProg(ProgContext ctx) {
    D_List statements = _context.asList().reverse();
    exitContext(statements);
  }

  // Operators ======================================================

  @Override
  public void enterApplicationRule(ApplicationRuleContext ctx) {
    enterContext();
  }

  @Override
  public void exitApplicationRule(ApplicationRuleContext ctx) {
    D_List args = D_List.EMPTY;
    if(_context.count() > 1)
      args = (D_List)pop();
    Obj abstr = pop();
    E_Application app = E_Application.create(abstr, args);
    exitContext(app);
  }

  @Override
  public void enterInfixOpRule(InfixOpRuleContext ctx) {
    debug("Entering infix op, context = ", _context);
    enterContext();
  }

  @Override
  public void exitInfixOpRule(InfixOpRuleContext ctx) {
    Obj rhs = pop();
    E_Identifier oper = (E_Identifier)pop();
    Obj lhs = pop();
    E_InfixExpr op = E_InfixExpr.create(lhs, oper, rhs);
    debug("Exiting infix op rule with ", op, ", context = ", _context);
    exitContext(op);
  }

  @Override
  public void enterBindingOpRule(BindingOpRuleContext ctx) {
    debug("Entering binding op, context = ", _context);
    enterContext();
  }

  @Override
  public void exitBindingOpRule(BindingOpRuleContext ctx) {
    Obj rhs = pop();
    pop();
    Obj lhs = pop();
    D_Binding binding = D_Binding.create(lhs, rhs);
    debug("Exiting binding op rule with ", binding, ", context = ", _context);
    exitContext(binding);
  }

  @Override
  public void enterSubscriptRule(SubscriptRuleContext ctx) {}

  @Override
  public void exitSubscriptRule(SubscriptRuleContext ctx) {
    Obj indexer = pop();
    Obj collection = pop();
    E_Subscript subscript = E_Subscript.create(collection, indexer);
    push(subscript);
  }

  @Override
  public void enterPrefixRule(PrefixRuleContext ctx) {}

  @Override
  public void exitPrefixRule(PrefixRuleContext ctx) {
    Obj expr = pop();
    E_Identifier opIdent = (E_Identifier)pop();
    E_PrefixExpr prefixOp = E_PrefixExpr.create(opIdent, expr);
    push(prefixOp);
  }

  @Override
  public void enterPrefixOps(PrefixOpsContext ctx) {}

  @Override
  public void exitPrefixOps(PrefixOpsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterLevel5ops(Level5opsContext ctx) {}

  @Override
  public void exitLevel5ops(Level5opsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterLevel4ops(Level4opsContext ctx) {}

  @Override
  public void exitLevel4ops(Level4opsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterLevel3ops(Level3opsContext ctx) {}

  @Override
  public void exitLevel3ops(Level3opsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterLevel2ops(Level2opsContext ctx) {}

  @Override
  public void exitLevel2ops(Level2opsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterBindingOp(BindingOpContext ctx) {}

  @Override
  public void exitBindingOp(BindingOpContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterLevel1ops(Level1opsContext ctx) {}

  @Override
  public void exitLevel1ops(Level1opsContext ctx) {
    E_Identifier opIdent = E_Identifier.create(ctx.getText());
    push(opIdent);
  }

  @Override
  public void enterParenList(ParenListContext ctx) {
    enterContext();
  }

  @Override
  public void exitParenList(ParenListContext ctx)
  {
    D_List elems = _context.asList().reverse();
    exitContext(elems);
  }

  // Expressions ====================================================

  // Support methods

  @Override
  public void enterBindingSeq(BindingSeqContext ctx) {
    enterContext();
  }

  @Override
  public void exitBindingSeq(BindingSeqContext ctx) {
    D_List bindings = D_List.EMPTY;
    for(Obj bindingObj : _context)
      bindings = D_List.create(bindingObj, bindings);
    exitContext(bindings);
  }

  @Override
  public void enterExpr(ExprContext ctx) {}

  @Override
  public void exitExpr(ExprContext ctx) {}

  @Override
  public void enterExprRule(ExprRuleContext ctx) {}

  @Override
  public void exitExprRule(ExprRuleContext ctx) {}


  @Override
  public void enterExprSeq(ExprSeqContext ctx) {
    enterContext();
  }

  @Override
  public void exitExprSeq(ExprSeqContext ctx) {
    D_List lst = _context.asList().reverse();
    exitContext(lst);
  }

  // Expressions

  @Override
  public void enterEAsync(EAsyncContext ctx) {}

  @Override
  public void exitEAsync(EAsyncContext ctx) {
    D_List exprList = (D_List)_context.pop();
    Obj[] exprs = exprList.asRawArray();
    E_Async async = E_Async.create(exprs);
    push(async);
  }

  @Override
  public void enterEBackQuote(EBackQuoteContext ctx) {}

  @Override
  public void exitEBackQuote(EBackQuoteContext ctx) {}

  @Override
  public void enterECobegin(ECobeginContext ctx) {}

  @Override
  public void exitECobegin(ECobeginContext ctx) {
    D_List exprList = (D_List)_context.pop();
    Obj[] exprs = exprList.asRawArray();
    E_Cobegin cobegin = E_Cobegin.create(exprs);
    push(cobegin);
  }

  @Override
  public void enterEIf(EIfContext ctx) {
    enterContext();
  }

  @Override
  public void exitEIf(EIfContext ctx) {
    Obj[] alt;
    if(_context.count() == 2)
      alt = new Obj[] { D_Nil.NIL };
    else
      alt = ((D_List)pop()).asRawArray();
    Obj[] conseq = ((D_List)pop()).asRawArray();
    Obj cond = pop();
    E_If ifExpr = E_If.create(cond, conseq, alt);
    exitContext(ifExpr);
  }

  @Override
  public void enterEFun(EFunContext ctx) {
    enterContext();
  }

  @Override
  public void exitEFun(EFunContext ctx) {
    D_Stack ruleStack = D_Stack.create();
    E_Abstraction abstr;
    while(_context.count() > 1) {
      D_List body = (D_List)pop();
      D_List params = (D_List)pop();
      abstr = E_Abstraction.create(params, body.asRawArray());
      ruleStack.push(abstr);
    }
    abstr = (E_Abstraction)ruleStack.pop();
    String funOp = ctx.op.getText();
    if(funOp.endsWith("#"))
      abstr.setMemoized(true);
    Obj resFun = abstr;
    for(Obj abstrObj : ruleStack) {
      E_Abstraction abstr1 = (E_Abstraction)abstrObj;
      abstr.setNext(abstr1);
      abstr = abstr1;
    }
    if(_context.count() > 0) {
      E_Identifier ident = (E_Identifier)_context.pop();
      D_Binding binding = D_Binding.create(ident, resFun);
      resFun = E_Let.create(binding);
    }
    exitContext(resFun);
  }

  @Override
  public void enterEFunRules(EFunRulesContext ctx) {}

  @Override
  public void exitEFunRules(EFunRulesContext ctx) {
  }

  @Override
  public void enterELet(ELetContext ctx) {
    enterContext();
  }

  @Override
  public void exitELet(ELetContext ctx) {
    Obj letExpr = D_Nil.NIL;
    if(_context.count() == 2) {
      D_List exprs = (D_List)pop();
      D_List bindingObjs = (D_List)pop();
      letExpr = E_LetIn.create(bindingObjs.asRawArray(), exprs.asRawArray());
    }
    else {
      D_List bindingObjs = (D_List)pop();
      letExpr = E_Let.create(bindingObjs.asRawArray());
    }
    exitContext(letExpr);
  }

  @Override
  public void enterELoop(ELoopContext ctx) {}

  @Override
  public void exitELoop(ELoopContext ctx) {
    D_List exprs = (D_List)pop();
    Obj iter = pop();
    E_Loop loop = E_Loop.create(iter, exprs.asRawArray());
    push(loop);
  }

  @Override
  public void enterENondet(ENondetContext ctx) {}

  @Override
  public void exitENondet(ENondetContext ctx) {
    D_List exprList = (D_List)_context.pop();
    Obj[] exprs = exprList.asRawArray();
    E_Nondet nondet = E_Nondet.create(exprs);
    push(nondet);
  }

  @Override
  public void enterEQuote(EQuoteContext ctx) {}

  @Override
  public void exitEQuote(EQuoteContext ctx) {
    Obj any = pop();
    E_Quote quote = E_Quote.create(any);
    push(quote);
  }

  @Override
  public void enterESeq(ESeqContext ctx) {}

  @Override
  public void exitESeq(ESeqContext ctx) {
    D_List exprList = (D_List)pop();
    Obj[] exprs = exprList.asRawArray();
    E_Do seq = E_Do.create(exprs);
    push(seq);
  }

  @Override
  public void enterEWhile(EWhileContext ctx) {}

  @Override
  public void exitEWhile(EWhileContext ctx) {
    D_List exprs = (D_List)pop();
    Obj cond = pop();
    E_While loop = E_While.create(cond, exprs.asRawArray());
    push(loop);
  }

  // Collections ====================================================

  // Support methods

  @Override
  public void enterCollection(CollectionContext ctx) {}

  @Override
  public void exitCollection(CollectionContext ctx) {}

@Override
  public void enterCollectionRule(CollectionRuleContext ctx) {}

  @Override
  public void exitCollectionRule(CollectionRuleContext ctx) {}

  @Override
  public void enterCommaSepExprs(CommaSepExprsContext ctx) {
    enterContext();
  }

  @Override
  public void exitCommaSepExprs(CommaSepExprsContext ctx) {
    D_List lst = _context.asList().reverse();
    exitContext(lst);
  }

  // Collection methods
  
  @Override
  public void enterCArray(CArrayContext ctx) {
    enterContext();
  }

  @Override
  public void exitCArray(CArrayContext ctx) {
    D_List elems = D_List.EMPTY;
    if(_context.count() > 0)
      elems = (D_List)pop();
    D_Array ary = D_Array.copyFrom(elems, elems.count());
    exitContext(ary);
  }

  @Override
  public void enterCBinding(CBindingContext ctx) {
    enterContext();
  }

  @Override
  public void exitCBinding(CBindingContext ctx) {
    Obj value = pop();
    Obj key = pop();
    D_Binding binding = D_Binding.create(key, value);
    debug("Exiting binding rule with ", binding, ", context = ", _context);
    exitContext(binding);
  }

  @Override
  public void enterCBindingLhs(CBindingLhsContext ctx) {}

  @Override
  public void exitCBindingLhs(CBindingLhsContext ctx) {}

  
  @Override
  public void enterCHash(CHashContext ctx) {
    enterContext();
  }

  @Override
  public void exitCHash(CHashContext ctx) {
    D_List bindingList = D_List.EMPTY;
    if(_context.count() > 0)
      bindingList = (D_List)pop();
    D_HashTable hash = D_HashTable.copyFrom(bindingList);
    exitContext(hash);
  }

  @Override
  public void enterCList(CListContext ctx) {
    enterContext();
  }

  @Override
  public void exitCList(CListContext ctx) {
    D_List lst = D_List.EMPTY;
    if(_context.count() == 1)
      lst = (D_List)pop();
    else if(_context.count() == 2) {
      Obj rest = pop();
      Obj first = pop();
      lst = D_List.create(first, rest);
    }
    exitContext(lst);
  }

  @Override
  public void enterCQueue(CQueueContext ctx) {
    enterContext();
  }

  @Override
  public void exitCQueue(CQueueContext ctx) {
    D_List elems = D_List.EMPTY;
    if(_context.count() > 0)
      elems = (D_List)pop();
    D_Queue q = D_Queue.copyFrom(elems);
    exitContext(q);
  }

  @Override
  public void enterCSet(CSetContext ctx) {
    enterContext();
  }

  @Override
  public void exitCSet(CSetContext ctx) {
    D_List elems = D_List.EMPTY;
    if(_context.count() > 0)
      elems = (D_List)pop();
    D_Set set = D_Set.copyFrom(elems);
    exitContext(set);
  }

  @Override
  public void enterCStack(CStackContext ctx) {
    enterContext();
  }

  @Override
  public void exitCStack(CStackContext ctx) {
    D_List elems = D_List.EMPTY;
    if(_context.count() > 0)
      elems = (D_List)pop();
    D_Stack stack = D_Stack.copyFrom(elems);
    exitContext(stack);
  }

  @Override
  public void enterCTerm(CTermContext ctx) {
    enterContext();
  }

  @Override
  public void exitCTerm(CTermContext ctx) {
    D_Boolean vis = D_Boolean.FALSE;
    Obj attr = D_Nil.NIL;
    if(_context.count() == 4) {
      vis = (D_Boolean)pop();
      attr = pop();
    }
    D_Array elems = (D_Array)pop();
    D_Symbol name = (D_Symbol)pop();
    D_Term term = D_Term.create(name, elems, vis.boolValue(), attr);
    exitContext(term);
  }

  @Override
  public void enterCTermAttrib(CTermAttribContext ctx) {}

  @Override
  public void exitCTermAttrib(CTermAttribContext ctx) {
    String visOpStr = ctx.visOp.getText();
    push(D_Boolean.create(visOpStr.charAt(0) == '%'));
  }

  // Atoms ==========================================================

  @Override
  public void enterAtom(AtomContext ctx) {}

  @Override
  public void exitAtom(AtomContext ctx) {}

  @Override
  public void enterAtomRule(AtomRuleContext ctx) {}

  @Override
  public void exitAtomRule(AtomRuleContext ctx) {}

  @Override
  public void enterABoolean(ABooleanContext ctx) {}

  @Override
  public void exitABoolean(ABooleanContext ctx) {
    String text = ctx.getText();
    D_Boolean bln = D_Boolean.create(text.charAt(0) == 't');
    push(bln);
  }

  @Override
  public void enterAIdent(AIdentContext ctx) {}

  @Override
  public void exitAIdent(AIdentContext ctx) {
    String text = ctx.getText();
    debug("Exiting ident rule with ", text, ", context = ", _context);
    E_Identifier ident = E_Identifier.create(text);
    push(ident);
  }

  @Override
  public void enterAInteger(AIntegerContext ctx) {}

  @Override
  public void exitAInteger(AIntegerContext ctx)
  {
    String text = ctx.getText().replaceAll("_",  "");
    int i = Integer.parseInt(text);
    D_Integer integer  = D_Integer.create(i);
    push(integer);
  }

  @Override
  public void enterANil(ANilContext ctx) {}

  @Override
  public void exitANil(ANilContext ctx) {
    push(D_Nil.NIL);
  }

  @Override
  public void enterAReal(ARealContext ctx) {}

  @Override
  public void exitAReal(ARealContext ctx) {
    String text = ctx.getText().replaceAll("_",  "");
    float f = Float.parseFloat(text);
    D_Real r = D_Real.create(f);
    push(r);
  }

  @Override
  public void enterAString(AStringContext ctx) {}

  @Override
  public void exitAString(AStringContext ctx) {
    String text = ctx.getText();
    D_String str = D_String.create(text);
    push(str);
  }

  @Override
  public void enterASymbol(ASymbolContext ctx) {}

  @Override
  public void exitASymbol(ASymbolContext ctx) {
    String text = ctx.getText();
    D_Symbol sym = D_Symbol.create(text);
    push(sym);
  }

}

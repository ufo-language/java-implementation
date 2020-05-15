// Generated from UFO.g4 by ANTLR 4.8

package main.java.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UFOParser}.
 */
public interface UFOListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UFOParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(UFOParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(UFOParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterPrefixRule(UFOParser.PrefixRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitPrefixRule(UFOParser.PrefixRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code collectionRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterCollectionRule(UFOParser.CollectionRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code collectionRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitCollectionRule(UFOParser.CollectionRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterAtomRule(UFOParser.AtomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitAtomRule(UFOParser.AtomRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterInfixOpRule(UFOParser.InfixOpRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitInfixOpRule(UFOParser.InfixOpRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applicationRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterApplicationRule(UFOParser.ApplicationRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applicationRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitApplicationRule(UFOParser.ApplicationRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bindingOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterBindingOpRule(UFOParser.BindingOpRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bindingOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitBindingOpRule(UFOParser.BindingOpRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptRule(UFOParser.SubscriptRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptRule(UFOParser.SubscriptRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void enterExprRule(UFOParser.ExprRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 */
	void exitExprRule(UFOParser.ExprRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOps(UFOParser.PrefixOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOps(UFOParser.PrefixOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#level5ops}.
	 * @param ctx the parse tree
	 */
	void enterLevel5ops(UFOParser.Level5opsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#level5ops}.
	 * @param ctx the parse tree
	 */
	void exitLevel5ops(UFOParser.Level5opsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#level4ops}.
	 * @param ctx the parse tree
	 */
	void enterLevel4ops(UFOParser.Level4opsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#level4ops}.
	 * @param ctx the parse tree
	 */
	void exitLevel4ops(UFOParser.Level4opsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#level3ops}.
	 * @param ctx the parse tree
	 */
	void enterLevel3ops(UFOParser.Level3opsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#level3ops}.
	 * @param ctx the parse tree
	 */
	void exitLevel3ops(UFOParser.Level3opsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#level2ops}.
	 * @param ctx the parse tree
	 */
	void enterLevel2ops(UFOParser.Level2opsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#level2ops}.
	 * @param ctx the parse tree
	 */
	void exitLevel2ops(UFOParser.Level2opsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#bindingOp}.
	 * @param ctx the parse tree
	 */
	void enterBindingOp(UFOParser.BindingOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#bindingOp}.
	 * @param ctx the parse tree
	 */
	void exitBindingOp(UFOParser.BindingOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#level1ops}.
	 * @param ctx the parse tree
	 */
	void enterLevel1ops(UFOParser.Level1opsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#level1ops}.
	 * @param ctx the parse tree
	 */
	void exitLevel1ops(UFOParser.Level1opsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#parenList}.
	 * @param ctx the parse tree
	 */
	void enterParenList(UFOParser.ParenListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#parenList}.
	 * @param ctx the parse tree
	 */
	void exitParenList(UFOParser.ParenListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#exprSeq}.
	 * @param ctx the parse tree
	 */
	void enterExprSeq(UFOParser.ExprSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#exprSeq}.
	 * @param ctx the parse tree
	 */
	void exitExprSeq(UFOParser.ExprSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#bindingSeq}.
	 * @param ctx the parse tree
	 */
	void enterBindingSeq(UFOParser.BindingSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#bindingSeq}.
	 * @param ctx the parse tree
	 */
	void exitBindingSeq(UFOParser.BindingSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#commaSepExprs}.
	 * @param ctx the parse tree
	 */
	void enterCommaSepExprs(UFOParser.CommaSepExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#commaSepExprs}.
	 * @param ctx the parse tree
	 */
	void exitCommaSepExprs(UFOParser.CommaSepExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(UFOParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(UFOParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eAsync}.
	 * @param ctx the parse tree
	 */
	void enterEAsync(UFOParser.EAsyncContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eAsync}.
	 * @param ctx the parse tree
	 */
	void exitEAsync(UFOParser.EAsyncContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eBackQuote}.
	 * @param ctx the parse tree
	 */
	void enterEBackQuote(UFOParser.EBackQuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eBackQuote}.
	 * @param ctx the parse tree
	 */
	void exitEBackQuote(UFOParser.EBackQuoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eCobegin}.
	 * @param ctx the parse tree
	 */
	void enterECobegin(UFOParser.ECobeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eCobegin}.
	 * @param ctx the parse tree
	 */
	void exitECobegin(UFOParser.ECobeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eFun}.
	 * @param ctx the parse tree
	 */
	void enterEFun(UFOParser.EFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eFun}.
	 * @param ctx the parse tree
	 */
	void exitEFun(UFOParser.EFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eFunRules}.
	 * @param ctx the parse tree
	 */
	void enterEFunRules(UFOParser.EFunRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eFunRules}.
	 * @param ctx the parse tree
	 */
	void exitEFunRules(UFOParser.EFunRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eIf}.
	 * @param ctx the parse tree
	 */
	void enterEIf(UFOParser.EIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eIf}.
	 * @param ctx the parse tree
	 */
	void exitEIf(UFOParser.EIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eLet}.
	 * @param ctx the parse tree
	 */
	void enterELet(UFOParser.ELetContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eLet}.
	 * @param ctx the parse tree
	 */
	void exitELet(UFOParser.ELetContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eLoop}.
	 * @param ctx the parse tree
	 */
	void enterELoop(UFOParser.ELoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eLoop}.
	 * @param ctx the parse tree
	 */
	void exitELoop(UFOParser.ELoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eNondet}.
	 * @param ctx the parse tree
	 */
	void enterENondet(UFOParser.ENondetContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eNondet}.
	 * @param ctx the parse tree
	 */
	void exitENondet(UFOParser.ENondetContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eQuote}.
	 * @param ctx the parse tree
	 */
	void enterEQuote(UFOParser.EQuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eQuote}.
	 * @param ctx the parse tree
	 */
	void exitEQuote(UFOParser.EQuoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eSeq}.
	 * @param ctx the parse tree
	 */
	void enterESeq(UFOParser.ESeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eSeq}.
	 * @param ctx the parse tree
	 */
	void exitESeq(UFOParser.ESeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#eWhile}.
	 * @param ctx the parse tree
	 */
	void enterEWhile(UFOParser.EWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#eWhile}.
	 * @param ctx the parse tree
	 */
	void exitEWhile(UFOParser.EWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#collection}.
	 * @param ctx the parse tree
	 */
	void enterCollection(UFOParser.CollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#collection}.
	 * @param ctx the parse tree
	 */
	void exitCollection(UFOParser.CollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cArray}.
	 * @param ctx the parse tree
	 */
	void enterCArray(UFOParser.CArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cArray}.
	 * @param ctx the parse tree
	 */
	void exitCArray(UFOParser.CArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cBinding}.
	 * @param ctx the parse tree
	 */
	void enterCBinding(UFOParser.CBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cBinding}.
	 * @param ctx the parse tree
	 */
	void exitCBinding(UFOParser.CBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cBindingLhs}.
	 * @param ctx the parse tree
	 */
	void enterCBindingLhs(UFOParser.CBindingLhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cBindingLhs}.
	 * @param ctx the parse tree
	 */
	void exitCBindingLhs(UFOParser.CBindingLhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cHash}.
	 * @param ctx the parse tree
	 */
	void enterCHash(UFOParser.CHashContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cHash}.
	 * @param ctx the parse tree
	 */
	void exitCHash(UFOParser.CHashContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cList}.
	 * @param ctx the parse tree
	 */
	void enterCList(UFOParser.CListContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cList}.
	 * @param ctx the parse tree
	 */
	void exitCList(UFOParser.CListContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cQueue}.
	 * @param ctx the parse tree
	 */
	void enterCQueue(UFOParser.CQueueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cQueue}.
	 * @param ctx the parse tree
	 */
	void exitCQueue(UFOParser.CQueueContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cSet}.
	 * @param ctx the parse tree
	 */
	void enterCSet(UFOParser.CSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cSet}.
	 * @param ctx the parse tree
	 */
	void exitCSet(UFOParser.CSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cStack}.
	 * @param ctx the parse tree
	 */
	void enterCStack(UFOParser.CStackContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cStack}.
	 * @param ctx the parse tree
	 */
	void exitCStack(UFOParser.CStackContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cTerm}.
	 * @param ctx the parse tree
	 */
	void enterCTerm(UFOParser.CTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cTerm}.
	 * @param ctx the parse tree
	 */
	void exitCTerm(UFOParser.CTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#cTermAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCTermAttrib(UFOParser.CTermAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#cTermAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCTermAttrib(UFOParser.CTermAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(UFOParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(UFOParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aBoolean}.
	 * @param ctx the parse tree
	 */
	void enterABoolean(UFOParser.ABooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aBoolean}.
	 * @param ctx the parse tree
	 */
	void exitABoolean(UFOParser.ABooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aIdent}.
	 * @param ctx the parse tree
	 */
	void enterAIdent(UFOParser.AIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aIdent}.
	 * @param ctx the parse tree
	 */
	void exitAIdent(UFOParser.AIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aInteger}.
	 * @param ctx the parse tree
	 */
	void enterAInteger(UFOParser.AIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aInteger}.
	 * @param ctx the parse tree
	 */
	void exitAInteger(UFOParser.AIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aNil}.
	 * @param ctx the parse tree
	 */
	void enterANil(UFOParser.ANilContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aNil}.
	 * @param ctx the parse tree
	 */
	void exitANil(UFOParser.ANilContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aReal}.
	 * @param ctx the parse tree
	 */
	void enterAReal(UFOParser.ARealContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aReal}.
	 * @param ctx the parse tree
	 */
	void exitAReal(UFOParser.ARealContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aString}.
	 * @param ctx the parse tree
	 */
	void enterAString(UFOParser.AStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aString}.
	 * @param ctx the parse tree
	 */
	void exitAString(UFOParser.AStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFOParser#aSymbol}.
	 * @param ctx the parse tree
	 */
	void enterASymbol(UFOParser.ASymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFOParser#aSymbol}.
	 * @param ctx the parse tree
	 */
	void exitASymbol(UFOParser.ASymbolContext ctx);
}
// Generated from UFO.g4 by ANTLR 4.8

package main.java.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UFOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UFOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UFOParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(UFOParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixRule(UFOParser.PrefixRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code collectionRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionRule(UFOParser.CollectionRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomRule(UFOParser.AtomRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOpRule(UFOParser.InfixOpRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code applicationRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationRule(UFOParser.ApplicationRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bindingOpRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingOpRule(UFOParser.BindingOpRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptRule(UFOParser.SubscriptRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRule}
	 * labeled alternative in {@link UFOParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRule(UFOParser.ExprRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#prefixOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOps(UFOParser.PrefixOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#level5ops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel5ops(UFOParser.Level5opsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#level4ops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel4ops(UFOParser.Level4opsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#level3ops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel3ops(UFOParser.Level3opsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#level2ops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel2ops(UFOParser.Level2opsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#bindingOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingOp(UFOParser.BindingOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#level1ops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel1ops(UFOParser.Level1opsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#parenList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenList(UFOParser.ParenListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#exprSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSeq(UFOParser.ExprSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#bindingSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingSeq(UFOParser.BindingSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#commaSepExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaSepExprs(UFOParser.CommaSepExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(UFOParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eAsync}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAsync(UFOParser.EAsyncContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eBackQuote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEBackQuote(UFOParser.EBackQuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eCobegin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitECobegin(UFOParser.ECobeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEFun(UFOParser.EFunContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eFunRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEFunRules(UFOParser.EFunRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEIf(UFOParser.EIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eLet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitELet(UFOParser.ELetContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitELoop(UFOParser.ELoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eNondet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENondet(UFOParser.ENondetContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eQuote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQuote(UFOParser.EQuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitESeq(UFOParser.ESeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#eWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEWhile(UFOParser.EWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection(UFOParser.CollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCArray(UFOParser.CArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCBinding(UFOParser.CBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cBindingLhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCBindingLhs(UFOParser.CBindingLhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCHash(UFOParser.CHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCList(UFOParser.CListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cQueue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCQueue(UFOParser.CQueueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCSet(UFOParser.CSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cStack}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCStack(UFOParser.CStackContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCTerm(UFOParser.CTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#cTermAttrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCTermAttrib(UFOParser.CTermAttribContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(UFOParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aBoolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitABoolean(UFOParser.ABooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAIdent(UFOParser.AIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAInteger(UFOParser.AIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aNil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitANil(UFOParser.ANilContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAReal(UFOParser.ARealContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAString(UFOParser.AStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link UFOParser#aSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASymbol(UFOParser.ASymbolContext ctx);
}
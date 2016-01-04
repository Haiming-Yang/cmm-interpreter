package antlr;// Generated from E:/TangJiong/Workspace/CmmCompiler/src\Cmm.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CmmParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_block(CmmParser.Stmt_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(CmmParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(CmmParser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#decl_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_assign(CmmParser.Decl_assignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S(CmmParser.I_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB(CmmParser.I_SBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S_E_S}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S_E_S(CmmParser.I_S_E_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_S_E_SB}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_S_E_SB(CmmParser.I_S_E_SBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB_E_S}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB_E_S(CmmParser.I_SB_E_SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code I_SB_E_SB}
	 * labeled alternative in {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_SB_E_SB(CmmParser.I_SB_E_SBContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(CmmParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(CmmParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#read_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stmt(CmmParser.Read_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#write_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_stmt(CmmParser.Write_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(CmmParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CmmParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(CmmParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CmmParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(CmmParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(CmmParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(CmmParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddMinExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMinExpr(CmmParser.AddMinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(CmmParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(CmmParser.ParenthesesExprContext ctx);
}
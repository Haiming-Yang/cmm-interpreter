package antlr;// Generated from E:/TangJiong/Workspace/CmmCompiler/src\Cmm.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CmmParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CmmParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void enterStmt_block(CmmParser.Stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void exitStmt_block(CmmParser.Stmt_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(CmmParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(CmmParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#varlist}.
	 * @param ctx the parse tree
	 */
	void enterVarlist(CmmParser.VarlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#varlist}.
	 * @param ctx the parse tree
	 */
	void exitVarlist(CmmParser.VarlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(CmmParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(CmmParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(CmmParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(CmmParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(CmmParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(CmmParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(CmmParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(CmmParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(CmmParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(CmmParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(CmmParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(CmmParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CmmParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CmmParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CmmParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CmmParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CmmParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CmmParser.ExprContext ctx);
}
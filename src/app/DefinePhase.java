package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by TangJiong on 2016/1/2.
 * 变量定义阶段的监听器
 */
public class DefinePhase extends CmmBaseListener {

    // 是一个IdentityHashMap<ParseTree,T>
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    GlobalScope globals;
    Scope currentScope;

    public void saveScope(ParserRuleContext context, Scope scope){
        scopes.put(context, scope);
    }

    @Override
    public void enterProgram(CmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(CmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void enterStmt(CmmParser.StmtContext ctx) {
        super.enterStmt(ctx);
    }

    @Override
    public void exitStmt(CmmParser.StmtContext ctx) {
        super.exitStmt(ctx);
    }

    @Override
    public void enterStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
    }

    @Override
    public void exitStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
    }

    @Override
    public void enterVar_decl(CmmParser.Var_declContext ctx) {
        super.enterVar_decl(ctx);
    }

    @Override
    public void exitVar_decl(CmmParser.Var_declContext ctx) {
        super.exitVar_decl(ctx);
    }

    @Override
    public void enterIf_stmt(CmmParser.If_stmtContext ctx) {
        super.enterIf_stmt(ctx);
    }

    @Override
    public void exitIf_stmt(CmmParser.If_stmtContext ctx) {
        super.exitIf_stmt(ctx);
    }

    @Override
    public void enterWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.enterWhile_stmt(ctx);
    }

    @Override
    public void exitWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.exitWhile_stmt(ctx);
    }

    @Override
    public void enterBreak_stmt(CmmParser.Break_stmtContext ctx) {
        super.enterBreak_stmt(ctx);
    }

    @Override
    public void exitBreak_stmt(CmmParser.Break_stmtContext ctx) {
        super.exitBreak_stmt(ctx);
    }

    @Override
    public void enterRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.enterRead_stmt(ctx);
    }

    @Override
    public void exitRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.exitRead_stmt(ctx);
    }

    @Override
    public void enterWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.enterWrite_stmt(ctx);
    }

    @Override
    public void exitWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.exitWrite_stmt(ctx);
    }

    @Override
    public void enterAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.enterAssign_stmt(ctx);
    }

    @Override
    public void exitAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.exitAssign_stmt(ctx);
    }
}

package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by TangJiong on 2016/1/3.
 * 变量引用阶段的监听器
 */
public class ReferPhase extends CmmBaseListener {

    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    public ReferPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.globals = globals;
        this.scopes = scopes;
    }

    // 下列语句中需要切换作用域
    @Override
    public void enterProgram(CmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        currentScope = globals;
    }

    @Override
    public void enterStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterIf_stmt(CmmParser.If_stmtContext ctx) {
        super.enterIf_stmt(ctx);
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitIf_stmt(CmmParser.If_stmtContext ctx) {
        super.exitIf_stmt(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.enterWhile_stmt(ctx);
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.exitWhile_stmt(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    // 执行到下面的语句时，需要判断变量是否已定义
    @Override
    public void exitRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.exitRead_stmt(ctx);
        Token token = null;
        if(ctx.Ident() == null){
            token = ctx.array().Ident().getSymbol();
        }else{
            token = ctx.Ident().getSymbol();
        }
        String varName = token.getText();
        Symbol var = currentScope.resolve(varName);
        if(var == null){
            // TODO 将信息输出到UI
            System.out.println("ERROR: no such variable <"
                    + varName
                    + "> in line"
                    + token.getLine()
                    + ":" + token.getCharPositionInLine());
        }
    }

    @Override
    public void exitValue(CmmParser.ValueContext ctx) {
        super.exitValue(ctx);
        Token token = null;
        if(ctx.Ident() == null){
            token = ctx.array().Ident().getSymbol();
        }else{
            token = ctx.Ident().getSymbol();
        }
        String varName = token.getText();
        Symbol var = currentScope.resolve(varName);
        if(var == null){
            // TODO 将信息输出到UI
            System.out.println("ERROR: no such variable <"
                    + varName
                    + "> in line"
                    + token.getLine()
                    + ":" + token.getCharPositionInLine());
        }
    }

    @Override
    public void exitParenthesesExpr(CmmParser.ParenthesesExprContext ctx) {
        super.exitParenthesesExpr(ctx);
    }

    @Override
    public void enterParenthesesExpr(CmmParser.ParenthesesExprContext ctx) {
        super.enterParenthesesExpr(ctx);
    }

    @Override
    public void exitCompareExpr(CmmParser.CompareExprContext ctx) {
        super.exitCompareExpr(ctx);
    }

    @Override
    public void enterCompareExpr(CmmParser.CompareExprContext ctx) {
        super.enterCompareExpr(ctx);
    }

    @Override
    public void exitAddMinExpr(CmmParser.AddMinExprContext ctx) {
        super.exitAddMinExpr(ctx);
    }

    @Override
    public void enterAddMinExpr(CmmParser.AddMinExprContext ctx) {
        super.enterAddMinExpr(ctx);
    }

    @Override
    public void exitMulDivExpr(CmmParser.MulDivExprContext ctx) {
        super.exitMulDivExpr(ctx);
    }

    @Override
    public void enterMulDivExpr(CmmParser.MulDivExprContext ctx) {
        super.enterMulDivExpr(ctx);
    }

    @Override
    public void exitValueExpr(CmmParser.ValueExprContext ctx) {
        super.exitValueExpr(ctx);
    }

    @Override
    public void enterValueExpr(CmmParser.ValueExprContext ctx) {
        super.enterValueExpr(ctx);
    }

    @Override
    public void exitSignExpr(CmmParser.SignExprContext ctx) {
        super.exitSignExpr(ctx);
    }

    @Override
    public void enterSignExpr(CmmParser.SignExprContext ctx) {
        super.enterSignExpr(ctx);
    }
}

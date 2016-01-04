package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by TangJiong on 2016/1/3.
 * 变量引用阶段的监听器
 */
public class RefPhaseListener extends CmmBaseListener {

    private IOInterface io;

    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    public RefPhaseListener(GlobalScope globals, ParseTreeProperty<Scope> scopes, IOInterface io) {
        this.globals = globals;
        this.scopes = scopes;
        this.io = io;
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

    // 执行到下面的语句时，需要判断变量是否已定义
    @Override
    public void exitRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.exitRead_stmt(ctx);
        Token token = null;
        if(ctx.Ident() == null){ // 数组
            token = ctx.array().Ident().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return;
            }
            int varIndex = Integer.parseInt(ctx.array().IntConstant().getText());
            if(var.getType() == Type.tIntArray){ // int数组

                int[] varArray = (int[]) var.getValue();

                // 数组越界检查
                if(varIndex < varArray.length){
                    int in = Integer.parseInt(io.input());
                    varArray[varIndex] = in;
                }else{
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) var.getValue();

                // 数组越界检查
                if(varIndex < varArray.length){
                    Double in = Double.parseDouble(io.input());
                    varArray[varIndex] = in;
                }else{
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }
        }else{ // 普通变量
            token = ctx.Ident().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return;
            }
            if(var.getType() == Type.tInt){
                int in = Integer.parseInt(io.input());
                var.setValue(in);
            }else{
                Double in = Double.parseDouble(io.input());
                var.setValue(in);
            }

        }

    }

    @Override
    public void exitAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.exitAssign_stmt(ctx);
        Token token = null;
        if(ctx.value().Ident() == null){
            token = ctx.value().array().Ident().getSymbol();
        }else{
            token = ctx.value().Ident().getSymbol();
        }
        String varName = token.getText();
        Symbol var = currentScope.resolve(varName);
        if(var == null){
            io.output("ERROR: no such variable <"
                    + varName
                    + "> in line "
                    + token.getLine()
                    + ":" + token.getCharPositionInLine());
        }else{ // 变量存在
            Token assign = ctx.Assign().getSymbol();
            ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal value = exprComputeVisitor.visit(ctx.expr());
            if(var.getType() != value.getType()){
                    io.output("ERROR: unmatched type on two side of <"
                            + assign.getText()
                            + "> in line "
                            + assign.getLine()
                            +":"
                            + assign.getCharPositionInLine());
            }else{ // 新值覆盖旧值
                var.setValue(value.getValue());
            }
        }
    }

    // 输出变量或表达式


    @Override
    public void enterWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.enterWrite_stmt(ctx);
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        Object value = exprComputeVisitor.visit(ctx.expr()).getValue();
        io.output(value);
    }

    @Override
    public void exitWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.exitWrite_stmt(ctx);
    }
}

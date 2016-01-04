package app;

import antlr.CmmBaseVisitor;
import antlr.CmmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by TangJiong on 2016/1/4.
 */
public class ControlVisitor extends CmmBaseVisitor<ExprReturnVal> {

    private IOInterface io;

    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    public ControlVisitor(GlobalScope globals, ParseTreeProperty<Scope> scopes, IOInterface io) {
        this.io = io;
        this.globals = globals;
        this.scopes = scopes;
    }

    @Override
    public ExprReturnVal visitProgram(CmmParser.ProgramContext ctx) {
        currentScope = globals;
        super.visitProgram(ctx);
        return null;
    }

    @Override
    public ExprReturnVal visitStmt_block(CmmParser.Stmt_blockContext ctx) {
        currentScope = scopes.get(ctx);
        super.visitStmt_block(ctx);
        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    @Override
    public ExprReturnVal visitAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.visitAssign_stmt(ctx);
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
        return null;
    }

    @Override
    public ExprReturnVal visitRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.visitRead_stmt(ctx);
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
                return null;
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
                return null;
            }
            if(var.getType() == Type.tInt){
                int in = Integer.parseInt(io.input());
                var.setValue(in);
            }else{
                Double in = Double.parseDouble(io.input());
                var.setValue(in);
            }

        }
        return null;
    }

    @Override
    public ExprReturnVal visitWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.visitWrite_stmt(ctx);
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        Object value = exprComputeVisitor.visit(ctx.expr()).getValue();
        io.output(value);
        return null;
    }

    // ==========下面是if else的各种变种，为了减少判断，特地在文法了进行了拆分

    @Override
    public ExprReturnVal visitI_S(CmmParser.I_SContext ctx) { // if stmt
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB(CmmParser.I_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_S(CmmParser.I_S_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt(0));
        }else{
            visit(ctx.stmt(1));
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_SB(CmmParser.I_S_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }else{
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_S(CmmParser.I_SB_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }else{
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_SB(CmmParser.I_SB_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block(0));
        }else{
            visit(ctx.stmt_block(1));
        }
        return null;
    }

    private boolean isExprTrue(CmmParser.ExprContext ctx){
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        ExprReturnVal value = exprComputeVisitor.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Boolean) value.getValue();
        }else{
            return (Double) value.getValue() > 0;
        }
    }

    // ============================= end if else ==========================

    @Override
    public ExprReturnVal visitWhile_stmt(CmmParser.While_stmtContext ctx) {

        while (isExprTrue(ctx.expr())) {
            if(ctx.stmt() != null){ // while后面紧跟stmt
                visit(ctx.stmt());
            }else{ // while后面紧跟stmt_block
                visit(ctx.stmt_block());
            }
        }

        return null;
    }

    @Override
    public ExprReturnVal visitBreak_stmt(CmmParser.Break_stmtContext ctx) {
        return super.visitBreak_stmt(ctx);
    }


}

package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.*;

/**
 * Created by TangJiong on 2015/12/14.
 * Listener
 */
public class MyCmmListener extends CmmBaseListener {

    private JTextArea consoleArea;

    public MyCmmListener(JTextArea consoleArea){
        this.consoleArea = consoleArea;
    }

    @Override
    public void enterProgram(CmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
//        consoleArea.append("enter program\n");
    }

    @Override
    public void exitProgram(CmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);
//        consoleArea.append("exit program\n");
    }

    @Override
    public void enterStmt(CmmParser.StmtContext ctx) {
        super.enterStmt(ctx);
//        consoleArea.append("enter stmt\n");
    }

    @Override
    public void exitStmt(CmmParser.StmtContext ctx) {
        super.exitStmt(ctx);
//        consoleArea.append("exit stmt\n");
    }

    @Override
    public void enterStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
//        consoleArea.append("enter stmt_block\n");
    }

    @Override
    public void exitStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
//        consoleArea.append("exit stmt_block\n");
    }

    @Override
    public void enterVar_decl(CmmParser.Var_declContext ctx) {
        super.enterVar_decl(ctx);
//        consoleArea.append("enter var_decl\n");
    }

    @Override
    public void exitVar_decl(CmmParser.Var_declContext ctx) {
        super.exitVar_decl(ctx);
//        consoleArea.append("exit var_decl\n");
    }

    @Override
    public void enterType(CmmParser.TypeContext ctx) {
        super.enterType(ctx);
//        consoleArea.append("enter type\n");
    }

    @Override
    public void exitType(CmmParser.TypeContext ctx) {
        super.exitType(ctx);
//        consoleArea.append("exit type\n");
    }

    @Override
    public void enterVarlist(CmmParser.VarlistContext ctx) {
        super.enterVarlist(ctx);
//        consoleArea.append("enter varlist\n");
    }

    @Override
    public void exitVarlist(CmmParser.VarlistContext ctx) {
        super.exitVarlist(ctx);
//        consoleArea.append("exit varlist\n");
    }

    @Override
    public void enterIf_stmt(CmmParser.If_stmtContext ctx) {
        super.enterIf_stmt(ctx);
//        consoleArea.append("enter if_stmt\n");
    }

    @Override
    public void exitIf_stmt(CmmParser.If_stmtContext ctx) {
        super.exitIf_stmt(ctx);
//        consoleArea.append("exit if_stmt\n");
    }

    @Override
    public void enterWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.enterWhile_stmt(ctx);
//        consoleArea.append("enter while_stmt\n");
    }

    @Override
    public void exitWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.exitWhile_stmt(ctx);
//        consoleArea.append("exit while_stmt\n");
    }

    @Override
    public void enterBreak_stmt(CmmParser.Break_stmtContext ctx) {
        super.enterBreak_stmt(ctx);
//        consoleArea.append("enter break_stmt\n");
    }

    @Override
    public void exitBreak_stmt(CmmParser.Break_stmtContext ctx) {
        super.exitBreak_stmt(ctx);
//        consoleArea.append("exit break_stmt\n");
    }

    @Override
    public void enterRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.enterRead_stmt(ctx);
//        consoleArea.append("enter read_stmt\n");
    }

    @Override
    public void enterWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.enterWrite_stmt(ctx);
//        consoleArea.append("enter write_stmt\n");
    }

    @Override
    public void exitRead_stmt(CmmParser.Read_stmtContext ctx) {
        super.exitRead_stmt(ctx);
//        consoleArea.append("exit read_stmt\n");
    }

    @Override
    public void exitWrite_stmt(CmmParser.Write_stmtContext ctx) {
        super.exitWrite_stmt(ctx);
//        consoleArea.append("exit write_stmt\n");
    }

    @Override
    public void enterAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.enterAssign_stmt(ctx);
//        consoleArea.append("enter assgin_stmt\n");
    }

    @Override
    public void exitAssign_stmt(CmmParser.Assign_stmtContext ctx) {
        super.exitAssign_stmt(ctx);
//        consoleArea.append("exit assign_stmt\n");
    }

    @Override
    public void enterValue(CmmParser.ValueContext ctx) {
        super.enterValue(ctx);
//        consoleArea.append("enter value\n");
    }

    @Override
    public void exitValue(CmmParser.ValueContext ctx) {
        super.exitValue(ctx);
//        consoleArea.append("exit value\n");
    }

    @Override
    public void enterConstant(CmmParser.ConstantContext ctx) {
        super.enterConstant(ctx);
//        consoleArea.append("enter constant\n");
    }

    @Override
    public void exitConstant(CmmParser.ConstantContext ctx) {
        super.exitConstant(ctx);
//        consoleArea.append("exit constant\n");
    }

    @Override
    public void enterExpr(CmmParser.ExprContext ctx) {
        super.enterExpr(ctx);
//        consoleArea.append("enter expr\n");
    }

    @Override
    public void exitExpr(CmmParser.ExprContext ctx) {
        super.exitExpr(ctx);
//        consoleArea.append("exit expr\n");
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
//        consoleArea.append("enter every rule\n");
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
//        consoleArea.append("exit every rule\n");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
//        consoleArea.append("visit terminal\n");
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        consoleArea.append("ERROR: " + node.getText()
                +" in line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine()
                +"\n");
    }
}

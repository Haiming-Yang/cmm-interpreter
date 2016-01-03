package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by TangJiong on 2016/1/2.
 * 变量定义阶段的监听器
 */
public class DefinePhase extends CmmBaseListener {

    // 是一个IdentityHashMap<ParseTree,T>
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    GlobalScope globals;
    Scope currentScope;

    public void saveScope(ParserRuleContext ctx, Scope scope){
        scopes.put(ctx, scope);
    }

    @Override
    public void enterProgram(CmmParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        globals = new GlobalScope(null);
        currentScope = globals;
    }

    @Override
    public void exitProgram(CmmParser.ProgramContext ctx) {
        super.exitProgram(ctx);
//        if(Constant.DEBUG){
//            System.out.println(scopes.toString());
//        }
    }

    @Override
    public void enterStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.enterStmt_block(ctx);
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitStmt_block(CmmParser.Stmt_blockContext ctx) {
        super.exitStmt_block(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterVarlist(CmmParser.VarlistContext ctx) {
        super.enterVarlist(ctx);

        // 变量类型，变量列表里的变量类型都是相同的
        String typeStr = ctx.getParent().getChild(0).getText();

        // 数组声明
        for(CmmParser.ArrayContext arrayContext: ctx.array()){
            Token token = arrayContext.Ident().getSymbol();
            if(Constant.DEBUG){
                System.out.println("<"
                        + typeStr + " "
                        + token.getText()
                        + " >");
            }
            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            currentScope.define(new Symbol(token.getText(),
                    typeStr.equals("int")? Type.tIntArray : Type.tRealArray));
        }

        // 普通变量声明
        for(TerminalNode node : ctx.getTokens(CmmParser.Ident)){
            if(Constant.DEBUG){
                System.out.println("<"
                        + typeStr + " "
                        + node.getSymbol().getText()
                        + " >");
            }
            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            currentScope.define(new Symbol(node.getSymbol().getText(),
                    typeStr.equals("int")? Type.tInt : Type.tReal));

        }

        // 普通变量在声明时赋值
        for(CmmParser.Decl_assignContext decl_assignContext : ctx.decl_assign()){
            Token token = decl_assignContext.Ident().getSymbol();
            if(Constant.DEBUG){
                System.out.println("<"
                        + typeStr + " "
                        + token.getText()
                        + " >");
            }
            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            currentScope.define(new Symbol(token.getText(),
                    typeStr.equals("int")? Type.tInt : Type.tReal));
        }

    }

    @Override
    public void enterIf_stmt(CmmParser.If_stmtContext ctx) {
        super.enterIf_stmt(ctx);
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitIf_stmt(CmmParser.If_stmtContext ctx) {
        super.exitIf_stmt(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.enterWhile_stmt(ctx);
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitWhile_stmt(CmmParser.While_stmtContext ctx) {
        super.exitWhile_stmt(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

}

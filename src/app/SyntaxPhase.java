package app;

import antlr.CmmBaseListener;
import antlr.CmmParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.*;

/**
 * Created by TangJiong on 2015/12/14.
 * 语法错误扫描阶段监听器
 */
public class SyntaxPhase extends CmmBaseListener {

    private IOInterface io;

    public SyntaxPhase(IOInterface io){
        this.io = io;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        io.output("ERROR: " + node.getText()
                +" in line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine()
                +"\n");
    }
}

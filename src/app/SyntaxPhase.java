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

    private JTextArea consoleArea;

    public SyntaxPhase(JTextArea consoleArea){
        this.consoleArea = consoleArea;
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

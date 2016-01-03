package app;

import antlr.CmmLexer;
import antlr.CmmParser;
import antlr.CmmToken;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.util.List;

/**
 * Created by TangJiong on 2015/12/14.
 * The core compiler program based on antlr
 */
public class Compiler {

    private boolean showLexerResult = true;
    private boolean showAST = true;
    private String source;
    private JTextArea outputArea;

    public Compiler(String source, JTextArea outputArea){
        this.source = source;
        this.outputArea = outputArea;
    }

    public void run(){

        try{

            outputArea.append("====== compiler starting... ======\n");

            CmmLexer lexer = new CmmLexer(new ANTLRInputStream(source));

            // ===================== 词法分析 =======================
            if(showLexerResult){
                outputArea.append("====== lexer analysis result: ======\n");
                outputArea.append("Token\tLine\tType\n");
                List<CmmToken> tokenList = (List<CmmToken>) lexer.getAllTokens();
                for(Token token : tokenList){

                    outputArea.append(token.getText() + "\t" + token.getLine()
                            + "\t" + TokenDictionary.getTokenType(token.getType()) + "\n");

                }
                lexer.reset();
            }

            // =================== 语法分析 =======================
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CmmParser parser = new CmmParser(tokenStream);
            ParseTree parseTree = parser.program();
            if(showAST){
                outputArea.append("====== show tree ======\n");
                Trees.inspect(parseTree, parser);
            }
            ParseTreeWalker walker = new ParseTreeWalker();

            // 语法分析阶段，分析语法错误
            SyntaxPhase syntaxPhase = new SyntaxPhase(outputArea);
            walker.walk(syntaxPhase, parseTree);

            // 定义阶段，将变量放入符号表
            DefinePhase definePhase = new DefinePhase();
            walker.walk(definePhase, parseTree);

            // 引用阶段，变量作用域检查
            ReferPhase referPhase = new ReferPhase(definePhase.globals, definePhase.scopes);
            walker.walk(referPhase, parseTree);

        }catch (Exception e){
            outputArea.append(e.getMessage());
        }

    }

    public boolean isShowLexerResult() {
        return showLexerResult;
    }
    public void setShowLexerResult(boolean showLexerResult) {
        this.showLexerResult = showLexerResult;
    }
    public boolean isShowAST() {
        return showAST;
    }
    public void setShowAST(boolean showAST) {
        this.showAST = showAST;
    }
}

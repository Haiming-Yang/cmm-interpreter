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
    private IOInterface io;

    public Compiler(String source, IOInterface io){
        this.source = source;
        this.io = io;
    }

    public void run(){

        try{

            io.output("====== compiler starting... ======\n");

            CmmLexer lexer = new CmmLexer(new ANTLRInputStream(source));

            // ===================== 词法分析 =======================
            if(showLexerResult){
                io.output("====== lexer analysis result: ======\n");
                io.output("Token\tLine\tType\n");
                List<CmmToken> tokenList = (List<CmmToken>) lexer.getAllTokens();
                for(Token token : tokenList){

                    io.output(token.getText() + "\t" + token.getLine()
                            + "\t" + TokenDictionary.getTokenType(token.getType()) + "\n");

                }
                lexer.reset();
            }

            // =================== 语法分析 =======================
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CmmParser parser = new CmmParser(tokenStream);
            ParseTree parseTree = parser.program();
            if(showAST){
                io.output("====== show tree ======\n");
                Trees.inspect(parseTree, parser);
            }
            ParseTreeWalker walker = new ParseTreeWalker();

            // 语法分析阶段，分析语法错误
            SyntaxPhase syntaxPhase = new SyntaxPhase(io);
            walker.walk(syntaxPhase, parseTree);

            // 定义阶段，将变量放入符号表
            DefPhaseListener defPhaseListener = new DefPhaseListener(io);
            walker.walk(defPhaseListener, parseTree);

            // 引用阶段，变量作用域检查
            RefPhaseListener refPhaseListener = new RefPhaseListener(defPhaseListener.globals,
                    defPhaseListener.scopes,
                    io);
            walker.walk(refPhaseListener, parseTree);

        }catch (Exception e){
            io.output(e.getMessage());
            if(Constant.DEBUG){
                e.printStackTrace();
            }
        }

    }

    public void setShowLexerResult(boolean showLexerResult) {
        this.showLexerResult = showLexerResult;
    }
    public void setShowAST(boolean showAST) {
        this.showAST = showAST;
    }
}

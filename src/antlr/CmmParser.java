package antlr;// Generated from E:/TangJiong/Workspace/CmmCompiler/src\Cmm.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, While=3, Read=4, Write=5, Int=6, Real=7, Break=8, Ident=9, 
		IntConstant=10, RealConstant=11, BooleanConstant=12, Operator=13, Sign=14, 
		LBracket=15, RBracket=16, LBigBracket=17, RBigBracket=18, LMidBracket=19, 
		RMidBracket=20, Assign=21, LineEnd=22, Comma=23, WS=24, SL_COMMENT=25, 
		MUL_COMMENT=26;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_stmt_block = 2, RULE_var_decl = 3, 
		RULE_type = 4, RULE_varlist = 5, RULE_if_stmt = 6, RULE_while_stmt = 7, 
		RULE_break_stmt = 8, RULE_read_stmt = 9, RULE_write_stmt = 10, RULE_assign_stmt = 11, 
		RULE_value = 12, RULE_constant = 13, RULE_expr = 14;
	public static final String[] ruleNames = {
		"program", "stmt", "stmt_block", "var_decl", "type", "varlist", "if_stmt", 
		"while_stmt", "break_stmt", "read_stmt", "write_stmt", "assign_stmt", 
		"value", "constant", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'read'", "'write'", "'int'", "'real'", 
		"'break'", null, null, null, null, null, null, "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "'='", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "If", "Else", "While", "Read", "Write", "Int", "Real", "Break", 
		"Ident", "IntConstant", "RealConstant", "BooleanConstant", "Operator", 
		"Sign", "LBracket", "RBracket", "LBigBracket", "RBigBracket", "LMidBracket", 
		"RMidBracket", "Assign", "LineEnd", "Comma", "WS", "SL_COMMENT", "MUL_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				stmt();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Real) | (1L << Break) | (1L << Ident) | (1L << IntConstant) | (1L << RealConstant) | (1L << BooleanConstant) | (1L << LBigBracket))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(43);
			switch (_input.LA(1)) {
			case Int:
			case Real:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				var_decl();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				while_stmt();
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				break_stmt();
				}
				break;
			case Ident:
			case IntConstant:
			case RealConstant:
			case BooleanConstant:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				assign_stmt();
				}
				break;
			case Read:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				read_stmt();
				}
				break;
			case Write:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				write_stmt();
				}
				break;
			case LBigBracket:
				enterOuterAlt(_localctx, 8);
				{
				setState(42);
				stmt_block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_blockContext extends ParserRuleContext {
		public TerminalNode LBigBracket() { return getToken(CmmParser.LBigBracket, 0); }
		public TerminalNode RBigBracket() { return getToken(CmmParser.RBigBracket, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStmt_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStmt_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStmt_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_blockContext stmt_block() throws RecognitionException {
		Stmt_blockContext _localctx = new Stmt_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(LBigBracket);
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				stmt();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << While) | (1L << Read) | (1L << Write) | (1L << Int) | (1L << Real) | (1L << Break) | (1L << Ident) | (1L << IntConstant) | (1L << RealConstant) | (1L << BooleanConstant) | (1L << LBigBracket))) != 0) );
			setState(51);
			match(RBigBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public TerminalNode LineEnd() { return getToken(CmmParser.LineEnd, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			type();
			setState(54);
			varlist();
			setState(55);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(CmmParser.Int, 0); }
		public TerminalNode Real() { return getToken(CmmParser.Real, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==Real) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarlistContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(CmmParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(CmmParser.Ident, i);
		}
		public List<TerminalNode> LMidBracket() { return getTokens(CmmParser.LMidBracket); }
		public TerminalNode LMidBracket(int i) {
			return getToken(CmmParser.LMidBracket, i);
		}
		public List<TerminalNode> IntConstant() { return getTokens(CmmParser.IntConstant); }
		public TerminalNode IntConstant(int i) {
			return getToken(CmmParser.IntConstant, i);
		}
		public List<TerminalNode> RMidBracket() { return getTokens(CmmParser.RMidBracket); }
		public TerminalNode RMidBracket(int i) {
			return getToken(CmmParser.RMidBracket, i);
		}
		public List<TerminalNode> Assign() { return getTokens(CmmParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(CmmParser.Assign, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CmmParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CmmParser.Comma, i);
		}
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(Ident);
			setState(63);
			_la = _input.LA(1);
			if (_la==LMidBracket) {
				{
				setState(60);
				match(LMidBracket);
				setState(61);
				match(IntConstant);
				setState(62);
				match(RMidBracket);
				}
			}

			setState(67);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(65);
				match(Assign);
				setState(66);
				expr(0);
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(69);
				match(Comma);
				setState(70);
				match(Ident);
				setState(74);
				_la = _input.LA(1);
				if (_la==LMidBracket) {
					{
					setState(71);
					match(LMidBracket);
					setState(72);
					match(IntConstant);
					setState(73);
					match(RMidBracket);
					}
				}

				setState(78);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(76);
					match(Assign);
					setState(77);
					expr(0);
					}
				}

				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CmmParser.If, 0); }
		public TerminalNode LBracket() { return getToken(CmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(CmmParser.RBracket, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<Stmt_blockContext> stmt_block() {
			return getRuleContexts(Stmt_blockContext.class);
		}
		public Stmt_blockContext stmt_block(int i) {
			return getRuleContext(Stmt_blockContext.class,i);
		}
		public TerminalNode Else() { return getToken(CmmParser.Else, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(If);
			setState(86);
			match(LBracket);
			setState(87);
			expr(0);
			setState(88);
			match(RBracket);
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(89);
				stmt();
				}
				break;
			case 2:
				{
				setState(90);
				stmt_block();
				}
				break;
			}
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(93);
				match(Else);
				setState(96);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(94);
					stmt();
					}
					break;
				case 2:
					{
					setState(95);
					stmt_block();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(CmmParser.While, 0); }
		public TerminalNode LBracket() { return getToken(CmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(CmmParser.RBracket, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_blockContext stmt_block() {
			return getRuleContext(Stmt_blockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(While);
			setState(101);
			match(LBracket);
			setState(102);
			expr(0);
			setState(103);
			match(RBracket);
			setState(106);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(104);
				stmt();
				}
				break;
			case 2:
				{
				setState(105);
				stmt_block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(CmmParser.Break, 0); }
		public TerminalNode LineEnd() { return getToken(CmmParser.LineEnd, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBreak_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBreak_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(Break);
			setState(109);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public TerminalNode Read() { return getToken(CmmParser.Read, 0); }
		public TerminalNode LBracket() { return getToken(CmmParser.LBracket, 0); }
		public TerminalNode Ident() { return getToken(CmmParser.Ident, 0); }
		public TerminalNode RBracket() { return getToken(CmmParser.RBracket, 0); }
		public TerminalNode LineEnd() { return getToken(CmmParser.LineEnd, 0); }
		public TerminalNode LMidBracket() { return getToken(CmmParser.LMidBracket, 0); }
		public TerminalNode IntConstant() { return getToken(CmmParser.IntConstant, 0); }
		public TerminalNode RMidBracket() { return getToken(CmmParser.RMidBracket, 0); }
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRead_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRead_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_read_stmt);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(Read);
				setState(112);
				match(LBracket);
				setState(113);
				match(Ident);
				setState(114);
				match(RBracket);
				setState(115);
				match(LineEnd);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(Read);
				setState(117);
				match(LBracket);
				setState(118);
				match(Ident);
				setState(119);
				match(LMidBracket);
				setState(120);
				match(IntConstant);
				setState(121);
				match(RMidBracket);
				setState(122);
				match(RBracket);
				setState(123);
				match(LineEnd);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_stmtContext extends ParserRuleContext {
		public TerminalNode Write() { return getToken(CmmParser.Write, 0); }
		public TerminalNode LBracket() { return getToken(CmmParser.LBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(CmmParser.RBracket, 0); }
		public TerminalNode LineEnd() { return getToken(CmmParser.LineEnd, 0); }
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWrite_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWrite_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWrite_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(Write);
			setState(127);
			match(LBracket);
			setState(128);
			expr(0);
			setState(129);
			match(RBracket);
			setState(130);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CmmParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LineEnd() { return getToken(CmmParser.LineEnd, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			value();
			setState(133);
			match(Assign);
			setState(134);
			expr(0);
			setState(135);
			match(LineEnd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(CmmParser.Ident, 0); }
		public TerminalNode LMidBracket() { return getToken(CmmParser.LMidBracket, 0); }
		public TerminalNode IntConstant() { return getToken(CmmParser.IntConstant, 0); }
		public TerminalNode RMidBracket() { return getToken(CmmParser.RMidBracket, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(143);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(Ident);
				setState(138);
				match(LMidBracket);
				setState(139);
				match(IntConstant);
				setState(140);
				match(RMidBracket);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(Ident);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				constant();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode IntConstant() { return getToken(CmmParser.IntConstant, 0); }
		public TerminalNode RealConstant() { return getToken(CmmParser.RealConstant, 0); }
		public TerminalNode BooleanConstant() { return getToken(CmmParser.BooleanConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntConstant) | (1L << RealConstant) | (1L << BooleanConstant))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode Sign() { return getToken(CmmParser.Sign, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBracket() { return getToken(CmmParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(CmmParser.RBracket, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode Operator() { return getToken(CmmParser.Operator, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(148);
				match(Sign);
				setState(149);
				expr(3);
				}
				break;
			case 2:
				{
				setState(150);
				match(LBracket);
				setState(151);
				expr(0);
				setState(152);
				match(RBracket);
				}
				break;
			case 3:
				{
				setState(154);
				value();
				}
				break;
			case 4:
				{
				setState(155);
				constant();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(158);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(159);
					match(Operator);
					setState(160);
					expr(6);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2"+
		"\16\2#\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\6\4\62\n\4\r\4"+
		"\16\4\63\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7B\n\7\3\7"+
		"\3\7\5\7F\n\7\3\7\3\7\3\7\3\7\3\7\5\7M\n\7\3\7\3\7\5\7Q\n\7\7\7S\n\7\f"+
		"\7\16\7V\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b^\n\b\3\b\3\b\3\b\5\bc\n\b\5"+
		"\be\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0092\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u009f\n\20\3\20\3\20\3\20\7\20\u00a4\n\20\f\20\16\20\u00a7\13\20\3\20"+
		"\2\3\36\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\b\t\3\2\f\16"+
		"\u00b2\2!\3\2\2\2\4-\3\2\2\2\6/\3\2\2\2\b\67\3\2\2\2\n;\3\2\2\2\f=\3\2"+
		"\2\2\16W\3\2\2\2\20f\3\2\2\2\22n\3\2\2\2\24~\3\2\2\2\26\u0080\3\2\2\2"+
		"\30\u0086\3\2\2\2\32\u0091\3\2\2\2\34\u0093\3\2\2\2\36\u009e\3\2\2\2 "+
		"\"\5\4\3\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%.\5\b\5"+
		"\2&.\5\16\b\2\'.\5\20\t\2(.\5\22\n\2).\5\30\r\2*.\5\24\13\2+.\5\26\f\2"+
		",.\5\6\4\2-%\3\2\2\2-&\3\2\2\2-\'\3\2\2\2-(\3\2\2\2-)\3\2\2\2-*\3\2\2"+
		"\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\61\7\23\2\2\60\62\5\4\3\2\61\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\24"+
		"\2\2\66\7\3\2\2\2\678\5\n\6\289\5\f\7\29:\7\30\2\2:\t\3\2\2\2;<\t\2\2"+
		"\2<\13\3\2\2\2=A\7\13\2\2>?\7\25\2\2?@\7\f\2\2@B\7\26\2\2A>\3\2\2\2AB"+
		"\3\2\2\2BE\3\2\2\2CD\7\27\2\2DF\5\36\20\2EC\3\2\2\2EF\3\2\2\2FT\3\2\2"+
		"\2GH\7\31\2\2HL\7\13\2\2IJ\7\25\2\2JK\7\f\2\2KM\7\26\2\2LI\3\2\2\2LM\3"+
		"\2\2\2MP\3\2\2\2NO\7\27\2\2OQ\5\36\20\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2"+
		"RG\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\r\3\2\2\2VT\3\2\2\2WX\7\3\2"+
		"\2XY\7\21\2\2YZ\5\36\20\2Z]\7\22\2\2[^\5\4\3\2\\^\5\6\4\2][\3\2\2\2]\\"+
		"\3\2\2\2^d\3\2\2\2_b\7\4\2\2`c\5\4\3\2ac\5\6\4\2b`\3\2\2\2ba\3\2\2\2c"+
		"e\3\2\2\2d_\3\2\2\2de\3\2\2\2e\17\3\2\2\2fg\7\5\2\2gh\7\21\2\2hi\5\36"+
		"\20\2il\7\22\2\2jm\5\4\3\2km\5\6\4\2lj\3\2\2\2lk\3\2\2\2m\21\3\2\2\2n"+
		"o\7\n\2\2op\7\30\2\2p\23\3\2\2\2qr\7\6\2\2rs\7\21\2\2st\7\13\2\2tu\7\22"+
		"\2\2u\177\7\30\2\2vw\7\6\2\2wx\7\21\2\2xy\7\13\2\2yz\7\25\2\2z{\7\f\2"+
		"\2{|\7\26\2\2|}\7\22\2\2}\177\7\30\2\2~q\3\2\2\2~v\3\2\2\2\177\25\3\2"+
		"\2\2\u0080\u0081\7\7\2\2\u0081\u0082\7\21\2\2\u0082\u0083\5\36\20\2\u0083"+
		"\u0084\7\22\2\2\u0084\u0085\7\30\2\2\u0085\27\3\2\2\2\u0086\u0087\5\32"+
		"\16\2\u0087\u0088\7\27\2\2\u0088\u0089\5\36\20\2\u0089\u008a\7\30\2\2"+
		"\u008a\31\3\2\2\2\u008b\u008c\7\13\2\2\u008c\u008d\7\25\2\2\u008d\u008e"+
		"\7\f\2\2\u008e\u0092\7\26\2\2\u008f\u0092\7\13\2\2\u0090\u0092\5\34\17"+
		"\2\u0091\u008b\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\33"+
		"\3\2\2\2\u0093\u0094\t\3\2\2\u0094\35\3\2\2\2\u0095\u0096\b\20\1\2\u0096"+
		"\u0097\7\20\2\2\u0097\u009f\5\36\20\5\u0098\u0099\7\21\2\2\u0099\u009a"+
		"\5\36\20\2\u009a\u009b\7\22\2\2\u009b\u009f\3\2\2\2\u009c\u009f\5\32\16"+
		"\2\u009d\u009f\5\34\17\2\u009e\u0095\3\2\2\2\u009e\u0098\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a5\3\2\2\2\u00a0\u00a1\f\7"+
		"\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00a4\5\36\20\b\u00a3\u00a0\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\37\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\22#-\63AELPT]bdl~\u0091\u009e\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
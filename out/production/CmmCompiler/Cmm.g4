/**
 * grammar for cmm language
 * By 
 * 唐炯 2013302580231,
 * 张子谦 2013302580241,
 * 易晓轩 2013302580221
 */
grammar Cmm;

// ============文法定义==============================
program : (stmt)+ ; // 程序，由语句组成
stmt : var_decl | 
		if_stmt | 
		while_stmt |
		break_stmt |
		assign_stmt |
		read_stmt | 
		write_stmt | 
		stmt_block ;   //语句
stmt_block : LBigBracket (stmt)+ RBigBracket ;      //语句块
var_decl : type varlist LineEnd | type Ident Assign expr LineEnd;    //变量申明
type : Int | Real | type LMidBracket IntConstant RMidBracket ;
varlist : Ident | Ident(Comma Ident)+ ;
if_stmt : If LBracket expr RBracket (stmt | stmt_block) (Else (stmt | stmt_block))? ;
while_stmt : While LBracket expr RBracket (stmt | stmt_block) ;
break_stmt : Break LineEnd ;
read_stmt : Read LBracket Ident RBracket LineEnd |
			Read LBracket Ident LMidBracket IntConstant RMidBracket RBracket LineEnd;
write_stmt : Write LBracket expr RBracket LineEnd;
assign_stmt : value Assign expr LineEnd ;
value : Ident LMidBracket IntConstant RMidBracket | Ident | constant;
constant : IntConstant | RealConstant | BooleanConstant ;
expr : expr Operator expr |
		LBracket expr RBracket |
		Sign expr |
		value |
		constant ;

// ===========词素定义=================================
// 关键字(保留字)
If : 'if' ;
Else : 'else' ;
While : 'while' ;
Read : 'read' ;
Write : 'write' ;
Int : 'int' ;
Real : 'real' ;
Break : 'break' ;
// 标识符
Ident :  [A-z]([A-z] | '_' | [0-9])*;
// 常量
IntConstant : '0' | [1-9][0-9]*;  //带符号，base 10，暂未实现base 16
RealConstant : IntConstant('.'([0-9]+))? ; //带符号
BooleanConstant : 'true' | 'false' ;
// 操作符
Operator : '+' | '-' | '*' | '/' | '%' | '<=' | '>=' | '>' | '<' | '!=' | '==' | '<>' ;
// 正负号
Sign : '+' | '-' ;
// 括号
LBracket : '(' ;
RBracket : ')' ;
LBigBracket : '{' ;
RBigBracket : '}' ;
LMidBracket : '[' ;
RMidBracket : ']' ;
// 赋值
Assign : '=' ;
// 分号，语句结束
LineEnd : ';' ;
// 逗号，变量分隔
Comma : ',' ;
// 空格
WS : [' '\t\r\n]+ -> skip ;
// 注释
SL_COMMENT :   '//' ~[\r\n]* -> skip;
MUL_COMMENT :   '/*' .*? '*/' -> skip;
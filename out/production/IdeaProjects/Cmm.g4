/**
 * grammar for cmm language
 * By 
 * �ƾ� 2013302580231, 
 * ����ǫ 2013302580241, 
 * ������ 2013302580221
 */
grammar Cmm;

// ============�ķ�����==============================
program : stmts ; // ������������
stmts : stmt+ ;
stmt : var_decl | 
		if_stmt | 
		while_stmt |
		break_stmt |
		assign_stmt |
		read_stmt | 
		write_stmt | 
		stmt_block ;   //���
stmt_block : LBigBracket stmts RBigBracket ;      //����
var_decl : type varlist LineEnd | type Ident Assign expr LineEnd;    //��������
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

// ===========���ض���=================================
// �ؼ���(������)
If : 'if' ;
Else : 'else' ;
While : 'while' ;
Read : 'read' ;
Write : 'write' ;
Int : 'int' ;
Real : 'real' ;
Break : 'break' ;
// ��ʶ��
Ident :  [A-z]([A-z] | '_' | [0-9])*;
// ����
IntConstant : '0' | [1-9][0-9]*;  //�����ţ�base 10����δʵ��base 16
RealConstant : IntConstant('.'([0-9]+))? ; //������
BooleanConstant : 'true' | 'false' ;
// ������
Operator : '+' | '-' | '*' | '/' | '%' | '<=' | '>=' | '>' | '<' | '!=' | '==' | '<>' ;
// ������
Sign : '+' | '-' ;
// ����
LBracket : '(' ;
RBracket : ')' ;
LBigBracket : '{' ;
RBigBracket : '}' ;
LMidBracket : '[' ;
RMidBracket : ']' ;
// ��ֵ
Assign : '=' ;
// �ֺţ�������
LineEnd : ';' ;
// ���ţ������ָ�
Comma : ',' ;
// �ո�
WS : [' '\t\r\n]+ -> skip ;
// ע��
SL_COMMENT :   '//' ~[\r\n]* -> channel(HIDDEN);
MUL_COMMENT :   '/*' .*? '*/' -> channel(HIDDEN);
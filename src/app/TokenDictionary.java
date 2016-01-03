package app;

import antlr.CmmParser;

/**
 * Created by TangJiong on 2015/11/30.
 * A dictionary for translating token type
 */
public class TokenDictionary {

    public static String getTokenType(int typeCode){

        String type = null;

        switch(typeCode){
            case CmmParser.If:
            case CmmParser.Else:
            case CmmParser.While:
            case CmmParser.Read:
            case CmmParser.Write:
            case CmmParser.Int:
            case CmmParser.Real:
            case CmmParser.Break:
                type = "keyword";
                break;
            case CmmParser.Ident:
                type = "identifier";
                break;
            case CmmParser.IntConstant:
                type = "int constant";
                break;
            case CmmParser.RealConstant:
                type = "real constant";
                break;
            case CmmParser.BooleanConstant:
                type = "boolean constant";
                break;
            case CmmParser.MulDivMod:
            case CmmParser.CompOp:
            case CmmParser.AddMin:
                type = "operator";
                break;
            case CmmParser.LBracket:
            case CmmParser.RBracket:
            case CmmParser.LBigBracket:
            case CmmParser.RBigBracket:
            case CmmParser.LMidBracket:
            case CmmParser.RMidBracket:
                type = "bracket";
                break;
            case CmmParser.Assign:
                type = "assign symbol";
                break;
            case CmmParser.LineEnd:
                type = "semicolon";
                break;
            case CmmParser.Comma:
                type = "comma";
                break;
            case CmmParser.WS:
                type = "white space";
                break;
            case CmmParser.SL_COMMENT:
            case CmmParser.MUL_COMMENT:
                type = "comment";
                break;
            default:
                type = "unknown type";
                break;

        }

        return type;

    }

}

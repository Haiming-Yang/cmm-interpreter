package app;

/**
 * Created by TangJiong on 2015/11/30.
 * A dictionary for translating token type
 */
public class TokenDictionary {

    public static String getTokenType(int typeCode){

        String type = null;

        switch(typeCode){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                type = "keyword";
                break;
            case 9:
                type = "identifier";
                break;
            case 10:
                type = "int constant";
                break;
            case 11:
                type = "double constant";
                break;
            case 12:
                type = "boolean constant";
                break;
            case 13:
                type = "operator";
                break;
            case 14:
                type = "sign";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                type = "bracket";
                break;
            case 21:
                type = "assign symbol";
                break;
            case 22:
                type = "semicolon";
                break;
            case 23:
                type = "comma";
                break;
            case 24:
                type = "white space";
                break;
            case 25:
            case 26:
                type = "comment";
                break;
            default:
                type = "unknown type";
                break;

        }

        return type;

    }

}

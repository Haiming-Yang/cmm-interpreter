package app;

import antlr.CmmBaseVisitor;
import antlr.CmmParser;
import org.antlr.v4.runtime.Token;

/**
 * Created by TangJiong on 2016/1/3.
 * 运算阶段监听器
 */
public class ExprComputeVisitor extends CmmBaseVisitor<ExprReturnVal> {

    @Override
    public ExprReturnVal visitMulDivExpr(CmmParser.MulDivExprContext ctx) {
        Token op = ctx.MulDivMod().getSymbol(); // 操作符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        if(leftValue.getType() != rightValue.getType()){
            // TODO 向UI输出错误信息，类型不匹配
            if(Constant.DEBUG){
                System.out.println("ERROR: unmatched type on two side of <"
                        + op.getText()
                        + "> in line "
                        + op.getLine()
                        +":"
                        + op.getCharPositionInLine());
            }
            return null;
        }
        ExprReturnVal returnVal = new ExprReturnVal();
        if(op.getText().equals("*")){ // 乘法
            if(leftValue.getType() == Type.tInt){ // 整数乘法
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() * (Integer)rightValue.getValue());
            }else { // 小数乘法
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() * (Integer)rightValue.getValue());
            }
        }else if(op.getText().equals("/")){ // 除法
            if(leftValue.getType() == Type.tInt){ // 整数除法
                if((Integer)rightValue.getValue() == 0){
                    // TODO 向UI输出错误信息，除0错误
                    if(Constant.DEBUG){
                        System.out.println("ERROR: divide zero"
                                + " in line "
                                + op.getLine()
                                +":"
                                + op.getCharPositionInLine());
                    }
                    return null;
                }
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() * (Integer)rightValue.getValue());
            }else { // 小数除法
                returnVal.setType(Type.tReal);
                returnVal.setValue((Double)leftValue.getValue() / (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("%")){
            if(leftValue.getType() == Type.tInt){ // 整数取模
                if((Integer)rightValue.getValue() == 0){
                    // TODO 向UI输出错误信息，除0错误
                    if(Constant.DEBUG){
                        System.out.println("ERROR: divide zero"
                                + " in line "
                                + op.getLine()
                                +":"
                                + op.getCharPositionInLine());
                    }
                    return null;
                }
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() % (Integer)rightValue.getValue());
            }else { // 小数取模
                returnVal.setType(Type.tReal);
                returnVal.setValue((Double)leftValue.getValue() % (Double) rightValue.getValue());
            }
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitAddMinExpr(CmmParser.AddMinExprContext ctx) {

        Token op = ctx.AddMin().getSymbol(); // 操作符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        if(leftValue.getType() != rightValue.getType()){
            // TODO 向UI输出错误信息，类型不匹配
            if(Constant.DEBUG){
                System.out.println("ERROR: unmatched type on two side of <"
                        + op.getText()
                        + "> in line "
                        + op.getLine()
                        +":"
                        + op.getCharPositionInLine());
            }
            return null;
        }
        ExprReturnVal returnVal = new ExprReturnVal();
        if(op.getText().equals("+")){ // 加法
            if(leftValue.getType() == Type.tInt){ // 整数
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() + (Integer)rightValue.getValue());
            }else { // 小数
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() + (Integer)rightValue.getValue());
            }
        }else if(op.getText().equals("-")){ // 减法
            if(leftValue.getType() == Type.tInt){ // 整数
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() - (Integer)rightValue.getValue());
            }else { // 小数
                returnVal.setType(Type.tReal);
                returnVal.setValue((Double)leftValue.getValue() - (Double) rightValue.getValue());
            }
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitCompareExpr(CmmParser.CompareExprContext ctx) {
        Token op = ctx.CompOp().getSymbol(); // 比较符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        if(leftValue.getType() != rightValue.getType()){
            // TODO 向UI输出错误信息，类型不匹配
            if(Constant.DEBUG){
                System.out.println("ERROR: unmatched type on two side of <"
                        + op.getText()
                        + "> in line "
                        + op.getLine()
                        +":"
                        + op.getCharPositionInLine());
            }
            return null;
        }
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setType(Type.tBool);
        if(op.getText().equals(">")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() > (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() > (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() < (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() < (Double) rightValue.getValue());
            }
        }else if(op.getText().equals(">=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() >= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() >= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() <= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() <= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("!=") || op.getText().equals("<>")){
            returnVal.setValue(leftValue.getValue() != rightValue.getValue());
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitParenthesesExpr(CmmParser.ParenthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ExprReturnVal visitValueExpr(CmmParser.ValueExprContext ctx) {

        if(ctx.value().constant() != null){ // 直接是字面值的运算
            if(ctx.value().constant().IntConstant() != null){
                return new ExprReturnVal(Type.tInt,
                        Integer.valueOf(ctx.value().constant().IntConstant().getText()));
            }else{
                return new ExprReturnVal(Type.tReal,
                        Double.valueOf(ctx.value().constant().RealConstant().getText()));
            }
        }else{ // TODO: 表达式里包含变量的情况
            return null;
        }

    }

    @Override
    public ExprReturnVal visitSignExpr(CmmParser.SignExprContext ctx) {
        String sign = ctx.AddMin().getSymbol().getText();
        if(sign.equals("+")){
            return visit(ctx.expr());
        }else{
            ExprReturnVal value = visit(ctx.expr());
            if(value.getType() == Type.tInt){
                return new ExprReturnVal(value.getType(), -(Integer)value.getValue());
            }else{
                return new ExprReturnVal(value.getType(), -(Double)value.getValue());
            }

        }
    }
}

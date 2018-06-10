package org.mackenzine.calculator;

import org.mackenzine.interpreter.*;

public class BinaryExpressionFactory {

    public static Expression<Double> getExpression(Expression<Double> leftOperand, String line, Expression<Double> rightOperand) {
        switch (line) {
            case "+":
                return new Plus(leftOperand, rightOperand);
            case "-":
                return new Minus(leftOperand, rightOperand);
            case "*":
                return new Multiply(leftOperand, rightOperand);
            case "/":
                return new Divide(leftOperand, rightOperand);
            default:
                throw new RuntimeException("Unable to build expression");
        }
    }
}

package org.mackenzine.interpreter;

public class UnaryExpression implements Expression {

    private final String expression;

    public UnaryExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Double interpret() {
        return Double.valueOf(expression);
    }
}

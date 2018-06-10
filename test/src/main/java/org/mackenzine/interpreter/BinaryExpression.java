package org.mackenzine.interpreter;

public abstract class BinaryExpression<T> implements Expression<T> {
    protected final Expression<T> leftOperand;
    protected final Expression<T> rightOperand;

    public BinaryExpression(final Expression leftOperand, final Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public abstract T interpret();
}

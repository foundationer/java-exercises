package org.mackenzine.interpreter;

public class Divide extends BinaryExpression<Double> {

    public Divide(final Expression<Double> leftOperand, final Expression<Double> rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double interpret() {
        return leftOperand.interpret() / rightOperand.interpret();
    }
}

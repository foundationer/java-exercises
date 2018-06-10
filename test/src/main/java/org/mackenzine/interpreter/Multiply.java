package org.mackenzine.interpreter;

public class Multiply extends BinaryExpression<Double> {

    public Multiply(final Expression<Double> leftOperand, final Expression<Double> rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double interpret() {
        return leftOperand.interpret() * rightOperand.interpret();
    }
}

package org.mackenzine.interpreter;

public class Minus extends BinaryExpression<Double> {

    public Minus(final Expression<Double> leftOperand, final Expression<Double> rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}

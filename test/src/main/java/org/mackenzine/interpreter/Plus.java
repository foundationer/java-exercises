package org.mackenzine.interpreter;

public class Plus extends BinaryExpression<Double> {

    public Plus(final Expression leftOperand, final Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Double interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}

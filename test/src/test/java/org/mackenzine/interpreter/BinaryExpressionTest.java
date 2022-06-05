package org.mackenzine.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryExpressionTest {

    private BinaryExpression<Double> expression;
    private UnaryExpression leftOperand;
    private UnaryExpression rightOperand;

    @BeforeEach
    public void setUp() {
        leftOperand = new UnaryExpression("6");
        rightOperand = new UnaryExpression("5");
    }

    @Test
    public void plus() {
        expression = new Plus(leftOperand, rightOperand);

        assertThat(expression.interpret(), is(equalTo(11.0)));
    }

    @Test
    public void minus() {
        expression = new Minus(leftOperand, rightOperand);

        assertThat(expression.interpret(), is(equalTo(1.0)));
    }

    @Test
    public void multiply() {
        expression = new Multiply(leftOperand, rightOperand);

        assertThat(expression.interpret(), is(equalTo(30.0)));
    }

    @Test
    public void divide() {
        expression = new Divide(leftOperand, rightOperand);

        assertThat(expression.interpret(), is(equalTo(1.2)));
    }
}

package org.mackenzine.calculator;

import org.mackenzine.collections.Pile;
import org.mackenzine.interpreter.Expression;
import org.mackenzine.interpreter.UnaryExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.mackenzine.calculator.BinaryExpressionFactory.getExpression;

public class Launcher {

    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("[-+]?\\d*\\.?\\d+");
    private static final Pattern OPERATION_PATTERN = Pattern.compile("\\+|\\-|\\*|\\/");

    public static void main(String[] args) {
        Pile<Expression<Double>> stack = new Pile();
        String line;

        LOG.info("Enter expression...");

        Scanner scanner = new Scanner(System.in);

        do {
            line = scanner.nextLine();
            if (NUMERIC_PATTERN.matcher(line).matches()) {
                UnaryExpression unaryExpression = new UnaryExpression(line);
                stack.push(unaryExpression);
                LOG.info("Entered unary expression: " + unaryExpression.interpret());
            } else if (OPERATION_PATTERN.matcher(line).matches()) {
                Optional<Expression<Double>> leftOperand = stack.pop();
                Optional<Expression<Double>> rightOperand = stack.pop();
                if(leftOperand.isPresent() && rightOperand.isPresent()) {
                    Expression<Double> binaryExpression = getExpression(leftOperand.get(), line, rightOperand.get());
                    stack.push(binaryExpression);
                    LOG.info("Evaluating binary expression :" + binaryExpression.interpret());
                } else {
                    LOG.error("Attempted to create binary operation without enough operands");
                }
            } else if ("exit".equals(line)) {
                System.exit(0);
            } else {
                LOG.error("Unable to parse command");
            }
        } while (true);
    }
}

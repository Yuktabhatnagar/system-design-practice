package com.yukta.systemdesign.lld.designpatterns.behavioural.interpreter;

public class InterpreterDemo {

    // Expression Interface
    interface Expression {
        int interpret();
    }

    // Terminal Expression (Number)
    static class NumberExpression implements Expression {

        private int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        @Override
        public int interpret() {
            return number;
        }
    }

    // Non-Terminal Expression (Multiplication)
    static class MultiplyExpression implements Expression {

        private Expression left;
        private Expression right;

        public MultiplyExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() * right.interpret();
        }
    }

    // Non-Terminal Expression (Addition)
    static class AddExpression implements Expression {

        private Expression left;
        private Expression right;

        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() + right.interpret();
        }
    }

    public static void main(String[] args) {

        // Values
        Expression a = new NumberExpression(2);
        Expression b = new NumberExpression(3);

        Expression c = new NumberExpression(4);
        Expression d = new NumberExpression(5);

        // (a * b)
        Expression ab =
                new MultiplyExpression(a, b);

        // (c * d)
        Expression cd =
                new MultiplyExpression(c, d);

        // ((a*b) + (c*d))
        Expression finalExpression =
                new AddExpression(ab, cd);

        int result = finalExpression.interpret();

        System.out.println("Result: " + result);
    }
}

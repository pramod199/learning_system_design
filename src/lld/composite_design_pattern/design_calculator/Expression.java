package lld.composite_design_pattern.design_calculator;

public class Expression implements ArithmeticExpression {
    ArithmeticExpression left;
    ArithmeticExpression right;
    Operator operator;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        int value = 0;
        switch (operator) {
            case ADD:
                value = left.evaluate() + right.evaluate();
                break;
            case SUBTRACT:
                value = left.evaluate() - right.evaluate();
                break;
            case MULTIPLY:
                value = left.evaluate() * right.evaluate();
                break;
            case DIVIDE:
                value = left.evaluate() / right.evaluate();
                break;
        }
        System.out.println("Expression value is : " + value);
        return value;
    }
}

package lld.composite_design_pattern.design_calculator;

public class Main {
    public static void main(String[] args) {
        //2*(1+7)

       /*

                         *
                       /   \
                     2      +
                           / \
                          1   7

        */

        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        Expression addExpression = new Expression(one, seven, Operator.ADD);
        Expression multiplyExpression = new Expression(two, addExpression, Operator.MULTIPLY);

        System.out.println(multiplyExpression.evaluate());
    }
}

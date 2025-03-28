package lld.composite_design_pattern.design_calculator;

public class Number implements ArithmeticExpression {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        System.out.println("Number value is : " + value);
        return value;
    }
}

package lld.interpreter_design_pattern;

public class Client {
    public static void main(String[] args) {
        // initialize context
        Context context = new Context();
        context.put("a", 10);
        context.put("b", 20);

        // a*b
        AbstractExpression expression = new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("a"),
                new NumberTerminalExpression("b")
        );

        int res = expression.interpret(context);
        System.out.println(res);
    }
}

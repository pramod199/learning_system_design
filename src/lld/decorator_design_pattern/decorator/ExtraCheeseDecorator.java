package lld.decorator_design_pattern.decorator;

import lld.decorator_design_pattern.BasePizza;
import lld.decorator_design_pattern.decorator.ToppingDecorator;

public class ExtraCheeseDecorator extends ToppingDecorator {

    public ExtraCheeseDecorator(BasePizza bp) {
        super(bp);
    }

    @Override
    public int cost() {
//        return super.basePizza.cost() + 10;
        return super.getBasePizza().cost() + 10;
    }
}

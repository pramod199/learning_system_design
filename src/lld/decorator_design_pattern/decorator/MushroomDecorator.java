package lld.decorator_design_pattern.decorator;

import lld.decorator_design_pattern.BasePizza;

public class MushroomDecorator extends ToppingDecorator {
    public MushroomDecorator(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return super.basePizza.cost() + 20;
    }
}

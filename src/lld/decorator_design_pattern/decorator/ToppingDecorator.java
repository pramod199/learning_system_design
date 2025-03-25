package lld.decorator_design_pattern.decorator;

import lld.decorator_design_pattern.BasePizza;

public abstract class ToppingDecorator extends BasePizza { // inheritance

    BasePizza basePizza;

    public ToppingDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    public BasePizza getBasePizza() {
        return basePizza;
    }
}

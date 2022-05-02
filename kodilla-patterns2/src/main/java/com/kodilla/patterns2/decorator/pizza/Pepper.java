package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Pepper extends AbstractPizzaDecorator {
    public Pepper(PizzaOrder pizza) {
        super(pizza);
    }
    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", pepper";
    }
}
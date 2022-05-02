package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza ingredients: bottom, cheese, tomato sauce", description);
    }

    @Test
    public void testPineappleAndHamPizzaOrderGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new Ham(pizzaOrder);
        pizzaOrder = new Pineapple(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(24), cost);
    }

    @Test
    public void testPineappleAndHamPizzaOrderGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new Pineapple(pizzaOrder);
        pizzaOrder = new Ham(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza ingredients: bottom, cheese, tomato sauce, pineapple, ham", description);
    }

    @Test
    public void testSalamiCornPepperCherryTomatoesPizzaOrderGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new Salami(pizzaOrder);
        pizzaOrder = new Corn(pizzaOrder);
        pizzaOrder = new Pepper(pizzaOrder);
        pizzaOrder = new CherryTomatoes(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(32), cost);
    }

    @Test
    public void testSalamiCornPepperCherryTomatoesPizzaOrderGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new Salami(pizzaOrder);
        pizzaOrder = new Corn(pizzaOrder);
        pizzaOrder = new Pepper(pizzaOrder);
        pizzaOrder = new CherryTomatoes(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza ingredients: bottom, cheese, tomato sauce, salami, corn, pepper, cherry tomatoes", description);
    }
}
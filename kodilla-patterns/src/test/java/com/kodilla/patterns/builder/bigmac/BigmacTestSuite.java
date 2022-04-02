package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("bun with sesame seeds")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("tomato")
                .ingredient("cheese")
                .ingredient("lettuce")
                .ingredient("cucumber")
                .build();

        //When
        int amountOfIngredients = bigmac.getIngredients().size();
        String sauce = bigmac.getSauce();

        //Then
        Assertions.assertEquals(4, amountOfIngredients);
        Assertions.assertEquals("barbecue", sauce);
    }
}
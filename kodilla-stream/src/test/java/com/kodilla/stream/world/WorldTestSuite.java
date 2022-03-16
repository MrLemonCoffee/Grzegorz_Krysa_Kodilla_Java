package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testPeopleQuantity() {
        //Given
        World world = new World();
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();
        Continent continent4 = new Continent();
        Continent continent5 = new Continent();

        //When
        continent1.addCountry(new Country("Poland", new BigDecimal("34535670999")));
        continent1.addCountry(new Country("Canada", new BigDecimal("5896410999")));
        continent2.addCountry(new Country("Russia", new BigDecimal("12345667")));
        continent3.addCountry(new Country("Africa", new BigDecimal("7231314")));
        continent3.addCountry(new Country("America", new BigDecimal("1246735125")));
        continent4.addCountry(new Country("Germany", new BigDecimal("423467321")));
        continent5.addCountry(new Country("Korea", new BigDecimal("58911643")));
        continent5.addCountry((new Country("Ukraine", new BigDecimal("123126163"))));

        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        world.addContinent(continent5);

        BigDecimal quantity = world.getPeopleQuantity();
        BigDecimal expectedQuantity = new BigDecimal("42303899231");

        //Then
        Assertions.assertEquals(expectedQuantity, quantity);
    }

    @Test
    void testPeopleQuantityNoCountries() {
        //Given
        World world = new World();
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();
        Continent continent4 = new Continent();
        Continent continent5 = new Continent();

        //When
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        world.addContinent(continent5);

        BigDecimal quantity = world.getPeopleQuantity();
        BigDecimal expectedQuantity = new BigDecimal("0");

        //Then
        Assertions.assertEquals(expectedQuantity, quantity);
    }
}
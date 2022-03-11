package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }
    @DisplayName("Does empty list work?")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //when
        List<Integer> evenList = exterminator.exterminate(numbers);
        //then
        assertEquals(numbers.isEmpty(), evenList.isEmpty());
    }
    @Test
    @DisplayName("Does list work with even and odd numbers?")
    void testOddNumbersExterminatorNormalList() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(4);
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //when
        List<Integer> evenList = exterminator.exterminate(numbers);
        //then
        assertEquals(expectedResult, evenList);
    }
}

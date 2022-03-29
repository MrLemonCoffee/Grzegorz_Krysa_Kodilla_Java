package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {

    @Test
    public void testAdd() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        System.out.println("Testing 8 + 2");
        calculator.add(8, 2);

        // Then
        // do nothing

    }

    @Test
    public void testSub() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        System.out.println("Testing 5.5 - 6.5");
        calculator.sub(5.5, 6.5);

        // Then
        // do nothing
    }

    @Test
    public void testMul() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        System.out.println("Testing 11 * 12");
        calculator.mul(11, 12);

        // Then
        // do nothing
    }

    @Test
    public void testDiv() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        System.out.println("Testing 12 / 4");
        calculator.div(12, 4);

        // Then
        // do nothing
    }
}
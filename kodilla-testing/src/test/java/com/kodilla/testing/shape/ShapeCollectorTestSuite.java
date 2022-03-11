package com.kodilla.testing.shape;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Tests ended");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(5, 10);
        // When
        shapeCollector.addFigure(triangle);
        // Then
        Shape result = shapeCollector.getFigure(0);
        Assert.assertEquals(triangle, result);
    }

    @Test
    public void testRemoveFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(5, 10);
        Shape circle = new Circle(9);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        // When
        shapeCollector.removeFigure(triangle);
        // Then
        Shape result = shapeCollector.getFigure(0);
        Assert.assertEquals(circle, result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        shapeCollector.addFigure(square);

        //When
        Shape retrievedShape = shapeCollector.getFigure(0);

        // Then
        Assert.assertEquals(square, retrievedShape);

    }
    @Test
    public void testShowFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5.0);
        Shape circle = new Circle(3.0);
        Shape triangle = new Triangle(4.0, 5.0);

        //Then
        String squareName = square.getShapeName();
        String circleName = circle.getShapeName();
        String triangleName = triangle.getShapeName();

        //When
        Assert.assertEquals("square", squareName);
        Assert.assertEquals("circle", circleName);
        Assert.assertEquals("triangle", triangleName);

    }
}

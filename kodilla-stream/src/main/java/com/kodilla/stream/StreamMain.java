package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text!"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator:: subBFromA);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("orange", String::toUpperCase);
        poemBeautifier.beautify("ORANGE", (text) -> text.toLowerCase());
        poemBeautifier.beautify("orange", (text) -> "big " + text);
        poemBeautifier.beautify("orange", (text) -> text.substring(0, 4));
        poemBeautifier.beautify("orange", (text) -> text.replace("a","A"));

    }
}
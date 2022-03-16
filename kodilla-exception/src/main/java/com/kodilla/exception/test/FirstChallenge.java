package com.kodilla.exception.test;

public class FirstChallenge {
    private static double result;
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            result = firstChallenge.divide(5, 0);
        } catch (ArithmeticException a) {
            System.out.println("Error - u tried to divide by 0: " + a);
        } finally {
            System.out.println("Division result(not correct if second value is 0) = " + result);
        }
    }
}
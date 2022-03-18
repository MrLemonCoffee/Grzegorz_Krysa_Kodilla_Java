package com.kodilla.good.patterns.food2door;

public class OrderRunner {
    public static void main(String[] args) {

        Order order1 = new Order("cucumber", 5, 555479);
        Order order2 = new Order("fish", 3,569031);
        Order order3 = new Order("apple", 4,127893); // available apples = 3

        SupplierRetriever supplierRetriever = new SupplierRetriever();
        supplierRetriever.process(order1);
        supplierRetriever.process(order2);
        supplierRetriever.process(order3);
    }
}
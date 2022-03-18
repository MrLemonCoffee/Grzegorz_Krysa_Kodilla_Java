package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderProcessorRunner {
    public static void main(String[] args) {

        InformationService informationService = new OrderInformationService();
        OrderService orderService = new ProductOrderService();
        OrderProcessor orderProcessor = new OrderProcessor(informationService, orderService);
        orderProcessor.process(new User("Grzegorz", "Krysa"), "guitar", 1, LocalDate.now(), true);
    }
}
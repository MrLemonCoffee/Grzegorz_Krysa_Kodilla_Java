package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Supplier {

    private final String name;
    private final Map<String, Integer> depotOfHealthyShop = new HashMap<>();

    public HealthyShop() {
        this.name = "Healthy Shop";
        putProductsInMap();
    }

    private void putProductsInMap() {
        depotOfHealthyShop.put("tomato", 1000);
        depotOfHealthyShop.put("cucumber", 4000);
        depotOfHealthyShop.put("radish", 4200);
    }

    private void updateDepotStatus(String product, Integer quantityOfProducts) {
        Integer depotStatus = depotOfHealthyShop.get(product) - quantityOfProducts;
        depotOfHealthyShop.put(product, depotStatus);
    }

    public String getName() {
        return name;
    }

    public void process(Order order) {
        if(depotOfHealthyShop.containsKey(order.getTypeOfProduct()) && depotOfHealthyShop.get(order.getTypeOfProduct()) >= order.getQuantity()) {
            updateDepotStatus(order.getTypeOfProduct(), order.getQuantity());
            System.out.println("Your order number is: " + order.getOrderNumber());
            System.out.println("You ordered " + order.getTypeOfProduct() + " in quantity " + order.getQuantity());
            System.out.println("The order has been transferred for execution");
            System.out.println("Thank you for using the services \"Healthy Shop\"");
        }else {
            System.out.println("The selected product is not available.");
        }
    }
}

package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class SupplierRetriever {

    private Map<String,Supplier> suppliers = new HashMap<>();

    public SupplierRetriever(){
        fillMap();
    }

    private void fillMap(){
        Supplier extraFoodShop = new ExtraFoodShop();
        Supplier glutenFreeShop = new GlutenFreeShop();
        Supplier healthyShop = new HealthyShop();
        suppliers.put("salmon", extraFoodShop);
        suppliers.put("prawn", extraFoodShop);
        suppliers.put("caviar", extraFoodShop);
        suppliers.put("cucumber", healthyShop);
        suppliers.put("tomato", healthyShop);
        suppliers.put("radish", healthyShop);
        suppliers.put("apple", glutenFreeShop);
        suppliers.put("pear", glutenFreeShop);
        suppliers.put("banana", glutenFreeShop);
    }

    public void process(Order order){
        if(suppliers.containsKey(order.getTypeOfProduct())){
            suppliers.get(order.getTypeOfProduct()).process(order);
        }else{
            System.out.println("Your order has not been fulfilled");
        }
    }
}
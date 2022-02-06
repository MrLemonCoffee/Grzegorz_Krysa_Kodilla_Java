package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        System.out.println("\n -------Test 6.2------- \n");
                Calculator calculator = new Calculator ();

                 int addResult = calculator.add(1,2);

                 int substractResult = calculator.subtract(1,2);
                //test1
                if (addResult==3){
                    System.out.println("Test 6.2.1 addResult is OK");
                } else {
                    System.out.println("Test 6.2.1 addResult ERROR");
                }
                //test2
                if (substractResult==-1){
                    System.out.print("Test 6.2.2 substractResult is OK");
                } else {
                    System.out.print("Test 6.2.2 substractResult ERROR");
                }




    }
}

package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (Integer currentNumber : numbers) {
            if(currentNumber % 2 == 0) {
                evenList.add(currentNumber);
            }
        }
        return evenList;
    }
}

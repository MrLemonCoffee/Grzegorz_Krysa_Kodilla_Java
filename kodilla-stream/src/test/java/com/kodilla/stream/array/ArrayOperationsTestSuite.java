package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        // Given
        int[] numbers = new int[15];
        numbers[0] = 12;
        numbers[1] = 11;
        numbers[2] = 34;
        numbers[3] = 12;
        numbers[4] = 45;
        numbers[5] = 21;
        numbers[6] = 89;
        numbers[7] = 34;
        numbers[8] = 56;
        numbers[9] = 67;
        numbers[10] = 89;
        numbers[11] = 594;
        numbers[12] = 23;
        numbers[13] = 27;
        numbers[14] = 71;

        // When
        double avg = ArrayOperations.getAverage(numbers);
        // Then
        Assert.assertEquals(79.0, avg, 0.001);

    }
}
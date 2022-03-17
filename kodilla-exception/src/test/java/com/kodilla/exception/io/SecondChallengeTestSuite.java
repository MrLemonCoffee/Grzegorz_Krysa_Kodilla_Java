package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        // Given
        SecondChallenge challenge = new SecondChallenge();

        // When & Then
        assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1, 1.3));
    }

    @Test
    void testIWillThrowException() {
        // Given
        SecondChallenge challenge = new SecondChallenge();

        // When & Then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2, 1.5));
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1, 1.5));
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(5, 8.8));
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0, 8.8));
    }
}
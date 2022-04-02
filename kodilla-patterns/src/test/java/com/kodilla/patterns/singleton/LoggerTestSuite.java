package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void createLog(){
        logger = Logger.INSTANCE;
        logger.log("last log");
    }

    @Test
    void testGetLastLog(){
        //When
        String lastLog = logger.getLastLog();

        //Then
        Assertions.assertEquals("last log", lastLog);
    }
}
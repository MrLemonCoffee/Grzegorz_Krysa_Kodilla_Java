package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowStatisticsTestSuite {
    private static  int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is beginning of all tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("\nPreparing to execute test No. " + testCounter);
    }

    @Test
    public void testStatisticsNoPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        usersList.add("Grzegorz Krysa");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(0, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerPost(), 0);
    }
    @Test
    public void testStatistics1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        usersList.add("Grzegorz Krysa");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1500);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(1000, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(1500, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(1.5, calculateStatistics.getCommentsPerPost(), 0);
    }

    @Test
    public void testStatisticsNoComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        usersList.add("Grzegorz Krysa");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        CalculateStatistics calculateStatistics = new CalculateStatistics();


        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(1000, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerPost(), 0);
    }

    @Test
    public void testStatisticsCommentsLessThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        usersList.add("Grzegorz Krysa");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(100, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(50, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(0.5, calculateStatistics.getCommentsPerPost(), 0);
    }

    @Test
    public void testStatisticsCommentsMoreThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        usersList.add("Grzegorz Krysa");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        CalculateStatistics calculateStatistics = new CalculateStatistics();


        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(50, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(100, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(2, calculateStatistics.getCommentsPerPost(), 0);
    }

    @Test
    public void testStatisticsNoUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(50);

        CalculateStatistics calculateStatistics = new CalculateStatistics();


        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(0, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerPost(), 0);
    }

    @Test
    public void testStatistics100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new  ArrayList<>();
        for (int i=0; i<100;i++) {
            usersList.add(Integer.toString(i));
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();

        //Then
        Assert.assertEquals(1, calculateStatistics.getPostsPerUser(),0);
        Assert.assertEquals(0.5, calculateStatistics.getCommentsPerUser(),0);
        Assert.assertEquals(0.5, calculateStatistics.getCommentsPerPost(), 0);
    }
}
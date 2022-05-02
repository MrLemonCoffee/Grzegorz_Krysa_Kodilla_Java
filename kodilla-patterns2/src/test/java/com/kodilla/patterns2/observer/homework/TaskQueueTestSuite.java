package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void RegisterMentorTest(){
        //Given
        TasksQueue tasksQueue1 = new TasksQueue("Ilona Marzec");
        TasksQueue tasksQueue2 = new TasksQueue("Rafał Romanowicz");
        TasksQueue tasksQueue3 = new TasksQueue("Marcin Sowa");

        TaskObserver SebastianAdamiak = new Mentor("Sebastian Adamiak");
        TaskObserver PiotrMatejek = new Mentor("Piotr Matejek");

        //When
        tasksQueue1.registerMentor(SebastianAdamiak, tasksQueue1);
        tasksQueue2.registerMentor(SebastianAdamiak, tasksQueue2);
        tasksQueue3.registerMentor(PiotrMatejek, tasksQueue3);

        //Then
        assertEquals(2, SebastianAdamiak.countQueues());
        assertEquals(1, PiotrMatejek.countQueues());
    }

}
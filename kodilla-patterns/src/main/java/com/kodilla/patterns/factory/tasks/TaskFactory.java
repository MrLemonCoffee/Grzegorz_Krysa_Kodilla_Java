package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

import java.util.HashMap;
import java.util.Map;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String DRIVING_TASK = "DRIVING TASK";
    private final Map<Task, Boolean> tasks = new HashMap<>();

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("SHOPPING TASK", "milk", 1);
            case PAINTING_TASK:
                return new PaintingTask("PAINTING TASK", "blue", "sky");
            case DRIVING_TASK:
                return new DrivingTask("DRIVING TASK", "Croatia", "aeroplane");
            default:
                return null;
        }
    }

    public Map<Task, Boolean> putTaskInMap(Task task) {
        task.executeTask();
        Boolean isExecuted = task.isTaskExecuted();
        tasks.put(task, isExecuted);
        return tasks;
    }
}

package com.devops.ToDoList;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest1 {
    @Test
    public void testTaskCreation() {
        Task task = new Task("Write documentation");
        assertEquals("Write documentation", task.getTitle());
    }
}


package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    DbService dbService;

    @Test
    public void testGetAllTask() {
        //Given
        List<Task> tasks;

        //When
        tasks = dbService.getAllTasks();

        //Then
        assertEquals(4, tasks.size());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task("test", "testing");

        //When
        dbService.saveTask(task);

        //Then
        assertEquals(5, dbService.getAllTasks().size());

        //CleanUp
        dbService.deleteTask(task.getId());
        assertEquals(4, dbService.getAllTasks().size());
    }

    @Test
    public void testGetOneTask() {
        //Given
        Task task = new Task("test", "testing");
        dbService.saveTask(task);

        //When
        Optional<Task> tasks = dbService.getTask(task.getId());

        //Then
        assertEquals(true, tasks.isPresent());

        //CleanUp
        dbService.deleteTask(task.getId());
    }
}

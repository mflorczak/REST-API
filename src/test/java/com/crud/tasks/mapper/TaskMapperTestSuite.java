package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto  taskDto = new TaskDto(1L, "test", "testing");

        //When
        Task task = taskMapper.mapToTask(taskDto);
        boolean result = false;
        if(task.getId() == 1L && task.getTitle().equals("test") && task.getContent().equals("testing")) {
            result = true;
        }

        //Then
        assertTrue(result);
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task  task = new Task(1L, "test", "testing");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        boolean result = false;
        if(taskDto.getId() == 1L && taskDto.getTitle().equals("test") && taskDto.getContent().equals("testing")) {
            result = true;
        }

        //Then
        assertTrue(result);
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task  task = new Task(1L, "test", "testing");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);
        boolean result = false;
        if(taskDtos.get(0).getId() == 1L && taskDtos.get(0).getTitle().equals(task.getTitle()) &&
                taskDtos.get(0).getContent().equals(task.getContent())) {
            result = true;
        }

        //Then
        assertTrue(result);
        assertEquals(1, taskDtos.size());
    }
}

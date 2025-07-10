package com.example.TaskManager.controller;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task, Authentication auth) {
        return service.addTask(task, auth.getName());
    }

    @GetMapping
    public List<Task> getAllTasks(Authentication auth) {
        return service.getAllTasks(auth.getName());
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task, Authentication auth) {
        return service.updateTask(id, task, auth.getName());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id, Authentication auth) {
        return service.deleteTask(id, auth.getName());
    }
}

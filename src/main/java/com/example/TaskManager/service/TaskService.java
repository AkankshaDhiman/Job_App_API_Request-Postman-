package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.User;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepo userRepo;

    public Task addTask(Task task, String username) {
        User user = userRepo.findByUsername(username);
        task.setUser(user);
        return taskRepo.save(task);
    }

    public List<Task> getAllTasks(String username) {
        User user = userRepo.findByUsername(username);
        return taskRepo.findByUser(user);
    }

    public Task updateTask(int id, Task updatedTask, String username) {
        Task existing = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        if (!existing.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Unauthorized");
        }
        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setPriority(updatedTask.getPriority());
        return taskRepo.save(existing);
    }

    public String deleteTask(int id, String username) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        if (!task.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Unauthorized");
        }
        taskRepo.delete(task);
        return "Deleted";
    }
}

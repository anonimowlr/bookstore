/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service;

import com.jocimar.bookstore.domain.Task;
import com.jocimar.bookstore.repositories.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */
@Service
public class TaskService {
    
    
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        
          return  taskRepository.findAll();

    }

    public Task createdTask(Task task) {
       return taskRepository.save(task);
    }
    
    
    
    
    
    
    
}

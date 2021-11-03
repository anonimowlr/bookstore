/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources;

import com.jocimar.bookstore.domain.Task;
import com.jocimar.bookstore.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F5078775
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value="tasks")
public class TaskResource {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.findAll(); 
        
        return ResponseEntity.ok().body(tasks);
        
    }
    
    @PostMapping
    public ResponseEntity<Task> criarCategoria(@RequestBody Task task){
        
        task = taskService.createdTask(task);
        return ResponseEntity.ok().body(task);
        
    }
    
    
}

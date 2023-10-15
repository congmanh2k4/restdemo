/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RestDemoLoda.restcontroller;

import com.example.RestDemoLoda.model.Todo;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manhnche
 */
@RestController
@RequestMapping("api/v1")
public class WebController {
    private List<Todo> todoList = new CopyOnWriteArrayList<>();
    @PostConstruct
    public void init(){
        todoList = IntStream.range(0,10)
                .mapToObj(i->new Todo("Title_" + i , "Detail_" + i))
                .collect(Collectors.toList());
    }
    @GetMapping("/todo")
    public List<Todo> getTodoList(){
        return todoList;
    }
    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name="todoId") Integer todoId){
        return todoList.get(todoId);
    }
    
    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name="todoId") Integer todoId, @RequestBody Todo todo){
        todoList.set(todoId, todo);
        return todo;
    }
    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name="todoId") Integer todoId){
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo){
        todoList.add(todo);
        return ResponseEntity.ok().body(todo);
    }
    
}

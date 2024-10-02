package com.example.todo.controller;


import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class TodoController {


    @Autowired
    TodoService todoService;

    @GetMapping("/getAll")
    public List<Todo> getAll() { return todoService.getAll(); }

    @PostMapping("/create")
    public ResponseEntity<List<Todo>> createTodo(@RequestBody List<Todo> todo) {


        return ResponseEntity.status(HttpStatus.CREATED).body( todoService.addTodo(todo));
    }

    @GetMapping("/getTodo/{id}")
    public ResponseEntity<?> getTodo(@PathVariable("id") int id) {
        Optional<Todo> todo = todoService.getTodo(id);
        if (todo.isPresent())
        {
            return ResponseEntity.ok(todo.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id,
                           @RequestBody Todo updatedTodo) {

        return ResponseEntity.ok(todoService.updateTodo(id, updatedTodo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int id) {
        Boolean response = todoService.removeTodo(id);
        if(response)
        {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/filter/{priority}")
    public List<Todo> filterTodo(@PathVariable("priority") String priority)
    {

        return todoService.getFilterTodos(priority);
    }


}

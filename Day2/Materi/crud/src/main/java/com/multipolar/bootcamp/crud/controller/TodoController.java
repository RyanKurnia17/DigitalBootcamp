package com.multipolar.bootcamp.crud.controller;

import com.multipolar.bootcamp.crud.domain.Todo;
import com.multipolar.bootcamp.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@Validated
public class TodoController {

    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    //Mengepost atau menambahkan data ke database
    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo){
        return todoService.createOrUpdateTodo(todo);
    }
    //mengambil data dari database
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    //get todo by id lewat pathvariabel/segment
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id){
        Optional<Todo> todo = todoService.getTodoByID(id);
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //edit todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todo){
        todo.setId(id);
        return  todoService.createOrUpdateTodo(todo);
    }

    //menghapus data pada database
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id){
        todoService.deleteTodoById(id);
        return ResponseEntity.notFound().build();
    }


}

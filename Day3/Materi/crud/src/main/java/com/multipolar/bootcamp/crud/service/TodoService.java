package com.multipolar.bootcamp.crud.service;

import com.multipolar.bootcamp.crud.domain.Todo;
import com.multipolar.bootcamp.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//untuk mengidentifikasi class ini merupakan service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired//
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //fungsi untuk get all todos
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    //fungsi untuk get todo by id
    public Optional<Todo> getTodoByID(String id){
        return todoRepository.findById(id);
    }

    //fungsi untuk create todo baru
    public Todo createOrUpdateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //fungsi untuk delete todo
    public void deleteTodoById(String id){
        todoRepository.deleteById(id);
    }

    //find by task
    public Optional<Todo> getTodoByTask(String task){
        return todoRepository.findByTaskInCaseSensitive(task);
    }
}
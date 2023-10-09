package com.multipolar.bootcamp.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    //http://localhost:8080/api/hello
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }
    //Menggunakan param
    //http://localhost:8080/api/name?yourName=Ryan
    @GetMapping("/name")
    public  ResponseEntity<String> helloName(@RequestParam String yourName){
        return  ResponseEntity.ok("Hello " + yourName);
    }
    //menggunakan pathvariable
    //http://localhost:8080/api/name/Ryan
    @GetMapping("/name/{yourName}")
    public  ResponseEntity<String> helloNameSegment(@PathVariable String yourName){
        return ResponseEntity.ok("Hello " + yourName);
    }
    //http://localhost:8080/api/todos
    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> toDos(){
        List<ToDo> todoList = List.of(
                new ToDo(1,"Learning"),
                new ToDo(2,"Coding"),
                new ToDo(3,"Monetizing"));
        return ResponseEntity.ok(todoList);
    }

}

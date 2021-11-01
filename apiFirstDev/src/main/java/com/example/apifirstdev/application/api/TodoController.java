package com.example.apifirstdev.application.api;

import com.example.apifirstdev.application.dto.TodoRequest;
import com.example.apifirstdev.application.dto.TodoResponce;
import com.example.apifirstdev.application.service.TodoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public ResponseEntity<List<TodoResponce>> getTodo() {
    List<TodoResponce> todoResponces = todoService.getTodos();
    return ResponseEntity.ok(todoResponces);
  }

  @PostMapping
  public ResponseEntity<TodoResponce> saveTodo(@RequestBody TodoRequest request) {
    TodoResponce todoResponce = todoService.saveTodo(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(todoResponce);
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }
}

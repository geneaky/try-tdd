package com.example.apifirstdev.application.service;

import com.example.apifirstdev.application.dto.TodoRequest;
import com.example.apifirstdev.application.dto.TodoResponce;
import java.util.List;

public interface TodoService {

  List<TodoResponce> getTodos();

  TodoResponce saveTodo(TodoRequest request);

  void deleteTodo(Long id);
}

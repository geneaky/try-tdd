package com.example.apifirstdev.application.service;

import com.example.apifirstdev.application.dto.TodoRequest;
import com.example.apifirstdev.application.dto.TodoResponce;
import com.example.apifirstdev.domain.Todo;
import com.example.apifirstdev.domain.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  @Override
  public List<TodoResponce> getTodos() {
    return todoRepository.findAll().stream()
        .map(todo -> TodoResponce.of(todo.getId(), todo.getContent()))
        .collect(Collectors.toList());
  }

  @Override
  public TodoResponce saveTodo(TodoRequest request) {
    Todo saveTodo = todoRepository.save(Todo.of(request.getContent()));
    return TodoResponce.of(saveTodo.getId(), saveTodo.getContent());
  }

  @Override
  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}

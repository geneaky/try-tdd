package com.example.apifirstdev.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.apifirstdev.application.dto.TodoRequest;
import com.example.apifirstdev.application.dto.TodoResponce;
import com.example.apifirstdev.domain.Todo;
import com.example.apifirstdev.domain.TodoRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

  @Mock
  private TodoRepository todoRepository;

  @InjectMocks
  private TodoServiceImpl todoService;

  @Test
  @DisplayName("getTodos")
  public void getTodos() throws Exception {

    List<Todo> todos = Arrays.asList(Todo.of(1L, "할 일"));
    when(todoRepository.findAll()).thenReturn(todos);

    List<TodoResponce> todoResponses = todoService.getTodos();

    assertThat(todoResponses).hasSize(todos.size());
    verify(todoRepository).findAll();
  }


  @Test
  @DisplayName("saveTodo")
  public void saveTodo() throws Exception {
    Todo todo;
    TodoRequest request = TodoRequest.of("할 일");

    todo = Todo.of(request.getContent());
    when(todoRepository.save(todo))
        .thenReturn(Todo.of(1L, request.getContent()));

    TodoResponce todoResponce = todoService.saveTodo(request);

    assertThat(todoResponce).isNotNull();
    verify(todoRepository).save(todo);
  }

  @Test
  @DisplayName("deleteTodo")
  public void deleteTodo() throws Exception {

    Long id = 1L;
    todoService.deleteTodo(id);

    verify(todoRepository).deleteById(id);
  }
}
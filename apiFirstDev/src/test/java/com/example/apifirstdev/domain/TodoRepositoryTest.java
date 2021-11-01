package com.example.apifirstdev.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TodoRepositoryTest {

  @Autowired
  private TodoRepository todoRepository;

  @Test
  @DisplayName("save_and_get_and_delete")
  public void save_and_get_and_delete() throws Exception {

    Todo todoToSave = Todo.of("할 일");

    Todo saveTodo = todoRepository.save(todoToSave);

    assertThat(saveTodo).isEqualTo(todoToSave);

    assertThat(todoRepository.existsById(saveTodo.getId())).isTrue();

    todoRepository.deleteById(saveTodo.getId());

    assertThat(todoRepository.existsById(saveTodo.getId())).isFalse();
  }
}
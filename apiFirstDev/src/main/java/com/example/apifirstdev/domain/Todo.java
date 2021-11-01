package com.example.apifirstdev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Getter
@EqualsAndHashCode
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @EqualsAndHashCode.Exclude
  private String content;

  public static Todo of(String content) {
    Todo todo = new Todo();
    todo.content = content;
    return todo;
  }

  public static Todo of(long id, String content) {
    Todo todo = new Todo();
    todo.id = id;
    todo.content = content;
    return todo;
  }
}

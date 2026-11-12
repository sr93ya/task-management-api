package com.example.taskapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody CreateTodoRequest request) {
        Todo todo = new Todo(
            counter.incrementAndGet(),
            request.title(),
            false
        );
        todos.add(todo);
        return todo;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    public record CreateTodoRequest(String title) {
    }
}

package basic.initial.controller;


import basic.initial.domain.Todo;
import basic.initial.dto.CreateTodoRequest;
import basic.initial.dto.TodoResponse;
import basic.initial.dto.UpdateTodoRequest;
import basic.initial.service.TodoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public Long create(@RequestBody CreateTodoRequest request) {
        return todoService.create(request.title());
    }


    @GetMapping("/todos")
    public List<TodoResponse> list(){
        return todoService.findAll()
                .stream()
                .map(TodoResponse::from)
                .toList();
    }

    @GetMapping("/todos/{id}")
    public TodoResponse findOne(@PathVariable Long id){
        Todo todo = todoService.findById(id);
        return TodoResponse.from(todo);
    }
    @PatchMapping("/todos/{id}")
    public TodoResponse update(
            @PathVariable Long id,
            @RequestBody UpdateTodoRequest request
    ){
        Todo updated=todoService.update(id,request.title(),request.completed());
        return TodoResponse.from(updated);

    }
    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}

package basic.initial.service;

import basic.initial.domain.Todo;
import basic.initial.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public Long create(String title){
        Todo todo= new Todo(title);
        return todoRepository.save(todo).getId();
    }

    @Transactional(readOnly=true)
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }
    @Transactional(readOnly=true)
    public Todo findById(Long id){
        return todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Todo not found!"+id));
    }

    public Todo update(Long id, String title,Boolean completed) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Todo not found: "+id));
        todo.update(title,completed);
        return todo;
    }


    public void delete(Long id){
        if(!todoRepository.existsById(id)){
            throw new IllegalArgumentException("Todo not found: "+id);
        }
        todoRepository.deleteById(id);
    }
}

package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    public List<Todo> list = new ArrayList<>();
    @Autowired
    TodoRepository todoRepository;
    public List<Todo> addTodo(List<Todo> todo)
    {
        for(Todo t : todo)
        {
            todoRepository.save(t);
        }
        return todoRepository.saveAll(todo);
    }
    public Optional<Todo> getTodo(int id)
    {
//        for(Todo e : list)
//        {
//            if(e.getId() == id)
//            {
//                return e;
//            }
//        }
//        return null;
        return todoRepository.findById(id);
    }

    public Boolean removeTodo(int id)
    {

            Optional<Todo> currentTodo = getTodo(id);

            if(currentTodo.isPresent())
            {
                todoRepository.delete(currentTodo.get());
                return true;
            }


        return false;
    }

    public Todo updateTodo(int id,Todo updatedTodo)
    {
        Optional<Todo> currentTodo = getTodo(id);
        if(currentTodo.isPresent())
        {
            currentTodo.get().setPriority(updatedTodo.getPriority());
            currentTodo.get().setDescription(updatedTodo.getDescription());

            return todoRepository.save(currentTodo.get());
        }

        return null;



    }

    public List<Todo> getAll()
    {
        return todoRepository.findAll();
    }


    public List<Todo> getFilterTodos(String priority) {

        return todoRepository.findByPriority(priority);
    }
}

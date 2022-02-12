package com.exampleAll.learn.repository;


import com.exampleAll.learn.model.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<ToDo, Long> {
}

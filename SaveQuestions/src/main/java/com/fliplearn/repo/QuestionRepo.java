package com.fliplearn.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fliplearn.entity.Question;
@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer>{

}

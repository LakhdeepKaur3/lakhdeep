package com.fliplearn.service;

import java.util.List;

import com.fliplearn.entity.Question;

public interface QuestionService {
	public void saveQuestion(Question question);

	void saveQuestion(List<Question> listOfquestions);
}

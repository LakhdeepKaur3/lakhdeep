package com.fliplearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fliplearn.entity.Question;
import com.fliplearn.repo.QuestionRepo;
import com.fliplearn.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepo questionrepo;

	@Override
	public void saveQuestion(List<Question> listOfquestions) {
		questionrepo.save(listOfquestions);
	}

	@Override
	public void saveQuestion(Question question) {
		questionrepo.save(question);

	}
}

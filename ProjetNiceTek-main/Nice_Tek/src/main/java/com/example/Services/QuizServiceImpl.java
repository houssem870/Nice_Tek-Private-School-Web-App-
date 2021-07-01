package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Quiz;
import com.example.Repository.QuizRepository;



@Service
public class QuizServiceImpl implements QuizService{

	 @Autowired
	 QuizRepository QuizRepository; 
	@Override
	public List<Quiz> retrieveAllQuiz() {
	return	(List<Quiz>) QuizRepository.findAll();
	}

	@Override
	public Quiz addQuiz(Quiz a) {
		return QuizRepository.save(a);
	}

	@Override
	public void deleteQuiz(Long id) {
		QuizRepository.deleteById(id);
	}

	@Override
	public Quiz updateQuiz(Quiz u) {
		return QuizRepository.save(u);

	}

	@Override
	public Quiz retrieveQuiz(Long id) {
return QuizRepository.findById(id).get();
	}

	@Override
	public List<Quiz> FindQuizSortedByName() {
	 		return QuizRepository.FindQuizSortedByName();

	}

}

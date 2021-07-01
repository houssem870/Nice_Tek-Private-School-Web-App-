package com.example.Services;

import java.util.List;

import com.example.Entities.Quiz;


public interface QuizService {
	public List<Quiz> retrieveAllQuiz();
	Quiz addQuiz(Quiz a);
	 void deleteQuiz(Long id);
	 Quiz updateQuiz(Quiz u);
	 Quiz retrieveQuiz(Long id);
	 public List<Quiz> FindQuizSortedByName();

}

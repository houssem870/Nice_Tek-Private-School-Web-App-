package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Entities.Quiz;




public interface QuizRepository extends CrudRepository <Quiz,Long> {
	@Query(value="SELECT * FROM Quiz Order By quiz",nativeQuery =true)
	public List<Quiz> FindQuizSortedByName();
}

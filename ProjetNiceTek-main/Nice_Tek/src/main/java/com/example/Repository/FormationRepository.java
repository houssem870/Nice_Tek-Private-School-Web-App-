package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Entities.Formation;




public interface FormationRepository extends CrudRepository <Formation,Long> {
	@Query(value="SELECT * FROM Formation Order By intitule",nativeQuery =true)
	public List<Formation> FindQuizSortedByFormation();
}

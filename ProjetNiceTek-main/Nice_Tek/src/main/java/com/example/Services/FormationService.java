package com.example.Services;

import java.util.List;

import com.example.Entities.Formation;


public interface FormationService {
	public List<Formation> retrieveAllFormation();
	Formation addFormation(Formation a);
	 void deleteFormation(Long id);
	 Formation updateFormation(Formation u);
	 Formation retrieveFormation(Long id);
	 public List<Formation> FindQuizSortedByFormation();

}

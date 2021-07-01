package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Formation;
import com.example.Repository.FormationRepository;



@Service
public class FormationServiceImpl implements FormationService{

	 @Autowired
	 FormationRepository FormationRepository;
	 
	@Override
	public List<Formation> retrieveAllFormation() {
		return 	(List<Formation>) FormationRepository.findAll();
	}

	@Override
	public Formation addFormation(Formation a) {
		return FormationRepository.save(a);
	}

	@Override
	public void deleteFormation(Long id) {
		FormationRepository.deleteById(id);
	}

	@Override
	public Formation updateFormation(Formation u) {
		return FormationRepository.save(u);

	}

	@Override
	public Formation retrieveFormation(Long id) {
		return FormationRepository.findById(id).get();
}

	@Override
	public List<Formation> FindQuizSortedByFormation() {
 		return FormationRepository.FindQuizSortedByFormation();

	}

	 
}

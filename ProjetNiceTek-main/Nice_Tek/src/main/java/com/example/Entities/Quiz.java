package com.example.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Quiz")
public class Quiz implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdQuiz")
	private Long IdQuiz;
	
	@Column(name="Quiz")
	private String Quiz;
	
	
	@Column(name="Reponse1")
	private String Reponse1;
	
	
	
	@Column(name="Reponse2")
	private String Reponse2;
	
	
	
	@Column(name="Reponse3")
	private String Reponse3;
	
	
	@Column(name="ReponseCorrecte")
	private String ReponseCorrecte;


	public Long getIdQuiz() {
		return IdQuiz;
	}


	public void setIdQuiz(Long idQuiz) {
		IdQuiz = idQuiz;
	}


	public String getQuiz() {
		return Quiz;
	}


	public void setQuiz(String quiz) {
		Quiz = quiz;
	}


	public String getReponse1() {
		return Reponse1;
	}


	public void setReponse1(String reponse1) {
		Reponse1 = reponse1;
	}


	public String getReponse2() {
		return Reponse2;
	}


	public void setReponse2(String reponse2) {
		Reponse2 = reponse2;
	}


	public String getReponse3() {
		return Reponse3;
	}


	public void setReponse3(String reponse3) {
		Reponse3 = reponse3;
	}


	public String getReponseCorrecte() {
		return ReponseCorrecte;
	}


	public void setReponseCorrecte(String reponseCorrecte) {
		ReponseCorrecte = reponseCorrecte;
	}


	public Quiz(Long idQuiz, String quiz, String reponse1, String reponse2, String reponse3, String reponseCorrecte) {
		super();
		IdQuiz = idQuiz;
		Quiz = quiz;
		Reponse1 = reponse1;
		Reponse2 = reponse2;
		Reponse3 = reponse3;
		ReponseCorrecte = reponseCorrecte;
	}
	
	
	
	
	
	public Quiz( String quiz, String reponse1, String reponse2, String reponse3, String reponseCorrecte) {
		super();
		
		Quiz = quiz;
		Reponse1 = reponse1;
		Reponse2 = reponse2;
		Reponse3 = reponse3;
		ReponseCorrecte = reponseCorrecte;
	}


	@Override
	public String toString() {
		return "Quiz [IdQuiz=" + IdQuiz + ", Quiz=" + Quiz + ", Reponse1=" + Reponse1 + ", Reponse2=" + Reponse2
				+ ", Reponse3=" + Reponse3 + ", ReponseCorrecte=" + ReponseCorrecte + "]";
	}
	
	
	
	
	
}


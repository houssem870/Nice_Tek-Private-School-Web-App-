package com.example.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Formation")
public class Formation implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdFormation")
	private Long IdFormation;
	
	@Column(name="IntituleFormation")
	private String IntituleFormation;
	
	
	@Column(name="Description")
	private String Description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TypeFormation")
	private TypeFormation TypeFormation;

	@Column(name="Prix")
	private Float Prix;
	
	@Column(name="ChargeHoraire")
	private int ChargeHoraire;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Duree")
	private DureeEnum Duree;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Mode")
	private ModeEnum Mode;
	
	@Column(name="Debut")
	private Date Debut;

	public Long getIdFormation() {
		return IdFormation;
	}

	public void setIdFormation(Long idFormation) {
		IdFormation = idFormation;
	}

	public String getIntituleFormation() {
		return IntituleFormation;
	}

	public void setIntituleFormation(String intituleFormation) {
		IntituleFormation = intituleFormation;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public TypeFormation getTypeFormation() {
		return TypeFormation;
	}

	public void setTypeFormation(TypeFormation typeFormation) {
		TypeFormation = typeFormation;
	}

	public Float getPrix() {
		return Prix;
	}

	public void setPrix(Float prix) {
		Prix = prix;
	}

	public int getChargeHoraire() {
		return ChargeHoraire;
	}

	public void setChargeHoraire(int chargeHoraire) {
		ChargeHoraire = chargeHoraire;
	}

	public DureeEnum getDuree() {
		return Duree;
	}

	public void setDuree(DureeEnum duree) {
		Duree = duree;
	}

	public ModeEnum getMode() {
		return Mode;
	}

	public void setMode(ModeEnum mode) {
		Mode = mode;
	}

	public Date getDebut() {
		return Debut;
	}

	public void setDebut(Date debut) {
		Debut = debut;
	}

	public Formation(Long idFormation, String intituleFormation, String description,
			com.example.Entities.TypeFormation typeFormation, Float prix, int chargeHoraire, DureeEnum duree, ModeEnum mode,
			Date debut) {
		super();
		IdFormation = idFormation;
		IntituleFormation = intituleFormation;
		Description = description;
		TypeFormation = typeFormation;
		Prix = prix;
		ChargeHoraire = chargeHoraire;
		Duree = duree;
		Mode = mode;
		Debut = debut;
	}
	
	
	
	public Formation(String intituleFormation, String description,
			com.example.Entities.TypeFormation typeFormation, Float prix, int chargeHoraire, DureeEnum duree, ModeEnum mode,
			Date debut) {
		super();
		IntituleFormation = intituleFormation;
		Description = description;
		TypeFormation = typeFormation;
		Prix = prix;
		ChargeHoraire = chargeHoraire;
		Duree = duree;
		Mode = mode;
		Debut = debut;
	}

	@Override
	public String toString() {
		return "Formation [IdFormation=" + IdFormation + ", IntituleFormation=" + IntituleFormation + ", Description="
				+ Description + ", TypeFormation=" + TypeFormation + ", Prix=" + Prix + ", ChargeHoraire="
				+ ChargeHoraire + ", Duree=" + Duree + ", Mode=" + Mode + ", Debut=" + Debut + "]";
	}
	

}

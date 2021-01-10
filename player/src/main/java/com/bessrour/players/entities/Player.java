package com.bessrour.players.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayer;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomPLayer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@NotNull
	@Size (min = 0)
	private Double scorePLayer;
	
	@ManyToOne
	private Categorie categorie;
	
	public Player() {
		super();
	}
	
	public Player(String nomPLayer, Date dateCreation , Double scorePLayer) {
		super();
		this.nomPLayer = nomPLayer;
		this.dateCreation = dateCreation;
		this.scorePLayer = scorePLayer;
	}

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getNomPLayer() {
		return nomPLayer;
	}

	public void setNomPLayer(String nomPLayer) {
		this.nomPLayer = nomPLayer;
	}


	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Double getScorePLayer() {
		return scorePLayer;
	}

	public void setScorePLayer(Double scorePLayer) {
		this.scorePLayer = scorePLayer;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", nomPLayer=" + nomPLayer + ", dateCreation=" + dateCreation
				+ ", scorePLayer=" + scorePLayer + "]";
	}
	
	public Categorie getCategorie() 
	{
		return categorie;
	}



	public void setCategorie(Categorie categorie) 
	{
		this.categorie = categorie;
	}
	
	
}
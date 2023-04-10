package com.tima.tp1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="AUTEUR")
public class Auteur implements Serializable {

	private static final long serialVersionUID = -345553817069222758L;

	@Id
    private Long matricule;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String prenom;
    
    @Column(nullable = false, name = "genre", columnDefinition = "ENUM('Masculin', 'Feminin')")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    
    @OneToMany(mappedBy = "auteur", orphanRemoval=true)
    private List<Livre> livres;
    

	public Auteur() {
		super();
	}

	public Auteur(Long matricule, String nom, String prenom, Genre genre) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Auteur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + "]";
	}
    
	
    
}

package com.tima.tp1.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="LIVRE")
public class Livre implements Serializable {

	private static final long serialVersionUID = 6229855349402825316L;

	@Id
	@Column(nullable=false, name="ISBN")
    private Long isbn;
    
    @Column(nullable = false)
    private String titre;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private LocalDate dateEdition;
    
    @Column(nullable = false, name = "editeur", columnDefinition = "ENUM('ENI', 'FIRST', 'DUNOD')")
    @Enumerated(EnumType.STRING)
    private Editeur editeur;
    
    @ManyToOne
    @JoinColumn(name = "matricule")
    private Auteur auteur;
    
    public Livre() {
		super();
	}
    
	public Livre(Long isbn, String titre, String description, LocalDate dateEdition, Editeur editeur,
			Auteur auteur) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.description = description;
		this.dateEdition = dateEdition;
		this.editeur = editeur;
		this.auteur = auteur;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", titre=" + titre + ", description=" + description + ", dateEdition="
				+ dateEdition + ", editeur=" + editeur + ", auteur=" + auteur + "]";
	}
    
    

}

package it.musei.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(name="Artista.Dipinto.get", query="SELECT a.nomeArtista, a.cognomeArtista, a.annoNascita, d.titolo, d.annoDipinto FROM Artista a JOIN a.dipinti d")
@Table(name="artista")
@Entity
public class Artista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idArtista;
	private String nomeArtista;
	private String cognomeArtista;
	private int annoNascita;
	private int annoMorte;
	
	private Set<Dipinto> dipinti;
	
	@Id
	@Column(name="id_artista")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	
	@Column(name="nome_artista")
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	@Column(name="cognome_artista")
	public String getCognomeArtista() {
		return cognomeArtista;
	}
	public void setCognomeArtista(String cognomeArtista) {
		this.cognomeArtista = cognomeArtista;
	}
	
	@Column(name="anno_nascita")
	public int getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	
	@Column(name="anno_morte")
	public int getAnnoMorte() {
		return annoMorte;
	}
	public void setAnnoMorte(int annoMorte) {
		this.annoMorte = annoMorte;
	}
	
	@ManyToMany()
	@JoinTable(
			name="dipinto_artista",
			joinColumns = @JoinColumn(name = "id_dipinto"),
			inverseJoinColumns = @JoinColumn(name="id_artista")
			)
	@JoinColumn
	public Set<Dipinto> getDipinti() {
		return dipinti;
	}
	public void setDipinti(Set<Dipinto> dipintiFatti) {
		this.dipinti = dipintiFatti;
	}
}
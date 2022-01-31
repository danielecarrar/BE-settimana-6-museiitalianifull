package it.musei.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(name="dipinto.artista", query =  "select d.idDipinto, d.titolo, d.annoDipinto, a.nomeArtista, a.cognomeArtista, a.annoNascita FROM Dipinto d join d.artisti a")
@Table(name="dipinto")
@Entity
public class Dipinto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idDipinto;
	private String titolo;
	private int annoDipinto;
	
	private Museo museo; //eccola!
	
	private Set<Artista> artisti;
	
	public Dipinto(){}
	
	public Dipinto(String titolo, int annoDipinto) {
		this.titolo = titolo;
		this.annoDipinto = annoDipinto;
	}
	@Id
	@Column(name="id_dipinto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdDipinto() {
		return idDipinto;
	}
	public void setIdDipinto(int idDipinto) {
		this.idDipinto = idDipinto;
	}
	
	@Column(name = "titolo")
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Column(name ="anno")
	public int getAnnoDipinto() {
		return annoDipinto;
	}
	public void setAnnoDipinto(int annoDipinto) {
		this.annoDipinto = annoDipinto;
	}
	
	//salvo un dipinto, persiste un museo
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_museo")
	public Museo getMuseo() {
		return museo;
	}
	public void setMuseo(Museo museo) {
		this.museo = museo;
	}
	
	@ManyToMany()
	@JoinTable(name="dipinto_artista",
	joinColumns = @JoinColumn(name = "id_dipinto"),
			inverseJoinColumns = @JoinColumn(name="id_artista")
			)
	public Set<Artista> getArtisti() {
		return artisti;
	}
	public void setArtisti(Set<Artista> artisti) {
		this.artisti = artisti;
	}
	
	
}
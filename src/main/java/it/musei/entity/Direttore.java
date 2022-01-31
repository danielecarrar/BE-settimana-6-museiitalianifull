package it.musei.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="direttore")
@Entity
public class Direttore implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idDirettore;
	private String nomeDirettore;
	private String cognomeDirettore;
	private Museo museoGestito;
	
	@Id
	@Column(name="id_direttore")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdDirettore() {
		return idDirettore;
	}
	@Column(name="nome_direttore")
	public String getNomeDirettore() {
		return nomeDirettore;
	}
	@Column(name="cognome_direttore")
	public String getCognomeDirettore() {
		return cognomeDirettore;
	}
	public void setIdDirettore(int idDirettore) {
		this.idDirettore = idDirettore;
	}
	public void setNomeDirettore(String nomeDirettore) {
		this.nomeDirettore = nomeDirettore;
	}
	public void setCognomeDirettore(String cognomeDirettore) {
		this.cognomeDirettore = cognomeDirettore;
	}
	
	//mapped by direttore, variabile in museo!
	@OneToOne(mappedBy = "direttore", cascade = CascadeType.PERSIST)	
	public Museo getMuseoGestito() {
		return museoGestito;
	}
	public void setMuseoGestito(Museo museoGestito) {
		this.museoGestito = museoGestito;
	}
}
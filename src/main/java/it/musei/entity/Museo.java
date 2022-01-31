package it.musei.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@NamedQuery(name="museo.SelectAll", query="SELECT m FROM Museo m")
@Table(name = "museo")
@Entity
public class Museo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idMuseo;
	private String nome;
	private String citta;
	private Direttore direttore; 	//variabile
	Set<Dipinto> dipinti;
	
	
	public Museo() {}

	public Museo(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	@Id
	@Column(name="id_museo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdMuseo() {
		return idMuseo;
	}

	public void setIdMuseo(int idMuseo) {
		this.idMuseo = idMuseo;
	}

	@Column(name = "nome_museo")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="citta")
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	/*il mapped by va sempre one to many
	 *in questo caso, "museo" è l'oggetto di tipo
	 *Museo presente in dipinto (vedi attributo in dipinto)
	 *e deve avere lo stesso nome
	 * */
	 
	@OneToMany(mappedBy = "museo", cascade = CascadeType.PERSIST)
	public Set<Dipinto> getDipinti() {
		if(dipinti == null)
		{
			dipinti = new HashSet<Dipinto>();
		}
		return dipinti;
	}

	public void setDipinti(Set<Dipinto> dipinti) {
		this.dipinti = dipinti;
	}

	//vogliamo che nella tab museo compaia id_direttore
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_direttore")
	public Direttore getDirettore() {
		return direttore;
	}

	public void setDirettore(Direttore direttore) {
		this.direttore = direttore;
	}	
	
	public void aggiungiDipinto(Dipinto d) {
		getDipinti().add(d);
		d.setMuseo(this);
	}
}
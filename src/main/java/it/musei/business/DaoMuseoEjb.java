package it.musei.business;

import java.util.List;

import it.musei.entity.Dipinto;
import it.musei.entity.Museo;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class DaoMuseoEjb implements DaoMuseoEjbLocal {

	@PersistenceContext(unitName = "museiPS")
	EntityManager em;

	public DaoMuseoEjb() {
	}

	public List<Museo> getAllMusei() {
		Query q = em.createNamedQuery("museo.SelectAll");
		List<Museo> listaMusei = q.getResultList();

		return listaMusei;
	}

	public List<Dipinto> getAllDipinti() {
		Query q = em.createQuery("SELECT d FROM Dipinto d");
		List<Dipinto> listaDipinti = q.getResultList();
		return listaDipinti;
	}
	
	//metodo inserire i musei da form
	public Museo insertMuseo(Museo m) {
		 em.persist(m);
		 return m;
	}
	
	public Museo insertMuseo(String nomeM, String cittaM) {
	Museo m = new Museo(nomeM, cittaM);
	return insertMuseo(m);
	}
	
	public Dipinto insertDipinto(Dipinto d) {
		 em.persist(d);
		 return d;
	}
	
	public Dipinto insertDipinto(String titolo, int anno) {
		Dipinto d = new Dipinto(titolo, anno);
		
		return insertDipinto(d);
	}
	
	public List<Object[]> getDipintiMusei(){
		String sql = "SELECT d.idDipinto, d.titolo, d.annoDipinto, m.nome, m.citta FROM Dipinto d JOIN d.museo m";
		Query query = em.createQuery(sql);
		List<Object[]> dipintiMusei = query.getResultList();
		return dipintiMusei;
	}
	
	public List<Object[]> getArtistiDipinti(){
		Query q = em.createNamedQuery("Artista.Dipinto.get");
		List<Object[]> listaAd = q.getResultList();
		return listaAd;
	}
	
	public List<Object[]> getDipintiArtisti(){
		Query q = em.createNamedQuery("dipinto.artista");
		List<Object[]> listaDA = q.getResultList();
		return listaDA;
	}
	
	public List<Object[]> getMuseoDipintoArtista(){
		String sql="SELECT m.nome, m.citta, d.titolo, a.nomeArtista, a.cognomeArtista"
				+"FROM Museo m JOIN m.dipinti d, JOIN d.artisti a";
		Query q = em.createQuery(sql);
		 List<Object[]> listaMDA = q.getResultList();
		 return listaMDA;		
	}
	
}
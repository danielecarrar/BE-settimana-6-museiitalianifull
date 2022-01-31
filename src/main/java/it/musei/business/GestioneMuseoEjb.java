package it.musei.business;

import it.musei.entity.Dipinto;
import it.musei.entity.Direttore;
import it.musei.entity.Museo;
import it.musei.exceptions.IdNonSpecificatoException;
import it.musei.exceptions.MuseoNonTrovatoException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class GestioneMuseoEjb implements GestioneMuseoEjbLocal {

	@PersistenceContext(unitName = "museiPS")
	EntityManager em;

	public GestioneMuseoEjb() {
	}

	public void testDb() {
		Museo m = newMuseo();
		em.persist(m);
	}

	// metodo che richiama la creazione del museo
	// cosi da poterlo utilizzare ancora
	public Museo newMuseo() {
		Museo m = new Museo();
		m.setNome("museo di prova");
		m.setCitta("Genova");
		return m;
	}

	public void testMuseoeDipinti() {
//    	Dipinto d1 = new Dipinto();
//    	Dipinto d2 = new Dipinto();
//    	Dipinto d3 = new Dipinto();
//    	//creo i dipinti
//    	d1.setTitolo("La Serva");
//    	d2.setTitolo("L'inserviente");
//    	d3.setTitolo("Francone national");

		Museo m1 = newMuseo();
		// li aggiungo al museo
//    	m1.aggiungiDipinto(d1);
//    	m1.aggiungiDipinto(d2);
//    	m1.aggiungiDipinto(d3);
		aggiungiDipinti(m1);
		// aggiungiamo il museo al DB
		em.persist(m1);

//    	m1.getDipinti().add(d1);
//    	m1.getDipinti().add(d2);
//    	m1.getDipinti().add(d3);
//    	d1.setMuseo(m1);
//    	d2.setMuseo(m1);
//    	d3.setMuseo(m1);
	}

	public void direttoreMuseo() {
		Museo m = newMuseo();

		aggiungiDipinti(m);

		Direttore dir = new Direttore();
		dir.setCognomeDirettore("Giorgione");
		dir.setNomeDirettore("Sir");

		m.setDirettore(dir);

		em.persist(m);
	}

	private void aggiungiDipinti(Museo m) {
		Dipinto d1 = new Dipinto();
		Dipinto d2 = new Dipinto();
		Dipinto d3 = new Dipinto();
		// creo i dipinti
		d1.setTitolo("La Serva");
		d2.setTitolo("L'inserviente");
		d3.setTitolo("Francone national");

		// li aggiungo al museo
		m.aggiungiDipinto(d1);
		m.aggiungiDipinto(d2);
		m.aggiungiDipinto(d3);
	}

	// trovare il museo
	public Museo trovaMuseo(int idMuseo) throws MuseoNonTrovatoException {
		Museo m = em.find(Museo.class, idMuseo);
		if (m == null) {
			throw new MuseoNonTrovatoException();
		}
		return m;
	}

	public Museo trovaMuseo(String idMuseo) throws MuseoNonTrovatoException, IdNonSpecificatoException {
		if(idMuseo==null || idMuseo.isBlank()) {
			throw new IdNonSpecificatoException("L'ID del museo non è stato specificato");
		}
		
		Integer idCore = Integer.parseInt(idMuseo);
		
		return trovaMuseo(idCore);
	}
}
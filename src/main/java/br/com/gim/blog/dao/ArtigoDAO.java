package br.com.gim.blog.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gim.blog.model.entity.Artigo;
import br.com.gim.blog.util.jpa.EntityManagerProducer;

@RequestScoped
public class ArtigoDAO {

	
	
	EntityManager manager = new EntityManagerProducer().getEntityManager();
	
	public void salvar(Artigo artigo) {
		manager.getTransaction().begin();
		manager.persist(artigo);
		manager.getTransaction().commit();		
	}

	public List<Artigo> lista() {		
		return manager.createQuery("from Artigo", Artigo.class).getResultList();
	}

	public void remove(Artigo artigo) {
		manager.getTransaction().begin();
		manager.remove(artigo);
		manager.getTransaction().commit();
		
		
	}

}

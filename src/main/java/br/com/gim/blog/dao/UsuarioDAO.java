package br.com.gim.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gim.blog.model.entity.Usuario;
import br.com.gim.blog.util.jpa.EntityManagerProducer;

public class UsuarioDAO {
	
	private EntityManager manager = new EntityManagerProducer().getEntityManager();
	

	
	public List<Usuario> lista() {
		
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}



	public void salvar(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}



	public void remove(Usuario usuario) {
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();
		
	}

}

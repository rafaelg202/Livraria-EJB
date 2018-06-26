package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@Startup
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO]autorDao foi criado");
	}
	
	public void salva(Autor autor) {
		
//		System.out.println("[INFO] Salvando Autor: " +autor.getNome());
//		try {
//			Thread.sleep(20000); // 20 segundos
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		manager.persist(autor);
		System.out.println("[INFO] Autor cadastrado: " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}

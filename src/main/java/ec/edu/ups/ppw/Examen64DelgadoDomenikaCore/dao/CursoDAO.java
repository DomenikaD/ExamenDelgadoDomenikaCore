package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao;

import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CursoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Curso read (int codigo) {
		return em.find(Curso.class, codigo);
		
	}
	
	public void insert(Curso curso) {
		em.persist(curso);
	}
	
	  /* LISTAR */
	public List<Curso> getAll() {
	String jpql = "SELECT c FROM Curso c";
	Query query = em.createQuery(jpql, Curso.class);  
	return query.getResultList();  
	}


}

package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao;

import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class InscripcionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
    public void insert(Inscripcion inscripcion) {
        em.persist(inscripcion);
    }
	
	public Inscripcion read(int codigo) {
		return em.find(Inscripcion.class, codigo);
	}
	
    
	  /* LISTAR */
	public List<Inscripcion> getAll() {
	String jpql = "SELECT i FROM Inscripcion i";
	Query query = em.createQuery(jpql, Inscripcion.class);  
	return query.getResultList();  
	}
}

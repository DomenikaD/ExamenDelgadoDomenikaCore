package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business;

import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao.CursoDAO;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Curso;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCurso {
	
	@Inject
	private CursoDAO daoCurso;
	
	public void createCurso(Curso Curso) throws Exception {
		daoCurso.insert(Curso);
	}
	
	public Curso getCurso(int codigo) throws Exception {
		Curso Curso = daoCurso.read(codigo);
		if (Curso == null) {
			throw new Exception("Curso no existe");
		}
		return Curso;
	}
	
	public List<Curso> getCursos() {
		return daoCurso.getAll();
	}
	

}

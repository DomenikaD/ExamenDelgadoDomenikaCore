package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business;

import java.util.List;
import java.util.stream.Collectors;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao.InscripcionDAO;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionInscripcion {
	
	@Inject
	private InscripcionDAO daoInscripcion;
	
	public Inscripcion getInscripcion(int codigo) throws Exception {
		Inscripcion inscripcion = daoInscripcion.read(codigo);
		if (inscripcion == null) {
			throw new Exception("Inscripcion no existe");
		}
		return inscripcion;
	}
	
	
	
	public List<Inscripcion> getInscripciones() {
		return daoInscripcion.getAll();
	}
 
	public List<Inscripcion> filtrarPorCodigo(int codigo) {
        return daoInscripcion.getAll().stream()
                .filter(t -> t.getnCurso().getCodigo_curso() == codigo)
                .collect(Collectors.toList());
    }

	public void createInscripcion(Inscripcion Inscripcion) throws Exception {
		daoInscripcion.insert(Inscripcion);
	}
	

}

package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao.CursoDAO;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.dao.InscripcionDAO;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Curso;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Inscripcion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private CursoDAO daoCurso;
	
	@Inject
	private InscripcionDAO daoInscripcion;
	
	
	@PostConstruct
	public void init() {
		
		System.out.println("INFORMACION");
		
		Curso curso = new Curso();
		curso.setCodigo_curso(1);
		curso.setNombre("Programacion");
		curso.setCupo(15);
		curso.setFecha_inicio(new Date());
		
		
		Inscripcion i = new Inscripcion();
		i.setCedula_alumno("1717273401");
		i.setNombre_alumno("Domenika");
		i.setApellido_alumno("Delgado");
		i.setFecha_inscripcion(new Date());
		i.setnCurso(curso);
		daoInscripcion.insert(i);
		
		
		
		Inscripcion i2 = new Inscripcion();
		i2.setCedula_alumno("1002064002");
		i2.setNombre_alumno("Sofia");
		i2.setApellido_alumno("Ibujes");
		i2.setFecha_inscripcion(new Date());
		i2.setnCurso(curso);
		daoInscripcion.insert(i2);
		
		
		daoCurso.insert(curso);
		
		
		List<Inscripcion> listadoIns = daoInscripcion.getAll();
		for(Inscripcion ins: listadoIns) {
			System.err.println("Inscripciones --> " + ins.getCodigo_insc());
		}
		
		
		List<Curso> listado = daoCurso.getAll();
		for (Curso cur: listado) {
			System.err.println(cur.getCodigo_curso() + " " + cur.getNombre() + " " + cur.getCupo() + " " + cur.getFecha_inicio());
		}
		
	}

}

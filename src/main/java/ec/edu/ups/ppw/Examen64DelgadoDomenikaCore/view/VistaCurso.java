package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.view;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business.GestionCurso;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business.GestionInscripcion;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Curso;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Inscripcion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("cursos")
@RequestScoped
public class VistaCurso {
	
	
	@Inject
	private GestionInscripcion gInscripciones;
	
	@Inject
	private GestionCurso gCursos;

	
	private Inscripcion inscripcion = new Inscripcion();
	
	private Curso curso = new Curso();
	
	private int numeroCurso = 0;
	
	private List<Inscripcion> listado;
	
	@PostConstruct
	public void init() {
		listado = gInscripciones.getInscripciones();
	}

	
	/*GETTERS & SETTERS*/
	public GestionInscripcion getgInscripciones() {
		return gInscripciones;
	}

	public void setgInscripciones(GestionInscripcion gInscripciones) {
		this.gInscripciones = gInscripciones;
	}

	public GestionCurso getgCursos() {
		return gCursos;
	}

	public void setgCursos(GestionCurso gCursos) {
		this.gCursos = gCursos;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCuso(Curso curso) {
		this.curso = curso;
	}

	public int getNumeroCurso() {
		return numeroCurso;
	}

	public void setNumeroCurso(int numeroCurso) {
		this.numeroCurso = numeroCurso;
	}

	public List<Inscripcion> getListado() {
		return listado;
	}

	public void setListado(List<Inscripcion> listado) {
		this.listado = listado;
	}
	
	
	public String aceptar() {
		System.out.println(this.numeroCurso);
	
	try {
		curso = gCursos.getCurso(numeroCurso);
		
		inscripcion.setnCurso(curso);
		inscripcion.setFecha_inscripcion(new Date());
		System.out.println(this.numeroCurso);
		System.out.println(this.inscripcion);
		
		
		gInscripciones.createInscripcion(inscripcion);
		return "listadoCursos?faces-redirect=true";
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "error";
		}
	}
	
	
    // Método para navegar a la página de contactos
    public String back() {
        return "Examen64DelgadoDomenikaInscripcion?faces-redirect=true";  // Navega a contactos.xhtml
    }
	
	

}

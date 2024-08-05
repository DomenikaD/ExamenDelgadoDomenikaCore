package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name  = "TBL_CURSO")
public class Curso {

	
	@Id
	@Column(name = "curso_codigo")
	private int codigo_curso;
	
	@Column(name = "curso_nombre")
	private String nombre;
	
	@Column(name = "curso_cupo")
	private int cupo;
	@Column(name = "curso_fecha_inicio")
	private Date fecha_inicio;
	
	
	/*GETTERS & SETTERS*/

	public int getCodigo_curso() {
		return codigo_curso;
	}

	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	
	@Override
	public String toString() {
		return "Curso [codigo_curso=" + codigo_curso + ", nombre=" + nombre + ", cupo=" + cupo + ", fecha_inicio="
				+ fecha_inicio + "]";
	}





	@OneToMany
	@JoinColumn(name = "curso_codigo")
	private List<Inscripcion> listaInscripciones;

	

	
}

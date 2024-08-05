package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_INSCRIPCION")
public class Inscripcion {
	
	@Id
	@GeneratedValue
	@Column(name = "inscripcion_codigo")
	private int codigo_insc;
	
	@Column(name = "inscripcion_cedula_alumno")
	private String cedula_alumno;
	
	@Column(name = "inscripcion_nombre_alumno")
	private String nombre_alumno;
	
	@Column(name = "inscripcion_apellido_alumno")
	private String apellido_alumno;
	
	@Column(name = "inscripcion_fecha_inscripcion")
	private Date fecha_inscripcion;

	
	/*GETTERS & SETTERS*/
	

	public int getCodigo_insc() {
		return codigo_insc;
	}


	public void setCodigo_insc(int codigo_insc) {
		this.codigo_insc = codigo_insc;
	}


	public String getCedula_alumno() {
		return cedula_alumno;
	}


	public void setCedula_alumno(String cedula_alumno) {
		this.cedula_alumno = cedula_alumno;
	}


	public String getNombre_alumno() {
		return nombre_alumno;
	}


	public void setNombre_alumno(String nombre_alumno) {
		this.nombre_alumno = nombre_alumno;
	}


	public String getApellido_alumno() {
		return apellido_alumno;
	}


	public void setApellido_alumno(String apellido_alumno) {
		this.apellido_alumno = apellido_alumno;
	}


	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}


	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}


	public Curso getnCurso() {
		return nCurso;
	}


	public void setnCurso(Curso nCurso) {
		this.nCurso = nCurso;
	}
	
	


	@Override
	public String toString() {
		return "Inscripcion [codigo_insc=" + codigo_insc + ", cedula_alumno=" + cedula_alumno + ", nombre_alumno="
				+ nombre_alumno + ", apellido_alumno=" + apellido_alumno + ", fecha_inscripcion=" + fecha_inscripcion
				+ ", nCurso=" + nCurso + "]";
	}


	@ManyToOne
	@JoinColumn(name = "curso_codigo")
	private Curso nCurso;



}

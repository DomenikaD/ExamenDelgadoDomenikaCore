package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.services;

import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business.GestionCurso;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business.GestionInscripcion;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Curso;
import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.model.Inscripcion;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cursos")
public class CursoService {
	
	@Inject
	private GestionCurso gCursos;
	
	@Inject
	private GestionInscripcion gInscripciones;

	
	/* °°°°°°°°°°°°
	 * 	  POST
	 * °°°°°°°°°°°° */
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON) //en que formato va recibir el parametro, que es lo que viene y como transformalo
	public Response create(Curso curso) {
		
		try {
			gCursos.createCurso(curso);
			return Response.ok(curso).build();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	 
	
	/* °°°°°°°°°°°°
	 * 	   GET
	 * °°°°°°°°°°°° */
	@GET
	@Produces("application/json")
	@Path("/{numero}")
	public Curso get(@PathParam("codigo") String codigo) {
		Curso curso;
		System.out.print("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°     " + codigo);
		try {
			curso = gCursos.getCurso(Integer.valueOf(codigo));
			return curso;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}



	//Recuperar una lista de Curso
	@GET
	@Produces("application/json")
	public List<Curso> list() {
		List<Curso> cursos = gCursos.getCursos();
		return cursos;
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Inscripcion> list2() {
		List<Inscripcion> inscr = gInscripciones.getInscripciones();
		return inscr;
	}
}

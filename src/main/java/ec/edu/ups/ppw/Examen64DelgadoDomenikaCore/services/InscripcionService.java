package ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.services;

import java.util.List;

import ec.edu.ups.ppw.Examen64DelgadoDomenikaCore.business.GestionInscripcion;
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

@Path("/inscripciones")
public class InscripcionService {
	
	@Inject
	private GestionInscripcion gInscripciones;
	
	
	/* °°°°°°°°°°°°
	 * 	  POST
	 * °°°°°°°°°°°° */
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response create(Inscripcion Inscripcion) {
		
		try {
			gInscripciones.createInscripcion(Inscripcion);
			return Response.ok(Inscripcion).build();
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
	@Path("/{codigo}")
	public List<Inscripcion> list(@PathParam("codigo") String codigo) {
		try {
			List<Inscripcion> Inscripcions = gInscripciones.filtrarPorCodigo(Integer.valueOf(codigo));
			return Inscripcions;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}



	//Recuperar una lista de Inscripciones
	@GET
	@Produces("application/json")
	public List<Inscripcion> list() {
		List<Inscripcion> Inscripcions = gInscripciones.getInscripciones();
		return Inscripcions;
	}
	


}

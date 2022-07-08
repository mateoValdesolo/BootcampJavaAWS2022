package ar.com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.com.beans.Persona;

@Path("personas")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public interface PersonasCrud {

	@GET
	@Path("/")
	Response listarPersonas();

	@POST
	@Path("/")
	Response agregar(Persona per);

	@PUT
	@Path("/")
	Response modificar(Persona per);

	@DELETE
	@Path("/{dni}")
	Response eliminar(@PathParam("dni") String dni);
	
	@GET
	@Path("/{dni}")
	Response obtenerPersonaPorDni(@PathParam("dni") String dni);

}

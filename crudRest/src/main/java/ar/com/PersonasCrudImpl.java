package ar.com;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.com.beans.Persona;
import ar.com.beans.response.ErrorResponse;
import ar.com.beans.response.ListPersonaResponse;
import ar.com.beans.response.MessageResponse;
import ar.com.exceptions.BOException;
import ar.com.service.PersonaBo;
import ar.com.util.ErrorCode;

@Controller("persona.service")
public class PersonasCrudImpl implements PersonasCrud {

	@Autowired
	private PersonaBo perBo;

	@Override
	public Response listarPersonas() {
		try {
			List<Persona> lPersonas = this.perBo.listarPersonas();
			
			return Response.status(Status.OK)
							.entity(new ListPersonaResponse(lPersonas))
							.build();
			
		} catch (BOException e) {
			return Response.status(Status.BAD_REQUEST)
					       .entity(new ErrorResponse(ErrorCode.BO_ERROR, e.getMessage()))
					       .build();
		}
	}

	@Override
	public Response agregar(Persona per) {
		try {
			this.perBo.agregarPersona(per);
			
			return Response.status(Status.OK)
							.entity(new MessageResponse("Persona Agregada OK"))
							.build();
			
		} catch (BOException e) {
			return Response.status(Status.BAD_REQUEST)
					       .entity(new ErrorResponse(ErrorCode.BO_ERROR, e.getMessage()))
					       .build();
		}
	}

	@Override
	public Response modificar(Persona per) {
		try {
			this.perBo.modificarPersona(per);
			
			return Response.status(Status.OK)
							.entity(new MessageResponse("Persona Modificada OK"))
							.build();
			
		} catch (BOException e) {
			return Response.status(Status.BAD_REQUEST)
					       .entity(new ErrorResponse(ErrorCode.BO_ERROR, e.getMessage()))
					       .build();
		}
	}

	@Override
	public Response eliminar(String dni) {
		try {
			this.perBo.eliminarPersona(dni);
			
			return Response.status(Status.OK)
							.entity(new MessageResponse("Persona Eliminada OK"))
							.build();
			
		} catch (BOException e) {
			return Response.status(Status.BAD_REQUEST)
					       .entity(new ErrorResponse(ErrorCode.BO_ERROR, e.getMessage()))
					       .build();
		}
	}

	@Override
	public Response obtenerPersonaPorDni(String dni) {
		try {
			Persona p = this.perBo.obtenerPersonaPorDni(dni);
			
			return Response.status(Status.OK)
							.entity(p)
							.build();
			
		} catch (BOException e) {
			return Response.status(Status.BAD_REQUEST)
					       .entity(new ErrorResponse(ErrorCode.BO_ERROR, e.getMessage()))
					       .build();
		}
	}

}

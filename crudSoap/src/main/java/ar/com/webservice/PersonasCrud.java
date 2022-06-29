package ar.com.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.annotations.SchemaValidation;

import ar.com.entity.Persona;
import ar.com.exceptions.PersonaNotFoundException;
import ar.com.exceptions.PersonaRepetidaException;

@WebService(targetNamespace = "http://cxf.com.ar/personas")
public interface PersonasCrud {

	@WebMethod(operationName = "agregar")
	@WebResult(name = "resultadoAgregar")
	@SchemaValidation
	boolean agregar(@WebParam(name = "persona") Persona per) throws PersonaRepetidaException;

	@WebMethod(operationName = "obtenerPorDni")
	@WebResult(name = "persona")
	@SchemaValidation
	Persona obtenerPorDni(@WebParam(name = "dni") String dni) throws PersonaNotFoundException;

	@WebMethod(operationName = "eliminar")
	@WebResult(name = "resultadoEliminar")
	@SchemaValidation
	boolean eliminar(@WebParam(name = "dni") String dni) throws PersonaNotFoundException;

	@WebMethod(operationName = "modificar")
	@WebResult(name = "resultadoModificar")
	@SchemaValidation
	boolean modificar(@WebParam(name = "persona") Persona per) throws PersonaNotFoundException;

	@WebMethod(operationName = "listar")
	@WebResult(name = "persona")
	@SchemaValidation
	List<Persona> listar();

}

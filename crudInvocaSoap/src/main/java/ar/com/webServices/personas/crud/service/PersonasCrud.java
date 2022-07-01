package ar.com.webServices.personas.crud.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.2 2022-06-26T13:06:53.123-03:00
 * Generated source version: 3.5.2
 *
 */
@WebService(targetNamespace = "http://cxf.com.ar/personas", name = "PersonasCrud")
@XmlSeeAlso({ ObjectFactory.class })
public interface PersonasCrud {

	@WebMethod
	@RequestWrapper(localName = "listar", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.Listar")
	@ResponseWrapper(localName = "listarResponse", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.ListarResponse")
	@WebResult(name = "persona", targetNamespace = "")
	public java.util.List<Persona> listar();

	@WebMethod
	@RequestWrapper(localName = "obtenerPorDni", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.ObtenerPorDni")
	@ResponseWrapper(localName = "obtenerPorDniResponse", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.ObtenerPorDniResponse")
	@WebResult(name = "persona", targetNamespace = "")
	public Persona obtenerPorDni(

			@WebParam(name = "dni", targetNamespace = "") java.lang.String dni) throws PersonaNotFoundException;

	@WebMethod
	@RequestWrapper(localName = "eliminar", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.Eliminar")
	@ResponseWrapper(localName = "eliminarResponse", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.EliminarResponse")
	@WebResult(name = "resultadoEliminar", targetNamespace = "")
	public boolean eliminar(

			@WebParam(name = "dni", targetNamespace = "") java.lang.String dni) throws PersonaNotFoundException;

	@WebMethod
	@RequestWrapper(localName = "agregar", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.Agregar")
	@ResponseWrapper(localName = "agregarResponse", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.AgregarResponse")
	@WebResult(name = "resultadoAgregar", targetNamespace = "")
	public boolean agregar(

			@WebParam(name = "persona", targetNamespace = "") Persona persona) throws PersonaRepetidaException;

	@WebMethod
	@RequestWrapper(localName = "modificar", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.Modificar")
	@ResponseWrapper(localName = "modificarResponse", targetNamespace = "http://cxf.com.ar/personas", className = "ar.com.personas.crud.service.ModificarResponse")
	@WebResult(name = "resultadoModificar", targetNamespace = "")
	public boolean modificar(

			@WebParam(name = "persona", targetNamespace = "") Persona persona) throws PersonaNotFoundException;
}


package ar.com.webServices.personas.crud.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.com.personas.crud.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Agregar_QNAME = new QName("http://cxf.com.ar/personas", "agregar");
    private final static QName _AgregarResponse_QNAME = new QName("http://cxf.com.ar/personas", "agregarResponse");
    private final static QName _Eliminar_QNAME = new QName("http://cxf.com.ar/personas", "eliminar");
    private final static QName _EliminarResponse_QNAME = new QName("http://cxf.com.ar/personas", "eliminarResponse");
    private final static QName _Listar_QNAME = new QName("http://cxf.com.ar/personas", "listar");
    private final static QName _ListarResponse_QNAME = new QName("http://cxf.com.ar/personas", "listarResponse");
    private final static QName _Modificar_QNAME = new QName("http://cxf.com.ar/personas", "modificar");
    private final static QName _ModificarResponse_QNAME = new QName("http://cxf.com.ar/personas", "modificarResponse");
    private final static QName _ObtenerPorDni_QNAME = new QName("http://cxf.com.ar/personas", "obtenerPorDni");
    private final static QName _ObtenerPorDniResponse_QNAME = new QName("http://cxf.com.ar/personas", "obtenerPorDniResponse");
    private final static QName _PersonaNotFound_QNAME = new QName("http://cxf.com.ar/personas", "PersonaNotFound");
    private final static QName _PersonaRepetida_QNAME = new QName("http://cxf.com.ar/personas", "PersonaRepetida");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.com.personas.crud.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Agregar }
     * 
     */
    public Agregar createAgregar() {
        return new Agregar();
    }

    /**
     * Create an instance of {@link AgregarResponse }
     * 
     */
    public AgregarResponse createAgregarResponse() {
        return new AgregarResponse();
    }

    /**
     * Create an instance of {@link Eliminar }
     * 
     */
    public Eliminar createEliminar() {
        return new Eliminar();
    }

    /**
     * Create an instance of {@link EliminarResponse }
     * 
     */
    public EliminarResponse createEliminarResponse() {
        return new EliminarResponse();
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link Modificar }
     * 
     */
    public Modificar createModificar() {
        return new Modificar();
    }

    /**
     * Create an instance of {@link ModificarResponse }
     * 
     */
    public ModificarResponse createModificarResponse() {
        return new ModificarResponse();
    }

    /**
     * Create an instance of {@link ObtenerPorDni }
     * 
     */
    public ObtenerPorDni createObtenerPorDni() {
        return new ObtenerPorDni();
    }

    /**
     * Create an instance of {@link ObtenerPorDniResponse }
     * 
     */
    public ObtenerPorDniResponse createObtenerPorDniResponse() {
        return new ObtenerPorDniResponse();
    }

    /**
     * Create an instance of {@link PersonaNotFound }
     * 
     */
    public PersonaNotFound createPersonaNotFound() {
        return new PersonaNotFound();
    }

    /**
     * Create an instance of {@link PersonaRepetida }
     * 
     */
    public PersonaRepetida createPersonaRepetida() {
        return new PersonaRepetida();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Agregar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Agregar }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "agregar")
    public JAXBElement<Agregar> createAgregar(Agregar value) {
        return new JAXBElement<Agregar>(_Agregar_QNAME, Agregar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgregarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "agregarResponse")
    public JAXBElement<AgregarResponse> createAgregarResponse(AgregarResponse value) {
        return new JAXBElement<AgregarResponse>(_AgregarResponse_QNAME, AgregarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "eliminar")
    public JAXBElement<Eliminar> createEliminar(Eliminar value) {
        return new JAXBElement<Eliminar>(_Eliminar_QNAME, Eliminar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "eliminarResponse")
    public JAXBElement<EliminarResponse> createEliminarResponse(EliminarResponse value) {
        return new JAXBElement<EliminarResponse>(_EliminarResponse_QNAME, EliminarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "listar")
    public JAXBElement<Listar> createListar(Listar value) {
        return new JAXBElement<Listar>(_Listar_QNAME, Listar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "listarResponse")
    public JAXBElement<ListarResponse> createListarResponse(ListarResponse value) {
        return new JAXBElement<ListarResponse>(_ListarResponse_QNAME, ListarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Modificar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Modificar }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "modificar")
    public JAXBElement<Modificar> createModificar(Modificar value) {
        return new JAXBElement<Modificar>(_Modificar_QNAME, Modificar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModificarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "modificarResponse")
    public JAXBElement<ModificarResponse> createModificarResponse(ModificarResponse value) {
        return new JAXBElement<ModificarResponse>(_ModificarResponse_QNAME, ModificarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPorDni }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerPorDni }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "obtenerPorDni")
    public JAXBElement<ObtenerPorDni> createObtenerPorDni(ObtenerPorDni value) {
        return new JAXBElement<ObtenerPorDni>(_ObtenerPorDni_QNAME, ObtenerPorDni.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerPorDniResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerPorDniResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "obtenerPorDniResponse")
    public JAXBElement<ObtenerPorDniResponse> createObtenerPorDniResponse(ObtenerPorDniResponse value) {
        return new JAXBElement<ObtenerPorDniResponse>(_ObtenerPorDniResponse_QNAME, ObtenerPorDniResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonaNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonaNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "PersonaNotFound")
    public JAXBElement<PersonaNotFound> createPersonaNotFound(PersonaNotFound value) {
        return new JAXBElement<PersonaNotFound>(_PersonaNotFound_QNAME, PersonaNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonaRepetida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonaRepetida }{@code >}
     */
    @XmlElementDecl(namespace = "http://cxf.com.ar/personas", name = "PersonaRepetida")
    public JAXBElement<PersonaRepetida> createPersonaRepetida(PersonaRepetida value) {
        return new JAXBElement<PersonaRepetida>(_PersonaRepetida_QNAME, PersonaRepetida.class, null, value);
    }

}

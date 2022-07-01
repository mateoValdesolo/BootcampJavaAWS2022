
package ar.com.webServices.personas.crud.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para agregarResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="agregarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultadoAgregar" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agregarResponseType", propOrder = {
    "resultadoAgregar"
})
public class AgregarResponse {

    protected boolean resultadoAgregar;

    /**
     * Obtiene el valor de la propiedad resultadoAgregar.
     * 
     */
    public boolean isResultadoAgregar() {
        return resultadoAgregar;
    }

    /**
     * Define el valor de la propiedad resultadoAgregar.
     * 
     */
    public void setResultadoAgregar(boolean value) {
        this.resultadoAgregar = value;
    }

}

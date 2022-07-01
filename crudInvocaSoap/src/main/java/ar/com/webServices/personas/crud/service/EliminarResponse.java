
package ar.com.webServices.personas.crud.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminarResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultadoEliminar" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminarResponseType", propOrder = {
    "resultadoEliminar"
})
public class EliminarResponse {

    protected boolean resultadoEliminar;

    /**
     * Obtiene el valor de la propiedad resultadoEliminar.
     * 
     */
    public boolean isResultadoEliminar() {
        return resultadoEliminar;
    }

    /**
     * Define el valor de la propiedad resultadoEliminar.
     * 
     */
    public void setResultadoEliminar(boolean value) {
        this.resultadoEliminar = value;
    }

}

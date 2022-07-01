
package ar.com.webServices.personas.crud.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificarResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultadoModificar" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificarResponseType", propOrder = {
    "resultadoModificar"
})
public class ModificarResponse {

    protected boolean resultadoModificar;

    /**
     * Obtiene el valor de la propiedad resultadoModificar.
     * 
     */
    public boolean isResultadoModificar() {
        return resultadoModificar;
    }

    /**
     * Define el valor de la propiedad resultadoModificar.
     * 
     */
    public void setResultadoModificar(boolean value) {
        this.resultadoModificar = value;
    }

}

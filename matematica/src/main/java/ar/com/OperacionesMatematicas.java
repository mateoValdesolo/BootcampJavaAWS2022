package ar.com;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.annotations.SchemaValidation;

import ar.com.exceptions.DivisionPorZeroException;

@WebService(targetNamespace = "http://cxf.com.ar/matematica")
public interface OperacionesMatematicas {

	@WebMethod(operationName = "suma")
	@WebResult(name = "resultadoSuma")
	@SchemaValidation
	int suma(int a, int b);

	@WebMethod(operationName = "resta")
	@WebResult(name = "resultadoResta")
	@SchemaValidation
	int resta(int a, int b);

	@WebMethod(operationName = "multiplicacion")
	@WebResult(name = "resultadoMultiplicacion")
	@SchemaValidation
	int multiplicacion(int a, int b);

	@WebMethod(operationName = "division")
	@WebResult(name = "resultadoDivision")
	@SchemaValidation
	double division(double a, double b) throws DivisionPorZeroException;

}
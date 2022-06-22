package ar.com;

import javax.jws.WebService;

import ar.com.exceptions.DivisionPorZeroException;

@WebService
public class OperacionesMatematicasImpl implements OperacionesMatematicas {

	@Override
	public int suma(int a, int b) {
		return a + b;
	}

	@Override
	public int resta(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplicacion(int a, int b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) throws DivisionPorZeroException {
		return a / b;
	}

}

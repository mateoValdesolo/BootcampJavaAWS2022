package clase3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo Valdesolo
 * 
 */
public class EjerciciosClase3 {

	public static void main(String[] args) {


	}

	public static long factorial(long num) {
		/*
		 * Recibe un entero num, y retorna su factorial. Uso long en vez de int, ya que
		 * long tiene mayor rango de representacion.
		 */
		long fact;
		if (num == 1) {
			fact = 1;
		} else {
			fact = num * factorial(num - 1);
		}
		return fact;
	}

	public static int recProd(int num, int num2) {
		/*
		 * Calcula el producto de dos enteros sin utilizar multiplicacion, sin usar
		 * metodo auxiliar.
		 */
		if (num2 == 0 || num == 0) {
			return 0;
		} else if (num2 == 1) {
			return num;
		} else {
			return num + recProd(num, num2 - 1);
		}
	}

	public static int recProd2(int num, int num2) {
		/*
		 * Otra forma de calcular el producto de dos enteros sin utilizar
		 * multiplicacion. Uso un metodo auxiliar para calcular el producto, y sumar el
		 * numero mas grande de los dos, para realizar menos sumas.
		 */
		int prod;
		if (num2 == 0 || num == 0) {
			prod = 0;
		} else {
			if (num < num2) {
				prod = recProdAux(num, num2, 0);
			} else {
				prod = recProdAux(num2, num, 0);
			}
		}
		return prod;
	}

	public static int recProdAux(int num, int num2, int ac) {
		/* Sumo num veces num2 */
		if (num == 1) {
			ac = num2;
		} else {
			ac += num2 + recProdAux(num - 1, num2, ac);
		}
		return ac;
	}

	public static String reverse(String str) {
		if (str.length() == 1) {
			return str;
		} else {
			return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
		}
	}

	public static boolean esSumaDeConsecutivos(int num) {
		/*
		 * Metodo que devuelve un boolean indicando si num formado por la suma de
		 * numeros consecutivos menores.
		 */
		int first = (num / 2) + 1, i = first, j = first, acum = 0;
		boolean success = false;
		while (!success && i > 0) {
			while (acum < num) {
				acum += j;
				j--;
			}
			if (num == acum) {
				success = true;
			} else {
				acum = 0;
			}
			i--;
			j = i;
		}
		return success;
	}

	public static List<Integer> listaSumaDeConsecutivos(int num) {
		/*
		 * Metodo que devuelve una lista con los numeros consecutivos menores que
		 * sumados forman a num.
		 */
		List<Integer> list = new ArrayList<Integer>();
		int first = (num / 2) + 1, i = first, j = first, acum = 0;
		boolean success = false;
		while (!success && i > 0) {
			while (acum < num) {
				acum += j;
				list.add(j);
				j--;
			}
			if (num == acum) {
				success = true;
			} else {
				acum = 0;
				list.clear();
			}
			i--;
			j = i;
		}
		return list;
	}

}

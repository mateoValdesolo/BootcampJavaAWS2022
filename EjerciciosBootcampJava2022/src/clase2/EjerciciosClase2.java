package clase2;

/**
*
* @author Mateo Valdesolo
* 
*/
public class EjerciciosClase2 {
	
	public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(decimaltoBinary(78));
        System.out.println(binaryToDecimal(101110.0));
        System.out.println(enteroCapicua(52));
    }

    public static boolean enteroCapicua(int num) {
        // Funcion que verifica si el entero num es capicua / palindromo.
        int aux = num, aux2 = 0;
        boolean res = false;
        while (aux != 0) {
            aux2 = aux2 * 10 + aux % 10;
            aux = aux / 10;
        }
        if (aux2 == num) {
            res = true;
        }
        return res;
    }

    public static long factorial(long num) {
        /*
         * Recibe un entero num, y retorna su factorial.
         * Uso long en vez de int, ya que long tiene mayor rango de representacion.
         */
        long fact;
        if (num == 1) {
            fact = 1;
        } else {
            fact = num * factorial(num - 1);
        }
        return fact;
    }

    public static double decimaltoBinary(int num) {
        /*
         * Metodo que recibe un entero en formato decimal y devuelve un double en
         * formato binario.
         */
        double binary;
        if (num == 0) {
            binary = 0;
        } else {
            binary = (num % 2) + 10 * (decimaltoBinary(num / 2));
        }
        return binary;
    }

    public static int binaryToDecimal(double num) {
        /*
         * Metodo que recibe un double en formato binario y devuelve un entero en
         * formato decimal.
         */
        int decimal;
        if (num == 0) {
            decimal = 0;
        } else {
            decimal = (int) (num % 2) + 2 * (binaryToDecimal(num / 10));
        }
        return decimal;
    }


}

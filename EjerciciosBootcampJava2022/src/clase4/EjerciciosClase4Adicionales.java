package clase4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mateo Valdesolo
 *
 */
public class EjerciciosClase4Adicionales {
	public static void main(String[] args) {
		
		// Construir un Stream de numeros naturales que contenga todos los números pares mayores o iguales a 10 y 20 menores o iguales a 20.
		Stream<Integer> str = Stream.iterate(10, x -> x + 2)
									.limit(6);
		
		// Presentar en una lista de Integer en forma ordenada.
		List<Integer> list = str.collect(Collectors.toList());
		
		//Muestro la lista.
		System.out.println(list);
		
		// Prueba de obtenerListaSecuencialCondicionada.
		System.out.println(obtenerListaSecuencialCondicionada(5,20, x -> x % 2 == 0));
		
		// Prueba de obtenerListaSecuencialCondicionadaMultiple.
		System.out.println(obtenerListaSecuencialCondicionadaMultiple(5,20, x -> x % 2 == 0, x -> x % 7 == 0));
		
		// Ejercicio 3
		String cadena = obtenerListaSecuencial(11,20).stream()
													.map(x -> String.valueOf(x))
																	.collect(Collectors.joining(" -> "));
		// Muestro la cadena
		System.out.println(cadena);
		
		cadena = obtenerListaSecuencial(4,6).stream()
											.map(x -> concatenacion(x))
											.reduce("", (x,y) -> x + y);
		// Muestro la cadena
		System.out.println(cadena);
		
		/**
		 * Tome un texto considerablemente largo de alguna página de internet y
		 * coloquelo en un String. Proceda a quitarle los simbolos de puntuación (, . ;). 
		 * Luego realice un split en base a los espacios en blanco. Asi obtenemos
		 * una arreglo de palabras.
		 */
		String text, result, split[];

		text = "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.";

		// Quito los simbolos de puntuacion.
		result = text.replaceAll("\\p{Punct}", "");
		
		// Separo el String en los espacios en blanco, asignando cada palabra a una posicion del arreglo.
		split = result.split(" ");
		
		// Proceso el arreglo quitando los duplicados y clasificando las palabras respecto a su dimension.
		Arrays.stream(split)
				.distinct()
				.collect(Collectors.groupingBy(String::length))
				.forEach((key,value) -> {
					System.out.println("\n" + key + " Letras [" + value.size() + "]:");
					value.stream().forEach(word -> System.out.println(word));
				});
		
		// Ejercicio 5
		// Con una Interface Funcional
		Funcion<Long,Long,Long> fn = new Funcion<Long,Long,Long>(){
			
			@Override
			public Long apply(Long t, Long w) {
				return (2*t) + (3*w);
			}
		};
		
		System.out.println("Prueba con Interface: "+ eval(fn,3L,4L));
		
		// Con BIFunction
		BiFunction<Long, Long, Long> biFunc = new BiFunction<Long, Long, Long>(){
			
			@Override
			public Long apply(Long x, Long y) {
				return (2*x) + (3*y);
			}
			
		};
		
		System.out.println("Prueba con BIFunction: "+ evalBiFunc(biFunc,3L,4L));
		
		// Aplicando Currying
		Function<Long,
				Function<Long, Long> >
			funcCurr = x -> y -> (2*x) + (3*y);
		
		System.out.println("Prueba con Currying: "+ evalFunc(funcCurr,3L,4L));
		
		// Funcion de tres parametros
		Function<Long, 
				Function<Long, 
						Function<Long,Long> > >
			triFunc = x -> y -> z -> (2*x) + (3*y) + (4*z);
			
		System.out.println("Prueba funcion con tres parametros: "+ evalTriFunc(triFunc,3L,4L,5L));
		
	}
	
	// Ejercicio 5
	@FunctionalInterface
	public interface Funcion<T, W, X> {
		X apply(T t, W w);		
	}
	
	@SafeVarargs
	public static <T> T eval(Funcion<T, T, T> func, T ... params) {
		return func.apply(params[0], params[1]);
	}
	
	@SafeVarargs
	public static <T> T evalBiFunc(BiFunction<T, T, T> func, T ... params) {
		return func.apply(params[0], params[1]);
	}
	
	@SafeVarargs
	public static <T> T evalFunc(Function<T, Function<T, T>> f, T ... params) {
		return f.apply(params[0])
				.apply(params[1]);
	}
	
	@SafeVarargs
	public static <T> T evalTriFunc(Function<T, Function<T, Function<T, T>>> f, T ... params) {
		return f.apply(params[0])
				.apply(params[1])
				.apply(params[2]);
	}
			
	public static String concatenacion(Integer num) {
		// Concatena en un String num veces el numero num.
		String conc = "";
		for (int i = 0; i < num; i++) {
			conc += num;
		}
		return conc;
	}
	
	public static List<Integer> obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate<Integer> condicion){
		return Stream.iterate(Optional.ofNullable(desde)
										.orElse(1), 
										x -> x <= Optional.ofNullable(hasta)
															.orElse(100),
										x -> x + 1)
					.filter(Optional.ofNullable(condicion)
									.orElse(x -> true))
					.collect(Collectors.toList());
	}
	
	public static List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones){
		Predicate<Integer> conditions = Optional.ofNullable(condiciones)
												.orElse(List.of(x -> true))
												.stream()
												.reduce((x,y) -> x.and(y))
												.orElse(x -> true);
		
		return obtenerListaSecuencialCondicionada(desde,hasta, conditions);
	}
	
	@SafeVarargs
	public static List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer> ... condiciones){
		return obtenerListaSecuencialCondicionadaMultiple(desde,hasta,Arrays.asList(Optional.ofNullable(condiciones).orElse(null)));
	}
	
	public static List<Integer> obtenerListaSecuencial(Integer desde, Integer hasta){
		return obtenerListaSecuencialCondicionada(desde,hasta,null);
	}
	
	

}

package org.formacion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Para las soluciones de estos ejercicios utiliza streams, las 
 * operaciones intermedias que necesites y una operación terminal
 * con una estructura mutante.
 */
public class ReduccionesUtil {

	/**
	 * Devuelve una coleccion con los Strings de la lista original con:
	 *  - los nulls eliminados del resultado
	 *  - el resto pasado a mayúsculas.
	 *  
	 *  Es decir, si pasamos
	 *  {"a",null,"b",null} debe devolver {"A","B"}
	 *  
	 */
	public Collection<String> obtenSinNulosYMayusculas(List<String> original) {
		
		return original
				.stream()
				.filter(Objects::nonNull)
				.map(String::toUpperCase)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Devolver un array de dos enteros. En la posicion 0 con 
	 * el numero de pares encontrado en la lista de numeros y en 
	 * la posicion 1 el numero de impares
	 * 
	 * Por ejemplo, 
	 * si numeros es { 0, 1, 2, 4 } debe devolver [3,1]
	 */
	public int[] paresImpares (List<Integer> numeros) {
		
		/* Ir acumulando en la posicion 0 el recuento de pares
		 * y en la posicion 1 el recuento de impares
		 */
		int[] acumular = {0,0};

		acumular[0] = (int) numeros.stream().filter(numero -> numero % 2 == 0).count();
		acumular[1] = (int) numeros.stream().filter(numero -> numero % 2 != 0).count();

		return acumular;
		
	}
	
}

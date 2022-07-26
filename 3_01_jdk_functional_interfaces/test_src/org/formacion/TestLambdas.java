package org.formacion;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.Test;

public class TestLambdas {

	/**
	 * Modificad el test asignando a la variable cuadrado una expresion que produzca un
	 * IntUnaryOperator que, dado un entero, devuelva su cuadrado.
	 */
	
	@Test
	public void test_function() {
		
		IntUnaryOperator cuadrado = x -> x * x;
		
		assertEquals(0, cuadrado.applyAsInt(0));
		assertEquals(1, cuadrado.applyAsInt(1));
		assertEquals(4, cuadrado.applyAsInt(2));
		assertEquals(9, cuadrado.applyAsInt(3));
	}
	
	/**
	 * Igual que el anterior, sustituid el null asignado a menor por una expresion que 
	 * produzca un operador que devuelva el menor de dos numeros
	 */
	@Test
	public void test_funcion_2() {
		
		LongBinaryOperator menor = Math::min;
		
		assertEquals(-2, menor.applyAsLong(-2, 3));
		assertEquals(5, menor.applyAsLong(10, 5));
	}
	
	/**
	 * En los siguientes ejercicios debereis implementar tanto la declaracion de la 
	 * interface funcional como la lambda expression a assignar.
	 * Se utiliza el termino generico funcion, pero la opcion a usar puede ser cualquier tipo de 
	 * interface funcional del JDK
	 * Este ejercicio no tiene pruebas unitarias, ya que parte del ejercicio es determinar que tipo
	 * es el mas adecuado en cada caso y, sin la variable declarada con su tipo, es dificil hacer un test!
	 * Por este motivo, debereis probar vosotros mismos vuestros resultados. Para facilitaros las pruebas
	 * se crean tres personas con distintos apellidos.
	 */
	@Test
	public void test_extras() {
		
		// personas creadas para las pruebas
		Persona personaSinSegundoApellido = new Persona ("nombre","apellido1",null);
		Persona personaConSegundoApellido = new Persona ("nombre", "apellido1", "apellido2");
		Persona personaNoPariente = new Persona ("nombre","otro","otro");
		
		// Cread una funcion que indique si el segundo apellido de una persona es null
		Predicate<Persona> segundoApellidoNull = (Persona a) -> a.getApellido2() == null;
		assertTrue(segundoApellidoNull.test(personaSinSegundoApellido));
		assertFalse(segundoApellidoNull.test(personaConSegundoApellido));

		// Una funcion que nos diga si dos personas son parientes: para nosotros parientes
		// son personas con el mismo primer apellido
		BiFunction<Persona, Persona, Boolean> parientes = (a, b) -> a.getApellido1().equals(b.getApellido1());
		assertTrue(parientes.apply(personaConSegundoApellido, personaSinSegundoApellido));
		assertFalse(parientes.apply(personaConSegundoApellido, personaNoPariente));

		// Una funcion que "enmascare" los datos de una persona: debe permutar los valores de sus
		// y nombre
		Function<Persona, Persona> enmascarar = (Persona a) -> new Persona(a.getApellido1(), a.getApellido2(), a.getNombre());
		assertEquals(personaConSegundoApellido.getNombre(), enmascarar.apply(personaConSegundoApellido).getApellido2());
		assertEquals(personaConSegundoApellido.getApellido1(), enmascarar.apply(personaConSegundoApellido).getNombre());
		assertEquals(personaConSegundoApellido.getApellido2(), enmascarar.apply(personaConSegundoApellido).getApellido1());

	}
	
	
	@Test
	public void test_validadores() {

		/**
		 * Modificad la clase validador conforme las instrucciones que encontrareis ahi
		 *
		 * Hecho esto, descomentad el codigo que sigue (que, con vuestros cambios en Validador deberia
		 * compilar excepto por el contenido en la invocacion al metodo add.
		 * Como parametro al metodo add debereis pasar una expresion que produzca el tipo de funcion que
		 * hayais decidido que usa la clase Validador
		 */
		Validador<Persona> validador = new Validador<>();
		
		validador.add((Persona a) -> a.getApellido1() != null);
		
		assertTrue(validador.valida(new Persona("nombre","ape1","ape2")));
		assertFalse(validador.valida(new Persona("nombre",null,"ape2")));

	}
	
	
}

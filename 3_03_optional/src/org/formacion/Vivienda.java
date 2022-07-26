package org.formacion;

import java.util.Optional;

public class Vivienda {

	private Optional<Persona> propietario;
	
	private String nombre;

	public Vivienda(Persona propietario, String nombre) {
		this.nombre = nombre;
		this.propietario = Optional.of(propietario);
	}
	
	public Vivienda(String nombre) {
		this.nombre = nombre;
		this.propietario = Optional.empty();
	}

	public Optional<Persona> getPropietario() {
		return propietario;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Optional<String> nombrePropietario() {
		if (this.propietario.isPresent())
			return Optional.of(propietario.get().getNombre());
		else
			return Optional.empty();
	}
	
	
}

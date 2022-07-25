package org.formacion;

import java.util.Collection;
import java.util.List;

public interface Agrupador {

	void add (Object elemento);

	default void addAll(List<Object> elementos) {
		for (Object elemento : elementos) {
			this.add(elemento);
		}
	}
	
	int numeroElementos();
	
}

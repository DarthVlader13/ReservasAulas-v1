package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Aula {

	// DECLARACIÓN DE ATRIBUTOS
	private String nombre;

	// CONSTRUCTOR CON PARAMETROS
	public Aula (String nombre){
		setNombre(nombre);
	}

	// GENERAMOS GETTER Y SETTER
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	private void setNombre(String nombre) {
		if (nombre==null) {
			throw new NullPointerException("ERROR: El nombre del aula no puede ser nulo.");
		}
		else if (nombre.isBlank()) {
			throw new IllegalArgumentException("ERROR: El nombre del aula no puede estar vacío.");
		}
			this.nombre = nombre;
	}

	// CONSTRUCTOR COPIA
	public Aula (Aula a) {
		if (a==null) {
			throw new NullPointerException("ERROR: No se puede copiar un aula nula.");
		}
		setNombre(a.getNombre());
	}

	// GENERAMOS METODOS HASDHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(nombre, other.nombre);
	}

	// METODO STRING
	@Override
	public String toString() {
		return "nombre Aula=" + nombre;
	}

}

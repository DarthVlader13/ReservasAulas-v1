package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Aula {

	// DECLARACIÓN DE ATRIBUTOS
	private String nombre;

	// CONSTRUCTOR CON PARAMETROS
	public Aula(String nombre) {
		super();
		this.nombre = nombre;
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
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre del aula no puede ser nulo.");
		} else if (nombre.isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre del aula no puede estar vacío.");
		} else {
			this.nombre = nombre;
		}

	}

	// CONSTRUCTOR COPIA
	public Aula(Aula otraAula) {
		if (otraAula == null) {
			throw new NullPointerException("ERROR: No se puede copiar un aula nula.");
		} else {
			setNombre(otraAula.getNombre());
		}
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

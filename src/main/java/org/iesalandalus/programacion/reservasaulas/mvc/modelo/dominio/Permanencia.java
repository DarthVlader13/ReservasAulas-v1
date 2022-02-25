package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {

	// DECLARACIÓN DE VARIABLES Y CONSTANTES.
	private Tramo tramo;
	private LocalDate dia;
	private final static DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// CONSTRUCTOR CON PARAMETROS
	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

	// CONSTRUCTOR COPIA
	public Permanencia(Permanencia otraPermanencia) {
		if (otraPermanencia == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		} else {
			setDia(otraPermanencia.getDia());
			setTramo(otraPermanencia.getTramo());
		}
	}

	// GENERAMOS GETTER Y SETTER CON POSIBLES NULL DE DIA Y TRAMO
	/**
	 * @return the tramo
	 */
	public Tramo getTramo() {
		return tramo;
	}

	/**
	 * @param tramo the tramo to set
	 */
	private void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new NullPointerException("ERROR: El tramo de una permanencia no puede ser nulo.");
		}
		this.tramo = tramo;
	}

	/**
	 * @return the dia
	 */
	public LocalDate getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	private void setDia(LocalDate dia) {
		if (dia == null) {
			throw new NullPointerException("ERROR: El día de una permanencia no puede ser nulo.");
		}
		this.dia = dia;

	}
	
	//GENERAMOS HASCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permanencia other = (Permanencia) obj;
		return Objects.equals(dia, other.dia) && tramo == other.tramo;
	}
	
	//MÉTODO TOSTRING
	@Override
	public String toString() {

		return "dia=" + dia.format(FORMATO_DIA)+ ", tramo=" + tramo + "";
	}

}

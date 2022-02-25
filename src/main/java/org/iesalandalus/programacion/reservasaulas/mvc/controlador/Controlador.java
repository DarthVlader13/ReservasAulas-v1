package org.iesalandalus.programacion.reservasaulas.mvc.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Vista;

public class Controlador {
	
	// DECLARACIÓN DE ATRIBUTOS
	private Modelo modelo;
	private Vista vista;

	// CREAMOS CONSTRUCTOR CON PARÁMETROS DE MODELO Y VISTA
	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
		}
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}

	// CREAMOS MÉTODO COMENZAR
	public void comenzar() {
		vista.comenzar();
	}

	// CREAMOS MÉTODO TERMINAR
	public void terminar() {
		System.exit(0);
	}

	// CREAMOS MÉTODO INSERTARAULA
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		modelo.insertarAula(aula);
	}
	
	// CREAMOS MÉTODO INSERTARPROFESOR
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.insertarProfesor(profesor);
	}

	// CREAMOS MÉTODO BORRARAULA
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		modelo.borrarAula(aula);
	}
	
	// CREAMOS MÉTODO BORRARPROFESOR
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.borrarProfesor(profesor);
	}

	// CREAMOS MÉTODO BUSCARAAULA
	public Aula buscarAula(Aula aula) {
		Aula aulaBuscada = modelo.buscarAula(aula);
		return aulaBuscada;
	}

	// CREAMOS MÉTODO BUSCARPROFESOR
	public Profesor buscarProfesor(Profesor profesor) {
		Profesor profesorBuscado = modelo.buscarProfesor(profesor);
		return profesorBuscado;
	}

	// CREAMOS MÉTODO REPRESENTARAULAS
	public List<String> representarAulas() {
		List<String> listaAulas = modelo.representarAulas();
		return listaAulas;
	}

	// CREAMOS MÉTODO REPRESENTARPROFESOR
	public List<String> representarProfesores() {
		List<String> listaProfesores = modelo.representarProfesores();
		return listaProfesores;
	}

	// CREAMOS MÉTODO REPRESENTARRESERVA
	public List<String> representarReservas() {
		List<String> listaReservas = modelo.representarReservas();
		return listaReservas;
	}

	// CREAMOS MÉTODO RALIZARRESERVA
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		modelo.realizarReserva(reserva);
	}

	// CREAMOS MÉTODO ANULARRESERVA
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		modelo.anularReserva(reserva);
	}

	// CREAMOS MÉTODO RESERVASAURLA
	public List<Reserva> getReservasAula(Aula aula) {
		List<Reserva> reservasAula = modelo.getReservasAula(aula);
		return reservasAula;
	}

	// CREAMOS MÉTODO RESERVASPROFESOR
	public List<Reserva> getReservasProfesor(Profesor profesor) {
		List<Reserva> reservasProfesor = modelo.getReservasProfesor(profesor);
		return reservasProfesor;
	}

	// CREAMOS MÉTODO RESERVASPERMANENCIA
	public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		List<Reserva> reservasPermanencia = modelo.getReservasPermanencia(permanencia);
		return reservasPermanencia;
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		boolean disponibilidad = modelo.consultarDisponibilidad(aula, permanencia);
		return disponibilidad;
	}

}

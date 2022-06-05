package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Tramo;

public class Vista {

	private final static String ERROR = "No existen reservas para el parámetro proporcionado";
	private final static String NOMBRE_VALIDO = "Manolo";
	private final static String CORREO_VALIDO = "manolo@eldelbombo.com";

	// DECLARACIÓN DE ATRIBUTOS
	private Controlador controlador;

	// CREAMOS CONSTRUCTOR DEFAULT
	public Vista() {
		Opcion.setVista(this);
	}

	// CREAMOS MÉTODO SETCONTROLADOR
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	// CREAMOS MÉTODO COMENZAR
	public void comenzar() {
		int ordinalOpcion = 0;
		do {
			try {
				Consola.mostrarMenu();
				ordinalOpcion = Consola.elegirOpcion();
				Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
				opcion.ejecutar();
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	// CREAMOS MÉTODO SALIR
	public void salir() {
		System.out.println("¡Hasta la próxima!");
		controlador.terminar();
	}

	// CREAMOS MÉTODO INSERTARAULA
	public void insertarAula() {
		boolean problema = false;
		do {
			try {
				controlador.insertarAula(Consola.leerAula());
				problema = false;
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
				problema = true;
			}
		} while (problema == true);
		System.out.println("Aula insertada correctamente.");
	}

	// CREAMOS MÉTODO BORRAR AULA
	public void borrarAula() {
		List<String> listaAulas = controlador.representarAulas();
		if (listaAulas == null) {
			System.out.println("No existen aulas que borrar");
		} else {
			try {
				controlador.borrarAula(Consola.leerAula());
				System.out.println("Aula borrada correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO BUSCARAULA
	public void buscarAula() {
		Aula aula = null;
		List<String> listaAulas = controlador.representarAulas();
		if (listaAulas == null) {
			System.out.println("No existen aulas que buscar");
		} else {
			try {
				aula = controlador.buscarAula(Consola.leerAula());
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (aula == null) {
				System.out.println("El aula buscada no existe");
			} else {
				System.out.println(aula.toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARAULA
	public void listarAulas() {
		List<String> listaAulas = null;
		try {
			listaAulas = controlador.representarAulas();
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaAulas == null) {
			System.out.println("No hay aulas que mostrar");
		} else {
//			for (String r : listaAulas) {
//				if (r != null) {
//					System.out.println(r.toString());
//				}
//			}
			Iterator<String> iterador = listaAulas.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO INSERTARPROFESOR
	public void insertarProfesor() {
		try {
			controlador.insertarProfesor(Consola.leerProfesor());
			System.out.println("Profesor insertado correctamente.");
		} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	// CREAMOS MÉTODO BORRARPROFESOR
	public void borrarProfesor() {
		List<String> listaProfesores = controlador.representarProfesores();
		if (listaProfesores == null) {
			System.out.println("No existen profesores que borrar");
		} else {
			try {
				Profesor profesorABorrar = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
				controlador.borrarProfesor(profesorABorrar);
				System.out.println("Profesor borrado correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO BUSCARPROFESOR
	public void buscarProfesor() {
		Profesor profesor = null;
		List<String> listaProfesores = controlador.representarProfesores();
		if (listaProfesores == null) {
			System.out.println("No existen profesores que buscar");
		} else {
			try {
				Profesor profesorABuscar = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
				profesor = controlador.buscarProfesor(profesorABuscar);
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			if (profesor == null) {
				System.out.println("El profesor buscado no existe");
			} else {
				System.out.println(profesor.toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARPROFESOR
	public void listarProfesores() {
		List<String> listaProfesores = null;
		try {
			listaProfesores = controlador.representarProfesores();
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaProfesores == null) {
			System.out.println("No hay profesores que mostrar");
		} else {
			Iterator<String> iterador = listaProfesores.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO REALIZARRESERVA
	public void realizarReserva() {
		Reserva reservaARealizar = null;
		try {
			String nombreProfesor = Consola.leerNombreProfesor();
			Profesor profesor = new Profesor(nombreProfesor, CORREO_VALIDO);
			if (controlador.buscarProfesor(profesor) == null) {
				System.out.println(
						"ERROR: El profesor introducido no existe. Por favor, creélo antes de intentar realizar una reserva con él.");
			} else {
				reservaARealizar = leerReserva(controlador.buscarProfesor(profesor));
				if (reservaARealizar == null) {
					System.out.println("ERROR: La fecha introducida debe ser posterior a la presente");
				} else if (controlador.buscarAula(reservaARealizar.getAula()) == null) {
					System.out.println(
							"ERROR: El aula introducida no existe. Por favor, creéla antes de intentar realizar una reserva con ella.");
				} else {
					controlador.realizarReserva(reservaARealizar);
					System.out.println("Reserva realizada correctamente.");
				}
			}
		} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	// CREAMOS MÉTODO LEERRESERVA
	private Reserva leerReserva(Profesor profesor) {

		Reserva reserva = null;
		Aula aula = null;
		Tramo tramo = null;
		LocalDate dia = null;
		Permanencia permanencia = null;
		try {
			aula = Consola.leerAula();
			tramo = Consola.leerTramo();
			dia = Consola.leerDia();
			permanencia = new Permanencia(dia, tramo);
			reserva = new Reserva(profesor, aula, permanencia);
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (dia.isBefore(LocalDate.now())) {
			reserva = null;
		} else {
			reserva = new Reserva(reserva);
		}
		return reserva;
	}

	// CREAMOS MÉTODO ANULAR RESERVA
	public void anularReserva() {

		Reserva reserva = null;
		Profesor profesor = new Profesor(NOMBRE_VALIDO, CORREO_VALIDO);
		List<String> listaReservas = controlador.representarReservas();
		if (listaReservas == null) {
			System.out.println("No existen reservas que borrar");
		} else {
			try {
				reserva = leerReserva(profesor);
				controlador.anularReserva(reserva);
				System.out.println("Reserva anulada correctamente.");
			} catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// CREAMOS MÉTODO LISTAR RESERVAS
	public void listarReservas() {
		List<String> listaReservas = null;
		try {
			listaReservas = controlador.representarReservas();
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaReservas == null) {
			System.out.println("No hay reservas que mostrar");
		} else {
			Iterator<String> iterador = listaReservas.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARRESERVASAULA
	public void listarReservasAula() {
		List<Reserva> listaReservasAula = null;
		try {
			listaReservasAula = controlador.getReservasAula(Consola.leerAula());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaReservasAula == null) {
			System.out.println(ERROR);
		} else {
			Iterator<Reserva> iterador = listaReservasAula.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARRESERVASPROFESOR
	public void listarReservasProfesor() {
		List<Reserva> listaReservasProfesor = null;
		try {
			Profesor profesorABuscar = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
			listaReservasProfesor = controlador.getReservasProfesor(profesorABuscar);
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaReservasProfesor == null) {
			System.out.println(ERROR);
		} else {
			Iterator<Reserva> iterador = listaReservasProfesor.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO LISTARRESERVASPERMANENCIA
	public void listarReservasPermanencia() {
		List<Reserva> listaReservasPermanencia = null;
		Permanencia permanencia = null;
		Tramo tramo = null;
		LocalDate dia = null;
		try {
			tramo = Consola.leerTramo();
			dia = Consola.leerDia();
			permanencia = new Permanencia(dia, tramo);
			listaReservasPermanencia = controlador.getReservasPermanencia(permanencia);
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (listaReservasPermanencia == null) {
			System.out.println(ERROR);
		} else {
			Iterator<Reserva> iterador = listaReservasPermanencia.iterator();
			while (iterador.hasNext()) {
				System.out.println(iterador.next().toString());
			}
		}
	}

	// CREAMOS MÉTODO CONSULTARDISPONIBILIDAD
	public void consultarDisponibilidad() {
		boolean disponible = true;
		Permanencia permanencia = null;
		Tramo tramo = null;
		LocalDate dia = null;
		Aula aula = null;
		try {
			tramo = Consola.leerTramo();
			dia = Consola.leerDia();
			permanencia = new Permanencia(dia, tramo);
			aula = Consola.leerAula();
			disponible = controlador.consultarDisponibilidad(aula, permanencia);
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (controlador.buscarAula(aula) == null) {
			System.out.println("El aula introducida no existe");
		} else if (disponible == true) {
			System.out.println("El aula se encuentra disponible para el tramo y día introducidos");
		} else {
			System.out.println("El aula NO se encuentra disponible para el tramo y día introducidos");
		}
	}

}

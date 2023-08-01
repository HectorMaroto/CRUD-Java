package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dao.DaoPersonas;

public class Persona {
	private String dni;
	private String nombre;
	private Date fecnac;
	private String dir;
	private int tfno;
	private static int index;
	
	public Persona() {
		
	}

	public Persona(String dni, String nombre, Date fecnac, String dir, int tfno) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecnac = fecnac;
		this.dir = dir;
		this.tfno = tfno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
	}
	
	public static void sumIndex() {
		Persona.index++;
	}
	
	public void insertar() throws SQLException, ClassNotFoundException {
		DaoPersonas.getInstance().insertarDao(this); //Insertamos un objeto persona en la base de datos.
	}
	
	public static ArrayList<Persona> obtener() throws ClassNotFoundException, SQLException {
		return DaoPersonas.getInstance().obtener();
	}
	
	public static void actualizarNombre(Persona p) throws ClassNotFoundException, SQLException {
		DaoPersonas.getInstance().updateNombre(p);
	}
	
	public static void eliminar() throws ClassNotFoundException, SQLException {
		DaoPersonas.getInstance().delete();
	}

	@Override
	public String toString() {
		return Persona.index+".-> Persona [dni=" + dni + ", nombre=" + nombre + ", fecnac=" + fecnac + ", dir=" + dir + ", tfno=" + tfno
				+ "]";
	}
	
	
	
	
}

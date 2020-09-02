package Datos;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	private String nombre, apellido, password;
	private int edad;
	private long cedula;

	public Persona(String nombre, String apellido, int edad, long dni){
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cedula = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public long getCedula() {
		return cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

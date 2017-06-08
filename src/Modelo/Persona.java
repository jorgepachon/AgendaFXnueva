package Modelo;

public class Persona {
	private String nombre;
	private String apellido;
	private String edad;

	public Persona(String nombre, String apellido, String telefono) {
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


}


public class Mascota {
	private String nombre;
	private String tipo;
	private String raza;
	private String edad;
	
	public Mascota(String nombre, String tipo, String raza, String edad) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.raza = raza;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Mascota [Nombre: " + nombre + ", Tipo: " + tipo + ", Raza: " + raza + ", Edad: " + edad + "]";
	}
}

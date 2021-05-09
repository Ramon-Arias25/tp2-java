
public class Doctor implements Comparable<Object> {
	private String nombre;
	private int cantConsuntas = 0;

	public Doctor(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Doctor(String nombre, int cantConsuntas) {
		super();
		this.nombre = nombre;
		this.cantConsuntas = cantConsuntas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantConsuntas() {
		return cantConsuntas;
	}

	public void setCantConsuntas(int cantConsuntas) {
		this.cantConsuntas = cantConsuntas;
	}

	@Override
	public String toString() {
		return "Doctor [Nombre: " + nombre + ", Cantidad de Consuntas: " + cantConsuntas + "]";
	}

	@Override
	public int compareTo(Object o) {
		Doctor d = (Doctor) o;
		if (this.getCantConsuntas() < d.getCantConsuntas()) {
			return -1;
		}
		if (this.getCantConsuntas() > d.getCantConsuntas()) {
			return 1;
		}
		return 0;
	}
}

import java.util.List;

public class ReporteDoctor extends Reporte {

	public ReporteDoctor(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public void Imprimir(List<Doctor> lista) {

		System.out.println("Imprimiendo Reporte: " + this.getNombre());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}

	}
}

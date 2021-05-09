import java.util.List;

public class ReporteMascota extends Reporte {
	
	public ReporteMascota(String nombre) {
		super();
		this.setNombre(nombre);
	}
	
	public void Imprimir(List<Mascota> lista) {
		
		System.out.println("Imprimiendo Reporte: " + this.getNombre());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
	}
}

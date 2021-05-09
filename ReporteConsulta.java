import java.util.List;

public class ReporteConsulta extends Reporte {

	public ReporteConsulta(String nombre) {
		super();
		this.setNombre(nombre);
	}


	public void Imprimir(List<Consulta> lista) {
		
		System.out.println("Imprimiendo Reporte: " + this.getNombre());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
	}
}
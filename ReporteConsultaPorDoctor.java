
import java.util.List;

public class ReporteConsultaPorDoctor extends Reporte {

	public ReporteConsultaPorDoctor (String nombre) {
			super();
			this.setNombre(nombre);
		}

	public void Imprimir(List<Doctor> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Doctor(a): " + lista.get(i).getNombre() + " Atendio: "
					+ lista.get(i).getCantConsuntas() + " Consulta(s)");
		}
	}
}
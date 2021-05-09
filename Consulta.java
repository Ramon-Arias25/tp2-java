import java.util.ArrayList;
import java.util.List;

public class Consulta {
	private Mascota mascota;
	private Doctor doctor;
	private String causa;
	private String diagnostico;
	private List<String> lmedicamentos = new ArrayList<String>();

	public Consulta() {
	}

	public Consulta(String causa, Mascota mascota) {
		super();
		this.causa = causa;
		this.mascota = mascota;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public List<String> getLmedicamentos() {
		return lmedicamentos;
	}

	public void setLmedicamentos(List<String> lmedicamentos) {
		this.lmedicamentos = lmedicamentos;
	}
	
	public void addLmedicamentos(String medicamentos) {
		this.lmedicamentos.add(medicamentos);
	}

	@Override
	public String toString() {
		return "Consulta: " + mascota + ", " + doctor + ", Causa: " + causa + ", Diagnostico: "
				+ diagnostico + ", Medicamentos: " + lmedicamentos + "]";
	}

}

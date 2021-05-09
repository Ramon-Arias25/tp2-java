import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Launch {
	static List<Mascota> listaMascotas = new ArrayList<Mascota>();
	static List<Doctor> listaDoctores = new ArrayList<Doctor>();
	static List<Consulta> listaConsultas = new ArrayList<Consulta>();

	public static void main(String[] args) {
		creaDoctores();
		menu();
	}

	public static void creaDoctores() {
		String[] nombresDoctores = { "Sofia Gonzalez", "Nicolas Rodriguez", "Valentina Gomez", "Santiago Fernandez",
				"Zoe Lopez" };

		for (int i = 0; i < nombresDoctores.length; i++) {
			Doctor aux = new Doctor(nombresDoctores[i]);
			// Doctor aux = new Doctor(nombresDoctores[i],i);
			// TODO try, catch
			if (listaDoctores.size() < 5) {
				listaDoctores.add(aux);
			} else {
				System.out.println("Limite de doctores alcanzado");
			}
		}
	}
	
	public static void menu() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while (!salir) {
			System.out.println("## MENU ##");
			System.out.println("1. Ingresar Mascota");
			System.out.println("2. Imprimir Reporte cantidad consultas por doctor.");
			System.out.println("3. Imprimir Reporte imprimirlistaDoctores");
			System.out.println("4. Imprimir Reporte imprimirlistaMascotas");
			System.out.println("5. Imprimir Reporte imprimirlistaConsultas");
			System.out.println("0. Salir");
			try {
				System.out.println("--> Seleccione un numero de operación <--");
				opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					creaConsulta();
					break;
				case 2:
					ReporteDoctor reporteConsultaPorDoctor = new ReporteDoctor("Consultas por Doctores");
					reporteConsultaPorDoctor.Imprimir(listaDoctores);
					break;
				case 3:
					ReporteDoctor reporteDoctor = new ReporteDoctor("Doctores");
					reporteDoctor.Imprimir(listaDoctores);
					break;
				case 4:
					ReporteMascota reporteMascota= new ReporteMascota("Mascotas");
					reporteMascota.Imprimir(listaMascotas);
					break;
				case 5:
					ReporteConsulta reporteConsulta= new ReporteConsulta("Consultas");
					reporteConsulta.Imprimir(listaConsultas);
					break;
				case 0:
					salir = true;
					break;
				default:
					System.out.println("Debe ingresar una opcion valida");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				teclado.next();
			}
		}
	}

	@SuppressWarnings("resource")
	public static Mascota ingresarMascota() {

		Scanner tecladoNombre = new Scanner(System.in);
		Scanner tecladoTipo = new Scanner(System.in);
		Scanner tecladoRaza = new Scanner(System.in);
		Scanner tecladoEdad = new Scanner(System.in);

		System.out.println("nombre:");
		String nombre = tecladoNombre.next();
		System.out.println("tipo:");
		String tipo = tecladoTipo.next();
		// TODO try catch
		if (!(tipo.equals("perro")) && !(tipo.equals("gato")) && !(tipo.equals("conejo"))) {
			System.out.println("Tipo de mascota no es valido. Solo puede ser perro, gato o conejo");
			return null;
		}
		System.out.println("raza:");
		String raza = tecladoRaza.next();
		System.out.println("edad:");
		String edad = tecladoEdad.next();

		Mascota mascota = new Mascota(nombre, tipo, raza, edad);
		listaMascotas.add(mascota);
		return mascota;
	}

	@SuppressWarnings("resource")
	public static void creaConsulta() {
		Mascota mascota = ingresarMascota();
		// TODO try,catch
		if (listaMascotas.size() < 20) {
			Scanner tecladoCausa = new Scanner(System.in);
			Scanner tecladoDiagnostico = new Scanner(System.in);
			Scanner tecladoSubMenu = new Scanner(System.in);

			System.out.println("Causa:");
			String causa = tecladoCausa.next();

			System.out.println("Diagnostico:");
			String Diagnostico = tecladoDiagnostico.next();

			Consulta nuevaConsulta = new Consulta(causa, mascota);

			listaDoctores.sort(null);
			listaDoctores.get(0).setCantConsuntas(listaDoctores.get(0).getCantConsuntas() + 1);

			nuevaConsulta.setDoctor(listaDoctores.get(0));
			nuevaConsulta.setDiagnostico(Diagnostico);

			boolean volver = false;
			int opcion;

			while (!volver) {
				System.out.println("## AGREGAR MEDICAMENTOS ##");
				System.out.println("1. Agregar Medicamentos");
				System.out.println("0. Volver");
				try {
					System.out.println("--> Seleccione un numero de operación <--");
					opcion = tecladoSubMenu.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("Ingrese medicamento");
						Scanner tecladoMedicamentos = new Scanner(System.in);
						String nuevoMedicamento = tecladoMedicamentos.next();
						nuevaConsulta.addLmedicamentos(nuevoMedicamento);
						break;
					case 0:
						volver = true;
						break;
					default:
						System.out.println("Debe ingresar una opcion valida");
					}
				} catch (InputMismatchException e) {
					System.out.println("Debes insertar un número");
					tecladoSubMenu.next();
				}
			}

			// agregar medicamento
			listaConsultas.add(nuevaConsulta);
		} else {
			System.out.println("ya se alcanzo el maximo de 20 consultas");
		}
	}

}

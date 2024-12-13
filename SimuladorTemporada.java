import java.util.Scanner;

public class SimuladorTemporada {
    private Calendario calendario;
    private Equipo equipoSeleccionado;
    private Scanner teclado = new Scanner(System.in);

    public SimuladorTemporada(Calendario calendario, Equipo equipoSeleccionado) {
        this.calendario = calendario;
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public void iniciarSimulacion() {
        System.out.println("\nIniciando simulación de temporada para: " + equipoSeleccionado.getNombre());
        calendario.imprimirCalendario(equipoSeleccionado);
        System.out.println("Presiona Enter para continuar");
        teclado.nextLine();

        int totalSemanas = calendario.getJornadas().size(); // Total de jornadas dinámico

        for (int semana = 1; semana <= totalSemanas; semana++) {
            System.out.println("\n--- Semana " + semana + " ---");
            calendario.avanzarSemana(semana);
            System.out.println("\nTabla General Actualizada:");
            calendario.mostrarTablaGeneral();
            System.out.println("Presiona Enter para continuar");
            teclado.nextLine();
        }

        System.out.println("\n--- Temporada finalizada ---");
        System.out.println("Tabla final:");
        calendario.mostrarTablaGeneral();
    }

}
public class SimuladorTemporada {
    private Calendario calendario;
    private Equipo equipoSeleccionado;

    public SimuladorTemporada(Calendario calendario, Equipo equipoSeleccionado) {
        this.calendario = calendario;
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public void iniciarSimulacion() {
        System.out.println("\nIniciando simulación de temporada para: " + equipoSeleccionado.getNombre());

        for (int semana = 1; semana <= 38; semana++) { // Máximo de semanas típico en ligas
            System.out.println("\n--- Semana " + semana + " ---");
            calendario.avanzarSemana(semana);
            System.out.println("\nTabla General Actualizada:");
            calendario.mostrarTablaGeneral();
        }

        System.out.println("\n--- Temporada finalizada ---");
        System.out.println("Tabla final:");
        calendario.mostrarTablaGeneral();
    }
}
import java.util.ArrayList;
import java.util.Collections;

public class Calendario {
    private ArrayList<ArrayList<Partido>> jornadas;
    private TablaGeneral tablaGeneral;

    public Calendario(ArrayList<Equipo> equipos) {
        jornadas = new ArrayList<>();
        tablaGeneral = new TablaGeneral(equipos);
        generarCalendario(equipos);
    }

    private void generarCalendario(ArrayList<Equipo> equipos) {
        if (equipos.size() % 2 != 0) {
            equipos.add(new Equipo());
        }

        int numEquipos = equipos.size();
        int numJornadas = numEquipos - 1;

        for (int i = 0; i < numJornadas; i++) {
            ArrayList<Partido> jornada = new ArrayList<>();
            Collections.shuffle(equipos);

            for (int j = 0; j < numEquipos / 2; j++) {
                Equipo local = equipos.get(j);
                Equipo visitante = equipos.get(numEquipos - j - 1);

                if (!local.getNombre().equals("Semana de Descanso") &&
                    !visitante.getNombre().equals("Semana de Descanso")) {
                    jornada.add(new Partido(local, visitante));
                }
            }
            jornadas.add(jornada);
        }

        for (int i = 0; i < numJornadas; i++) {
            ArrayList<Partido> jornada = new ArrayList<>();

            for (Partido partidoIda : jornadas.get(i)) {
                Equipo local = partidoIda.getVisitante();
                Equipo visitante = partidoIda.getLocal();

                jornada.add(new Partido(local, visitante));
            }
            jornadas.add(jornada);
        }
    }

    public void imprimirCalendario(Equipo equipo) {
        System.out.println("Calendario de partidos de " + equipo.getNombre() + ":");
        for (int i = 0; i < jornadas.size(); i++) {
            for (Partido partido : jornadas.get(i)) {
                if (partido.getLocal().equals(equipo) || partido.getVisitante().equals(equipo)) {
                    System.out.println("Semana " + (i + 1) + ": " + partido.getLocal().getNombre() + " vs " +
                            partido.getVisitante().getNombre());
                }
            }
        }
    }

    public void avanzarSemana(int semana) {
        if (semana > jornadas.size() || semana < 1) {
            System.out.println("Semana no válida.");
            return;
        }

        System.out.println("\nResultados de la semana " + semana + ":");
        for (Partido partido : jornadas.get(semana - 1)) {
            partido.jugarPartido();
            System.out.println(partido.getResultado());

            if (partido.getResultado().contains("\u001B[32m" + partido.getLocal().getNombre())) {
                tablaGeneral.actualizarTabla(partido.getLocal(), partido.getVisitante(), false);
            } else if (partido.getResultado().contains("\u001B[32m" + partido.getVisitante().getNombre())) {
                tablaGeneral.actualizarTabla(partido.getVisitante(), partido.getLocal(), false);
            } else {
                tablaGeneral.actualizarTabla(partido.getLocal(), partido.getVisitante(), true);
            }
        }
    }

    public void mostrarTablaGeneral() {
        tablaGeneral.mostrarTabla();
    }
}


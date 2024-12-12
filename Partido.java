import java.util.Random;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private String resultado;
    private static int contadorPartidos = 0;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = "";
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void jugarPartido() {
        Random random = new Random();
        int puntosLocal = local.getScore() + 20;
        int puntosVisitante = visitante.getScore();

        // Reducimos el rango aleatorio para aumentar la probabilidad de empates
        int casillasLocal = random.nextInt((int) (puntosLocal * 0.7)) + 1;
        int casillasVisitante = random.nextInt((int) (puntosVisitante * 0.7)) + 1;

        // Lógica para determinar el resultado
        if (casillasLocal > casillasVisitante) {
            resultado = "\u001B[32m" + local.getNombre() + "\u001B[0m (Ganador) vs \u001B[31m" + visitante.getNombre() + "\u001B[0m";
        } else if (casillasVisitante > casillasLocal) {
            resultado = "\u001B[31m" + local.getNombre() + "\u001B[0m vs \u001B[32m" + visitante.getNombre() + "\u001B[0m (Ganador)";
        } else {
            resultado = local.getNombre() + " y " + visitante.getNombre() + " han empatado";
        }

        // Agregamos un mensaje adicional si uno de los equipos es seleccionado por el usuario
        if (local.isSelected() || visitante.isSelected()) {
            resultado += " \u001B[33m(Tu equipo seleccionado)\u001B[0m";
        }
    }

    public String getResultado() {
        return resultado;
    }
}

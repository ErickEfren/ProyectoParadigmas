import java.util.Random;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private String resultado;

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
        int puntosLocal = local.getScore() + 20; // Ventaja como local
        int puntosVisitante = visitante.getScore();

        int casillasLocal = random.nextInt(puntosLocal) + 1;
        int casillasVisitante = random.nextInt(puntosVisitante) + 1;

        if (casillasLocal > casillasVisitante) {
            resultado = "Ganador: " + local.getNombre();
        } else if (casillasVisitante > casillasLocal) {
            resultado = "Ganador: " + visitante.getNombre();
        } else {
            resultado = "Empate entre " + local.getNombre() + " y " + visitante.getNombre();
        }
    }

    public String getResultado() {
        return resultado;
    }
}
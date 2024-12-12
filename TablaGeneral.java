import java.util.ArrayList;
import java.util.Comparator;

public class TablaGeneral {
    private ArrayList<Equipo> equipos;

    public TablaGeneral(ArrayList<Equipo> equipos) {
        this.equipos = new ArrayList<>(equipos);
    }

    public void actualizarTabla(Equipo ganador, Equipo perdedor, boolean empate) {
        if (empate) {
            ganador.incrementDraws();
            perdedor.incrementDraws();
        } else {
            ganador.incrementWins();
            perdedor.incrementLosses();
        }
    }

    public void mostrarTabla() {
        System.out.println("\nTabla General:");
        System.out.printf("%-3s %-20s %-5s %-5s %-5s %-5s\n", "ID", "Equipo", "PJ", "G", "E", "P");
        System.out.println("-------------------------------------------------");

        equipos.sort(Comparator.comparingInt((Equipo e) -> e.getWins() * 3 + e.getDraws())
                .thenComparingInt(Equipo::getWins)
                .reversed());

        for (Equipo equipo : equipos) {
            int partidosJugados = equipo.getWins() + equipo.getDraws() + equipo.getLosses();
            System.out.printf("%-3d %-20s %-5d %-5d %-5d %-5d\n",
                    equipo.getId(),
                    equipo.getNombre(),
                    partidosJugados,
                    equipo.getWins(),
                    equipo.getDraws(),
                    equipo.getLosses());
        }
    }
}
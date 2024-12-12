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
            ganador.addPoints(1);
            perdedor.incrementDraws();
            perdedor.addPoints(1);
        } else {
            ganador.incrementWins();
            ganador.addPoints(3);
            perdedor.incrementLosses();
        }
    }

    public void mostrarTabla() {
        System.out.println("\nTabla General:");
        System.out.printf("%-3s %-30s %-5s %-5s %-5s %-5s %-5s\n", "ID", "Equipo", "PJ", "G", "E", "P", "Pts");
        System.out.println("-------------------------------------------------------------------------");

        equipos.sort(Comparator.comparingInt((Equipo e) -> e.getPoints())
                .thenComparingInt(Equipo::getWins)
                .reversed());

        for (Equipo equipo : equipos) {
            int partidosJugados = equipo.getWins() + equipo.getDraws() + equipo.getLosses();
            
            if (equipo.isSelected()) {
                System.out.printf("\u001B[32m");
            } else {
                System.out.printf("\u001B[0m"); 
            }

            System.out.printf("%-3d %-30s %-5d %-5d %-5d %-5d %-5d \u001B[0m\n",
                    equipo.getId(),
                    equipo.getNombre(),
                    partidosJugados,
                    equipo.getWins(),
                    equipo.getDraws(),
                    equipo.getLosses(),
                    equipo.getPoints());
        }
    }
}
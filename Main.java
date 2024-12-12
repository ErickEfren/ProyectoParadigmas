import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void AddEquipos(ArrayList<Equipo> equipos) {
        equipos.add(new Equipo("Alaves", 45));
        equipos.add(new Equipo("Athletic", 96));
        equipos.add(new Equipo("Atletico de Madrid", 105));
        equipos.add(new Equipo("Barcelona", 114));
        equipos.add(new Equipo("Betis", 63));
        equipos.add(new Equipo("Celta de Vigo", 63));
        equipos.add(new Equipo("Getafe", 48));
        equipos.add(new Equipo("Girona", 66));
        equipos.add(new Equipo("Leganes", 45));
        equipos.add(new Equipo("Osasuna", 72));
        equipos.add(new Equipo("Espanyol", 29));
        equipos.add(new Equipo("Mayorca", 72));
        equipos.add(new Equipo("Rayo Vallecano", 57));
        equipos.add(new Equipo("Real Madrid", 108));
        equipos.add(new Equipo("Real Sociedad", 72));
        equipos.add(new Equipo("Sevilla", 57));
        equipos.add(new Equipo("Universidad de las Palmas", 54));
        equipos.add(new Equipo("Valencia", 30));
        equipos.add(new Equipo("Valladolid", 27));
        equipos.add(new Equipo("Villareal", 78));
    }

    private static void AgregarEquipo(ArrayList<Equipo> equipos) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa el nombre del equipo: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingresa el puntaje del equipo: ");
        int score = teclado.nextInt();
        equipos.add(new Equipo(nombre, score));
    }

    private static void EliminarEquipo(ArrayList<Equipo> equipos) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa el ID del equipo que quieras eliminar: ");
        int id = teclado.nextInt();
        for (Equipo equipo : equipos) {
            if (equipo.getId() == id) {
                equipos.remove(equipo);
                return;
            }
        }
        System.out.println("Equipo no encontrado.");
        EliminarEquipo(equipos);
    }

    private static void MostrarEquipos(ArrayList<Equipo> equipos) {
        System.out.printf("%-3s %-30s %-5s\n", "ID", "Equipo", "Puntos");
        for (Equipo equipo : equipos) {
            String color = equipo.isSelected() ? "\u001B[32m" : "\u001B[37m";
            System.out.printf(color + "%-3d %-30s %-5d \u001B[0m\n", equipo.getId(), equipo.getNombre(), equipo.getScore());
        }
    }

    private static void SeleccionarById(ArrayList<Equipo> equipos, int id) {
        for (Equipo equipo : equipos) {
            if (equipo.getId() == id) {
                equipo.setSelected(true);
                return;
            }
        }
        System.out.println("Equipo no encontrado.");
        SeleccionarById(equipos);
    }
    
    private static void SeleccionarById(ArrayList<Equipo> equipos) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa el ID del equipo que quieras seleccionar: ");
        int id = teclado.nextInt();
        SeleccionarById(equipos, id);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        AddEquipos(equipos);

        System.out.println("Quieres agregar un equipo?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = teclado.nextInt();

        while (opcion == 1) {
            AgregarEquipo(equipos);
            System.out.println("Quieres agregar otro equipo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = teclado.nextInt();
        }

        System.out.println("------------------------------------------");
        System.out.println("Quieres eliminar un equipo?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = teclado.nextInt();


        while (opcion == 1) {
            MostrarEquipos(equipos);
            EliminarEquipo(equipos);
            System.out.println("Quieres eliminar otro equipo?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = teclado.nextInt();
        }

        MostrarEquipos(equipos);

        System.out.print("Ingresa el ID del equipo que quieras seleccionar: ");
        int ID = teclado.nextInt();
        SeleccionarById(equipos, ID);

        Calendario calendario = new Calendario(equipos);
        Equipo equipoSeleccionado = equipos.stream().filter(Equipo::isSelected).findFirst().orElse(null);

        System.out.println("------------------------------------------");

        SimuladorTemporada simulador = new SimuladorTemporada(calendario, equipoSeleccionado);
        simulador.iniciarSimulacion();
    }
}

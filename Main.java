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

    //Método Sobrecargado
    private static boolean EliminarById(ArrayList<Equipo> equipos, int id) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == id) {
                System.out.println("Equipo eliminado: " + equipos.get(i).getNombre());
                equipos.remove(i);
                return true;
            }
        }
        return EliminarById(equipos);
    }

    private static boolean EliminarById(ArrayList<Equipo> equipos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el ID del equipo que quieras eliminar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == id) {
                System.out.println("Equipo eliminado: " + equipos.get(i).getNombre());
                equipos.remove(i);
                return true;
            }
        }
        System.out.println("No se encontro el equipo");
        return EliminarById(equipos);
    }

    //Método Sobrecargado
    private static void SeleccionarById(ArrayList<Equipo> equipos, int id) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == id) {
                equipos.get(i).setSelected(true);
                System.out.println("Equipo seleccionado: " + equipos.get(i).getNombre());
                return;
            }
        }
        System.out.println("No se encontro el equipo");
        SeleccionarById(equipos);
    }

    private static void SeleccionarById(ArrayList<Equipo> equipos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el ID del equipo que quieras seleccionar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == id) {
                equipos.get(i).setSelected(true);
                System.out.println("Equipo seleccionado: " + equipos.get(i).getNombre());
                return;
            }
        }
        System.out.println("No se encontro el equipo");
        SeleccionarById(equipos);
    }

    private static void MostrarEquipos(ArrayList<Equipo> equipos) {
        System.out.printf("%-3s %-30s %-5s\n", "ID", "Equipo", "Puntos");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < equipos.size(); i++) {
            String color = equipos.get(i).isSelected() ? "\u001B[32m" : "\u001B[37m";
            System.out.printf(color + "%-3d %-30s %-5d \u001B[0m \n", equipos.get(i).getId(), equipos.get(i).getNombre(), equipos.get(i).getScore());
        }
        System.out.println("-----------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        AddEquipos(equipos);

        MostrarEquipos(equipos);

        System.out.println("-----------------------------------------------");
        System.out.println("Estos son los equipos base, deseas agregar alguno? (S/N)");
        String resp = teclado.nextLine();
        while (resp.equalsIgnoreCase("S")) {
            System.out.println("Ingresa el nombre del equipo: ");
            String name = teclado.nextLine();
            System.out.println("Ingresa el puntaje del equipo: ");
            int score = teclado.nextInt();
            teclado.nextLine();

            equipos.add(new Equipo(name, score));
            System.out.println("Quieres agregar más equipos? (S/N)");
            resp = teclado.nextLine();
        }

        MostrarEquipos(equipos);

        System.out.println("-----------------------------------------------");
        System.out.println("Deseas eliminar algun equipo? (S/N)");
        resp = teclado.nextLine();
        while (resp.equalsIgnoreCase("S")) {
            boolean deleted = EliminarById(equipos);

            System.out.println("Deseas eliminar algun equipo mas? (S/N)");
            resp = teclado.nextLine();
        }

        MostrarEquipos(equipos);

        System.out.print("Ingresa el ID del equipo que quieras ser: ");
        int ID = teclado.nextInt();

        SeleccionarById(equipos, ID);

        equipos.generateMatches(equipos);
    }
}
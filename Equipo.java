public class Equipo {
    private String nombre;
    private int score, id, wins, losses, draws;
    private static int contadorEquipos = 0;
    private ArrayList<Equipo> rivals = new ArrayList<>();
    private boolean selected;
    

    public Equipo() {
        this.id = -1;
        this.selected = false;
        this.score = 0;
        this.nombre = "Semana de Descanso";
        this.rivals = new ArrayList<>();
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public Equipo(String nombre, int score) {
        this.id = contadorEquipos;
        this.nombre = nombre;
        this.score = score;
        this.selected = false;
        this.rivals = new ArrayList<>();
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        contadorEquipos++;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public int getId() {
        return this.id;
    }

    public boolean isSelected() {
        return this.selected;
    }

}


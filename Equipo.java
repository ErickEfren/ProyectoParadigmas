public class Equipo {
    private String nombre;
    private int score, id;
    private static int contadorEquipos = 0;
    private boolean selected;
    
    public Equipo(String nombre, int score) {
        this.id = contadorEquipos;
        this.nombre = nombre;
        this.score = score;
        this.selected = false;
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


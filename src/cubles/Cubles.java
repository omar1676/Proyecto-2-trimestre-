package cubles;

public class Cubles {

    private int id;
    private String nombre;
    private int edad;
    private  String presidente;
    private int primerEquipo;
    private  String Jugadores[];
    private int numeroCantera;
    private String JugadoresCantera [];
    public Cubles(int id, String nombre, int edad, String posicion, String presidente) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.presidente = presidente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPresidente() {
        return presidente;
    }

    @Override
    public String toString() {
        return nombre + " " + edad + " " + id + " " + presidente;
    }
}




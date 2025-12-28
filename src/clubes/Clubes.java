package clubes;

public class Clubes {

    private int id;
    private String nombre;
    private int fundacion;
    private  String presidente;
    private int primerEquipo;
    private  String Jugadores[];
    private int numeroCantera;
    private String jugadoresCantera [];
    public Clubes(int id, String nombre, int fundacion, String presidente, int primerEquipo, int numeroCantera) {
        this.id = id;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.presidente = presidente;
        this.primerEquipo = primerEquipo;
        this.numeroCantera = numeroCantera;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public int getPrimerEquipo() {
        return primerEquipo;
    }

    public int getNumeroCantera() {
        return numeroCantera;
    }

    @Override
    public String toString() {
        return nombre + " " + fundacion + " " + id + " " + presidente + " " + primerEquipo + " " + numeroCantera;
    }
}




package cubles;

public class Cubles {

    private int id;
    private String nombre;
    private int fundacion;
    private String presidente;
    private int numeroCantera;
    private int jugadoresEnEquipo;


    public Cubles(int id, String nombre, int fundacion, String presidente, int numeroCantera, int jugadoresEnEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.presidente = presidente;
        this.numeroCantera = numeroCantera;
        this.jugadoresEnEquipo = jugadoresEnEquipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnoFundacion() {
        return fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public int getNumeroCantera() {
        return numeroCantera;
    }

    public int getJugadoresEnEquipo() {
        return jugadoresEnEquipo;
    }

    @Override
    public String toString() {
        return nombre + " " + fundacion + " " + id + " " + presidente + " " + numeroCantera + " " + jugadoresEnEquipo;
    }
}




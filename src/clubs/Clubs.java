package clubs;

public class Clubs {

    private int id;
    private String nombre;
    private int fundacion;
    private String presidente;
    private int numeroCantera;
    private int jugadoresEnEquipo;
    private long patrimonioClub;


    public Clubs(int id, String nombre, int fundacion, String presidente, int numeroCantera, int jugadoresEnEquipo, long patrimonioClub) {
        this.id = id;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.presidente = presidente;
        this.numeroCantera = numeroCantera;
        this.jugadoresEnEquipo = jugadoresEnEquipo;
        this.patrimonioClub = patrimonioClub;
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

    public long getPatrimonioClub() {
        return patrimonioClub;
    }

    @Override
    public String toString() {
        return nombre + " " + fundacion + " " + presidente + " " + numeroCantera + " " + jugadoresEnEquipo +  " " + patrimonioClub;
    }
}




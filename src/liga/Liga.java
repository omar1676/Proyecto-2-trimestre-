package liga;

import clubes.Club;
import competicion.Competicion;
import partido.Partido;

import java.util.Random;

public class Liga extends Competicion {

    private Club[] clubes;
    private int numeroClubes;

    private Partido[][] calendario;
    private int numJornadas;
    private int jornadaActual;

    private int[] pj, pg, pe, pp, gf, gc, pts;

    private String[] ultimosResultados;
    private int numUltimosResultados;

    private Random random;

    public void Liga() {
    }

    public Liga(String nombre, Club[] clubes) {
        super(nombre);

        this.random = new Random();

       this.clubes = clubes;
       this.numeroClubes = clubes.length;
    }


}

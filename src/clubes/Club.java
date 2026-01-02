package clubes;

import jugadores.Jugador;

public class Club {

    private int id;
    private String nombre;
    private int fundacion;
    private String presidente;


    private Jugador[] primerEquipo;
    private int numPrimerEquipo;


    private Jugador[] cantera;
    private int numCantera;

    public Club(int id, String nombre, int fundacion, String presidente,
                int maxPrimerEquipo, int maxCantera) {

        this.id = id;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.presidente = presidente;

        this.primerEquipo = new Jugador[maxPrimerEquipo];
        this.cantera = new Jugador[maxCantera];

        this.numPrimerEquipo = 0;
        this.numCantera = 0;
    }

    public boolean añadirPrimerEquipo(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        if (numPrimerEquipo >= primerEquipo.length) {
            return false;
        }
        primerEquipo[numPrimerEquipo] = jugador;
        numPrimerEquipo++;
        return true;
    }

    public boolean añadirCantera(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        if ((numCantera >= cantera.length)) {
            return false;
        }
        cantera[numCantera] = jugador;
        numCantera++;
        return true;
    }

    public void mostrarPlantilla() {

        System.out.println(
                "┌───────────────────────────────────────────────┐\n" +
                        "│                  PLANTILLA                    │\n" +
                        "└───────────────────────────────────────────────┘"
        );

        for (int i = 0; i < 5; i++) {
            System.out.println();
        }

        System.out.println(
                "┌───────────────────────────────────────────────┐\n" +
                        "│-----------" + nombre + "-----------------│\n" +
                        "├───────────────────────────────────────────────┤\n" +
                        "│                 PRIMER EQUIPO                 │"
        );

        for (int i = 0; i < numPrimerEquipo; i++) {
            System.out.println(
                    "│-----------" + primerEquipo[i] + "-----------------│"
            );
        }

        System.out.println(
                "├───────────────────────────────────────────────┤\n" +
                        "│                 CANTERA                       │"
        );

        for (int i = 0; i < numCantera; i++) {
            System.out.println(
                    "│-----------" + cantera[i] + "-----------------│"
            );
        }
    }

    public Jugador buscarPorDorsal(int dorsal) {

        for (int i = 0; i < numPrimerEquipo; i++) {
            if (primerEquipo[i].getDorsal() == dorsal) {
                return primerEquipo[i];
            }
        }

        for (int i = 0; i < numCantera; i++) {
            if (cantera[i].getDorsal() == dorsal) {
                return cantera[i];
            }
        }

        return null;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFundacion() {
        return fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public int getNumPrimerEquipo() {
        return numPrimerEquipo;
    }

    public int getNumCantera() {
        return numCantera;
    }

    @Override
    public String toString() {
        return nombre + " (Fundado en " + fundacion + ")";
    }
}

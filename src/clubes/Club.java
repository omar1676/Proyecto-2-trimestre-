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
        final int INNER = 63;
        final String TOP = "┌" + "─".repeat(INNER) + "┐";
        final String MID = "├" + "─".repeat(INNER) + "┤";
        final String BOT = "└" + "─".repeat(INNER) + "┘";

        System.out.println(TOP);
        System.out.println("│" + center("PLANTILLA", INNER) + "│");
        System.out.println("│" + center(nombre + "  |  Fundado: " + fundacion + "  |  Presidente: " + presidente, INNER) + "│");
        System.out.println(BOT);

        System.out.println();

        imprimirSeccion("PRIMER EQUIPO (" + numPrimerEquipo + ")", primerEquipo, numPrimerEquipo, INNER);

        System.out.println();

        imprimirSeccion("CANTERA (" + numCantera + ")", cantera, numCantera, INNER);
    }

    private void imprimirSeccion(String titulo, Jugador[] lista, int num, int INNER) {
        final String TOP = "┌" + "─".repeat(INNER) + "┐";
        final String MID = "├" + "─".repeat(INNER) + "┤";
        final String BOT = "└" + "─".repeat(INNER) + "┘";

        System.out.println(TOP);
        System.out.println("│" + center(titulo, INNER) + "│");
        System.out.println(MID);


        String header = " DOR  " + col("NOMBRE", 26) + "  " + col("POS", 3) + "  " + col("ED", 2) + "  " + colR("€M", 6) + "  " + colR("VAL", 3);
        System.out.println("│" + col(header, INNER) + "│");
        System.out.println(MID);

        if (num == 0) {
            System.out.println("│" + center("(sin jugadores)", INNER) + "│");
            System.out.println(BOT);
            return;
        }

        for (int i = 0; i < num; i++) {
            Jugador j = lista[i];


            String fila =
                    " " + colR(String.valueOf(j.getDorsal()), 3) + "  " +
                            col(j.getNombre(), 26) + "  " +
                            col(j.getPosicion(), 3) + "  " +
                            colR(String.valueOf(j.getEdad()), 2) + "  " +
                            colR(String.format("%.1f", j.getValorMercado()), 6) + "  " +
                            colR(String.valueOf(j.getValoracion()), 3);

            System.out.println("│" + col(fila, INNER) + "│");
        }

        System.out.println(BOT);
    }


    private static String col(String s, int len) {
        return String.format("%-" + len + "." + len + "s", s == null ? "" : s);
    }

    private static String colR(String s, int len) {
        return String.format("%" + len + "." + len + "s", s == null ? "" : s);
    }

    private static String center(String s, int len) {
        s = (s == null) ? "" : s;
        if (s.length() > len) s = s.substring(0, len);
        int left = (len - s.length()) / 2;
        int right = len - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    public Jugador buscarPorDorsalPrimerEquipo(int dorsal) {
        for (int i = 0; i < numPrimerEquipo; i++) {
            if (primerEquipo[i].getDorsal() == dorsal) {
                return primerEquipo[i];
            }
        }
        return null;
    }

    public Jugador buscarPorDorsalCantera(int dorsal) {
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

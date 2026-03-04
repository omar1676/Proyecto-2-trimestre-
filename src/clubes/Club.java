package clubes;

import jugadores.Jugador;

public class Club {

    private int id;
    private String nombre;
    private int anioFundacion;
    private String presidente;

    private int presupuesto;
    private int nivel;

    private String liga;

    private Jugador[] primerEquipo;
    private int numPrimerEquipo;

    private Jugador[] cantera;
    private int numCantera;

    private int titulosLiga;
    private int titulosCopa;
    private int titulosChampions;
    private int titulosEuropaLeague;
    private int titulosSupercopa;

    public Club(int id, String nombre, int anioFundacion, String presidente, int presupuesto, int nivel) {

        this.primerEquipo = new Jugador[25];
        this.numPrimerEquipo = 0;

        this.cantera = new Jugador[10];
        this.numCantera = 0;

        if (id > 0) this.id = id;
        else this.id = 1;

        if (nombre != null && nombre.trim().length() >= 2) this.nombre = nombre.trim();
        else this.nombre = "Sin nombre";

        if (anioFundacion >= 1850 && anioFundacion <= 2100) this.anioFundacion = anioFundacion;
        else this.anioFundacion = 1900;

        if (presidente != null && presidente.trim().length() >= 2) this.presidente = presidente.trim();
        else this.presidente = "Sin presidente";

        if (presupuesto >= 0) this.presupuesto = presupuesto;
        else this.presupuesto = 0;

        if (nivel >= 1 && nivel <= 100) this.nivel = nivel;
        else this.nivel = 50;

        this.liga = "Sin liga";

        this.titulosLiga = 0;
        this.titulosCopa = 0;
        this.titulosChampions = 0;
        this.titulosEuropaLeague = 0;
        this.titulosSupercopa = 0;
    }

    public Club() {
        this(1, "Club Genérico", 1900, "Presidente", 10, 50);
    }

    public static boolean validarNombre(String n) {
        if (n == null) return false;
        n = n.trim();
        return n.length() >= 2;
    }

    private static boolean validarId(int id) {
        return id > 0;
    }

    private static boolean validarAnio(int anio) {
        return anio >= 1850 && anio <= 2100;
    }

    private static boolean validarPresupuesto(int p) {
        return p >= 0;
    }

    private static boolean validarNivel(int n) {
        return n >= 1 && n <= 100;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // Setter SIN validación (la validación se hace con cambiarId / constructor)
        this.id = id;
    }

    /**
     * Método de acción recomendado: valida y aplica el cambio.
     */
    public boolean cambiarId(int id) {
        if (!validarId(id)) return false;
        this.id = id;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Setter SIN validación
        this.nombre = nombre;
    }

    public boolean cambiarNombre(String nombre) {
        if (!validarNombre(nombre)) return false;
        this.nombre = nombre.trim();
        return true;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        // Setter SIN validación
        this.anioFundacion = anioFundacion;
    }

    public boolean cambiarAnioFundacion(int anioFundacion) {
        if (!validarAnio(anioFundacion)) return false;
        this.anioFundacion = anioFundacion;
        return true;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        // Setter SIN validación
        this.presidente = presidente;
    }

    public boolean cambiarPresidente(String presidente) {
        if (presidente == null) return false;
        String p = presidente.trim();
        if (p.length() < 2) return false;
        this.presidente = p;
        return true;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        // Setter SIN validación
        this.presupuesto = presupuesto;
    }

    public boolean cambiarPresupuesto(int presupuesto) {
        if (!validarPresupuesto(presupuesto)) return false;
        this.presupuesto = presupuesto;
        return true;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        // Setter SIN validación
        this.nivel = nivel;
    }

    public boolean cambiarNivel(int nivel) {
        if (!validarNivel(nivel)) return false;
        this.nivel = nivel;
        return true;
    }

    public int getNumPrimerEquipo() {
        return numPrimerEquipo;
    }

    public Jugador getJugadorPrimerEquipo(int pos) {
        if (pos < 0 || pos >= numPrimerEquipo) return null;
        return primerEquipo[pos];
    }

    public int getNumCantera() {
        return numCantera;
    }

    public Jugador getJugadorCantera(int pos) {
        if (pos < 0 || pos >= numCantera) return null;
        return cantera[pos];
    }

    public boolean anadirPrimerEquipo(Jugador j) {
        if (j == null) return false;
        if (numPrimerEquipo >= primerEquipo.length) return false;

        for (int i = 0; i < numPrimerEquipo; i++) {
            if (primerEquipo[i] != null && primerEquipo[i].equals(j)) return false;
        }

        primerEquipo[numPrimerEquipo] = j;
        numPrimerEquipo++;
        return true;
    }

    public boolean anadirCantera(Jugador j) {
        if (j == null) return false;
        if (numCantera >= cantera.length) return false;

        for (int i = 0; i < numCantera; i++) {
            if (cantera[i] != null && cantera[i].equals(j)) return false;
        }

        cantera[numCantera] = j;
        numCantera++;
        return true;
    }

    public boolean ficharJugador(Jugador j) {
        if (j == null) return false;

        if (anadirPrimerEquipo(j)) return true;

        return anadirCantera(j);
    }

    public void vaciarPlantilla() {
        for (int i = 0; i < primerEquipo.length; i++) primerEquipo[i] = null;
        for (int i = 0; i < cantera.length; i++) cantera[i] = null;
        numPrimerEquipo = 0;
        numCantera = 0;
    }

    public void setPalmares(int ligas, int copas, int champions, int europaLeague, int supercopas) {

        if (ligas < 0) ligas = 0;
        if (copas < 0) copas = 0;
        if (champions < 0) champions = 0;
        if (europaLeague < 0) europaLeague = 0;
        if (supercopas < 0) supercopas = 0;

        this.titulosLiga = ligas;
        this.titulosCopa = copas;
        this.titulosChampions = champions;
        this.titulosEuropaLeague = europaLeague;
        this.titulosSupercopa = supercopas;
    }

    public void ganarLiga() {
        titulosLiga++;
    }

    public void ganarCopa() {
        titulosCopa++;
    }

    public void ganarChampions() {
        titulosChampions++;
    }

    public void ganarEuropaLeague() {
        titulosEuropaLeague++;
    }

    public void ganarSupercopa() {
        titulosSupercopa++;
    }

    public int getTitulosLiga() {
        return titulosLiga;
    }

    public int getTitulosCopa() {
        return titulosCopa;
    }

    public int getTitulosChampions() {
        return titulosChampions;
    }

    public int getTitulosEuropaLeague() {
        return titulosEuropaLeague;
    }

    public int getTitulosSupercopa() {
        return titulosSupercopa;
    }

    public String getPalmares() {
        return "Liga: " + titulosLiga +
                " | Copa: " + titulosCopa +
                " | Champions: " + titulosChampions +
                " | Europa League: " + titulosEuropaLeague +
                " | Supercopa: " + titulosSupercopa;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anioFundacion=" + anioFundacion +
                ", presidente='" + presidente + '\'' +
                ", presupuesto=" + presupuesto +
                ", nivel=" + nivel +
                ", primerEquipo=" + numPrimerEquipo + "/25" +
                ", cantera=" + numCantera + "/10" +
                ", palmares=[" + getPalmares() + "]" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != Club.class) return false;
        Club otro = (Club) o;
        return this.id == otro.id;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        if (liga == null) {
            this.liga = "Sin liga";
            return;
        }
        String t = liga.trim();
        if (t.isEmpty()) {
            this.liga = "Sin liga";
            return;
        }
        this.liga = t;
    }

}

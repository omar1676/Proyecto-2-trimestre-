package competicion;

import clubes.Club;

public abstract class Competicion {

    public static final int MAX_CLUBES = 50;

    private String nombre;
    private boolean generada;
    private boolean terminada;

    public Competicion(String nombre) {
        if (!validarNombre(nombre)) this.nombre = "Competicion";
        else this.nombre = nombre.trim();

        this.generada = false;
        this.terminada = false;
    }

    public static boolean validarNombre(String nombre) {
        if (nombre == null) return false;
        String n = nombre.trim();
        return n.length() >= 2 && n.length() <= 40;
    }

    public abstract void generar();

    public abstract boolean simularRonda(boolean verEnDirecto);

    public abstract void mostrarUltimosResultados();

    public abstract boolean haTerminado();

    public abstract Club[] getGanadoresUltimaJornada();

    public String getNombre() {
        return nombre;
    }

    public boolean isGenerada() {
        return generada;
    }

    public boolean isTerminada() {
        return terminada;
    }

    protected void setNombre(String nombre) {
        if (validarNombre(nombre)) this.nombre = nombre.trim();
    }

    protected void setGenerada(boolean generada) {
        this.generada = generada;
    }

    protected void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }
}
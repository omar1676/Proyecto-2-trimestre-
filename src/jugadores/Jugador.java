
package jugadores;

public class Jugador {

    private int dorsal;
    private String nombre;
    private int edad;
    private String posicion;
    private double valorMercado;
    private int valoracion;


    private String temporada;
    private int partidos;
    private int minutos;
    private int goles;
    private int asistencias;
    private int amarillas;
    private int rojas;
    private int porteriasCero;


    public Jugador(int dorsal, String nombre, int edad, String posicion,
                   double valorMercado, int valoracion) {

        this.dorsal = dorsal;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.valoracion = valoracion;
        this.temporada = "2025/26";
        this.partidos = 0;
        this.minutos = 0;
        this.goles = 0;
        this.asistencias = 0;
        this.amarillas = 0;
        this.rojas = 0;
        this.porteriasCero = 0;
    }


    public Jugador(int dorsal, String nombre, int edad, String posicion,
                   double valorMercado, int valoracion,
                   String temporada, int partidos, int minutos, int goles, int asistencias,
                   int amarillas, int rojas, int porteriasCero) {

        this.dorsal = dorsal;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.valoracion = valoracion;

        this.temporada = temporada;
        this.partidos = partidos;
        this.minutos = minutos;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.porteriasCero = porteriasCero;
    }


    public void datosTransferMarket() {
        final int INNER = 61;

        System.out.println(lineTop(INNER));
        System.out.println("│" + center("FICHA DEL JUGADOR", INNER) + "│");
        System.out.println(lineMid(INNER));


        System.out.println("│" + col(" Nombre: " + nombre, 38) + colR("Dorsal: " + dorsal + " ", INNER - 38) + "│");
        System.out.println("│" + col(" Posición: " + posicion, 38) + colR("Edad: " + edad + " ", INNER - 38) + "│");
        System.out.println("│" + col(" Valor mercado: " + String.format("%.1f", valorMercado) + " M€", 38)
                + colR("Valoración: " + valoracion + " ", INNER - 38) + "│");

        System.out.println(lineMid(INNER));


        System.out.println("│" + col(" Temporada: " + temporada, INNER) + "│");
        System.out.println(lineMid(INNER));


        System.out.println("│" + col(" Partidos: " + partidos, 20)
                + col("Minutos: " + minutos, 22)
                + colR("Porterías a 0: " + porteriasCero + " ", INNER - 42) + "│");

        System.out.println("│" + col(" Goles: " + goles, 20)
                + col("Asistencias: " + asistencias, 22)
                + colR("Tarjetas: " + amarillas + "A / " + rojas + "R ", INNER - 42) + "│");

        System.out.println(lineBot(INNER));
    }


    public int getDorsal() { return dorsal; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getPosicion() { return posicion; }
    public double getValorMercado() { return valorMercado; }
    public int getValoracion() { return valoracion; }
    public String getTemporada() { return temporada; }
    public int getPartidos() { return partidos; }
    public int getMinutos() { return minutos; }
    public int getGoles() { return goles; }
    public int getAsistencias() { return asistencias; }
    public int getAmarillas() { return amarillas; }
    public int getRojas() { return rojas; }
    public int getPorteriasCero() { return porteriasCero; }

    public void setDorsal(int dorsal) { this.dorsal = dorsal; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
    public void setValorMercado(double valorMercado) { this.valorMercado = valorMercado; }
    public void setValoracion(int valoracion) { this.valoracion = valoracion; }
    public void setTemporada(String temporada) { this.temporada = temporada; }
    public void setPartidos(int partidos) { this.partidos = partidos; }
    public void setMinutos(int minutos) { this.minutos = minutos; }
    public void setGoles(int goles) { this.goles = goles; }
    public void setAsistencias(int asistencias) { this.asistencias = asistencias; }
    public void setAmarillas(int amarillas) { this.amarillas = amarillas; }
    public void setRojas(int rojas) { this.rojas = rojas; }
    public void setPorteriasCero(int porteriasCero) { this.porteriasCero = porteriasCero; }


    @Override
    public String toString() {
        return dorsal + " - " + nombre + " (" + posicion + ") | Val: " + valoracion + " | " + String.format("%.1f", valorMercado) + "M€";
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
    private static String lineTop(int inner) {
        return "┌" + "─".repeat(inner) + "┐";
    }

    private static String lineMid(int inner) {
        return "├" + "─".repeat(inner) + "┤";
    }

    private static String lineBot(int inner) {
        return "└" + "─".repeat(inner) + "┘";
    }
}

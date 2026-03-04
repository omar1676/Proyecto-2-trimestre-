package jugadores;

public class Jugador {

    private int dorsal;
    private String nombre;
    private int edad;
    private Posicion posicion;
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

    public Jugador(int dorsal, String nombre, int edad, Posicion posicion,
                   double valorMercado, int valoracion) {

        if (!esDorsalValido(dorsal)) dorsal = 1;
        if (!esNombreValido(nombre)) nombre = "Jugador";
        if (!esEdadValida(edad)) edad = 18;
        if (posicion == null) posicion = Posicion.MC;
        if (!esValorMercadoValido(valorMercado)) valorMercado = 1.0;
        if (!esValoracionValida(valoracion)) valoracion = 50;

        this.dorsal = dorsal;
        this.nombre = nombre.trim();
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

    public Jugador(int dorsal, String nombre, int edad, Posicion posicion,
                   double valorMercado, int valoracion,
                   String temporada, int partidos, int minutos, int goles, int asistencias,
                   int amarillas, int rojas, int porteriasCero) {

        if (!esDorsalValido(dorsal)) dorsal = 1;
        if (!esNombreValido(nombre)) nombre = "Jugador";
        if (!esEdadValida(edad)) edad = 18;
        if (posicion == null) posicion = Posicion.MC;
        if (!esValorMercadoValido(valorMercado)) valorMercado = 1.0;
        if (!esValoracionValida(valoracion)) valoracion = 50;

        if (temporada == null || temporada.trim().isEmpty()) temporada = "2025/26";
        if (partidos < 0) partidos = 0;
        if (minutos < 0) minutos = 0;
        if (goles < 0) goles = 0;
        if (asistencias < 0) asistencias = 0;
        if (amarillas < 0) amarillas = 0;
        if (rojas < 0) rojas = 0;
        if (porteriasCero < 0) porteriasCero = 0;

        this.dorsal = dorsal;
        this.nombre = nombre.trim();
        this.edad = edad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.valoracion = valoracion;

        this.temporada = temporada.trim();
        this.partidos = partidos;
        this.minutos = minutos;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.porteriasCero = porteriasCero;
    }

    public static boolean esDorsalValido(int dorsal) {
        return dorsal >= 1 && dorsal <= 99;
    }

    public static boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean esEdadValida(int edad) {
        return edad >= 15 && edad <= 45;
    }

    public static boolean esValorMercadoValido(double valorMercado) {
        return valorMercado >= 0.0;
    }

    public static boolean esValoracionValida(int valoracion) {
        return valoracion >= 0 && valoracion <= 100;
    }

    public boolean cambiarDorsal(int nuevoDorsal) {
        if (!esDorsalValido(nuevoDorsal)) return false;
        this.dorsal = nuevoDorsal;
        return true;
    }

    public boolean cambiarNombre(String nuevoNombre) {
        if (!esNombreValido(nuevoNombre)) return false;
        this.nombre = nuevoNombre.trim();
        return true;
    }

    public boolean cambiarEdad(int nuevaEdad) {
        if (!esEdadValida(nuevaEdad)) return false;
        this.edad = nuevaEdad;
        return true;
    }

    public boolean cambiarPosicion(Posicion nuevaPosicion) {
        if (nuevaPosicion == null) return false;
        this.posicion = nuevaPosicion;
        return true;
    }

    public boolean cambiarValorMercado(double nuevoValor) {
        if (!esValorMercadoValido(nuevoValor)) return false;
        this.valorMercado = nuevoValor;
        return true;
    }

    public boolean cambiarValoracion(int nuevaValoracion) {
        if (!esValoracionValida(nuevaValoracion)) return false;
        this.valoracion = nuevaValoracion;
        return true;
    }

    public boolean cambiarTemporada(String nuevaTemporada) {
        if (nuevaTemporada == null || nuevaTemporada.trim().isEmpty()) return false;
        this.temporada = nuevaTemporada.trim();
        return true;
    }


    public void registrarPartido(int minutos, int goles, int asistencias, int amarillas, int rojas, boolean porteriaCero) {
        if (minutos < 0) minutos = 0;
        if (goles < 0) goles = 0;
        if (asistencias < 0) asistencias = 0;
        if (amarillas < 0) amarillas = 0;
        if (rojas < 0) rojas = 0;

        this.partidos++;
        this.minutos += minutos;
        this.goles += goles;
        this.asistencias += asistencias;
        this.amarillas += amarillas;
        this.rojas += rojas;
        if (porteriaCero) this.porteriasCero++;
    }


    public void datosTransferMarket() {
        final int INNER = 61;

        System.out.println(lineTop(INNER));
        System.out.println("|" + center("FICHA DEL JUGADOR", INNER) + "|");
        System.out.println(lineMid(INNER));

        System.out.println("|" + col(" Nombre: " + nombre, 38) + colR("Dorsal: " + dorsal + " ", INNER - 38) + "|");
        System.out.println("|" + col(" Posicion: " + posicion, 38) + colR("Edad: " + edad + " ", INNER - 38) + "|");
        System.out.println("|" + col(" Valor mercado: " + String.format("%.1f", valorMercado) + " M€", 38)
                + colR("Valoracion: " + valoracion + " ", INNER - 38) + "|");

        System.out.println(lineMid(INNER));

        System.out.println("|" + col(" Temporada: " + temporada, INNER) + "|");
        System.out.println(lineMid(INNER));

        System.out.println("|" + col(" Partidos: " + partidos, 20)
                + col("Minutos: " + minutos, 22)
                + colR("Porterias a 0: " + porteriasCero + " ", INNER - 42) + "|");

        System.out.println("|" + col(" Goles: " + goles, 20)
                + col("Asistencias: " + asistencias, 22)
                + colR("Tarjetas: " + amarillas + "A / " + rojas + "R ", INNER - 42) + "|");

        System.out.println(lineBot(INNER));
    }
    public int getDorsal() { return dorsal; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Posicion getPosicion() { return posicion; }
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

     void setDorsal(int dorsal) { this.dorsal = dorsal; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }
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
        return dorsal + " - " + nombre + " (" + posicion + ") | Val: " + valoracion
                + " | " + String.format("%.1f", valorMercado) + "M€";
    }

     static String col(String s, int len) {
        if (s == null) s = "";
        return String.format("%-" + len + "." + len + "s", s);
    }

    private static String colR(String s, int len) {
        if (s == null) s = "";
        return String.format("%" + len + "." + len + "s", s);
    }

    private static String center(String s, int len) {
        if (s == null) s = "";
        if (s.length() > len) s = s.substring(0, len);
        int left = (len - s.length()) / 2;
        int right = len - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    private static String lineTop(int inner) { return "+" + "-".repeat(inner) + "+"; }
    private static String lineMid(int inner) { return "+" + "-".repeat(inner) + "+"; }
    private static String lineBot(int inner) { return "+" + "-".repeat(inner) + "+"; }
}
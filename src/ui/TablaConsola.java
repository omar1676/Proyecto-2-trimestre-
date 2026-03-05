package ui;

import extra.Utilidades;

public class TablaConsola {

    private static final int MS_POR_CARACTER = 14;
    private static final int PAUSA_POR_LINEA = 42;

    private TablaConsola() {
    }


    public static void imprimirTablaCentrada(String titulo, String[] cabeceras, String[][] filas) {
        imprimirTablaCentrada(titulo, cabeceras, filas, 110);
    }

    public static void imprimirTablaCentrada(String titulo, String[] cabeceras, String[][] filas, int anchoConsola) {
        if (cabeceras == null) {
            cabeceras = new String[0];
        }
        if (filas == null) {
            filas = new String[0][0];
        }

        int columnas = cabeceras.length;
        int[] anchos = calcularAnchosColumnas(cabeceras, filas, columnas);

        int anchoTabla = calcularAnchoTabla(anchos);
        int margen = calcularMargen(anchoConsola, anchoTabla);
        String prefijo = repetirCaracter(' ', margen);

        if (titulo != null) {
            String t = titulo.trim();
            if (!t.isEmpty()) {
                Utilidades.escribirLineaLenta("", MS_POR_CARACTER, PAUSA_POR_LINEA);
                Utilidades.escribirLineaLenta(prefijo + tituloDecorado(t, anchoTabla), MS_POR_CARACTER, PAUSA_POR_LINEA);
            }
        }

        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoTabla), MS_POR_CARACTER, PAUSA_POR_LINEA);
        Utilidades.escribirLineaLenta(prefijo + construirLinea(anchos, cabeceras, true), MS_POR_CARACTER, PAUSA_POR_LINEA);
        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoTabla), MS_POR_CARACTER, PAUSA_POR_LINEA);

        for (int r = 0; r < filas.length; r++) {
            String[] fila = filas[r];
            if (fila == null) {
                fila = new String[columnas];
            }
            Utilidades.escribirLineaLenta(prefijo + construirLinea(anchos, fila, false), MS_POR_CARACTER, PAUSA_POR_LINEA);
        }

        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoTabla), MS_POR_CARACTER, PAUSA_POR_LINEA);
    }

    public static void imprimirTituloCentrado(String titulo, int anchoConsola) {
        if (titulo == null) {
            return;
        }

        String t = titulo.trim();
        if (t.isEmpty()) {
            return;
        }

        if (t.length() > anchoConsola) {
            t = t.substring(0, anchoConsola);
        }

        int margen = (anchoConsola - t.length()) / 2;
        if (margen < 0) {
            margen = 0;
        }

        Utilidades.escribirLineaLenta(repetirCaracter(' ', margen) + t, MS_POR_CARACTER, PAUSA_POR_LINEA);
    }

    public static void imprimirMenuCentrado(String titulo, String[][] opciones, int anchoConsola, int anchoPanel) {
        if (anchoPanel <= 0) {
            anchoPanel = 86;
        }

        int margen = calcularMargen(anchoConsola, anchoPanel);
        String prefijo = repetirCaracter(' ', margen);

        if (titulo != null) {
            String t = titulo.trim();
            if (!t.isEmpty()) {
                Utilidades.escribirLineaLenta("", MS_POR_CARACTER, PAUSA_POR_LINEA);
                Utilidades.escribirLineaLenta(prefijo + tituloDecorado(t, anchoPanel), MS_POR_CARACTER, PAUSA_POR_LINEA);
            }
        }

        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoPanel), MS_POR_CARACTER, PAUSA_POR_LINEA);
        Utilidades.escribirLineaLenta(prefijo + rellenarDerecha("OP", 4) + " " + "ACCION", MS_POR_CARACTER, PAUSA_POR_LINEA);
        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoPanel), MS_POR_CARACTER, PAUSA_POR_LINEA);

        if (opciones != null) {
            for (int i = 0; i < opciones.length; i++) {
                String op = "";
                String accion = "";

                if (opciones[i] != null) {
                    if (opciones[i].length > 0 && opciones[i][0] != null) {
                        op = opciones[i][0].trim();
                    }
                    if (opciones[i].length > 1 && opciones[i][1] != null) {
                        accion = opciones[i][1];
                    }
                }

                String linea = rellenarDerecha(op, 4) + " " + accion;
                if (linea.length() > anchoPanel) {
                    linea = recortarConPuntos(linea, anchoPanel);
                }
                Utilidades.escribirLineaLenta(prefijo + linea, MS_POR_CARACTER, PAUSA_POR_LINEA);
            }
        }

        Utilidades.escribirLineaLenta(prefijo + repetirCaracter('_', anchoPanel), MS_POR_CARACTER, PAUSA_POR_LINEA);
    }

    private static int[] calcularAnchosColumnas(String[] cabeceras, String[][] filas, int columnas) {
        int[] anchos = new int[columnas];

        for (int c = 0; c < columnas; c++) {
            anchos[c] = longitudSegura(cabeceras[c]);
        }

        for (int r = 0; r < filas.length; r++) {
            if (filas[r] == null) {
                continue;
            }
            for (int c = 0; c < columnas; c++) {
                if (c >= filas[r].length) {
                    break;
                }
                int len = longitudSegura(filas[r][c]);
                if (len > anchos[c]) {
                    anchos[c] = len;
                }
            }
        }

        for (int c = 0; c < columnas; c++) {
            anchos[c] = anchos[c] + 1;
        }

        return anchos;
    }

    private static int calcularAnchoTabla(int[] anchos) {
        int total = 0;
        for (int i = 0; i < anchos.length; i++) {
            total += anchos[i];
            if (i < anchos.length - 1) {
                total += 1;
            }
        }
        return total;
    }

    private static int calcularMargen(int anchoConsola, int anchoBloque) {
        int margen = (anchoConsola - anchoBloque) / 2;
        if (margen < 0) {
            margen = 0;
        }
        return margen;
    }

    private static String construirLinea(int[] anchos, String[] valores, boolean esCabecera) {
        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < anchos.length; c++) {
            String v = "";
            if (valores != null && c < valores.length && valores[c] != null) {
                v = valores[c];
            }

            boolean derecha = false;
            if (!esCabecera) {
                derecha = esNumero(v);
            }

            sb.append(ajustarCelda(v, anchos[c], derecha));

            if (c < anchos.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private static String ajustarCelda(String valor, int anchoCelda, boolean derecha) {
        if (valor == null) {
            valor = "";
        }

        int interior = anchoCelda;
        if (interior < 0) {
            interior = 0;
        }

        String contenido = valor;
        if (contenido.length() > interior) {
            contenido = recortarConPuntos(contenido, interior);
        }

        int espacios = interior - contenido.length();
        if (espacios < 0) {
            espacios = 0;
        }

        if (derecha) {
            return repetirCaracter(' ', espacios) + contenido;
        }
        return contenido + repetirCaracter(' ', espacios);
    }

    private static String tituloDecorado(String titulo, int ancho) {
        String t = titulo;
        if (t == null) {
            t = "";
        }
        t = t.trim();

        if (ancho <= 0) {
            return "";
        }

        if (t.isEmpty()) {
            return repetirCaracter('_', ancho);
        }

        String texto = " " + t + " ";
        if (texto.length() > ancho) {
            texto = texto.substring(0, ancho);
        }

        int izq = (ancho - texto.length()) / 2;
        if (izq < 0) {
            izq = 0;
        }

        int der = ancho - texto.length() - izq;
        if (der < 0) {
            der = 0;
        }

        return repetirCaracter('_', izq) + texto + repetirCaracter('_', der);
    }

    private static boolean esNumero(String texto) {
        if (texto == null) {
            return false;
        }

        String s = texto.trim();
        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0 && ch == '-') {
                continue;
            }
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private static int longitudSegura(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    private static String recortarConPuntos(String texto, int maximo) {
        if (texto == null) {
            return "";
        }
        if (maximo <= 0) {
            return "";
        }
        if (texto.length() <= maximo) {
            return texto;
        }
        if (maximo == 1) {
            return "…";
        }
        return texto.substring(0, maximo - 1) + "…";
    }

    private static String rellenarDerecha(String texto, int longitud) {
        if (texto == null) {
            texto = "";
        }

        if (texto.length() >= longitud) {
            return texto.substring(0, longitud);
        }

        StringBuilder sb = new StringBuilder(longitud);
        sb.append(texto);
        while (sb.length() < longitud) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String repetirCaracter(char c, int veces) {
        if (veces <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(veces);
        for (int i = 0; i < veces; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}

package extra;

public final class Utilidades {
    private Utilidades(){}

    private static int VELOCIDAD_TEXTO_MS = 26;
    private static int PAUSA_LINEA_MS = 55;

    public static final String RESET = "\u001B[0m";
    public static final String ROJO  = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMAR  = "\u001B[33m";
    public static final String AZUL  = "\u001B[34m";
    public static final String CIAN  = "\u001B[36m";
    public static final String GRIS  = "\u001B[90m";

    public static void printlnColor(String color, String msg) {
        System.out.println(color + msg + RESET);
        System.out.flush();
    }

    public static void printColor(String color, String msg) {
        System.out.print(color + msg + RESET);
        System.out.flush();
    }

        public static void escribirLento(String msg, int ms) {
        if (msg == null) {
            System.out.println();
            System.out.flush();
            return;
        }

        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            System.out.print(c);
            System.out.flush();

            int pausa = calcularPausaHumana(ms, c);
            dormir(pausa);
        }

        System.out.println();
        System.out.flush();
    }

        public static void escribirLentoSinSalto(String msg, int ms) {
        if (msg == null) {
            System.out.flush();
            return;
        }

        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            System.out.print(c);
            System.out.flush();

            int pausa = calcularPausaHumana(ms, c);
            dormir(pausa);
        }
    }

    public static void escribirLineaLenta(String linea) {
        escribirLento(linea, VELOCIDAD_TEXTO_MS);
        dormir(PAUSA_LINEA_MS);
    }

    public static void escribirLineaLenta(String linea, int msCaracter, int msPausaLinea) {
        escribirLento(linea, msCaracter);
        dormir(msPausaLinea);
    }

    public static void escribirLineaLentaColor(String color, String linea) {
        if (linea == null) {
            linea = "";
        }
        escribirLento(color + linea + RESET, VELOCIDAD_TEXTO_MS);
        dormir(PAUSA_LINEA_MS);
    }

    public static void setVelocidadTextoMs(int ms) {
        if (ms < 0) {
            return;
        }
        VELOCIDAD_TEXTO_MS = ms;
    }

    public static void setPausaLineaMs(int ms) {
        if (ms < 0) {
            return;
        }
        PAUSA_LINEA_MS = ms;
    }

    public static int getVelocidadTextoMs() {
        return VELOCIDAD_TEXTO_MS;
    }

    public static int getPausaLineaMs() {
        return PAUSA_LINEA_MS;
    }

        private static int calcularPausaHumana(int msBase, char c) {
        int ms = msBase;


        if (c == ' ') {
            ms = msBase / 2;
        }

        if (c == '.' || c == '!' || c == '?' ) {
            ms = msBase * 8;
        } else if (c == ',' || c == ';' || c == ':') {
            ms = msBase * 5;
        }

        if (ms < 0) {
            ms = 0;
        }
        if (ms > 650) {
            ms = 650;
        }

        return ms;
    }

    public static void dormir(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

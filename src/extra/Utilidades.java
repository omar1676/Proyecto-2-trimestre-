package extra;

public final class Utilidades {
    private Utilidades(){}

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
        if (msg == null) return;
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
            System.out.flush();
            dormir(ms);
}
        System.out.println();
    }

    public static void dormir(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

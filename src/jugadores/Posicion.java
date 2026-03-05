package jugadores;

public enum Posicion {
    POR,
    LD,
    LI,
    DFC,
    MCD,
    MC,
    MCO,
    EI,
    ED,
    DC;

    public static Posicion fromString(String s) {
        if (s == null) return MC;
        s = s.trim().toUpperCase();

        if (s.equals("DF") || s.equals("CB")) return DFC;
        if (s.equals("RB")) return LD;
        if (s.equals("LB")) return LI;
        if (s.equals("ST")) return DC;

        Posicion[] vals = values();
        for (int i = 0; i < vals.length; i++) {
            Posicion p = vals[i];
            if (p.name().equals(s)) return p;
        }
        return MC;
    }
}
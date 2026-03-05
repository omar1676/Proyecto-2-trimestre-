package competicion;

import clubes.Club;

public class SerieA extends Liga {

    public SerieA() {
        super("Serie A");
    }

    public SerieA(Club[] clubes) {
        super("Serie A", clubes);
    }
}
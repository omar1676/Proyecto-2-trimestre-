package competicion;

import clubes.Club;

public class EuropaLeague extends Liga {

    public EuropaLeague() {
        super("Europa League");
    }

    public EuropaLeague(Club[] clubes) {
        super("Europa League", clubes);
    }
}
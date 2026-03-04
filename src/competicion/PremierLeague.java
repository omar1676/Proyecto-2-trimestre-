package competicion;

import clubes.Club;

public class PremierLeague extends Liga {

    public PremierLeague() {
        super("Premier League");
    }

    public PremierLeague(Club[] clubes) {
        super("Premier League", clubes);
    }
}
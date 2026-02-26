package datos;

import clubes.Club;
import jugadores.Jugador;

public class CargadorDatos {

    public static Club[] crearClubesConPlantillas() {
        Club[] lista = crearClubes();
        cargarAlaves(buscarPorId(lista, 1));
        cargarRealMadrid(buscarPorId(lista, 15));
        return lista;
    }

    private static Club buscarPorId(Club[] lista, int id) {
        if (lista == null) return null;

        for (int i = 0; i < lista.length; i++) {
            Club c = lista[i];
            if (c != null && c.getId() == id) return c;
        }
        return null;
    }

    private static Club[] crearClubes() {
        Club alaves = new Club(1, "Deportivo Alaves", 1921, "Presidente", 30, 50);
        Club athletic = new Club(2, "Athletic Club", 1898, "Presidente", 30, 50);
        Club atletico = new Club(3, "Atletico de Madrid", 1903, "Presidente", 30, 50);
        Club barcelona = new Club(4, "FC Barcelona", 1899, "Presidente", 30, 50);
        Club celta = new Club(5, "Celta de Vigo", 1923, "Presidente", 30, 50);
        Club elche = new Club(6, "Elche", 1923, "Presidente", 30, 50);
        Club espanyol = new Club(7, "Espanyol", 1900, "Presidente", 30, 50);
        Club getafe = new Club(8, "Getafe", 1983, "Presidente", 30, 50);
        Club girona = new Club(9, "Girona", 1930, "Presidente", 30, 50);
        Club levante = new Club(10, "Levante", 1909, "Presidente", 30, 50);
        Club mallorca = new Club(11, "Real Mallorca", 1916, "Presidente", 30, 50);
        Club osasuna = new Club(12, "Osasuna", 1920, "Presidente", 30, 50);
        Club rayo = new Club(13, "Rayo Vallecano", 1924, "Presidente", 30, 50);
        Club betis = new Club(14, "Real Betis", 1907, "Presidente", 30, 50);
        Club madrid = new Club(15, "Real Madrid", 1902, "Presidente", 30, 50);
        Club oviedo = new Club(16, "Real Oviedo", 1926, "Presidente", 30, 50);
        Club sociedad = new Club(17, "Real Sociedad", 1909, "Presidente", 30, 50);
        Club sevilla = new Club(18, "Sevilla", 1890, "Presidente", 30, 50);
        Club valencia = new Club(19, "Valencia", 1919, "Presidente", 30, 50);
        Club villarreal = new Club(20, "Villarreal", 1923, "Presidente", 30, 50);

        alaves.setPalmares(0, 0, 0, 0, 0);
        athletic.setPalmares(8, 24, 0, 3, 0);
        atletico.setPalmares(11, 10, 0, 2, 1);
        barcelona.setPalmares(28, 32, 5, 15, 3);
        celta.setPalmares(0, 0, 0, 0, 0);
        elche.setPalmares(0, 0, 0, 0, 0);
        espanyol.setPalmares(0, 4, 0, 0, 0);
        getafe.setPalmares(0, 0, 0, 0, 0);
        girona.setPalmares(0, 0, 0, 0, 0);
        levante.setPalmares(0, 0, 0, 0, 0);
        mallorca.setPalmares(0, 1, 0, 1, 0);
        osasuna.setPalmares(0, 0, 0, 0, 0);
        rayo.setPalmares(0, 0, 0, 0, 0);
        betis.setPalmares(1, 3, 0, 0, 0);
        madrid.setPalmares(36, 20, 15, 13, 5);
        oviedo.setPalmares(0, 0, 0, 0, 0);
        sociedad.setPalmares(2, 2, 0, 1, 0);
        sevilla.setPalmares(1, 5, 0, 1, 0);
        valencia.setPalmares(6, 8, 0, 1, 0);
        villarreal.setPalmares(0, 0, 0, 0, 0);

        return new Club[]{
                alaves, athletic, atletico, barcelona, celta,
                elche, espanyol, getafe, girona, levante,
                mallorca, osasuna, rayo, betis, madrid,
                oviedo, sociedad, sevilla, valencia, villarreal
        };
    }


    public static Club[] crearClubesPremierLeague() {

        Club arsenal = new Club(101, "Arsenal", 1886, "Presidente", 30, 50);
        Club astonVilla = new Club(102, "Aston Villa", 1874, "Presidente", 30, 50);
        Club bournemouth = new Club(103, "AFC Bournemouth", 1899, "Presidente", 30, 50);
        Club brentford = new Club(104, "Brentford", 1889, "Presidente", 30, 50);
        Club brighton = new Club(105, "Brighton & Hove Albion", 1901, "Presidente", 30, 50);
        Club chelsea = new Club(106, "Chelsea", 1905, "Presidente", 30, 50);
        Club crystalPalace = new Club(107, "Crystal Palace", 1905, "Presidente", 30, 50);
        Club everton = new Club(108, "Everton", 1878, "Presidente", 30, 50);
        Club fulham = new Club(109, "Fulham", 1879, "Presidente", 30, 50);
        Club ipswich = new Club(110, "Ipswich Town", 1878, "Presidente", 30, 50);
        Club leicester = new Club(111, "Leicester City", 1884, "Presidente", 30, 50);
        Club liverpool = new Club(112, "Liverpool", 1892, "Presidente", 30, 50);
        Club manCity = new Club(113, "Manchester City", 1880, "Presidente", 30, 50);
        Club manUnited = new Club(114, "Manchester United", 1878, "Presidente", 30, 50);
        Club newcastle = new Club(115, "Newcastle United", 1892, "Presidente", 30, 50);
        Club nottinghamForest = new Club(116, "Nottingham Forest", 1865, "Presidente", 30, 50);
        Club southampton = new Club(117, "Southampton", 1885, "Presidente", 30, 50);
        Club tottenham = new Club(118, "Tottenham Hotspur", 1882, "Presidente", 30, 50);
        Club westHam = new Club(119, "West Ham United", 1895, "Presidente", 30, 50);
        Club wolves = new Club(120, "Wolverhampton Wanderers", 1877, "Presidente", 30, 50);

        arsenal.setPalmares(13, 14, 0, 17, 0);
        astonVilla.setPalmares(7, 7, 1, 1, 0);
        bournemouth.setPalmares(0, 0, 0, 0, 0);
        brentford.setPalmares(0, 0, 0, 0, 0);
        brighton.setPalmares(0, 0, 0, 1, 0);
        chelsea.setPalmares(6, 8, 2, 4, 2);
        crystalPalace.setPalmares(0, 1, 0, 1, 0);
        everton.setPalmares(9, 5, 0, 9, 0);
        fulham.setPalmares(0, 0, 0, 0, 0);
        ipswich.setPalmares(1, 1, 0, 0, 0);
        leicester.setPalmares(1, 1, 0, 2, 0);
        liverpool.setPalmares(20, 8, 6, 16, 1);
        manCity.setPalmares(10, 7, 1, 7, 1);
        manUnited.setPalmares(20, 13, 3, 21, 1);
        newcastle.setPalmares(4, 6, 0, 1, 0);
        nottinghamForest.setPalmares(1, 2, 2, 1, 0);
        southampton.setPalmares(0, 1, 0, 0, 0);
        tottenham.setPalmares(2, 8, 0, 7, 0);
        westHam.setPalmares(0, 3, 0, 1, 0);
        wolves.setPalmares(3, 4, 0, 4, 0);

        Club[] premier = new Club[] {
                arsenal, astonVilla, bournemouth, brentford, brighton, chelsea, crystalPalace, everton, fulham, ipswich, leicester, liverpool, manCity, manUnited, newcastle, nottinghamForest, southampton, tottenham, westHam, wolves
        };

        for (int i = 0; i < premier.length; i++) {
            if (premier[i] != null) {
                premier[i].setNombresTrofeos(
                        "LIGA INGLESA",
                        "FA CUP",
                        "CHAMPIONS LEAGUE",
                        "COMMUNITY SHIELD",
                        "MUNDIAL DE CLUBES"
                );
            }
        }

        return new Club[]{
                arsenal, astonVilla, bournemouth, brentford, brighton, chelsea,
                crystalPalace, everton, fulham, ipswich, leicester, liverpool,
                manCity, manUnited, newcastle, nottinghamForest, southampton,
                tottenham, westHam, wolves
        };

    }

    // ===============================
//   SERIE A (Italia)
// ===============================
    public static Club[] crearClubesSerieA() {

        Club inter = new Club(201, "Inter", 1908, "Presidente", 30, 50);
        Club milan = new Club(202, "AC Milan", 1899, "Presidente", 30, 50);
        Club juventus = new Club(203, "Juventus", 1897, "Presidente", 30, 50);
        Club napoli = new Club(204, "Napoli", 1926, "Presidente", 30, 50);
        Club roma = new Club(205, "Roma", 1927, "Presidente", 30, 50);
        Club lazio = new Club(206, "Lazio", 1900, "Presidente", 30, 50);
        Club atalanta = new Club(207, "Atalanta", 1907, "Presidente", 30, 50);
        Club fiorentina = new Club(208, "Fiorentina", 1926, "Presidente", 30, 50);
        Club bologna = new Club(209, "Bologna", 1909, "Presidente", 30, 50);
        Club torino = new Club(210, "Torino", 1906, "Presidente", 30, 50);
        Club genoa = new Club(211, "Genoa", 1893, "Presidente", 30, 50);
        Club udinese = new Club(212, "Udinese", 1896, "Presidente", 30, 50);
        Club empoli = new Club(213, "Empoli", 1920, "Presidente", 30, 50);
        Club verona = new Club(214, "Hellas Verona", 1903, "Presidente", 30, 50);
        Club cagliari = new Club(215, "Cagliari", 1920, "Presidente", 30, 50);
        Club lecce = new Club(216, "Lecce", 1908, "Presidente", 30, 50);
        Club monza = new Club(217, "Monza", 1912, "Presidente", 30, 50);
        Club parma = new Club(218, "Parma", 1913, "Presidente", 30, 50);
        Club como = new Club(219, "Como", 1907, "Presidente", 30, 50);
        Club venezia = new Club(220, "Venezia", 1907, "Presidente", 30, 50);

        // Liga / Copa / UCL / Supercopa / Mundial
        inter.setPalmares(20, 9, 3, 8, 1);
        milan.setPalmares(19, 5, 7, 8, 1);
        juventus.setPalmares(36, 15, 2, 9, 0);
        napoli.setPalmares(4, 6, 0, 3, 0);
        roma.setPalmares(3, 9, 0, 2, 0);
        lazio.setPalmares(2, 7, 0, 5, 0);
        atalanta.setPalmares(0, 1, 0, 0, 0);
        fiorentina.setPalmares(2, 6, 0, 1, 0);
        bologna.setPalmares(7, 3, 0, 0, 0);
        torino.setPalmares(7, 5, 0, 0, 0);
        genoa.setPalmares(9, 1, 0, 0, 0);
        udinese.setPalmares(0, 0, 0, 0, 0);
        empoli.setPalmares(0, 0, 0, 0, 0);
        verona.setPalmares(1, 0, 0, 0, 0);
        cagliari.setPalmares(1, 0, 0, 0, 0);
        lecce.setPalmares(0, 0, 0, 0, 0);
        monza.setPalmares(0, 0, 0, 0, 0);
        parma.setPalmares(0, 3, 0, 1, 0);
        como.setPalmares(0, 0, 0, 0, 0);
        venezia.setPalmares(0, 1, 0, 0, 0);

        Club[] clubes = new Club[]{
                inter, milan, juventus, napoli, roma,
                lazio, atalanta, fiorentina, bologna, torino,
                genoa, udinese, empoli, verona, cagliari,
                lecce, monza, parma, como, venezia
        };

        // Nombres de trofeos
        for (Club c : clubes) {
            if (c != null) c.setNombresTrofeos(
                    "Serie A",
                    "Coppa Italia",
                    "Champions League",
                    "Supercoppa Italiana",
                    "Mundial de Clubes"
            );
        }

        return clubes;
    }


    // ===============================
//   BUNDESLIGA (Alemania)
// ===============================
    public static Club[] crearClubesBundesliga() {

        Club bayern = new Club(301, "Bayern Munich", 1900, "Presidente", 30, 50);
        Club leverkusen = new Club(302, "Bayer Leverkusen", 1904, "Presidente", 30, 50);
        Club dortmund = new Club(303, "Borussia Dortmund", 1909, "Presidente", 30, 50);
        Club leipzig = new Club(304, "RB Leipzig", 2009, "Presidente", 30, 50);
        Club stuttgart = new Club(305, "VfB Stuttgart", 1893, "Presidente", 30, 50);
        Club frankfurt = new Club(306, "Eintracht Frankfurt", 1899, "Presidente", 30, 50);
        Club freiburg = new Club(307, "SC Freiburg", 1904, "Presidente", 30, 50);
        Club hoffenheim = new Club(308, "TSG Hoffenheim", 1899, "Presidente", 30, 50);
        Club heidenheim = new Club(309, "1. FC Heidenheim", 1846, "Presidente", 30, 50);
        Club bremen = new Club(310, "Werder Bremen", 1899, "Presidente", 30, 50);
        Club augsburg = new Club(311, "FC Augsburg", 1907, "Presidente", 30, 50);
        Club wolfsburg = new Club(312, "VfL Wolfsburg", 1945, "Presidente", 30, 50);
        Club mainz = new Club(313, "Mainz 05", 1905, "Presidente", 30, 50);
        Club gladbach = new Club(314, "Borussia Mönchengladbach", 1900, "Presidente", 30, 50);
        Club union = new Club(315, "Union Berlin", 1966, "Presidente", 30, 50);
        Club bochum = new Club(316, "VfL Bochum", 1848, "Presidente", 30, 50);
        Club kiel = new Club(317, "Holstein Kiel", 1900, "Presidente", 30, 50);
        Club stpauli = new Club(318, "FC St. Pauli", 1910, "Presidente", 30, 50);

        // Liga / Copa / UCL / Supercopa / Mundial
        bayern.setPalmares(34, 20, 6, 11, 2);
        leverkusen.setPalmares(1, 2, 0, 1, 0);
        dortmund.setPalmares(8, 5, 1, 6, 0);
        leipzig.setPalmares(0, 2, 0, 1, 0);
        stuttgart.setPalmares(5, 4, 0, 1, 0);
        frankfurt.setPalmares(1, 5, 0, 0, 0);
        freiburg.setPalmares(0, 0, 0, 0, 0);
        hoffenheim.setPalmares(0, 0, 0, 0, 0);
        heidenheim.setPalmares(0, 0, 0, 0, 0);
        bremen.setPalmares(4, 6, 0, 3, 0);
        augsburg.setPalmares(0, 0, 0, 0, 0);
        wolfsburg.setPalmares(1, 1, 0, 1, 0);
        mainz.setPalmares(0, 0, 0, 0, 0);
        gladbach.setPalmares(5, 3, 0, 0, 0);
        union.setPalmares(0, 0, 0, 0, 0);
        bochum.setPalmares(0, 0, 0, 0, 0);
        kiel.setPalmares(0, 0, 0, 0, 0);
        stpauli.setPalmares(0, 0, 0, 0, 0);

        Club[] clubes = new Club[]{
                bayern, leverkusen, dortmund, leipzig, stuttgart, frankfurt,
                freiburg, hoffenheim, heidenheim, bremen, augsburg, wolfsburg,
                mainz, gladbach, union, bochum, kiel, stpauli
        };

        for (Club c : clubes) {
            if (c != null) c.setNombresTrofeos(
                    "Bundesliga",
                    "DFB-Pokal",
                    "Champions League",
                    "DFL-Supercup",
                    "Mundial de Clubes"
            );
        }

        return clubes;
    }


    // ===============================
//   LIGUE 1 (Francia)
// ===============================
    public static Club[] crearClubesLigue1() {

        Club psg = new Club(401, "Paris Saint-Germain", 1970, "Presidente", 30, 50);
        Club marseille = new Club(402, "Olympique de Marseille", 1899, "Presidente", 30, 50);
        Club monaco = new Club(403, "AS Monaco", 1924, "Presidente", 30, 50);
        Club nice = new Club(404, "OGC Nice", 1904, "Presidente", 30, 50);
        Club lille = new Club(405, "LOSC Lille", 1944, "Presidente", 30, 50);
        Club lyon = new Club(406, "Olympique Lyonnais", 1950, "Presidente", 30, 50);
        Club strasbourg = new Club(407, "RC Strasbourg", 1906, "Presidente", 30, 50);
        Club rennes = new Club(408, "Stade Rennais", 1901, "Presidente", 30, 50);
        Club lens = new Club(409, "RC Lens", 1906, "Presidente", 30, 50);
        Club reims = new Club(410, "Stade de Reims", 1931, "Presidente", 30, 50);
        Club toulouse = new Club(411, "Toulouse FC", 1970, "Presidente", 30, 50);
        Club nantes = new Club(412, "FC Nantes", 1943, "Presidente", 30, 50);
        Club brest = new Club(413, "Stade Brestois", 1950, "Presidente", 30, 50);
        Club auxerre = new Club(414, "AJ Auxerre", 1905, "Presidente", 30, 50);
        Club stEtienne = new Club(415, "AS Saint-Étienne", 1919, "Presidente", 30, 50);
        Club lehavre = new Club(416, "Le Havre AC", 1872, "Presidente", 30, 50);
        Club montpellier = new Club(417, "Montpellier HSC", 1919, "Presidente", 30, 50);
        Club angers = new Club(418, "Angers SCO", 1919, "Presidente", 30, 50);

        // Liga / Copa / UCL / Supercopa / Mundial
        psg.setPalmares(13, 16, 1, 14, 0);
        marseille.setPalmares(10, 10, 1, 2, 0);
        monaco.setPalmares(8, 5, 0, 2, 0);
        nice.setPalmares(4, 3, 0, 0, 0);
        lille.setPalmares(4, 6, 0, 1, 0);
        lyon.setPalmares(7, 5, 0, 8, 0);
        strasbourg.setPalmares(1, 3, 0, 0, 0);
        rennes.setPalmares(0, 3, 0, 0, 0);
        lens.setPalmares(1, 0, 0, 0, 0);
        reims.setPalmares(6, 2, 0, 0, 0);
        toulouse.setPalmares(0, 1, 0, 0, 0);
        nantes.setPalmares(8, 4, 0, 2, 0);
        brest.setPalmares(0, 0, 0, 0, 0);
        auxerre.setPalmares(1, 4, 0, 0, 0);
        stEtienne.setPalmares(10, 6, 0, 0, 0);
        lehavre.setPalmares(0, 1, 0, 0, 0);
        montpellier.setPalmares(1, 2, 0, 0, 0);
        angers.setPalmares(0, 0, 0, 0, 0);

        Club[] clubes = new Club[]{
                psg, marseille, monaco, nice, lille, lyon,
                strasbourg, rennes, lens, reims, toulouse, nantes,
                brest, auxerre, stEtienne, lehavre, montpellier, angers
        };

        for (Club c : clubes) {
            if (c != null) c.setNombresTrofeos(
                    "Ligue 1",
                    "Coupe de France",
                    "Champions League",
                    "Trophée des Champions",
                    "Mundial de Clubes"
            );
        }

        return clubes;
    }




    private static void cargarAlaves(Club alaves) {
        if (alaves == null) return;

        Jugador j1 = new Jugador(1, "Antonio Sivera", 29, "POR", 6.0, 78);
        j1.setTemporada("2024/25");
        j1.setPartidos(18);
        j1.setMinutos(1620);
        j1.setPorteriasCero(6);
        j1.setAmarillas(1);

        Jugador j2 = new Jugador(13, "Raul Fernandez", 37, "POR", 0.2, 71);
        j2.setTemporada("2024/25");
        j2.setPartidos(6);
        j2.setMinutos(540);
        j2.setPorteriasCero(2);

        Jugador j3 = new Jugador(7, "Carlos Vicente", 26, "ED", 7.0, 76);
        j3.setTemporada("2024/25");
        j3.setPartidos(21);
        j3.setMinutos(1250);
        j3.setGoles(8);
        j3.setAsistencias(3);
        j3.setAmarillas(1);

        Jugador j4 = new Jugador(15, "Lucas Boye", 29, "DC", 5.0, 75);
        j4.setTemporada("2024/25");
        j4.setPartidos(14);
        j4.setMinutos(978);
        j4.setGoles(4);
        j4.setAmarillas(1);

        Jugador[] listaPrimerEquipo = {j1, j2, j3, j4};
        for (int i = 0; i < listaPrimerEquipo.length; i++) {
            alaves.añadirPrimerEquipo(listaPrimerEquipo[i]);
        }

        Jugador c1 = new Jugador(31, "Iker Aramburu", 19, "POR", 0.4, 64);
        Jugador c2 = new Jugador(44, "Adrian Paredes", 19, "DC", 0.8, 68);

        Jugador[] listaCantera = {c1, c2};
        for (int i = 0; i < listaCantera.length; i++) {
            alaves.añadirCantera(listaCantera[i]);
        }
    }

    private static void cargarRealMadrid(Club madrid) {
        if (madrid == null) return;

        Jugador j1 = new Jugador(1, "Thibaut Courtois", 33, "POR", 18.0, 88);
        Jugador j2 = new Jugador(5, "Jude Bellingham", 22, "MCO", 160.0, 91);
        Jugador j3 = new Jugador(10, "Kylian Mbappe", 27, "DC", 200.0, 94);


        Jugador[] listaPrimerEquipo = {j1, j2, j3};
        for (int i = 0; i < listaPrimerEquipo.length; i++) {
            madrid.añadirPrimerEquipo(listaPrimerEquipo[i]);
        }

        Jugador c1 = new Jugador(25, "Sergio Mestre", 20, "POR", 0.05, 66);
        madrid.añadirCantera(c1);
    }

}
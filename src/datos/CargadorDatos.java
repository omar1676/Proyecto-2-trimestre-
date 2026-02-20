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
        Jugador j4 = new Jugador();

        Jugador[] listaPrimerEquipo = {j1, j2, j3};
        for (int i = 0; i < listaPrimerEquipo.length; i++) {
            madrid.añadirPrimerEquipo(listaPrimerEquipo[i]);
        }

        Jugador c1 = new Jugador(25, "Sergio Mestre", 20, "POR", 0.05, 66);
        madrid.añadirCantera(c1);
    }
}
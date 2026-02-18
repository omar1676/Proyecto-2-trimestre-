package main;

import clubes.Club;
import jugadores.Jugador;
import liga.Liga;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Club[] clubes = crearClubes();


        cargarAlaves(buscarClubPorId(clubes, 1));
        cargarRealMadrid(buscarClubPorId(clubes, 15));


        Liga laliga = new Liga("LaLiga", clubes);
        laliga.generar();


    }

    static Club buscarClubPorId(Club[] clubes, int id) {
        if (clubes == null) return null;
        for (Club c : clubes) {
            if (c != null && c.getId() == id) return c;
        }
        return null;
    }

    static Club[] crearClubes() {
        Club alaves = new Club(1, "Deportivo Alavés", 1921, "Presidente", 30, 50);
        Club athletic = new Club(2, "Athletic Club", 1898, "Presidente", 30, 50);
        Club atletico = new Club(3, "Atlético de Madrid", 1903, "Presidente", 30, 50);
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

    // -------------------- CARGAS (EJEMPLO) --------------------
    static void cargarAlaves(Club alaves) {
        if (alaves == null) return;

        Jugador j1 = new Jugador(1, "Antonio Sivera", 29, "POR", 6.0, 78);
        j1.setTemporada("2024/25");
        j1.setPartidos(18);
        j1.setMinutos(1620);
        j1.setPorteriasCero(6);
        j1.setAmarillas(1);

        Jugador j2 = new Jugador(13, "Raúl Fernández", 37, "POR", 0.2, 71);
        j2.setTemporada("2024/25");
        j2.setPartidos(6);
        j2.setMinutos(540);
        j2.setPorteriasCero(2);

        Jugador j3 = new Jugador(5, "Jon Pacheco", 24, "DFC", 5.0, 74);
        j3.setTemporada("2024/25");
        j3.setPartidos(13);
        j3.setMinutos(1050);
        j3.setAsistencias(2);

        Jugador j4 = new Jugador(22, "Moussa Diarra", 25, "DFC", 1.5, 70);
        j4.setTemporada("2024/25");
        j4.setPartidos(5);
        j4.setMinutos(399);
        j4.setAsistencias(1);

        Jugador j5 = new Jugador(12, "Nikola Maras", 30, "DFC", 0.8, 69);
        j5.setTemporada("2024/25");

        Jugador j6 = new Jugador(2, "Facundo Garcés", 26, "DFC", 0.0, 70);
        j6.setTemporada("2024/25");
        j6.setPartidos(6);
        j6.setMinutos(540);
        j6.setAsistencias(2);

        Jugador j7 = new Jugador(3, "Youssef Enríquez", 20, "LI", 5.0, 73);
        j7.setTemporada("2024/25");
        j7.setPartidos(16);
        j7.setMinutos(948);
        j7.setAsistencias(4);

        Jugador j8 = new Jugador(24, "Victor Parada", 23, "LI", 2.0, 71);
        j8.setTemporada("2024/25");
        j8.setPartidos(16);
        j8.setMinutos(895);
        j8.setGoles(1);
        j8.setAsistencias(5);

        Jugador j9 = new Jugador(14, "Nahuel Tenaglia", 29, "LD", 3.0, 74);
        j9.setTemporada("2024/25");
        j9.setPartidos(18);
        j9.setMinutos(1620);
        j9.setGoles(1);
        j9.setAsistencias(1);
        j9.setAmarillas(2);

        Jugador j10 = new Jugador(17, "Jonny Otto", 31, "LD", 2.5, 72);
        j10.setTemporada("2024/25");
        j10.setPartidos(14);
        j10.setMinutos(1058);
        j10.setAsistencias(3);
        j10.setAmarillas(1);

        Jugador j11 = new Jugador(8, "Antonio Blanco", 25, "MCD", 10.0, 78);
        j11.setTemporada("2024/25");
        j11.setPartidos(17);
        j11.setMinutos(1415);
        j11.setGoles(1);
        j11.setAsistencias(5);

        Jugador j12 = new Jugador(23, "Carlos Protesoni", 27, "MCD", 1.0, 70);
        j12.setTemporada("2024/25");
        j12.setPartidos(8);
        j12.setMinutos(321);
        j12.setAmarillas(1);

        Jugador j13 = new Jugador(6, "Ander Guevara", 28, "MC", 3.0, 73);
        j13.setTemporada("2024/25");
        j13.setPartidos(14);
        j13.setMinutos(526);
        j13.setGoles(1);
        j13.setAsistencias(2);

        Jugador j14 = new Jugador(10, "Carles Aleñá", 27, "MC", 3.0, 74);
        j14.setTemporada("2024/25");
        j14.setPartidos(11);
        j14.setMinutos(428);
        j14.setAsistencias(2);

        Jugador j15 = new Jugador(19, "Pablo Ibáñez", 27, "MC", 3.0, 73);
        j15.setTemporada("2024/25");
        j15.setPartidos(15);
        j15.setMinutos(800);
        j15.setGoles(1);
        j15.setAsistencias(1);
        j15.setAmarillas(3);

        Jugador j16 = new Jugador(18, "Jon Guridi", 30, "MC", 2.5, 73);
        j16.setTemporada("2024/25");
        j16.setPartidos(14);
        j16.setMinutos(546);
        j16.setAsistencias(1);

        Jugador j17 = new Jugador(20, "Calebe", 25, "MCO", 2.0, 72);
        j17.setTemporada("2024/25");
        j17.setPartidos(13);
        j17.setMinutos(542);
        j17.setAsistencias(2);

        Jugador j18 = new Jugador(4, "Denis Suárez", 31, "MCO", 1.2, 73);
        j18.setTemporada("2024/25");
        j18.setPartidos(8);
        j18.setMinutos(391);
        j18.setAsistencias(1);
        j18.setAmarillas(1);

        Jugador j19 = new Jugador(21, "Abde Rebbach", 27, "EI", 1.5, 71);
        j19.setTemporada("2024/25");
        j19.setPartidos(16);
        j19.setMinutos(842);
        j19.setGoles(2);
        j19.setAsistencias(7);

        Jugador j20 = new Jugador(7, "Carlos Vicente", 26, "ED", 7.0, 76);
        j20.setTemporada("2024/25");
        j20.setPartidos(21);
        j20.setMinutos(1250);
        j20.setGoles(8);
        j20.setAsistencias(3);
        j20.setAmarillas(1);

        Jugador j21 = new Jugador(15, "Lucas Boyé", 29, "DC", 5.0, 75);
        j21.setTemporada("2024/25");
        j21.setPartidos(14);
        j21.setMinutos(978);
        j21.setGoles(4);
        j21.setAmarillas(1);

        Jugador j22 = new Jugador(11, "Toni Martínez", 28, "DC", 3.5, 74);
        j22.setTemporada("2024/25");
        j22.setPartidos(20);
        j22.setMinutos(1298);
        j22.setGoles(4);
        j22.setAsistencias(1);
        j22.setAmarillas(6);

        Jugador j23 = new Jugador(9, "Mariano Díaz", 32, "DC", 0.8, 70);
        j23.setTemporada("2024/25");
        j23.setPartidos(11);
        j23.setMinutos(414);
        j23.setGoles(3);
        j23.setAsistencias(1);
        j23.setAmarillas(2);

        Jugador[] primer = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23};
        for (Jugador j : primer) alaves.añadirPrimerEquipo(j);

        // Cantera mínima (para que no esté vacío)
        Jugador c1 = new Jugador(31, "Iker Aramburu", 19, "POR", 0.4, 64);
        Jugador c2 = new Jugador(33, "Aitor Zubizarreta", 20, "DFC", 0.6, 66);
        Jugador c3 = new Jugador(44, "Adrián Paredes", 19, "DC", 0.8, 68);

        Jugador[] can = {c1, c2, c3};
        for (Jugador j : can) alaves.añadirCantera(j);
    }

    static void cargarRealMadrid(Club madrid) {
        if (madrid == null) return;

        Jugador j1 = new Jugador(1, "Thibaut Courtois", 33, "POR", 18.0, 88);
        Jugador j2 = new Jugador(5, "Jude Bellingham", 22, "MCO", 160.0, 91);
        Jugador j3 = new Jugador(10, "Kylian Mbappé", 27, "DC", 200.0, 94);

        Jugador[] primer = {j1, j2, j3};
        for (Jugador j : primer) madrid.añadirPrimerEquipo(j);

        Jugador c1 = new Jugador(25, "Sergio Mestre", 20, "POR", 0.05, 66);
        madrid.añadirCantera(c1);
    }

}
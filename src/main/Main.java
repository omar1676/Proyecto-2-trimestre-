package main;

import clubes.Club;
import jugadores.Jugador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Club[] clubes = crearClubes();
        cargarAlaves(clubes[0]);
        cargarRealMadrid(clubes[14]);
        menu(clubes);
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

    static void cargarAlaves(Club alaves) {

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
        j3.setGoles(0);
        j3.setAsistencias(2);

        Jugador j4 = new Jugador(22, "Moussa Diarra", 25, "DFC", 1.5, 70);
        j4.setTemporada("2024/25");
        j4.setPartidos(5);
        j4.setMinutos(399);
        j4.setAsistencias(1);

        Jugador j5 = new Jugador(12, "Nikola Maras", 30, "DFC", 0.8, 69);
        j5.setTemporada("2024/25");
        j5.setPartidos(0);
        j5.setMinutos(0);

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


        Jugador c1 = new Jugador(31, "Iker Aramburu", 19, "POR", 0.4, 64);
        c1.setTemporada("2024/25");
        c1.setPartidos(12);
        c1.setMinutos(1080);
        c1.setPorteriasCero(4);
        c1.setAmarillas(1);

        Jugador c2 = new Jugador(32, "Unai Llorente", 18, "POR", 0.2, 61);
        c2.setTemporada("2024/25");
        c2.setPartidos(6);
        c2.setMinutos(540);
        c2.setPorteriasCero(2);

        Jugador c3 = new Jugador(33, "Aitor Zubizarreta", 20, "DFC", 0.6, 66);
        c3.setTemporada("2024/25");
        c3.setPartidos(18);
        c3.setMinutos(1480);
        c3.setGoles(1);
        c3.setAmarillas(5);

        Jugador c4 = new Jugador(34, "Markel Etxeberria", 19, "DFC", 0.5, 65);
        c4.setTemporada("2024/25");
        c4.setPartidos(15);
        c4.setMinutos(1210);
        c4.setAsistencias(1);
        c4.setAmarillas(4);
        c4.setRojas(1);

        Jugador c5 = new Jugador(35, "Hugo Santamaría", 18, "DFC", 0.3, 62);
        c5.setTemporada("2024/25");
        c5.setPartidos(10);
        c5.setMinutos(790);
        c5.setAmarillas(3);

        Jugador c6 = new Jugador(36, "Asier Garmendia", 20, "LI", 0.4, 64);
        c6.setTemporada("2024/25");
        c6.setPartidos(16);
        c6.setMinutos(1280);
        c6.setAsistencias(2);
        c6.setAmarillas(4);

        Jugador c7 = new Jugador(37, "Iñigo Salazar", 19, "LD", 0.4, 64);
        c7.setTemporada("2024/25");
        c7.setPartidos(14);
        c7.setMinutos(1120);
        c7.setGoles(1);
        c7.setAsistencias(1);
        c7.setAmarillas(5);

        Jugador c8 = new Jugador(38, "Jon Ander Urbieta", 20, "MCD", 0.7, 67);
        c8.setTemporada("2024/25");
        c8.setPartidos(19);
        c8.setMinutos(1490);
        c8.setGoles(2);
        c8.setAsistencias(1);
        c8.setAmarillas(6);

        Jugador c9 = new Jugador(39, "Mikel Arrieta", 19, "MC", 0.6, 66);
        c9.setTemporada("2024/25");
        c9.setPartidos(20);
        c9.setMinutos(1560);
        c9.setGoles(3);
        c9.setAsistencias(3);
        c9.setAmarillas(4);

        Jugador c10 = new Jugador(40, "Dani Calderón", 18, "MC", 0.3, 62);
        c10.setTemporada("2024/25");
        c10.setPartidos(12);
        c10.setMinutos(820);
        c10.setGoles(1);
        c10.setAsistencias(2);
        c10.setAmarillas(2);

        Jugador c11 = new Jugador(41, "Gorka Mendizabal", 20, "MCO", 0.6, 66);
        c11.setTemporada("2024/25");
        c11.setPartidos(17);
        c11.setMinutos(1180);
        c11.setGoles(4);
        c11.setAsistencias(5);
        c11.setAmarillas(3);

        Jugador c12 = new Jugador(42, "Izan Rivas", 19, "EI", 0.7, 67);
        c12.setTemporada("2024/25");
        c12.setPartidos(18);
        c12.setMinutos(1200);
        c12.setGoles(6);
        c12.setAsistencias(4);
        c12.setAmarillas(2);

        Jugador c13 = new Jugador(43, "Oier Baroja", 18, "ED", 0.5, 64);
        c13.setTemporada("2024/25");
        c13.setPartidos(16);
        c13.setMinutos(990);
        c13.setGoles(3);
        c13.setAsistencias(6);
        c13.setAmarillas(1);

        Jugador c14 = new Jugador(44, "Adrián Paredes", 19, "DC", 0.8, 68);
        c14.setTemporada("2024/25");
        c14.setPartidos(20);
        c14.setMinutos(1500);
        c14.setGoles(9);
        c14.setAsistencias(2);
        c14.setAmarillas(3);

        Jugador c15 = new Jugador(45, "Xabi Otxoa", 18, "DC", 0.4, 63);
        c15.setTemporada("2024/25");
        c15.setPartidos(14);
        c15.setMinutos(780);
        c15.setGoles(5);
        c15.setAsistencias(1);
        c15.setAmarillas(2);

        Jugador c16 = new Jugador(46, "Gael Romero", 20, "MC", 0.5, 65);
        c16.setTemporada("2024/25");
        c16.setPartidos(15);
        c16.setMinutos(1040);
        c16.setGoles(2);
        c16.setAsistencias(2);
        c16.setAmarillas(4);

        Jugador c17 = new Jugador(47, "Eneko Sola", 19, "DFC", 0.4, 64);
        c17.setTemporada("2024/25");
        c17.setPartidos(13);
        c17.setMinutos(980);
        c17.setGoles(1);
        c17.setAmarillas(5);

        Jugador c18 = new Jugador(48, "Nico Valverde", 18, "EI", 0.3, 62);
        c18.setTemporada("2024/25");
        c18.setPartidos(11);
        c18.setMinutos(640);
        c18.setGoles(2);
        c18.setAsistencias(3);
        c18.setAmarillas(1);


        Jugador[] can = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18};
        for (Jugador j : can) alaves.añadirCantera(j);
    }


    static void cargarRealMadrid(Club madrid) {

        Jugador j1 = new Jugador(1, "Thibaut Courtois", 33, "POR", 18.0, 88);
        j1.setTemporada("2024/25");
        j1.setPartidos(53);
        j1.setMinutos(4830);
        j1.setPorteriasCero(17);
        j1.setAmarillas(1);

        Jugador j2 = new Jugador(13, "Andriy Lunin", 26, "POR", 15.0, 80);
        j2.setTemporada("2024/25");
        j2.setPartidos(14);
        j2.setMinutos(1320);
        j2.setPorteriasCero(6);

        Jugador j3 = new Jugador(24, "Dean Huijsen", 20, "DFC", 70.0, 83);
        j3.setTemporada("2024/25");
        j3.setPartidos(41);
        j3.setMinutos(3262);
        j3.setGoles(3);
        j3.setAsistencias(2);
        j3.setAmarillas(12);

        Jugador j4 = new Jugador(3, "Éder Militão", 27, "DFC", 30.0, 84);
        j4.setTemporada("2024/25");
        j4.setPartidos(18);
        j4.setMinutos(1028);
        j4.setAsistencias(1);
        j4.setAmarillas(4);

        Jugador j5 = new Jugador(17, "Raúl Asencio", 22, "DFC", 30.0, 78);
        j5.setTemporada("2024/25");
        j5.setPartidos(57);
        j5.setMinutos(4177);
        j5.setAsistencias(2);
        j5.setAmarillas(10);
        j5.setRojas(1);

        Jugador j6 = new Jugador(22, "Antonio Rüdiger", 32, "DFC", 12.0, 85);
        j6.setTemporada("2024/25");
        j6.setPartidos(50);
        j6.setMinutos(4190);
        j6.setGoles(6);
        j6.setAmarillas(3);

        Jugador j7 = new Jugador(4, "David Alaba", 33, "DFC", 4.0, 78);
        j7.setTemporada("2024/25");
        j7.setPartidos(14);
        j7.setMinutos(606);
        j7.setAsistencias(1);
        j7.setAmarillas(7);

        Jugador j8 = new Jugador(18, "Álvaro Carreras", 22, "LI", 60.0, 82);
        j8.setTemporada("2024/25");
        j8.setPartidos(50);
        j8.setMinutos(4385);
        j8.setGoles(4);
        j8.setAsistencias(4);
        j8.setAmarillas(18);

        Jugador j9 = new Jugador(20, "Fran García", 26, "LI", 15.0, 79);
        j9.setTemporada("2024/25");
        j9.setPartidos(54);
        j9.setMinutos(3500);
        j9.setGoles(1);
        j9.setAsistencias(5);
        j9.setAmarillas(19);

        Jugador j10 = new Jugador(23, "Ferland Mendy", 30, "LI", 8.0, 80);
        j10.setTemporada("2024/25");
        j10.setPartidos(31);
        j10.setMinutos(2245);
        j10.setAsistencias(2);
        j10.setAmarillas(3);
        j10.setRojas(1);

        Jugador j11 = new Jugador(12, "Trent Alexander-Arnold", 27, "LD", 70.0, 86);
        j11.setTemporada("2024/25");
        j11.setPartidos(49);
        j11.setMinutos(3479);
        j11.setGoles(4);
        j11.setAsistencias(10);
        j11.setAmarillas(5);

        Jugador j12 = new Jugador(2, "Daniel Carvajal", 33, "LD", 7.0, 83);
        j12.setTemporada("2024/25");
        j12.setPartidos(12);
        j12.setMinutos(897);
        j12.setGoles(1);
        j12.setAsistencias(1);
        j12.setAmarillas(3);

        Jugador j13 = new Jugador(14, "Aurélien Tchouaméni", 25, "MCD", 75.0, 86);
        j13.setTemporada("2024/25");
        j13.setPartidos(61);
        j13.setMinutos(4158);
        j13.setGoles(4);
        j13.setAsistencias(8);
        j13.setAmarillas(10);

        Jugador j14 = new Jugador(8, "Federico Valverde", 27, "MC", 120.0, 90);
        j14.setTemporada("2024/25");
        j14.setPartidos(65);
        j14.setMinutos(5556);
        j14.setGoles(11);
        j14.setAsistencias(8);
        j14.setAmarillas(5);

        Jugador j15 = new Jugador(6, "Eduardo Camavinga", 23, "MC", 50.0, 86);
        j15.setTemporada("2024/25");
        j15.setPartidos(35);
        j15.setMinutos(2082);
        j15.setGoles(2);
        j15.setAsistencias(2);
        j15.setAmarillas(13);
        j15.setRojas(1);

        Jugador j16 = new Jugador(19, "Dani Ceballos", 29, "MC", 8.0, 79);
        j16.setTemporada("2024/25");
        j16.setPartidos(45);
        j16.setMinutos(2077);

        Jugador j17 = new Jugador(5, "Jude Bellingham", 22, "MCO", 160.0, 91);
        j17.setTemporada("2024/25");
        j17.setPartidos(50);
        j17.setMinutos(4341);
        j17.setGoles(22);
        j17.setAsistencias(14);
        j17.setAmarillas(10);

        Jugador j18 = new Jugador(15, "Arda Güler", 20, "MCO", 90.0, 82);
        j18.setTemporada("2024/25");
        j18.setPartidos(49);
        j18.setMinutos(2197);
        j18.setGoles(6);
        j18.setAsistencias(11);
        j18.setAmarillas(26);

        Jugador j19 = new Jugador(7, "Vinícius Júnior", 25, "EI", 150.0, 91);
        j19.setTemporada("2024/25");
        j19.setPartidos(58);
        j19.setMinutos(4260);
        j19.setGoles(23);
        j19.setAsistencias(13);
        j19.setAmarillas(12);

        Jugador j20 = new Jugador(11, "Rodrygo", 24, "ED", 60.0, 87);
        j20.setTemporada("2024/25");
        j20.setPartidos(54);
        j20.setMinutos(3453);
        j20.setGoles(14);
        j20.setAsistencias(11);
        j20.setAmarillas(14);

        Jugador j21 = new Jugador(30, "Franco Mastantuono", 18, "ED", 50.0, 80);
        j21.setTemporada("2024/25");
        j21.setPartidos(22);
        j21.setMinutos(1747);
        j21.setGoles(7);
        j21.setAsistencias(4);
        j21.setAmarillas(4);

        Jugador j22 = new Jugador(21, "Brahim Díaz", 26, "ED", 35.0, 83);
        j22.setTemporada("2024/25");
        j22.setPartidos(56);
        j22.setMinutos(2290);
        j22.setGoles(6);
        j22.setAsistencias(8);
        j22.setAmarillas(1);

        Jugador j23 = new Jugador(10, "Kylian Mbappé", 27, "DC", 200.0, 94);
        j23.setTemporada("2024/25");
        j23.setPartidos(56);
        j23.setMinutos(5032);
        j23.setGoles(47);
        j23.setAsistencias(19);
        j23.setAmarillas(6);

        Jugador j24 = new Jugador(16, "Gonzalo García", 21, "DC", 15.0, 76);
        j24.setTemporada("2024/25");

        Jugador[] primer = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24};

        for (Jugador j : primer) madrid.añadirPrimerEquipo(j);


        Jugador c1 = new Jugador(1, "Fran González", 20, "POR", 1.0, 70);
        c1.setTemporada("2024/25");
        c1.setPartidos(16);
        c1.setMinutos(1440);
        c1.setPorteriasCero(6);
        c1.setAmarillas(1);
        c1.setRojas(0);

        Jugador c2 = new Jugador(25, "Sergio Mestre", 20, "POR", 0.05, 66);
        c2.setTemporada("2024/25");
        c2.setPartidos(10);
        c2.setMinutos(900);
        c2.setPorteriasCero(4);
        c2.setAmarillas(0);
        c2.setRojas(0);

        Jugador c3 = new Jugador(13, "Guille Súnico", 21, "POR", 0.025, 63);
        c3.setTemporada("2024/25");
        c3.setPartidos(6);
        c3.setMinutos(540);
        c3.setPorteriasCero(2);
        c3.setAmarillas(1);
        c3.setRojas(0);

        Jugador c4 = new Jugador(3, "Víctor Valdepeñas", 19, "DFC", 3.0, 72);
        c4.setTemporada("2024/25");
        c4.setPartidos(22);
        c4.setMinutos(1760);
        c4.setGoles(1);
        c4.setAsistencias(0);
        c4.setAmarillas(6);
        c4.setRojas(0);

        Jugador c5 = new Jugador(15, "Joan Martínez", 18, "DFC", 3.0, 71);
        c5.setTemporada("2024/25");
        c5.setPartidos(18);
        c5.setMinutos(1440);
        c5.setGoles(1);
        c5.setAsistencias(1);
        c5.setAmarillas(5);
        c5.setRojas(0);

        Jugador c6 = new Jugador(21, "Diego Aguado", 18, "DFC", 3.0, 71);
        c6.setTemporada("2024/25");
        c6.setPartidos(20);
        c6.setMinutos(1600);
        c6.setGoles(0);
        c6.setAsistencias(1);
        c6.setAmarillas(7);
        c6.setRojas(1);

        Jugador c7 = new Jugador(23, "Lamini Fati", 19, "DFC", 1.0, 69);
        c7.setTemporada("2024/25");
        c7.setPartidos(16);
        c7.setMinutos(1210);
        c7.setGoles(0);
        c7.setAsistencias(0);
        c7.setAmarillas(4);
        c7.setRojas(0);

        Jugador c8 = new Jugador(4, "Mario Rivas", 18, "DFC", 0.3, 67);
        c8.setTemporada("2024/25");
        c8.setPartidos(15);
        c8.setMinutos(980);
        c8.setGoles(0);
        c8.setAsistencias(1);
        c8.setAmarillas(3);
        c8.setRojas(0);

        Jugador c9 = new Jugador(5, "Manu Serrano", 21, "LI", 0.3, 68);
        c9.setTemporada("2024/25");
        c9.setPartidos(19);
        c9.setMinutos(1410);
        c9.setGoles(1);
        c9.setAsistencias(3);
        c9.setAmarillas(5);
        c9.setRojas(0);

        Jugador c10 = new Jugador(2, "David Jiménez", 21, "LD", 3.0, 72);
        c10.setTemporada("2024/25");
        c10.setPartidos(21);
        c10.setMinutos(1650);
        c10.setGoles(1);
        c10.setAsistencias(4);
        c10.setAmarillas(6);
        c10.setRojas(0);

        Jugador c11 = new Jugador(17, "Jesús Fortea", 18, "LD", 2.0, 70);
        c11.setTemporada("2024/25");
        c11.setPartidos(17);
        c11.setMinutos(1180);
        c11.setGoles(0);
        c11.setAsistencias(3);
        c11.setAmarillas(4);
        c11.setRojas(0);

        Jugador c12 = new Jugador(6, "Cristian Perea", 20, "MCD", 0.5, 70);
        c12.setTemporada("2024/25");
        c12.setPartidos(23);
        c12.setMinutos(1790);
        c12.setGoles(1);
        c12.setAsistencias(2);
        c12.setAmarillas(7);
        c12.setRojas(0);

        Jugador c13 = new Jugador(14, "Jorge Cestero", 19, "MC", 3.0, 72);
        c13.setTemporada("2024/25");
        c13.setPartidos(25);
        c13.setMinutos(1920);
        c13.setGoles(3);
        c13.setAsistencias(5);
        c13.setAmarillas(5);
        c13.setRojas(0);

        Jugador c14 = new Jugador(27, "Thiago Pitarch", 18, "MC", 3.0, 71);
        c14.setTemporada("2024/25");
        c14.setPartidos(21);
        c14.setMinutos(1540);
        c14.setGoles(2);
        c14.setAsistencias(4);
        c14.setAmarillas(4);
        c14.setRojas(0);

        Jugador c15 = new Jugador(8, "Manuel Ángel", 21, "MC", 0.5, 69);
        c15.setTemporada("2024/25");
        c15.setPartidos(18);
        c15.setMinutos(1220);
        c15.setGoles(1);
        c15.setAsistencias(3);
        c15.setAmarillas(3);
        c15.setRojas(0);

        Jugador c16 = new Jugador(28, "Roberto Martín", 19, "MC", 0.05, 64);
        c16.setTemporada("2024/25");
        c16.setPartidos(12);
        c16.setMinutos(640);
        c16.setGoles(0);
        c16.setAsistencias(1);
        c16.setAmarillas(2);
        c16.setRojas(0);

        Jugador c17 = new Jugador(30, "Dani Meso", 20, "MC", 0.05, 64);
        c17.setTemporada("2024/25");
        c17.setPartidos(14);
        c17.setMinutos(790);
        c17.setGoles(1);
        c17.setAsistencias(1);
        c17.setAmarillas(3);
        c17.setRojas(0);

        Jugador c18 = new Jugador(10, "César Palacios", 21, "MCO", 0.5, 70);
        c18.setTemporada("2024/25");
        c18.setPartidos(20);
        c18.setMinutos(1360);
        c18.setGoles(5);
        c18.setAsistencias(6);
        c18.setAmarillas(2);
        c18.setRojas(0);

        Jugador c19 = new Jugador(20, "Pol Fortuny", 20, "MCO", 0.4, 69);
        c19.setTemporada("2024/25");
        c19.setPartidos(18);
        c19.setMinutos(1120);
        c19.setGoles(3);
        c19.setAsistencias(5);
        c19.setAmarillas(2);
        c19.setRojas(0);

        Jugador c20 = new Jugador(11, "Bruno Iglesias", 22, "MCO", 0.2, 68);
        c20.setTemporada("2024/25");
        c20.setPartidos(17);
        c20.setMinutos(1010);
        c20.setGoles(4);
        c20.setAsistencias(3);
        c20.setAmarillas(1);
        c20.setRojas(0);

        Jugador c21 = new Jugador(33, "Gabri Castrelo", 19, "MCO", 0.05, 64);
        c21.setTemporada("2024/25");
        c21.setPartidos(13);
        c21.setMinutos(670);
        c21.setGoles(2);
        c21.setAsistencias(2);
        c21.setAmarillas(1);
        c21.setRojas(0);

        Jugador c22 = new Jugador(22, "Hugo de Llanos", 20, "EI", 0.2, 67);
        c22.setTemporada("2024/25");
        c22.setPartidos(19);
        c22.setMinutos(1080);
        c22.setGoles(4);
        c22.setAsistencias(4);
        c22.setAmarillas(2);
        c22.setRojas(0);

        Jugador c23 = new Jugador(7, "Daniel Yáñez", 18, "ED", 0.15, 67);
        c23.setTemporada("2024/25");
        c23.setPartidos(17);
        c23.setMinutos(980);
        c23.setGoles(3);
        c23.setAsistencias(5);
        c23.setAmarillas(1);
        c23.setRojas(0);

        Jugador c24 = new Jugador(18, "Rachad Fettal", 20, "DC", 0.7, 69);
        c24.setTemporada("2024/25");
        c24.setPartidos(20);
        c24.setMinutos(1260);
        c24.setGoles(8);
        c24.setAsistencias(2);
        c24.setAmarillas(3);
        c24.setRojas(0);

        Jugador c25 = new Jugador(9, "Loren Zúñiga", 22, "DC", 0.2, 67);
        c25.setTemporada("2024/25");
        c25.setPartidos(16);
        c25.setMinutos(960);
        c25.setGoles(6);
        c25.setAsistencias(1);
        c25.setAmarillas(2);
        c25.setRojas(0);


        Jugador[] cantera = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25};

        for (Jugador j : cantera) madrid.añadirCantera(j);
    }


    static void menu(Club[] clubes) {
        Scanner sc = new Scanner(System.in);
        Club clubActual = clubes[0];
        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("CLUB ACTUAL: " + clubActual.getNombre());
            System.out.println("==============================");
            System.out.println("1. Elegir club");
            System.out.println("2. Ver plantilla");
            System.out.println("3. Buscar jugador por dorsal (stats)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            if (opcion == 1) {

                mostrarListaClubesRecuadro(clubes);

                System.out.print("\nElige número de club: ");
                int eleccion = sc.nextInt();

                if (eleccion >= 1 && eleccion <= clubes.length) {
                    clubActual = clubes[eleccion - 1];
                    System.out.println("\nClub seleccionado: " + clubActual.getNombre());
                    clubActual.mostrarFichaClub();
                } else {
                    System.out.println("Número inválido.");
                }

            } else if (opcion == 2) {

                if (clubActual.getNumPrimerEquipo() == 0 && clubActual.getNumCantera() == 0) {
                    System.out.println("\nEste club todavía no tiene jugadores cargados.");
                    continue;
                }

                clubActual.mostrarPlantilla();

            } else if (opcion == 3) {

                System.out.print("Dorsal del jugador: ");
                int dorsal = sc.nextInt();

                Jugador p = clubActual.buscarPrimerEquipo(dorsal);
                Jugador c = clubActual.buscarCantera(dorsal);

                if (p == null && c == null) {
                    System.out.println("No existe jugador con dorsal " + dorsal + " en " + clubActual.getNombre());

                } else if (p != null && c == null) {
                    mostrarEstadisticasRecuadro(clubActual, p);

                } else if (p == null) {
                    mostrarEstadisticasRecuadro(clubActual, c);

                } else {
                    System.out.println("\nHay dos jugadores con el dorsal " + dorsal + ":");
                    System.out.println("1) PRIMER EQUIPO -> " + p.getNombre() + " (" + p.getPosicion() + ")");
                    System.out.println("2) CANTERA       -> " + c.getNombre() + " (" + c.getPosicion() + ")");
                    System.out.print("Elige 1 o 2: ");
                    int elegir = sc.nextInt();

                    if (elegir == 1) mostrarEstadisticasRecuadro(clubActual, p);
                    else if (elegir == 2) mostrarEstadisticasRecuadro(clubActual, c);
                    else System.out.println("Opción inválida.");
                }

            } else if (opcion != 4) {
                System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);

        System.out.println("Saliendo del programa...");
        sc.close();
    }



    static void mostrarEstadisticasRecuadro(Club club, Jugador j) {
        final int INNER = 63;
        final String TOP = "┌" + "─".repeat(INNER) + "┐";
        final String MID = "├" + "─".repeat(INNER) + "┤";
        final String BOT = "└" + "─".repeat(INNER) + "┘";

        System.out.println(TOP);
        System.out.println("│" + center("ESTADÍSTICAS DEL JUGADOR", INNER) + "│");
        System.out.println(MID);

        System.out.println("│" + col(" Club: " + club.getNombre(), INNER) + "│");
        System.out.println("│" + col(" Jugador: " + j.getNombre() + "  (#" + j.getDorsal() + " - " + j.getPosicion() + ")", INNER) + "│");
        System.out.println("│" + col(" Edad: " + j.getEdad()
                + " | Valor (€M): " + String.format("%.1f", j.getValorMercado())
                + " | VAL: " + j.getValoracion(), INNER) + "│");

        System.out.println(MID);

        System.out.println("│" + col(" Temporada: " + j.getTemporada(), INNER) + "│");
        System.out.println("│" + col(" Partidos: " + j.getPartidos() + " | Minutos: " + j.getMinutos(), INNER) + "│");
        System.out.println("│" + col(" Goles: " + j.getGoles() + " | Asistencias: " + j.getAsistencias(), INNER) + "│");
        System.out.println("│" + col(" Amarillas: " + j.getAmarillas() + " | Rojas: " + j.getRojas(), INNER) + "│");

        if ("POR".equalsIgnoreCase(j.getPosicion())) {
            System.out.println("│" + col(" Porterías a cero: " + j.getPorteriasCero(), INNER) + "│");
        }

        System.out.println(BOT);
    }


    static void mostrarListaClubesRecuadro(Club[] clubes) {
        final int INNER = 86;
        final String TOP = "┌" + "─".repeat(INNER) + "┐";
        final String MID = "├" + "─".repeat(INNER) + "┤";
        final String BOT = "└" + "─".repeat(INNER) + "┘";

        System.out.println(TOP);
        System.out.println("│" + center("--- LISTA DE CLUBES (palmarés) ---", INNER) + "│");
        System.out.println(MID);

        String header =
                colR("Nº", 3) + "  " +
                        col("CLUB", 22) + "  " +
                        colR("LIGA", 4) + "  " +
                        colR("COPA", 4) + "  " +
                        colR("UCL", 4) + "  " +
                        colR("SUP", 4) + "  " +
                        colR("MUND", 4) + "  " +
                        col("JUGADORES", 15);

        System.out.println("│" + col(header, INNER) + "│");
        System.out.println(MID);

        for (int i = 0; i < clubes.length; i++) {
            Club c = clubes[i];

            String estado = (c.getNumPrimerEquipo() == 0 && c.getNumCantera() == 0)
                    ? ""
                    : ("OK (" + (c.getNumPrimerEquipo() + c.getNumCantera()) + ")");

            String fila =
                    colR(String.valueOf(i + 1), 3) + "  " +
                            col(c.getNombre(), 22) + "  " +
                            colR(String.valueOf(c.getLiga()), 4) + "  " +
                            colR(String.valueOf(c.getCopa()), 4) + "  " +
                            colR(String.valueOf(c.getUcl()), 4) + "  " +
                            colR(String.valueOf(c.getSupercopa()), 4) + "  " +
                            colR(String.valueOf(c.getMundial()), 4) + "  " +
                            col(estado, 15);

            System.out.println("│" + col(fila, INNER) + "│");
        }

        System.out.println(BOT);
    }

    private static String col(String s, int len) {
        return String.format("%-" + len + "." + len + "s", s == null ? "" : s);
    }

    private static String colR(String s, int len) {
        return String.format("%" + len + "." + len + "s", s == null ? "" : s);
    }

    private static String center(String s, int len) {
        s = (s == null) ? "" : s;
        if (s.length() > len) s = s.substring(0, len);
        int left = (len - s.length()) / 2;
        int right = len - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }
}

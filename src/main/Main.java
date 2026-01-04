package main;

import clubes.Club;
import jugadores.Jugador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Club c1 = new Club(1, "Alavés", 1930, "Omar", 30, 50);


        Jugador j1  = new Jugador(1,  "Antonio Sivera",   29, "POR", 6.0, 78);
        Jugador j2  = new Jugador(13, "Raúl Fernández",   37, "POR", 0.2, 71);


        Jugador j3  = new Jugador(5,  "Jon Pacheco",      24, "DFC", 5.0, 74);
        Jugador j4  = new Jugador(22, "Moussa Diarra",    25, "DFC", 1.5, 70);
        Jugador j5  = new Jugador(12, "Nikola Maras",     30, "DFC", 0.8, 69);

        Jugador j6  = new Jugador(2,  "Facundo Garcés",   26, "DFC", 0.0, 70);

        Jugador j7  = new Jugador(3,  "Youssef Enríquez", 20, "LI",  5.0, 73);
        Jugador j8  = new Jugador(24, "Victor Parada",    23, "LI",  2.0, 71);
        Jugador j9  = new Jugador(14, "Nahuel Tenaglia",  29, "LD",  3.0, 74);
        Jugador j10 = new Jugador(17, "Jonny Otto",       31, "LD",  2.5, 72);


        Jugador j11 = new Jugador(8,  "Antonio Blanco",   25, "MCD", 10.0, 78);
        Jugador j12 = new Jugador(23, "Carlos Protesoni", 27, "MCD", 1.0, 70);
        Jugador j13 = new Jugador(6,  "Ander Guevara",    28, "MC",  3.0, 73);
        Jugador j14 = new Jugador(10, "Carles Aleñá",     27, "MC",  3.0, 74);
        Jugador j15 = new Jugador(19, "Pablo Ibáñez",     27, "MC",  3.0, 73);
        Jugador j16 = new Jugador(18, "Jon Guridi",       30, "MC",  2.5, 73);

        Jugador j17 = new Jugador(20, "Calebe",           25, "MCO", 2.0, 72);
        Jugador j18 = new Jugador(4,  "Denis Suárez",     31, "MCO", 1.2, 73);


        Jugador j19 = new Jugador(21, "Abde Rebbach",     27, "EI",  1.5, 71);
        Jugador j20 = new Jugador(7,  "Carlos Vicente",  26, "ED",  7.0, 76);

        Jugador j21 = new Jugador(15, "Lucas Boyé",       29, "DC",  5.0, 75);
        Jugador j22 = new Jugador(11, "Toni Martínez",    28, "DC",  3.5, 74);
        Jugador j23 = new Jugador(9,  "Mariano Díaz",     32, "DC",  0.8, 70);


        j1.setTemporada("2025/26");
        j1.setPartidos(18);
        j1.setMinutos(1620);
        j1.setPorteriasCero(6);
        j1.setAmarillas(1);

        j2.setTemporada("2025/26");
        j2.setPartidos(6);
        j2.setMinutos(540);
        j2.setPorteriasCero(2);

        c1.añadirPrimerEquipo(j1);
        c1.añadirPrimerEquipo(j2);
        c1.añadirPrimerEquipo(j3);
        c1.añadirPrimerEquipo(j4);
        c1.añadirPrimerEquipo(j5);
        c1.añadirPrimerEquipo(j6);
        c1.añadirPrimerEquipo(j7);
        c1.añadirPrimerEquipo(j8);
        c1.añadirPrimerEquipo(j9);
        c1.añadirPrimerEquipo(j10);
        c1.añadirPrimerEquipo(j11);
        c1.añadirPrimerEquipo(j12);
        c1.añadirPrimerEquipo(j13);
        c1.añadirPrimerEquipo(j14);
        c1.añadirPrimerEquipo(j15);
        c1.añadirPrimerEquipo(j16);
        c1.añadirPrimerEquipo(j17);
        c1.añadirPrimerEquipo(j18);
        c1.añadirPrimerEquipo(j19);
        c1.añadirPrimerEquipo(j20);
        c1.añadirPrimerEquipo(j21);
        c1.añadirPrimerEquipo(j22);
        c1.añadirPrimerEquipo(j23);

        menu(c1);
    }


    static void menu(Club club) {

        Scanner sc = new Scanner(System.in);
        int opcionMenu;

        do {
            System.out.println("\n1. Ver plantilla");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcionMenu = sc.nextInt();

            if (opcionMenu == 1) {

                club.mostrarPlantilla();

                int opcionPlantilla;
                do {
                    System.out.println("\n¿Qué plantilla quieres consultar?");
                    System.out.println("1. Primer equipo");
                    System.out.println("2. Cantera");
                    System.out.println("3. Volver al menú principal");
                    System.out.print("Elige: ");
                    opcionPlantilla = sc.nextInt();

                    if (opcionPlantilla == 1 || opcionPlantilla == 2) {

                        int opcionEstadisticas;
                        do {
                            System.out.println("\n¿Quieres ver las estadísticas de algún jugador?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            System.out.print("Elige: ");
                            opcionEstadisticas = sc.nextInt();

                            if (opcionEstadisticas == 1) {

                                System.out.print("Introduce dorsal: ");
                                int dorsal = sc.nextInt();

                                Jugador encontrado;
                                if (opcionPlantilla == 1) {
                                    encontrado = club.buscarPorDorsalPrimerEquipo(dorsal);
                                } else {
                                    encontrado = club.buscarPorDorsalCantera(dorsal);
                                }

                                if (encontrado != null) {
                                    System.out.println("\nJugador encontrado:");

                                    encontrado.datosTransferMarket();
                                } else {
                                    System.out.println("\nNo existe ningún jugador con ese dorsal en esa plantilla.");
                                }

                            } else if (opcionEstadisticas == 2) {

                            } else {
                                System.out.println("Opción no válida.");
                            }

                        } while (opcionEstadisticas != 2);

                    } else if (opcionPlantilla == 3) {
                        System.out.println("Volviendo al menú principal...");
                    } else {
                        System.out.println("Opción incorrecta.");
                    }

                } while (opcionPlantilla != 3);

            } else if (opcionMenu == 2) {
                System.out.println("Partidos (en desarrollo)");

            } else if (opcionMenu == 3) {
                System.out.println("Porcentaje (en desarrollo)");

            } else if (opcionMenu == 4) {
                System.out.println("Saliendo del programa...");

            } else {
                System.out.println("Opción incorrecta");
            }

        } while (opcionMenu != 4);


    }
}

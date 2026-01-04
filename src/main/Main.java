package main;

import clubes.Club;
import jugadores.Jugador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Club c1 = new Club(1, "Alavés", 1930, "Omar", 30, 30);


        Jugador j1 = new Jugador(1, "Antonio Sivera", 29, "POR", 6.0, 78);
        Jugador j2 = new Jugador(3, "Raúl Fernández", 37, "POR", 0.2, 71);


        c1.añadirPrimerEquipo(j1);
        c1.añadirPrimerEquipo(j2);


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
                                    System.out.println(encontrado);
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

        sc.close();
    }
}
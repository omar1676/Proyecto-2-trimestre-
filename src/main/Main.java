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
        int opcion;

        do {
            System.out.println("1. Ver plantilla");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            if (opcion == 1) {
                club.mostrarPlantilla();
            } else if (opcion == 2) {
                System.out.println("Partidos (en desarrollo)");
            } else if (opcion == 3) {
                System.out.println("Porcentaje (en desarrollo)");
            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);
    }
}

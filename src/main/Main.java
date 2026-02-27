package main;

import clubes.Club;
import competicion.*;
import datos.CargadorDatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EuropaLeague europa = new EuropaLeague("Europa League (Simulación)", new Club[0]);

        while (true) {
            System.out.println("Elige competición:");
            System.out.println("1) LaLiga");
            System.out.println("2) Premier League");
            System.out.println("3) Bundesliga");
            System.out.println("4) Serie A");
            System.out.println("5) Ligue 1");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 0) {
                System.out.println("Saliendo...");
                return;
            }

            Club[] clubesElegidos;
            Competicion competicionElegida;

            switch (opcion) {
                case 1:
                    clubesElegidos = CargadorDatos.crearClubesConPlantillas();
                    competicionElegida = new Liga("LaLiga", clubesElegidos);
                    break;
                case 2:
                    clubesElegidos = CargadorDatos.crearClubesPremierLeague();
                    competicionElegida = new PremierLeague("Premier League 2024/25", clubesElegidos);
                    break;
                case 3:
                    clubesElegidos = CargadorDatos.crearClubesBundesliga();
                    competicionElegida = new Bundesliga("Bundesliga 2024/25", clubesElegidos);
                    break;
                case 4:
                    clubesElegidos = CargadorDatos.crearClubesSerieA();
                    competicionElegida = new SerieA("Serie A 2024/25", clubesElegidos);
                    break;
                case 5:
                    clubesElegidos = CargadorDatos.crearClubesLigue1();
                    competicionElegida = new Ligue1("Ligue 1 2024/25", clubesElegidos);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            competicionElegida.generar();
            Menu.mostrar(clubesElegidos, competicionElegida, europa);
        }
    }
}
package main;

import clubes.Club;
import competicion.Competicion;
import competicion.Liga;
import competicion.PremierLeague;
import competicion.SerieA;
import competicion.Bundesliga;
import competicion.Ligue1;
import datos.CargadorDatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elige competición:");
        System.out.println("1) LaLiga");
        System.out.println("2) Premier League");
        System.out.println("3) Serie A");
        System.out.println("4) Bundesliga");
        System.out.println("5) Ligue 1");
        System.out.print("Opción: ");

        int opcion = sc.nextInt();
        sc.nextLine(); // IMPORTANTE: consume el salto de línea

        Club[] clubesElegidos = null;
        Competicion competicionElegida = null;

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
                clubesElegidos = CargadorDatos.crearClubesSerieA();
                competicionElegida = new SerieA("Serie A 2024/25", clubesElegidos);
                break;

            case 4:
                clubesElegidos = CargadorDatos.crearClubesBundesliga();
                competicionElegida = new Bundesliga("Bundesliga 2024/25", clubesElegidos);
                break;

            case 5:
                clubesElegidos = CargadorDatos.crearClubesLigue1();
                competicionElegida = new Ligue1("Ligue 1 2024/25", clubesElegidos);
                break;

            default:
                System.out.println("Opción inválida. Saliendo...");
                return;
        }

        competicionElegida.generar();
        Menu.mostrar(clubesElegidos, competicionElegida);
    }
}
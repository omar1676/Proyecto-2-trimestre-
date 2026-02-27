package main;

import clubes.Club;
import competicion.*;
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
        System.out.println("6) Supercopa de España");
        System.out.println("7) Segunda División");
        System.out.println("8) Copa de España");
        System.out.print("Opción: ");

        int opcion = sc.nextInt();
        sc.nextLine();

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

            case 6:
                Club[] todosLosClubes = CargadorDatos.crearClubesConPlantillas();
                clubesElegidos = new Club[4];
                for (int i = 0; i < 4; i++) {
                    clubesElegidos[i] = todosLosClubes[i];
                }
                competicionElegida = new Supercopa("Supercopa de España", clubesElegidos);
                break;

            case 7:
                clubesElegidos = CargadorDatos.crearClubesHypermotion();
                competicionElegida = new SegundaDivision("LaLiga Hypermotion", clubesElegidos);
                break;

            case 8:
                Club[] p1 = CargadorDatos.crearClubesConPlantillas();
                Club[] p2 = CargadorDatos.crearClubesHypermotion();
                clubesElegidos = new Club[p1.length + p2.length];
                System.arraycopy(p1, 0, clubesElegidos, 0, p1.length);
                System.arraycopy(p2, 0, clubesElegidos, p1.length, p2.length);
                competicionElegida = new Copa("Copa de España 2024/25", clubesElegidos);
                break;

            default:
                System.out.println("Opción inválida. Saliendo...");
                return;
        }

        competicionElegida.generar();
        Menu.mostrar(clubesElegidos, competicionElegida);
    }
}
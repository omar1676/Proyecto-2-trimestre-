package main;

import clubes.Club;
import datos.CargadorDatos;
import liga.Liga;

public class Main {
    public static void main(String[] args) {

        Club[] clubes = CargadorDatos.crearClubesConPlantillas();

        Liga liga = new Liga("LaLiga", clubes);
        liga.generar();

        Menu.mostrar(clubes, liga);
    }
}

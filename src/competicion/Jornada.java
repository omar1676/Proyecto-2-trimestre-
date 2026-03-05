package competicion;

import partido.Partido;

public class Jornada {

    private int numero;
    private Partido[] partidos;

    public Jornada(int numero, Partido[] partidos) {
        if (numero < 1) {
            this.numero = 1;
        } else {
            this.numero = numero;
        }

        if (partidos == null) {
            this.partidos = new Partido[0];
        } else {
            this.partidos = partidos;
        }
    }

    public int getNumero() {
        return numero;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void mostrarPartidos() {
        if (partidos == null || partidos.length == 0) {
            System.out.println("(No hay partidos en esta jornada)");
            return;
        }

        int i = 0;
        while (i < partidos.length) {
            if (partidos[i] != null) {
                System.out.println(partidos[i]);
            }
            i++;
        }
    }

    @Override
    public String toString() {
        int total = 0;
        if (partidos != null) {
            total = partidos.length;
        }
        return "Jornada " + numero + " - " + total + " partidos";
    }
}
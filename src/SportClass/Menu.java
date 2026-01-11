package SportClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        LocalDate inicioSemana = LocalDate.now();

        ArrayList<Evento> eventosSemana = new ArrayList<>();
        eventosSemana.add(new Evento(inicioSemana.plusDays(1), "Fútbol", "Liga - Jornada"));
        eventosSemana.add(new Evento(inicioSemana.plusDays(5), "Fútbol", "Copa - Eliminatoria"));
        eventosSemana.add(new Evento(inicioSemana.plusDays(2), "Baloncesto", "Euroliga"));
        eventosSemana.add(new Evento(inicioSemana.plusDays(6), "Carreras", "Gran Premio"));


        do {
            System.out.println("\nSEMANA: " + inicioSemana + " -> " + inicioSemana.plusDays(6));
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Fútbol");
            System.out.println("2. Baloncesto");
            System.out.println("3. Carreras");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                mostrarDeporte(eventosSemana, "Fútbol");
            } else if (opcion == 2) {
                mostrarDeporte(eventosSemana, "Baloncesto");
            } else if (opcion == 3) {
                mostrarDeporte(eventosSemana, "Carreras");
            } else if (opcion == 0) {
                System.out.println("Saliendo de la semana...");
            } else {
                System.out.println("Opción invalida");
            }

        } while (opcion != 0);
    }

    private void mostrarDeporte(ArrayList<Evento> eventos, String deporte) {
        System.out.println("\n--- " + deporte + " esta semana ---");
        boolean hay = false;

        for (Evento e : eventos) {
            if (deporte.equalsIgnoreCase(deporte)) {
                System.out.println(e);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay eventos de " + deporte + " esta semana.");
        }
    }
}

package main;

import clubes.Club;
import competicion.*;
import jugadores.Jugador;

import java.util.Scanner;

public class Menu {

    public static void mostrar(Club[] clubes, Competicion competicion, EuropaLeague europa) {
        Scanner sc = new Scanner(System.in);

        Club clubActual = null;
        if (clubes != null && clubes.length > 0) {
            clubActual = clubes[0];
        }

        Club clubSeguido = null;
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n==============================");

            if (clubActual == null) System.out.println("CLUB ACTUAL: -");
            else System.out.println("CLUB ACTUAL: " + clubActual.getNombre());

            if (competicion == null) System.out.println("COMPETICION: -");
            else System.out.println("COMPETICION: " + competicion.getNombre());

            if (clubSeguido == null) System.out.println("EQUIPO SEGUIDO: -");
            else System.out.println("EQUIPO SEGUIDO: " + clubSeguido.getNombre());

            if (europa == null) System.out.println("EUROPA LEAGUE (SIM): -");
            else System.out.println("EUROPA LEAGUE (SIM): " + europa.getTotalEquipos() + " equipos");

            System.out.println("==============================");
            System.out.println("1. Elegir club actual");
            System.out.println("2. Ver plantilla (club actual)");
            System.out.println("3. Buscar jugador por dorsal (club actual)");
            System.out.println("4. Ver ficha del club (club actual)");
            System.out.println("------------------------------");
            System.out.println("5. Elegir equipo a seguir");
            System.out.println("6. Simular 1 jornada (rapido)");
            System.out.println("7. Simular 1 jornada (solo equipo seguido en directo)");
            System.out.println("8. Ver ultima jornada");
            System.out.println("9. Ver clasificacion");
            System.out.println("------------------------------");
            System.out.println("11. Ver equipos clasificados a Europa League (sim)");
            System.out.println("12. Simular 1 jornada Europa League (sim)");
            System.out.println("13. Ver ultima jornada Europa League (sim)");
            System.out.println("14. Ver clasificacion Europa League (sim)");
            System.out.println("------------------------------");
            System.out.println("10. Elegir otras Ligas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero(sc);

            if (opcion == 1) {

                clubActual = elegirClub(sc, clubes);
                if (clubActual != null) clubActual.mostrarFichaClub();

            } else if (opcion == 2) {

                if (clubActual == null) {
                    System.out.println("No hay club seleccionado.");
                } else {
                    if (clubActual.getNumPrimerEquipo() == 0 && clubActual.getNumCantera() == 0) {
                        System.out.println("Este club no tiene jugadores cargados.");
                    } else {
                        clubActual.mostrarPlantilla();
                    }
                }

            } else if (opcion == 3) {

                if (clubActual == null) {
                    System.out.println("No hay club seleccionado.");
                } else {
                    System.out.print("Dorsal: ");
                    int dorsal = leerEntero(sc);

                    Jugador p = clubActual.buscarPrimerEquipo(dorsal);
                    Jugador c = clubActual.buscarCantera(dorsal);

                    if (p == null && c == null) {
                        System.out.println("No existe jugador con dorsal " + dorsal + " en " + clubActual.getNombre());
                    } else if (p != null && c == null) {
                        mostrarEstadisticas(clubActual, p);
                    } else if (p == null) {
                        mostrarEstadisticas(clubActual, c);
                    } else {
                        System.out.println("Hay dos jugadores con el dorsal " + dorsal + ":");
                        System.out.println("1) Primer equipo -> " + p.getNombre() + " (" + p.getPosicion() + ")");
                        System.out.println("2) Cantera       -> " + c.getNombre() + " (" + c.getPosicion() + ")");
                        System.out.print("Elige 1 o 2: ");
                        int elegir = leerEntero(sc);

                        if (elegir == 1) mostrarEstadisticas(clubActual, p);
                        else if (elegir == 2) mostrarEstadisticas(clubActual, c);
                        else System.out.println("Opcion invalida.");
                    }
                }

            } else if (opcion == 4) {

                if (clubActual == null) System.out.println("No hay club seleccionado.");
                else clubActual.mostrarFichaClub();

            } else if (opcion == 5) {

                clubSeguido = elegirClub(sc, clubes);
                if (clubSeguido != null) {
                    System.out.println("Equipo seguido: " + clubSeguido.getNombre());
                }

            } else if (opcion == 6) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    if (clubSeguido == null) {
                        System.out.println("Elige primero el equipo que quieres seguir (opcion 5).");
                        clubSeguido = elegirClub(sc, clubes);
                    }

                    if (clubSeguido == null) {
                        competicion.simularRonda(false);
                    } else {
                        simularConEquipoSeguido(competicion, clubSeguido, false);
                    }

                    añadirGanadoresAEuropa(competicion, europa);
                }

            } else if (opcion == 7) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    if (clubSeguido == null) {
                        System.out.println("Elige primero el equipo que quieres seguir (opcion 5).");
                        clubSeguido = elegirClub(sc, clubes);
                    }

                    if (clubSeguido == null) {
                        System.out.println("No se ha seleccionado equipo seguido.");
                    } else {
                        simularConEquipoSeguido(competicion, clubSeguido, true);

                        añadirGanadoresAEuropa(competicion, europa);
                    }
                }

            } else if (opcion == 8) {

                if (competicion == null) System.out.println("No hay competicion creada.");
                else competicion.mostrarUltimosResultados();

            } else if (opcion == 9) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    mostrarClasificacionSiExiste(competicion);
                }

            } else if (opcion == 11) {

                if (europa == null) System.out.println("No hay Europa League (sim).");
                else europa.mostrarEquipos();

            } else if (opcion == 12) {

                if (europa == null) {
                    System.out.println("No hay Europa League (sim).");
                } else {
                    europa.simularRonda(false);
                }

            } else if (opcion == 13) {

                if (europa == null) System.out.println("No hay Europa League (sim).");
                else europa.mostrarUltimosResultados();

            } else if (opcion == 14) {

                if (europa == null) System.out.println("No hay Europa League (sim).");
                else europa.mostrarClasificacion();

            } else if (opcion == 10) {

                return;

            } else if (opcion == 0) {

                System.out.println("Saliendo...");

            } else {

                System.out.println("Opcion incorrecta.");
            }
        }
    }

    private static void añadirGanadoresAEuropa(Competicion competicion, EuropaLeague europa) {
        if (competicion == null || europa == null) return;

        Club[] ganadores = competicion.getGanadoresUltimaJornada();
        int añadidos = 0;

        for (int i = 0; i < ganadores.length; i++) {
            if (europa.añadirEquipo(ganadores[i])) {
                añadidos++;
            }
        }

        if (añadidos > 0) {
            System.out.println(">> Europa League (sim): se han añadido " + añadidos + " equipos.");
        }
    }

    private static void simularConEquipoSeguido(Competicion competicion, Club seguido, boolean enDirecto) {

        if (competicion instanceof Liga) {
            ((Liga) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof PremierLeague) {
            ((PremierLeague) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof Bundesliga) {
            ((Bundesliga) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof SerieA) {
            ((SerieA) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof Ligue1) {
            ((Ligue1) competicion).simularRonda(seguido, enDirecto);

        } else {
            System.out.println("Esta competicion no soporta modo carrera. Simulando normal...");
            competicion.simularRonda(enDirecto);
        }
    }

    private static void mostrarClasificacionSiExiste(Competicion competicion) {

        if (competicion instanceof Liga) {
            ((Liga) competicion).mostrarClasificacion();

        } else if (competicion instanceof PremierLeague) {
            ((PremierLeague) competicion).mostrarClasificacion();

        } else if (competicion instanceof Bundesliga) {
            ((Bundesliga) competicion).mostrarClasificacion();

        } else if (competicion instanceof SerieA) {
            ((SerieA) competicion).mostrarClasificacion();

        } else if (competicion instanceof Ligue1) {
            ((Ligue1) competicion).mostrarClasificacion();

        } else {
            System.out.println("Esta competicion no tiene clasificacion.");
        }
    }

    private static Club elegirClub(Scanner sc, Club[] clubes) {
        if (clubes == null || clubes.length == 0) {
            System.out.println("No hay clubes cargados.");
            return null;
        }

        System.out.println("\nLISTA DE CLUBES:");
        for (int i = 0; i < clubes.length; i++) {
            if (clubes[i] != null) {
                System.out.println((i + 1) + ". " + clubes[i].getNombre());
            }
        }

        System.out.print("Numero de club: ");
        int n = leerEntero(sc);

        if (n < 1 || n > clubes.length) {
            System.out.println("Numero invalido.");
            return null;
        }

        return clubes[n - 1];
    }

    private static int leerEntero(Scanner sc) {
        String texto = sc.nextLine();
        try {
            return Integer.parseInt(texto.trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void mostrarEstadisticas(Club club, Jugador j) {
        System.out.println("\n------------------------------");
        System.out.println("CLUB: " + club.getNombre());
        System.out.println("JUGADOR: " + j.getNombre() + " (#" + j.getDorsal() + " - " + j.getPosicion() + ")");
        System.out.println("EDAD: " + j.getEdad() + " | VALOR: " + String.format("%.1f", j.getValorMercado()) + " | VAL: " + j.getValoracion());
        System.out.println("TEMPORADA: " + j.getTemporada());
        System.out.println("PARTIDOS: " + j.getPartidos() + " | MINUTOS: " + j.getMinutos());
        System.out.println("GOLES: " + j.getGoles() + " | ASISTENCIAS: " + j.getAsistencias());
        System.out.println("AMARILLAS: " + j.getAmarillas() + " | ROJAS: " + j.getRojas());
        if ("POR".equalsIgnoreCase(j.getPosicion())) {
            System.out.println("PORTERIAS A CERO: " + j.getPorteriasCero());
        }
        System.out.println("------------------------------\n");
    }
}
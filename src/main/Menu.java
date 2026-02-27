package main;

import clubes.Club;
import competicion.*;
import jugadores.Jugador;

import java.util.Scanner;

public class Menu {

    public static void mostrar(Club[] clubes, Competicion competicion) {
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

            System.out.println("==============================");
            System.out.println("1. Elegir club actual");
            System.out.println("2. Ver plantilla (club actual)");
            System.out.println("3. Buscar jugador por dorsal (club actual)");
            System.out.println("4. Ver ficha del club (club actual)");
            System.out.println("------------------------------");
            System.out.println("5. Elegir equipo a seguir");
            System.out.println("6. Simular 1 jornada (rapido)");
            System.out.println("7. Simular 1 jornada (solo equipo seguido en directo)");
            System.out.println("8. Simular hasta el final");
            System.out.println("9. Ver clasificacion");
            System.out.println("10. Elegir otras Ligas");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero(sc);

            if (opcion == 1) {

                clubActual = elegirClub(sc, clubes, competicion);
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

                clubSeguido = elegirClub(sc, clubes, competicion);
                if (clubSeguido != null) {
                    System.out.println("Equipo seguido: " + clubSeguido.getNombre());
                }

            } else if (opcion == 6) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    if (clubSeguido == null) {
                        System.out.println("Elige primero el equipo que quieres seguir (opcion 5).");
                        clubSeguido = elegirClub(sc, clubes, competicion);
                    }

                    // Si no hay equipo seguido, simulación normal
                    if (clubSeguido == null) {
                        competicion.simularRonda(false);
                    } else {
                        simularConEquipoSeguido(competicion, clubSeguido, false);
                    }
                    
                    // Comprobar eliminación tras simular (SOLO SI NO HA TERMINADO EL TORNEO)
                    if (clubSeguido != null && !competicion.haTerminado()) {
                        if (competicion instanceof Copa && !((Copa)competicion).sigueVivo(clubSeguido)) {
                            System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                            System.out.println("Debes elegir un nuevo equipo para seguir.");
                            clubSeguido = elegirClub(sc, clubes, competicion);
                        } else if (competicion instanceof Supercopa && !((Supercopa)competicion).sigueVivo(clubSeguido)) {
                            System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                            System.out.println("Debes elegir un nuevo equipo para seguir.");
                            clubSeguido = elegirClub(sc, clubes, competicion);
                        }
                    }
                }

            } else if (opcion == 7) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    if (clubSeguido == null) {
                        System.out.println("Elige primero el equipo que quieres seguir (opcion 5).");
                        clubSeguido = elegirClub(sc, clubes, competicion);
                    }

                    if (clubSeguido == null) {
                        System.out.println("No se ha seleccionado equipo seguido.");
                    } else {
                        simularConEquipoSeguido(competicion, clubSeguido, true);
                        
                        // Comprobar eliminación tras simular en directo (SOLO SI NO HA TERMINADO EL TORNEO)
                        if (clubSeguido != null && !competicion.haTerminado()) {
                            if (competicion instanceof Copa && !((Copa)competicion).sigueVivo(clubSeguido)) {
                                System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                                System.out.println("Debes elegir un nuevo equipo para seguir.");
                                clubSeguido = elegirClub(sc, clubes, competicion);
                            } else if (competicion instanceof Supercopa && !((Supercopa)competicion).sigueVivo(clubSeguido)) {
                                System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                                System.out.println("Debes elegir un nuevo equipo para seguir.");
                                clubSeguido = elegirClub(sc, clubes, competicion);
                            }
                        }
                    }
                }

            } else if (opcion == 8) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    System.out.println("\n>>> SIMULANDO HASTA EL FINAL DE " + competicion.getNombre().toUpperCase() + " <<<");
                    while (!competicion.haTerminado()) {
                        if (clubSeguido == null) {
                            competicion.simularRonda(false);
                        } else {
                            simularConEquipoSeguido(competicion, clubSeguido, false);
                        }
                        
                        // Si tras simular una ronda el equipo seguido es eliminado, forzar cambio
                        if (clubSeguido != null && !competicion.haTerminado()) {
                            if (competicion instanceof Copa && !((Copa)competicion).sigueVivo(clubSeguido)) {
                                System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                                System.out.println("Debes elegir un nuevo equipo para seguir.");
                                clubSeguido = elegirClub(sc, clubes, competicion);
                            } else if (competicion instanceof Supercopa && !((Supercopa)competicion).sigueVivo(clubSeguido)) {
                                System.out.println("\n¡TU EQUIPO (" + clubSeguido.getNombre() + ") HA SIDO ELIMINADO!");
                                System.out.println("Debes elegir un nuevo equipo para seguir.");
                                clubSeguido = elegirClub(sc, clubes, competicion);
                            }
                        }
                    }
                    System.out.println("\n>>> SIMULACIÓN FINALIZADA <<<");
                }

            } else if (opcion == 9) {

                if (competicion == null) {
                    System.out.println("No hay competicion creada.");
                } else {
                    mostrarClasificacionSiExiste(competicion);
                }

            } else if (opcion == 10) {

                System.out.println("Eligiendo otras Ligas...");
                Main.main(null);

            } else if (opcion == 0) {

                System.out.println("Saliendo...");

            } else {

                System.out.println("Opcion incorrecta.");
            }

            // Si la competición ha terminado, volvemos al menú principal
            if (competicion != null && competicion.haTerminado()) {
                System.out.println("\nPresiona ENTER para volver al menú de Ligas...");
                sc.nextLine();
                Main.main(null);
                return; // Cerramos este menú para no acumular procesos
            }
        }
    }

    // --- Helpers para no duplicar if/instanceof ---

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

        } else if (competicion instanceof SegundaDivision) {
            ((SegundaDivision) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof Supercopa) {
            ((Supercopa) competicion).simularRonda(seguido, enDirecto);

        } else if (competicion instanceof Copa) {
            ((Copa) competicion).simularRonda(seguido, enDirecto);

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

        } else if (competicion instanceof SegundaDivision) {
            ((SegundaDivision) competicion).mostrarClasificacion();

        } else if (competicion instanceof Supercopa) {
            System.out.println("La Supercopa es eliminatoria (semifinales y final).");
            competicion.mostrarUltimosResultados();

        } else if (competicion instanceof Copa) {
            System.out.println("La Copa es eliminatoria (desde Octavos hasta la Final).");
            competicion.mostrarUltimosResultados();

        } else {
            System.out.println("Esta competicion no tiene clasificacion.");
        }
    }

    // --- Lo demás igual que lo tenías ---

    private static Club elegirClub(Scanner sc, Club[] clubes, Competicion competicion) {
        if (clubes == null || clubes.length == 0) {
            System.out.println("No hay clubes cargados.");
            return null;
        }

        System.out.println("\nLISTA DE CLUBES DISPONIBLES:");
        int mostrados = 0;
        for (int i = 0; i < clubes.length; i++) {
            if (clubes[i] != null) {
                boolean vivo = true;
                if (competicion instanceof Copa) vivo = ((Copa) competicion).sigueVivo(clubes[i]);
                else if (competicion instanceof Supercopa) vivo = ((Supercopa) competicion).sigueVivo(clubes[i]);
                
                if (vivo) {
                    System.out.println((i + 1) + ". " + clubes[i].getNombre());
                    mostrados++;
                }
            }
        }

        if (mostrados == 0) {
            System.out.println("No quedan equipos vivos en esta competición.");
            return null;
        }

        System.out.print("Numero de club: ");
        int n = leerEntero(sc);

        if (n < 1 || n > clubes.length || clubes[n-1] == null) {
            System.out.println("Numero invalido.");
            return null;
        }
        
        // Validación extra de supervivencia
        Club elegido = clubes[n-1];
        if (competicion instanceof Copa && !((Copa) competicion).sigueVivo(elegido)) {
            System.out.println("Ese equipo ya ha sido eliminado.");
            return null;
        }
        if (competicion instanceof Supercopa && !((Supercopa) competicion).sigueVivo(elegido)) {
            System.out.println("Ese equipo ya ha sido eliminado.");
            return null;
        }

        return elegido;
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
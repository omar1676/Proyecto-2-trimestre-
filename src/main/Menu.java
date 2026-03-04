package main;

import clubes.Club;
import competicion.ChampionsLeague;
import competicion.Liga;
import datos.CargadorDatos;
import extra.Utilidades;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;

    private int tipoCompeticion;

    private Liga ligaActual;
    private ChampionsLeague championsActual;

    private Club[] clubesActuales;

    private Club[] todosClubes;

    private Club equipoEnDirecto;
    private boolean verEnDirecto;

    public Menu() {
        this.sc = new Scanner(System.in);

        this.tipoCompeticion = 0;

        this.ligaActual = null;
        this.championsActual = null;

        this.clubesActuales = null;

        this.todosClubes = CargadorDatos.crearTodosLosClubes();
        CargadorDatos.cargarPlantillasAleatorias(this.todosClubes, 22, 6, "2024/25");

        this.equipoEnDirecto = null;
        this.verEnDirecto = false;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            pintarMenuPrincipal();
            int op = leerEntero("Selecciona opcion: ");

            switch (op) {
                case 1:
                    elegirCompeticion();
                    break;
                case 2:
                    elegirLigaOChampions();
                    break;
                case 3:
                    generar();
                    break;
                case 4:
                    verCalendarioOCuadro();
                    break;
                case 5:
                    simularSiguiente();
                    break;
                case 6:
                    verUltimosResultados();
                    break;
                case 7:
                    verClasificacion();
                    break;
                case 8:
                    saltarAJornada();
                    break;
                case 9:
                    elegirEquipoEnDirecto();
                    break;
                case 10:
                    toggleVerEnDirecto();
                    break;
                case 11:
                    verPremios();
                    break;
                case 12:
                    simularPartidoEnVivo();
                    break;
                case 0:
                    salir = true;
                    Utilidades.printlnColor(Utilidades.GRIS, "Saliendo...");
                    break;
                default:
                    Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
            }
        }
    }

    private void pintarMenuPrincipal() {
        String comp = nombreCompeticion();
        String sel = nombreSeleccionado();

        String generado = estadoGenerado();
        String terminado = estadoTerminado();

        String directo;
        if (verEnDirecto) {
            directo = "ON";
        } else {
            directo = "OFF";
        }

        String equipo;
        if (equipoEnDirecto == null) {
            equipo = "Ninguno";
        } else {
            equipo = equipoEnDirecto.getNombre();
        }

        String titulo = "SIMULADOR - MENU";

        String[] cabEstado = {"ESTADO", "VALOR"};
        String[][] filasEstado = {
                {"Competicion", comp},
                {"Seleccion", sel},
                {"Generada", generado},
                {"Terminada", terminado},
                {"En directo", directo},
                {"Equipo", equipo}
        };

        String[] cabMenu = {"OP", "ACCION"};
        String[][] filasMenu = {
                {"1", "Elegir competicion"},
                {"2", "Elegir liga / crear Champions (TOP16)"},
                {"3", "Generar (calendario / cuadro)"},
                {"4", "Ver calendario / cuadro"},
                {"5", "Simular siguiente (jornada / ronda)"},
                {"6", "Ver ultimos resultados"},
                {"7", "Ver clasificacion (solo Liga)"},
                {"8", "Saltar a jornada (solo Liga)"},
                {"9", "Elegir equipo (solo Liga)"},
                {"10", "Toggle ver en directo"},
                {"11", "Premios (Pichichi, Asist., Zamora, Fair Play, MVP)"},
                {"12", "Simular partido EN VIVO (elegir)"},
                {"0", "Salir"}
        };

        ui.TablaConsola.imprimirTituloCentrado(titulo, 110);
        ui.TablaConsola.imprimirTablaCentrada(null, cabEstado, filasEstado, 110);
        ui.TablaConsola.imprimirTablaCentrada(null, cabMenu, filasMenu, 110);
    }

    private void elegirCompeticion() {
        String[] cab = {"OP", "COMPETICION"};
        String[][] filas = {
                {"1", "Liga"},
                {"2", "Champions League (TOP16 mix)"},
                {"0", "Volver"}
        };

        ui.TablaConsola.imprimirTablaCentrada("ELEGIR COMPETICION", cab, filas, 110);

        int op = leerEntero("Opcion: ");
        if (op == 0) {
            return;
        }

        if (op != 1 && op != 2) {
            Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
            return;
        }

        tipoCompeticion = op;

        ligaActual = null;
        championsActual = null;
        clubesActuales = null;
        equipoEnDirecto = null;

        if (tipoCompeticion == 1) {
            Utilidades.printlnColor(Utilidades.VERDE, "Has elegido Liga. Ahora elige cual (opcion 2).");
        } else {
            Utilidades.printlnColor(Utilidades.VERDE, "Has elegido Champions. Crea el TOP16 mix (opcion 2).");
        }
    }

    private void elegirLigaOChampions() {
        if (tipoCompeticion == 0) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una competicion (opcion 1).");
            return;
        }

        if (tipoCompeticion == 1) {
            seleccionarLiga();
            return;
        }

        if (tipoCompeticion == 2) {
            crearChampionsTop16Mix();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "Competicion no valida.");
    }

    private void seleccionarLiga() {
        String[] cab = {"OP", "LIGA"};
        String[][] filas = {
                {"1", "LaLiga (20)"},
                {"2", "Premier League (20)"},
                {"3", "Serie A (20)"},
                {"4", "Bundesliga (18)"},
                {"5", "Ligue 1 (18)"},
                {"0", "Volver"}
        };

        ui.TablaConsola.imprimirTablaCentrada("ELEGIR LIGA (TOP 5)", cab, filas, 110);

        int op = leerEntero("Opcion: ");
        if (op == 0) {
            return;
        }

        Club[] clubes;
        String nombreLiga;
        int max;

        if (op == 1) {
            nombreLiga = "LaLiga";
            max = 20;
        } else if (op == 2) {
            nombreLiga = "Premier League";
            max = 20;
        } else if (op == 3) {
            nombreLiga = "Serie A";
            max = 20;
        } else if (op == 4) {
            nombreLiga = "Bundesliga";
            max = 18;
        } else if (op == 5) {
            nombreLiga = "Ligue 1";
            max = 18;
        } else {
            Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
            return;
        }

        clubes = CargadorDatos.clubesDeLiga(this.todosClubes, nombreLiga, max);

        ligaActual = new Liga(nombreLiga, clubes);
        championsActual = null;
        clubesActuales = clubes;
        equipoEnDirecto = null;

        Utilidades.printlnColor(Utilidades.VERDE, "Liga seleccionada: " + ligaActual.getNombre());
    }

    private void crearChampionsTop16Mix() {
        Club[] top16 = CargadorDatos.top16(this.todosClubes);
        championsActual = new ChampionsLeague("Champions League", top16);

        ligaActual = null;
        clubesActuales = top16;
        equipoEnDirecto = null;

        Utilidades.printlnColor(Utilidades.VERDE, "Champions creada: TOP16 mix.");
    }

    private void generar() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
                return;
            }
            ligaActual.generar();
            return;
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero crea la Champions TOP16 mix (opcion 2).");
                return;
            }
            championsActual.generar();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una competicion.");
    }

    private void verCalendarioOCuadro() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
                return;
            }
            ligaActual.mostrarCalendario();
            return;
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero crea la Champions TOP16 mix (opcion 2).");
                return;
            }
            championsActual.mostrarCuadro();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "No disponible.");
    }

    private void simularSiguiente() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
                return;
            }
            if (ligaActual.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "La liga ya ha terminado.");
                return;
            }

            boolean ok;
            if (equipoEnDirecto != null) {
                ok = ligaActual.simularRondaSoloEquipo(equipoEnDirecto, verEnDirecto);
            } else {
                ok = ligaActual.simularRonda(verEnDirecto);
            }

            if (!ok) {
                Utilidades.printlnColor(Utilidades.AMAR, "No se pudo simular la jornada.");
            }
            return;
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero crea la Champions TOP16 mix (opcion 2).");
                return;
            }
            if (championsActual.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "La Champions ya ha terminado.");
                return;
            }
            championsActual.simularRonda(verEnDirecto);
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "No hay competicion activa.");
    }

    private void verUltimosResultados() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
                return;
            }
            ligaActual.mostrarUltimosResultados();
            return;
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Primero crea la Champions TOP16 mix (opcion 2).");
                return;
            }
            championsActual.mostrarUltimosResultados();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "No disponible.");
    }

    private void verClasificacion() {
        if (tipoCompeticion != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "La clasificacion solo existe en Liga.");
            return;
        }

        if (ligaActual == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
            return;
        }

        ligaActual.mostrarClasificacion();
    }

    private void saltarAJornada() {
        if (tipoCompeticion != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "Solo disponible para Liga.");
            return;
        }

        if (ligaActual == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
            return;
        }

        int j = leerEntero("A que jornada quieres saltar?: ");
        ligaActual.simularHastaJornada(j);
        Utilidades.printlnColor(Utilidades.VERDE, "Salto completado.");
    }

    private void elegirEquipoEnDirecto() {
        if (tipoCompeticion != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "Solo disponible para Liga.");
            return;
        }

        if (ligaActual == null || clubesActuales == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga (opcion 2).");
            return;
        }

        int w = 74;
        System.out.println("\n" + marco(w));
        System.out.println("|" + center("ELEGIR EQUIPO (SOLO SU PARTIDO)", w) + "|");
        System.out.println(marco(w));

        int i = 0;
        while (i < clubesActuales.length) {
            Club c = clubesActuales[i];
            if (c != null) {
                String fila = String.format(" %3d) %-60s", c.getId(), c.getNombre());
                System.out.println("|" + pad(fila, w) + "|");
            }
            i++;
        }

        System.out.println("|" + pad("   0) Quitar equipo en directo", w) + "|");
        System.out.println(marco(w));

        int id = leerEntero("ID: ");
        if (id == 0) {
            equipoEnDirecto = null;
            Utilidades.printlnColor(Utilidades.GRIS, "Equipo en directo desactivado.");
            return;
        }

        Club elegido = buscarClubPorId(clubesActuales, id);
        if (elegido == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "No existe ese ID.");
            return;
        }

        equipoEnDirecto = elegido;
        Utilidades.printlnColor(Utilidades.VERDE, "Ahora veras SOLO el partido de: " + equipoEnDirecto.getNombre());
    }

    private void simularPartidoEnVivo() {
        if (tipoCompeticion == 0) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige competicion (opcion 1).");
            return;
        }

        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay liga seleccionada. Usa la opcion 2.");
                return;
            }

            String[] disponibles = ligaActual.listarPartidosDisponibles();
            if (disponibles == null || disponibles.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay partidos disponibles ahora mismo.");
                return;
            }

            System.out.println();
            System.out.println("PARTIDOS DISPONIBLES (JORNADA ACTUAL):");
            for (int i = 0; i < disponibles.length; i++) {
                System.out.println(" " + disponibles[i]);
            }

            int sel = leerEntero("Elige numero de partido para simular EN VIVO: ");
            ligaActual.simularPartidoEnVivo(sel);
            return;
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay Champions creada. Usa la opcion 2.");
                return;
            }

            String[] disponibles = championsActual.listarPartidosDisponibles();
            if (disponibles == null || disponibles.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay eliminatorias disponibles ahora mismo.");
                return;
            }

            System.out.println();
            System.out.println("ELIMINATORIAS DISPONIBLES (RONDA ACTUAL):");
            for (int i = 0; i < disponibles.length; i++) {
                System.out.println(" " + disponibles[i]);
            }

            int sel = leerEntero("Elige numero de eliminatoria para simular EN VIVO: ");
            championsActual.simularPartidoEnVivo(sel);
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "Modo no disponible para esta competicion.");
    }

    private void toggleVerEnDirecto() {
        if (verEnDirecto) {
            verEnDirecto = false;
        } else {
            verEnDirecto = true;
        }

        String estado;
        if (verEnDirecto) {
            estado = "ON";
        } else {
            estado = "OFF";
        }

        Utilidades.printlnColor(Utilidades.GRIS, "Ver en directo: " + estado);
    }

    private String nombreCompeticion() {
        if (tipoCompeticion == 1) {
            return "Liga";
        }
        if (tipoCompeticion == 2) {
            return "Champions League";
        }
        return "Ninguna";
    }

    private String nombreSeleccionado() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                return "Ninguna";
            }
            return ligaActual.getNombre();
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                return "Sin participantes";
            }
            return championsActual.getNombre();
        }

        return "-";
    }

    private String estadoGenerado() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                return "NO";
            }
            if (ligaActual.isGenerada()) {
                return "SI";
            }
            return "NO";
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                return "NO";
            }
            if (championsActual.isGenerada()) {
                return "SI";
            }
            return "NO";
        }

        return "NO";
    }

    private String estadoTerminado() {
        if (tipoCompeticion == 1) {
            if (ligaActual == null) {
                return "NO";
            }
            if (ligaActual.haTerminado()) {
                return "SI";
            }
            return "NO";
        }

        if (tipoCompeticion == 2) {
            if (championsActual == null) {
                return "NO";
            }
            if (championsActual.haTerminado()) {
                return "SI";
            }
            return "NO";
        }

        return "NO";
    }

    private void verPremios() {
        if (clubesActuales == null || clubesActuales.length == 0) {
            Utilidades.printlnColor(Utilidades.ROJO, "Primero elige una liga o crea la Champions (opcion 2).");
            return;
        }

        premios.PremioJugador[] lista = premios.Premiador.calcularPremios(clubesActuales);
        int w = 74;

        System.out.println("\n" + marco(w));
        System.out.println("|" + center("PREMIOS DE LA TEMPORADA", w) + "|");
        System.out.println(marco(w));

        for (int i = 0; i < lista.length; i++) {
            premios.PremioJugador p = lista[i];
            if (p == null) {
                continue;
            }

            String tipo = p.getTipo().toString();

            String jugador = "Jugador";
            if (p.getJugador() != null && p.getJugador().getNombre() != null) {
                jugador = p.getJugador().getNombre();
            }

            String club = "Club";
            if (p.getClub() != null && p.getClub().getNombre() != null) {
                club = p.getClub().getNombre();
            }

            String valorTxt;
            if (p.getTipo() == premios.TipoPremio.FAIR_PLAY) {
                valorTxt = "Tarjetas: " + p.getValor();
            } else if (p.getTipo() == premios.TipoPremio.MVP) {
                valorTxt = "Valoracion: " + p.getValor();
            } else if (p.getTipo() == premios.TipoPremio.ZAMORA) {
                valorTxt = "Porterias a 0: " + p.getValor();
            } else if (p.getTipo() == premios.TipoPremio.ASISTENCIAS) {
                valorTxt = "Asistencias: " + p.getValor();
            } else {
                valorTxt = "Goles: " + p.getValor();
            }

            String linea = " " + tipo + " | " + jugador + " - " + club + " | " + valorTxt;
            System.out.println("|" + pad(linea, w) + "|");
        }

        System.out.println(marco(w));
    }

    private int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            s = s.trim();

            if (s.isEmpty()) {
                Utilidades.printlnColor(Utilidades.ROJO, "Vacio. Intenta de nuevo.");
                continue;
            }

            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                Utilidades.printlnColor(Utilidades.ROJO, "No es un numero. Intenta de nuevo.");
            }
        }
    }

    private Club buscarClubPorId(Club[] clubes, int id) {
        if (clubes == null) {
            return null;
        }
        int i = 0;
        while (i < clubes.length) {
            Club c = clubes[i];
            if (c != null && c.getId() == id) {
                return c;
            }
            i++;
        }
        return null;
    }

    private static String marco(int inner) {
        return "+" + "-".repeat(inner) + "+";
    }

    private static String pad(String s, int len) {
        if (s == null) {
            s = "";
        }
        if (s.length() > len) {
            s = s.substring(0, len);
        }
        return String.format("%-" + len + "s", s);
    }

    private static String center(String s, int len) {
        if (s == null) {
            s = "";
        }
        if (s.length() > len) {
            s = s.substring(0, len);
        }
        int left = (len - s.length()) / 2;
        int right = len - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }
}

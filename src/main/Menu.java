package main;

import clubes.Club;
import competicion.ChampionsLeague;
import competicion.Copa;
import competicion.EuropaLeague;
import competicion.Liga;
import competicion.Supercopa;
import datos.CargadorDatos;
import extra.Utilidades;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    private static final int ANCHO_CONSOLA = 120;
    private static final int ANCHO_PANEL = 86;
    private static final int PAUSA_LINEA_MS = 18;

    private final Scanner sc;
    private final Random rnd;

    private int comp;

    private Liga ligaAct;
    private ChampionsLeague chl;
    private EuropaLeague el;
    private Copa cdr;
    private Supercopa sup;

    private Club[] clubs;

    private Club eqFav;
    private boolean directo;

    public Menu() {
        sc = new Scanner(System.in);
        rnd = new Random();

        comp = 0;

        ligaAct = null;
        chl = null;
        el = null;
        cdr = null;
        sup = null;

        clubs = null;

        eqFav = null;
        directo = false;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            pintarMenu();
            int op = leerInt("Opcion: ");

            if (op == 1) {
                elegirComp();
            } else if (op == 2) {
                crearEquipos();
            } else if (op == 3) {
                generar();
            } else if (op == 4) {
                ver();
            } else if (op == 5) {
                simular();
            } else if (op == 6) {
                resultados();
            } else if (op == 7) {
                clasificacion();
            } else if (op == 8) {
                saltarJornada();
            } else if (op == 9) {
                elegirEquipo();
            } else if (op == 10) {
                cambiarDirecto();
            } else if (op == 11) {
                partidoEnVivo();
            } else if (op == 0) {
                salir = true;
            } else {
                Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
                pausa();
            }
        }
    }

    private void pintarMenu() {
        int w = ANCHO_PANEL;

        int margen = (ANCHO_CONSOLA - (w + 2)) / 2;
        if (margen < 0) {
            margen = 0;
        }
        String prefijo = repetir(" ", margen);

        String d;
        if (directo) {
            d = "ON";
        } else {
            d = "OFF";
        }

        String fav;
        if (eqFav == null) {
            fav = "Ninguno";
        } else {
            fav = eqFav.getNombre();
        }

        System.out.println();

        imprimirLineaMenu(prefijo + linea(w));
        imprimirLineaMenu(prefijo + "|" + centrar("SIMULADOR FUTBOL", w) + "|");
        imprimirLineaMenu(prefijo + linea(w));

        imprimirLineaMenu(prefijo + "|" + rellenar("Comp: " + txtComp(), w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("Sel : " + txtSel(), w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("Gen : " + txtGen() + "    Fin: " + txtFin(), w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("Dir : " + d + "    Eq : " + fav, w) + "|");

        imprimirLineaMenu(prefijo + linea(w));

        imprimirLineaMenu(prefijo + "|" + rellenar("1  Elegir competicion", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("2  Crear equipos", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("3  Generar", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("4  Ver calendario o cuadro", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("5  Simular siguiente", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("6  Ver ultimos resultados", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("7  Ver clasificacion", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("8  Saltar a jornada", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("9  Elegir equipo", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("10 Cambiar directo", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("11 Partido en vivo", w) + "|");
        imprimirLineaMenu(prefijo + "|" + rellenar("0  Salir", w) + "|");

        imprimirLineaMenu(prefijo + linea(w));
    }

    private void imprimirLineaMenu(String s) {
        if (s == null) {
            s = "";
        }
        System.out.println(s);
        Utilidades.dormir(PAUSA_LINEA_MS);
    }

    private void elegirComp() {
        System.out.println();
        System.out.println("1  Liga");
        System.out.println("2  Champions");
        System.out.println("3  Europa League");
        System.out.println("4  Copa del Rey");
        System.out.println("5  Supercopa");
        System.out.println("0  Volver");

        int op = leerInt("Opcion: ");
        if (op == 0) {
            return;
        }

        if (op >= 1 && op <= 5) {
            comp = op;

            ligaAct = null;
            chl = null;
            el = null;
            cdr = null;
            sup = null;

            clubs = null;
            eqFav = null;
        } else {
            Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
        }
    }

    private void crearEquipos() {
        if (comp == 0) {
            Utilidades.printlnColor(Utilidades.ROJO, "Elige competicion.");
            return;
        }

        if (comp == 1) {
            elegirLiga();
            return;
        }
        if (comp == 2) {
            crearChampions();
            return;
        }
        if (comp == 3) {
            crearEuropa();
            return;
        }
        if (comp == 4) {
            crearCopa();
            return;
        }
        if (comp == 5) {
            crearSupercopa();
        }
    }

    private void elegirLiga() {
        System.out.println();
        System.out.println("1  LaLiga");
        System.out.println("2  Hypermotion");
        System.out.println("3  Premier League");
        System.out.println("4  Serie A");
        System.out.println("5  Bundesliga");
        System.out.println("6  Ligue 1");
        System.out.println("0  Volver");

        int op = leerInt("Opcion: ");
        if (op == 0) {
            return;
        }

        Club[] arr = null;
        String nombre = "Liga";

        if (op == 1) {
            arr = CargadorDatos.crearClubesLaLiga();
            nombre = "LaLiga";
        } else if (op == 2) {
            arr = CargadorDatos.crearClubesHypermotion();
            nombre = "Hypermotion";
        } else if (op == 3) {
            arr = CargadorDatos.crearClubesPremierLeague();
            nombre = "Premier";
        } else if (op == 4) {
            arr = CargadorDatos.crearClubesSerieA();
            nombre = "Serie A";
        } else if (op == 5) {
            arr = CargadorDatos.crearClubesBundesliga();
            nombre = "Bundesliga";
        } else if (op == 6) {
            arr = CargadorDatos.crearClubesLigue1();
            nombre = "Ligue 1";
        } else {
            Utilidades.printlnColor(Utilidades.ROJO, "Opcion invalida.");
            return;
        }

        CargadorDatos.cargarPlantillasAleatorias(arr, 22, 6, "2025/26");

        ligaAct = new Liga(nombre, arr);
        clubs = arr;
        eqFav = null;

        chl = null;
        el = null;
        cdr = null;
        sup = null;
    }

    private void crearChampions() {
        Club[] top16 = CargadorDatos.crearClubesChampionsTop16();
        CargadorDatos.cargarPlantillasAleatorias(top16, 22, 6, "2025/26");

        chl = new ChampionsLeague("Champions League", top16);
        clubs = top16;
        eqFav = null;

        ligaAct = null;
        el = null;
        cdr = null;
        sup = null;
    }

    private void crearEuropa() {
        Club[] arr = CargadorDatos.crearClubesEuropaLeagueTop16();
        el = new EuropaLeague(arr);
        clubs = arr;
        eqFav = null;

        ligaAct = null;
        chl = null;
        cdr = null;
        sup = null;
    }

    private void crearCopa() {
        Club[] a = CargadorDatos.crearClubesLaLiga();
        Club[] b = CargadorDatos.crearClubesHypermotion();

        Club[] arr = unir(a, b);
        CargadorDatos.cargarPlantillasAleatorias(arr, 22, 6, "2025/26");

        cdr = new Copa("Copa del Rey", arr);
        clubs = arr;
        eqFav = null;

        ligaAct = null;
        chl = null;
        el = null;
        sup = null;
    }

    private void crearSupercopa() {
        Club[] a = CargadorDatos.crearClubesLaLiga();
        CargadorDatos.cargarPlantillasAleatorias(a, 22, 6, "2025/26");

        Club[] cuatro = new Club[4];
        if (a != null && a.length >= 4) {
            cuatro[0] = a[0];
            cuatro[1] = a[1];
            cuatro[2] = a[2];
            cuatro[3] = a[3];
        }

        sup = new Supercopa("Supercopa", cuatro);
        clubs = cuatro;
        eqFav = null;

        ligaAct = null;
        chl = null;
        el = null;
        cdr = null;
    }

    private void generar() {
        if (comp == 1) {
            if (ligaAct == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
                return;
            }
            ligaAct.generar();
            return;
        }

        if (comp == 2) {
            if (chl == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea champions.");
                return;
            }
            chl.generar();
            return;
        }

        if (comp == 3) {
            if (el == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea europa.");
                return;
            }
            el.generar();
            return;
        }

        if (comp == 4) {
            if (cdr == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea copa.");
                return;
            }
            cdr.generar();
            return;
        }

        if (comp == 5) {
            if (sup == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea supercopa.");
                return;
            }
            sup.generar();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "Elige competicion.");
    }

    private void ver() {
        if (comp == 1) {
            if (ligaAct == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
                return;
            }
            ligaAct.mostrarCalendario();
            pausa();
            return;
        }

        if (comp == 2) {
            if (chl == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea champions.");
                return;
            }
            chl.mostrarCuadro();
            pausa();
            return;
        }

        if (comp == 3) {
            if (el == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea europa.");
                return;
            }
            el.mostrarCalendario();
            pausa();
            return;
        }

        if (comp == 4) {
            if (cdr == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea copa.");
                pausa();
                return;
            }

            if (!cdr.isGenerada()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Primero genera la copa.");
                pausa();
                return;
            }

            cdr.mostrarEstadoCopa();
            pausa();
            return;
        }

        if (comp == 5) {
            if (sup == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea supercopa.");
                return;
            }
            sup.mostrarUltimosResultados();
            pausa();
        }
    }

    private void simular() {
        if (comp == 1) {
            if (ligaAct == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
                return;
            }
            if (ligaAct.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Ya termino.");
                return;
            }

            boolean ok;
            if (eqFav != null) {
                ok = ligaAct.simularRondaSoloEquipo(eqFav, directo);
            } else {
                ok = ligaAct.simularRonda(directo);
            }

            if (!ok) {
                Utilidades.printlnColor(Utilidades.AMAR, "No se pudo.");
            }
            pausa();
            return;
        }

        if (comp == 2) {
            if (chl == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea champions.");
                return;
            }
            if (chl.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Ya termino.");
                return;
            }
            chl.simularRonda(directo);
            pausa();
            return;
        }

        if (comp == 3) {
            if (el == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea europa.");
                return;
            }
            if (el.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Ya termino.");
                return;
            }
            el.simularRonda(directo);
            pausa();
            return;
        }

        if (comp == 4) {
            if (cdr == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea copa.");
                return;
            }
            if (cdr.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Ya termino.");
                return;
            }
            cdr.simularRonda(directo);
            pausa();
            return;
        }

        if (comp == 5) {
            if (sup == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea supercopa.");
                return;
            }
            if (sup.haTerminado()) {
                Utilidades.printlnColor(Utilidades.AMAR, "Ya termino.");
                return;
            }
            sup.simularRonda(directo);
            pausa();
            return;
        }

        Utilidades.printlnColor(Utilidades.ROJO, "Elige competicion.");
        pausa();
    }

    private void resultados() {
        if (comp == 1) {
            if (ligaAct == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
                return;
            }
            ligaAct.mostrarUltimosResultados();
            pausa();
            return;
        }

        if (comp == 2) {
            if (chl == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea champions.");
                return;
            }
            chl.mostrarUltimosResultados();
            pausa();
            return;
        }

        if (comp == 3) {
            if (el == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea europa.");
                return;
            }
            el.mostrarUltimosResultados();
            pausa();
            return;
        }

        if (comp == 4) {
            if (cdr == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea copa.");
                return;
            }
            cdr.mostrarUltimosResultados();
            pausa();
            return;
        }

        if (comp == 5) {
            if (sup == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea supercopa.");
                return;
            }
            sup.mostrarUltimosResultados();
            pausa();
        }
    }

    private void clasificacion() {
        if (comp != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "Solo liga.");
            pausa();
            return;
        }
        if (ligaAct == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
            pausa();
            return;
        }
        ligaAct.mostrarClasificacion();
        pausa();
    }

    private void saltarJornada() {
        if (comp != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "Solo liga.");
            pausa();
            return;
        }
        if (ligaAct == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
            pausa();
            return;
        }
        int j = leerInt("Jornada: ");
        ligaAct.simularHastaJornada(j);
        pausa();
    }

    private void elegirEquipo() {
        if (comp != 1) {
            Utilidades.printlnColor(Utilidades.AMAR, "Solo liga.");
            pausa();
            return;
        }
        if (clubs == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
            pausa();
            return;
        }

        System.out.println();
        int i = 0;
        while (i < clubs.length) {
            if (clubs[i] != null) {
                System.out.println(clubs[i].getId() + "  " + clubs[i].getNombre());
            }
            i++;
        }
        System.out.println("0  Quitar");

        int id = leerInt("ID: ");
        if (id == 0) {
            eqFav = null;
            return;
        }

        Club x = buscarId(clubs, id);
        if (x == null) {
            Utilidades.printlnColor(Utilidades.ROJO, "ID no valido.");
            pausa();
            return;
        }

        eqFav = x;
    }

    private void cambiarDirecto() {
        if (directo) {
            directo = false;
        } else {
            directo = true;
        }
    }

    private void partidoEnVivo() {

        if (comp == 1) {
            if (ligaAct == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea liga.");
                pausa();
                return;
            }

            String[] p = ligaAct.listarPartidosDisponibles();
            if (p == null || p.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay.");
                pausa();
                return;
            }

            int i = 0;
            while (i < p.length) {
                System.out.println(p[i]);
                i++;
            }

            int n = leerInt("Numero: ");
            ligaAct.simularPartidoEnVivo(n);
            pausa();
            return;
        }

        if (comp == 2) {
            if (chl == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea champions.");
                pausa();
                return;
            }

            String[] p = chl.listarPartidosDisponibles();
            if (p == null || p.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay.");
                pausa();
                return;
            }

            int i = 0;
            while (i < p.length) {
                System.out.println(p[i]);
                i++;
            }

            int n = leerInt("Numero: ");
            chl.simularPartidoEnVivo(n);
            pausa();
            return;
        }

        if (comp == 4) {
            if (cdr == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea copa.");
                pausa();
                return;
            }

            String[] p = cdr.listarPartidosDisponibles();
            if (p == null || p.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay.");
                pausa();
                return;
            }

            int i = 0;
            while (i < p.length) {
                System.out.println(p[i]);
                i++;
            }

            int n = leerInt("Numero: ");
            cdr.simularPartidoEnVivo(n);
            pausa();
            return;
        }

        if (comp == 5) {
            if (sup == null) {
                Utilidades.printlnColor(Utilidades.ROJO, "Crea supercopa.");
                pausa();
                return;
            }

            String[] p = sup.listarPartidosDisponibles();
            if (p == null || p.length == 0) {
                Utilidades.printlnColor(Utilidades.ROJO, "No hay.");
                pausa();
                return;
            }

            int i = 0;
            while (i < p.length) {
                System.out.println(p[i]);
                i++;
            }

            int n = leerInt("Numero: ");
            sup.simularPartidoEnVivo(n);
            pausa();
            return;
        }

        Utilidades.printlnColor(Utilidades.AMAR, "No disponible.");
        pausa();
    }

    private String txtComp() {
        if (comp == 1) {
            return "Liga";
        }
        if (comp == 2) {
            return "Champions";
        }
        if (comp == 3) {
            return "Europa League";
        }
        if (comp == 4) {
            return "Copa del Rey";
        }
        if (comp == 5) {
            return "Supercopa";
        }
        return "Ninguna";
    }

    private String txtSel() {
        if (comp == 1) {
            if (ligaAct == null) {
                return "Ninguna";
            }
            return ligaAct.getNombre();
        }
        if (comp == 2) {
            if (chl == null) {
                return "Ninguna";
            }
            return chl.getNombre();
        }
        if (comp == 3) {
            if (el == null) {
                return "Ninguna";
            }
            return "Europa League";
        }
        if (comp == 4) {
            if (cdr == null) {
                return "Ninguna";
            }
            return cdr.getNombre();
        }
        if (comp == 5) {
            if (sup == null) {
                return "Ninguna";
            }
            return sup.getNombre();
        }
        return "Ninguna";
    }

    private String txtGen() {
        if (comp == 1) {
            if (ligaAct == null) {
                return "NO";
            }
            if (ligaAct.isGenerada()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 2) {
            if (chl == null) {
                return "NO";
            }
            if (chl.isGenerada()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 3) {
            if (el == null) {
                return "NO";
            }
            if (el.isGenerada()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 4) {
            if (cdr == null) {
                return "NO";
            }
            if (cdr.isGenerada()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 5) {
            if (sup == null) {
                return "NO";
            }
            if (sup.isGenerada()) {
                return "SI";
            }
            return "NO";
        }
        return "NO";
    }

    private String txtFin() {
        if (comp == 1) {
            if (ligaAct == null) {
                return "NO";
            }
            if (ligaAct.haTerminado()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 2) {
            if (chl == null) {
                return "NO";
            }
            if (chl.haTerminado()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 3) {
            if (el == null) {
                return "NO";
            }
            if (el.haTerminado()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 4) {
            if (cdr == null) {
                return "NO";
            }
            if (cdr.haTerminado()) {
                return "SI";
            }
            return "NO";
        }
        if (comp == 5) {
            if (sup == null) {
                return "NO";
            }
            if (sup.haTerminado()) {
                return "SI";
            }
            return "NO";
        }
        return "NO";
    }

    private int leerInt(String txt) {
        while (true) {
            System.out.print(txt);
            String s = sc.nextLine();
            if (s == null) {
                s = "";
            }
            s = s.trim();

            if (s.length() == 0) {
                continue;
            }

            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                Utilidades.printlnColor(Utilidades.ROJO, "Numero no valido.");
            }
        }
    }

    private void pausa() {
        System.out.println("Pulsa ENTER");
        sc.nextLine();
    }

    private Club buscarId(Club[] arr, int id) {
        if (arr == null) {
            return null;
        }

        int i = 0;
        while (i < arr.length) {
            if (arr[i] != null && arr[i].getId() == id) {
                return arr[i];
            }
            i++;
        }
        return null;
    }

    private Club[] unir(Club[] a, Club[] b) {
        if (a == null) {
            a = new Club[0];
        }
        if (b == null) {
            b = new Club[0];
        }

        Club[] r = new Club[a.length + b.length];

        int i = 0;
        while (i < a.length) {
            r[i] = a[i];
            i++;
        }

        int j = 0;
        while (j < b.length) {
            r[a.length + j] = b[j];
            j++;
        }

        return r;
    }

    private String linea(int w) {
        return "+" + repetir("-", w) + "+";
    }

    private String repetir(String s, int n) {
        String out = "";
        int i = 0;
        while (i < n) {
            out = out + s;
            i++;
        }
        return out;
    }

    private String rellenar(String s, int len) {
        if (s == null) {
            s = "";
        }
        if (s.length() > len) {
            return s.substring(0, len);
        }

        String out = s;
        while (out.length() < len) {
            out = out + " ";
        }
        return out;
    }

    private String centrar(String s, int len) {
        if (s == null) {
            s = "";
        }
        if (s.length() > len) {
            s = s.substring(0, len);
        }

        int izq = (len - s.length()) / 2;
        int der = len - s.length() - izq;

        String out = "";
        int i = 0;
        while (i < izq) {
            out = out + " ";
            i++;
        }

        out = out + s;

        i = 0;
        while (i < der) {
            out = out + " ";
            i++;
        }

        return out;
    }
}
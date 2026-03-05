package competicion;

import clubes.Club;
import partido.Partido;

import java.util.Random;

public class Liga extends Competicion {

    private Club[] equipos;
    private int totalEquipos;

    private Jornada[] jornadas;
    private int totalJornadas;
    private int partidosPorJornada;
    private int jornadaEnCurso;

    private int[] jugados, ganados, empatados, perdidos, golesFavor, golesContra, puntos;

    private String[] resultadosUltimaJornada;
    private int numResultadosUltimaJornada;

    private String[] resultadosUltimoEquipo;
    private int numResultadosUltimoEquipo;

    private Club[] ganadoresUltimaJornada;
    private int numGanadoresUltimaJornada;

    private Random rnd;

    public Liga(String nombre) {
        super(nombre);
        this.rnd = new Random();

        this.equipos = new Club[0];
        this.totalEquipos = 0;

        this.jornadas = new Jornada[0];
        this.totalJornadas = 0;
        this.partidosPorJornada = 0;
        this.jornadaEnCurso = 0;

        this.jugados = new int[0];
        this.ganados = new int[0];
        this.empatados = new int[0];
        this.perdidos = new int[0];
        this.golesFavor = new int[0];
        this.golesContra = new int[0];
        this.puntos = new int[0];

        this.resultadosUltimaJornada = new String[1];
        this.resultadosUltimoEquipo = new String[1];
        this.numResultadosUltimaJornada = 0;
        this.numResultadosUltimoEquipo = 0;

        this.ganadoresUltimaJornada = new Club[1];
        this.numGanadoresUltimaJornada = 0;
    }

    public Liga(String nombre, Club[] clubes) {
        super(nombre);
        this.rnd = new Random();

        if (clubes == null) {
            this.equipos = new Club[0];
            this.totalEquipos = 0;
        } else {
            this.equipos = new Club[clubes.length];
            this.totalEquipos = 0;

            for (int i = 0; i < clubes.length; i++) {
                if (clubes[i] != null) {
                    this.equipos[this.totalEquipos] = clubes[i];
                    this.totalEquipos++;
                }
            }
        }

        this.jornadas = new Jornada[0];
        this.jornadaEnCurso = 0;
        this.totalJornadas = 0;
        this.partidosPorJornada = 0;

        this.jugados = new int[this.totalEquipos];
        this.ganados = new int[this.totalEquipos];
        this.empatados = new int[this.totalEquipos];
        this.perdidos = new int[this.totalEquipos];
        this.golesFavor = new int[this.totalEquipos];
        this.golesContra = new int[this.totalEquipos];
        this.puntos = new int[this.totalEquipos];

        int tam = this.totalEquipos / 2;
        if (tam <= 0) {
            tam = 1;
        }

        this.resultadosUltimaJornada = new String[tam];
        this.resultadosUltimoEquipo = new String[tam];
        this.numResultadosUltimaJornada = 0;
        this.numResultadosUltimoEquipo = 0;

        this.ganadoresUltimaJornada = new Club[tam];
        this.numGanadoresUltimaJornada = 0;
    }

    @Override
    public void generar() {
        if (isGenerada()) {
            System.out.println("Ya estaba generada: " + getNombre());
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("GENERANDO LIGA: " + getNombre().toUpperCase());
        System.out.println("==========================================");

        if (totalEquipos < 2) {
            this.jornadas = new Jornada[0];
            this.totalJornadas = 0;
            this.partidosPorJornada = 0;
            setGenerada(true);
            setTerminada(true);
            System.out.println("No hay clubes suficientes.");
            System.out.println("==========================================\n");
            return;
        }

        boolean hayDescanso = false;
        if (totalEquipos % 2 != 0) {
            hayDescanso = true;
        }

        int n = totalEquipos;
        if (hayDescanso) {
            n = totalEquipos + 1;
        }

        Club[] ordenEquipos = new Club[n];
        for (int i = 0; i < totalEquipos; i++) {
            ordenEquipos[i] = equipos[i];
        }
        if (hayDescanso) {
            ordenEquipos[n - 1] = null;
        }

        mezclar(ordenEquipos);

        int jornadasIda = n - 1;
        this.partidosPorJornada = n / 2;
        this.totalJornadas = jornadasIda * 2;

        this.jornadas = new Jornada[totalJornadas];

        System.out.print("Clubes: " + totalEquipos);
        if (hayDescanso) {
            System.out.print(" (1 descanso)");
        }
        System.out.println();

        System.out.println("Jornadas: " + totalJornadas + " (Ida " + jornadasIda + " | Vuelta " + jornadasIda + ")");
        System.out.println("Partidos/jornada: " + partidosPorJornada);
        System.out.println("------------------------------------------");

        for (int numJornada = 0; numJornada < jornadasIda; numJornada++) {

            Partido[] partidos = new Partido[partidosPorJornada];

            for (int numPartido = 0; numPartido < partidosPorJornada; numPartido++) {
                Club equipoA = ordenEquipos[numPartido];
                Club equipoB = ordenEquipos[n - 1 - numPartido];

                if (equipoA == null || equipoB == null) {
                    partidos[numPartido] = null;
                } else {
                    boolean invertirLocalia = false;
                    if (numJornada % 2 != 0) {
                        invertirLocalia = true;
                    }

                    Club local;
                    Club visitante;

                    if (invertirLocalia) {
                        local = equipoB;
                        visitante = equipoA;
                    } else {
                        local = equipoA;
                        visitante = equipoB;
                    }

                    partidos[numPartido] = new Partido(local, visitante);
                }
            }

            this.jornadas[numJornada] = new Jornada(numJornada + 1, partidos);
            rotarOrden(ordenEquipos);
        }

        for (int numJornada = 0; numJornada < jornadasIda; numJornada++) {
            Jornada ida = this.jornadas[numJornada];
            Partido[] idaPartidos;

            if (ida == null) {
                idaPartidos = new Partido[partidosPorJornada];
            } else {
                idaPartidos = ida.getPartidos();
            }

            Partido[] vuelta = new Partido[partidosPorJornada];

            for (int numPartido = 0; numPartido < partidosPorJornada; numPartido++) {
                Partido partidoIda = idaPartidos[numPartido];

                if (partidoIda == null) {
                    vuelta[numPartido] = null;
                } else {
                    vuelta[numPartido] = new Partido(partidoIda.getEquipoVisitante(), partidoIda.getEquipoLocal());
                }
            }

            this.jornadas[jornadasIda + numJornada] = new Jornada(jornadasIda + numJornada + 1, vuelta);
        }

        this.ganadoresUltimaJornada = new Club[partidosPorJornada];
        this.numGanadoresUltimaJornada = 0;

        this.resultadosUltimaJornada = new String[partidosPorJornada];
        this.resultadosUltimoEquipo = new String[partidosPorJornada];
        this.numResultadosUltimaJornada = 0;
        this.numResultadosUltimoEquipo = 0;

        this.jornadaEnCurso = 0;
        reiniciarTabla();

        setGenerada(true);
        setTerminada(false);

        System.out.println("Calendario generado.");
        System.out.println("Listo para simular jornadas.");
        System.out.println("==========================================\n");
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        return simularRondaMotor(true, null, verEnDirecto);
    }

    public boolean simularRondaSoloEquipo(Club equipo, boolean verEnDirectoEquipo) {
        return simularRondaMotor(false, equipo, verEnDirectoEquipo);
    }

    public boolean simularHastaJornada(int jornadaObjetivo) {
        if (!isGenerada()) {
            generar();
        }

        if (jornadaObjetivo < 1) {
            jornadaObjetivo = 1;
        }
        if (jornadaObjetivo > totalJornadas) {
            jornadaObjetivo = totalJornadas;
        }

        while (!haTerminado() && jornadaEnCurso < jornadaObjetivo) {
            simularRondaMotor(false, null, false);
        }

        return true;
    }

    private boolean simularRondaMotor(boolean mostrarTodosLosResultados, Club equipoSolo, boolean verEnDirecto) {

        if (!isGenerada()) {
            generar();
        }

        numGanadoresUltimaJornada = 0;

        if (haTerminado()) {
            System.out.println("La liga ya terminó.");
            return false;
        }

        if (jornadaEnCurso >= totalJornadas) {
            setTerminada(true);
            System.out.println("Temporada completada.");
            return false;
        }

        if (mostrarTodosLosResultados) {
            System.out.println(getNombre().toUpperCase() + " | JORNADA " + (jornadaEnCurso + 1) + "/" + totalJornadas);
        }

        Jornada jornada = jornadas[jornadaEnCurso];
        resetResultados();

        Partido[] listaPartidos;
        if (jornada == null) {
            listaPartidos = null;
        } else {
            listaPartidos = jornada.getPartidos();
        }

        if (listaPartidos != null) {
            for (int i = 0; i < listaPartidos.length; i++) {
                Partido partido = listaPartidos[i];
                if (partido == null) {
                    continue;
                }
                if (partido.isJugado()) {
                    continue;
                }

                boolean esPartidoDelEquipo = false;
                if (equipoSolo != null && partido.participa(equipoSolo)) {
                    esPartidoDelEquipo = true;
                }

                boolean verEsteEnDirecto = false;
                if (equipoSolo != null) {
                    if (verEnDirecto && esPartidoDelEquipo) {
                        verEsteEnDirecto = true;
                    }
                } else {
                    if (verEnDirecto) {
                        verEsteEnDirecto = true;
                    }
                }

                partido.simular(verEsteEnDirecto);
                actualizarTabla(partido);
                registrarGanador(partido);

                guardarResultadoJornada(partido);

                if (equipoSolo != null && esPartidoDelEquipo) {
                    guardarResultadoEquipo(partido);
                }
            }
        }

        if (mostrarTodosLosResultados) {
            System.out.println("\nRESULTADOS:");
            for (int i = 0; i < numResultadosUltimaJornada; i++) {
                System.out.println(" - " + resultadosUltimaJornada[i]);
            }
        } else {
            if (equipoSolo != null) {
                System.out.println("\nPARTIDO DEL EQUIPO:");
                for (int i = 0; i < numResultadosUltimoEquipo; i++) {
                    System.out.println(" - " + resultadosUltimoEquipo[i]);
                }
            }
        }

        jornadaEnCurso++;

        if (jornadaEnCurso >= totalJornadas) {
            setTerminada(true);
            System.out.println("\nFin de temporada: se han jugado todas las jornadas.");
        }

        return true;
    }

    public boolean simularPartidoEnVivo(int indiceSeleccion) {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            System.out.println("La liga ya termino.");
            return false;
        }

        if (jornadaEnCurso < 0 || jornadaEnCurso >= totalJornadas) {
            setTerminada(true);
            return false;
        }

        Jornada jornada = jornadas[jornadaEnCurso];
        if (jornada == null) {
            return false;
        }

        Partido[] listaPartidos = jornada.getPartidos();
        if (listaPartidos == null || listaPartidos.length == 0) {
            return false;
        }

        int[] indices = new int[listaPartidos.length];
        int totalDisponibles = 0;

        for (int i = 0; i < listaPartidos.length; i++) {
            Partido p = listaPartidos[i];
            if (p == null) {
                continue;
            }
            if (p.isJugado()) {
                continue;
            }
            indices[totalDisponibles] = i;
            totalDisponibles++;
        }

        if (totalDisponibles == 0) {
            System.out.println("No hay partidos disponibles en la jornada actual.");
            return false;
        }

        if (indiceSeleccion < 1) {
            indiceSeleccion = 1;
        }
        if (indiceSeleccion > totalDisponibles) {
            indiceSeleccion = totalDisponibles;
        }

        int indiceReal = indices[indiceSeleccion - 1];
        Partido partido = listaPartidos[indiceReal];
        if (partido == null) {
            return false;
        }

        partido.simular(true);
        actualizarTabla(partido);
        registrarGanador(partido);

        asegurarArraysResultados(listaPartidos.length);
        guardarResultadoJornada(partido);

        boolean quedan = false;
        for (int i = 0; i < listaPartidos.length; i++) {
            Partido p = listaPartidos[i];
            if (p != null && !p.isJugado()) {
                quedan = true;
                break;
            }
        }

        if (!quedan) {
            jornadaEnCurso++;

            if (jornadaEnCurso >= totalJornadas) {
                setTerminada(true);
                System.out.println("\nFin de temporada: se han jugado todas las jornadas.");
            } else {
                System.out.println("\nJornada completada. Pasando a la siguiente...");
            }
        }

        return true;
    }

    public String[] listarPartidosDisponibles() {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            return new String[0];
        }

        if (jornadaEnCurso < 0 || jornadaEnCurso >= totalJornadas) {
            return new String[0];
        }

        Jornada jornada = jornadas[jornadaEnCurso];
        if (jornada == null) {
            return new String[0];
        }

        Partido[] listaPartidos = jornada.getPartidos();
        if (listaPartidos == null || listaPartidos.length == 0) {
            return new String[0];
        }

        int total = 0;
        for (int i = 0; i < listaPartidos.length; i++) {
            Partido p = listaPartidos[i];
            if (p == null) {
                continue;
            }
            if (p.isJugado()) {
                continue;
            }
            total++;
        }

        if (total == 0) {
            return new String[0];
        }

        String[] lineas = new String[total];
        int pos = 0;
        int num = 1;

        for (int i = 0; i < listaPartidos.length; i++) {
            Partido p = listaPartidos[i];
            if (p == null) {
                continue;
            }
            if (p.isJugado()) {
                continue;
            }

            String texto = num + ") " + p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre();
            lineas[pos] = texto;
            pos++;
            num++;
        }

        return lineas;
    }

    @Override
    public void mostrarUltimosResultados() {
        if (numResultadosUltimaJornada <= 0) {
            System.out.println("No hay resultados guardados todavía.");
            return;
        }

        System.out.println("ULTIMA JORNADA - " + getNombre().toUpperCase());

        for (int i = 0; i < numResultadosUltimaJornada; i++) {
            System.out.println(" - " + resultadosUltimaJornada[i]);
        }
    }

    @Override
    public boolean haTerminado() {
        return isTerminada();
    }

    public void mostrarCalendario() {
        if (!isGenerada()) {
            System.out.println("Primero genera el calendario.");
            return;
        }

        if (jornadas == null || jornadas.length == 0) {
            System.out.println("No hay jornadas para mostrar.");
            return;
        }

        System.out.println("\n===== CALENDARIO: " + getNombre().toUpperCase() + " =====");

        for (int j = 0; j < jornadas.length; j++) {
            Jornada jo = jornadas[j];
            System.out.println("\n--- Jornada " + (j + 1) + " ---");

            if (jo == null) {
                System.out.println("(Sin jornada creada)");
            } else {
                jo.mostrarPartidos();
            }
        }
    }

    public void mostrarClasificacion() {
        String titulo = "CLASIFICACION - " + getNombre().toUpperCase()
                + " (Jornada " + jornadaEnCurso + "/" + totalJornadas + ")";

        String[] cab = {"#", "CLUB", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "PTS"};

        int[] orden = new int[totalEquipos];
        for (int i = 0; i < totalEquipos; i++) {
            orden[i] = i;
        }

        for (int i = 0; i < totalEquipos - 1; i++) {
            int mejor = i;
            for (int j = i + 1; j < totalEquipos; j++) {
                if (esMejor(orden[j], orden[mejor])) {
                    mejor = j;
                }
            }
            int aux = orden[i];
            orden[i] = orden[mejor];
            orden[mejor] = aux;
        }

        String[][] filas = new String[totalEquipos][cab.length];
        for (int pos = 0; pos < totalEquipos; pos++) {
            int i = orden[pos];
            int dg = golesFavor[i] - golesContra[i];

            filas[pos][0] = String.valueOf(pos + 1);
            if (equipos[i] == null) {
                filas[pos][1] = "-";
            } else {
                filas[pos][1] = equipos[i].getNombre();
            }
            filas[pos][2] = String.valueOf(jugados[i]);
            filas[pos][3] = String.valueOf(ganados[i]);
            filas[pos][4] = String.valueOf(empatados[i]);
            filas[pos][5] = String.valueOf(perdidos[i]);
            filas[pos][6] = String.valueOf(golesFavor[i]);
            filas[pos][7] = String.valueOf(golesContra[i]);
            filas[pos][8] = String.valueOf(dg);
            filas[pos][9] = String.valueOf(puntos[i]);
        }

        ui.TablaConsola.imprimirTablaCentrada(titulo, cab, filas, 110);
    }

    private boolean esMejor(int a, int b) {
        if (puntos[a] != puntos[b]) {
            return puntos[a] > puntos[b];
        }

        int difA = golesFavor[a] - golesContra[a];
        int difB = golesFavor[b] - golesContra[b];
        if (difA != difB) {
            return difA > difB;
        }

        if (golesFavor[a] != golesFavor[b]) {
            return golesFavor[a] > golesFavor[b];
        }

        return equipos[a].getNombre().compareToIgnoreCase(equipos[b].getNombre()) < 0;
    }

    private void actualizarTabla(Partido partido) {
        Club local = partido.getEquipoLocal();
        Club visitante = partido.getEquipoVisitante();

        int idxLocal = indiceEquipo(local);
        int idxVisitante = indiceEquipo(visitante);

        if (idxLocal < 0 || idxVisitante < 0) {
            return;
        }

        int gLocal = partido.getGolesDelLocal();
        int gVisitante = partido.getGolesDelVisitante();

        jugados[idxLocal]++;
        jugados[idxVisitante]++;

        golesFavor[idxLocal] += gLocal;
        golesContra[idxLocal] += gVisitante;

        golesFavor[idxVisitante] += gVisitante;
        golesContra[idxVisitante] += gLocal;

        if (gLocal > gVisitante) {
            ganados[idxLocal]++;
            perdidos[idxVisitante]++;
            puntos[idxLocal] += 3;
        } else if (gLocal < gVisitante) {
            ganados[idxVisitante]++;
            perdidos[idxLocal]++;
            puntos[idxVisitante] += 3;
        } else {
            empatados[idxLocal]++;
            empatados[idxVisitante]++;
            puntos[idxLocal] += 1;
            puntos[idxVisitante] += 1;
        }
    }

    private int indiceEquipo(Club equipo) {
        if (equipo == null) {
            return -1;
        }

        for (int i = 0; i < totalEquipos; i++) {
            if (equipos[i] == equipo) {
                return i;
            }
        }

        String nombre = equipo.getNombre();
        if (nombre == null) {
            return -1;
        }

        for (int i = 0; i < totalEquipos; i++) {
            if (equipos[i] != null && equipos[i].getNombre() != null) {
                if (equipos[i].getNombre().equalsIgnoreCase(nombre)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private void reiniciarTabla() {
        for (int i = 0; i < totalEquipos; i++) {
            jugados[i] = 0;
            ganados[i] = 0;
            empatados[i] = 0;
            perdidos[i] = 0;
            golesFavor[i] = 0;
            golesContra[i] = 0;
            puntos[i] = 0;
        }
    }

    private void mezclar(Club[] lista) {
        for (int i = lista.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Club tmp = lista[i];
            lista[i] = lista[j];
            lista[j] = tmp;
        }
    }

    private void rotarOrden(Club[] lista) {
        if (lista.length <= 2) {
            return;
        }

        Club ultimo = lista[lista.length - 1];
        for (int i = lista.length - 1; i > 1; i--) {
            lista[i] = lista[i - 1];
        }
        lista[1] = ultimo;
    }

    private String recortar(String s, int max) {
        if (s == null) {
            return "";
        }
        if (s.length() <= max) {
            return s;
        }
        return s.substring(0, max);
    }

    private void registrarGanador(Partido partido) {
        if (partido == null) {
            return;
        }

        Club ganador = null;

        if (partido.getGolesDelLocal() > partido.getGolesDelVisitante()) {
            ganador = partido.getEquipoLocal();
        } else if (partido.getGolesDelLocal() < partido.getGolesDelVisitante()) {
            ganador = partido.getEquipoVisitante();
        }

        if (ganador == null) {
            return;
        }
        if (ganadoresUltimaJornada == null) {
            return;
        }
        if (numGanadoresUltimaJornada >= ganadoresUltimaJornada.length) {
            return;
        }

        ganadoresUltimaJornada[numGanadoresUltimaJornada] = ganador;
        numGanadoresUltimaJornada++;
    }

    @Override
    public Club[] getGanadoresUltimaJornada() {
        Club[] res = new Club[numGanadoresUltimaJornada];
        for (int i = 0; i < numGanadoresUltimaJornada; i++) {
            res[i] = ganadoresUltimaJornada[i];
        }
        return res;
    }

    private void resetResultados() {
        numResultadosUltimaJornada = 0;
        numResultadosUltimoEquipo = 0;
    }

    private void asegurarArraysResultados(int tam) {
        if (resultadosUltimaJornada == null || resultadosUltimaJornada.length < tam) {
            resultadosUltimaJornada = new String[tam];
        }
        if (resultadosUltimoEquipo == null || resultadosUltimoEquipo.length < tam) {
            resultadosUltimoEquipo = new String[tam];
        }
        if (ganadoresUltimaJornada == null || ganadoresUltimaJornada.length < tam) {
            ganadoresUltimaJornada = new Club[tam];
        }
    }

    private void guardarResultadoJornada(Partido partido) {
        if (partido == null) {
            return;
        }
        if (numResultadosUltimaJornada < resultadosUltimaJornada.length) {
            resultadosUltimaJornada[numResultadosUltimaJornada] = partido.toString();
            numResultadosUltimaJornada++;
        }
    }

    private void guardarResultadoEquipo(Partido partido) {
        if (partido == null) {
            return;
        }
        if (numResultadosUltimoEquipo < resultadosUltimoEquipo.length) {
            resultadosUltimoEquipo[numResultadosUltimoEquipo] = partido.toString();
            numResultadosUltimoEquipo++;
        }
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + getNombre() + '\'' +
                ", totalEquipos=" + totalEquipos +
                ", jornadaEnCurso=" + jornadaEnCurso +
                ", totalJornadas=" + totalJornadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != Liga.class) {
            return false;
        }

        Liga otra = (Liga) o;

        if (getNombre() == null && otra.getNombre() == null) {
            return true;
        }
        if (getNombre() == null || otra.getNombre() == null) {
            return false;
        }

        return getNombre().equalsIgnoreCase(otra.getNombre());
    }
}
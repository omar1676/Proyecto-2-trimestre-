package competicion;

import clubes.Club;
import partido.Partido;

import java.util.Random;

public class Liga extends Competicion {

    private Club[] equipos;
    private int totalEquipos;

    private Partido[][] jornadas;
    private int totalJornadas;
    private int partidosPorJornada;
    private int jornadaEnCurso;

    private int[] jugados, ganados, empatados, perdidos, golesFavor, golesContra, puntos;

    private String[] resultadosUltimaJornada;
    private int numResultadosUltimaJornada;
    private Club[] ganadoresUltimaJornada;
    private int numGanadoresUltimaJornada;

    private Random rnd;

    public Liga() {
        super("Liga");
        this.rnd = new Random();

        this.equipos = new Club[0];
        this.totalEquipos = 0;

        this.jornadas = new Partido[0][0];
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
        this.numResultadosUltimaJornada = 0;

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
        if (tam <= 0) tam = 1;
        this.resultadosUltimaJornada = new String[tam];
        this.numResultadosUltimaJornada = 0;
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
            this.jornadas = new Partido[0][0];
            this.totalJornadas = 0;
            this.partidosPorJornada = 0;
            setGenerada(true);
            setTerminada(true);
            System.out.println("No hay clubes suficientes.");
            System.out.println("==========================================\n");
            return;
        }

        boolean hayDescanso = false;
        if (totalEquipos % 2 != 0) hayDescanso = true;

        int n = totalEquipos;
        if (hayDescanso) n = totalEquipos + 1;

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

        this.jornadas = new Partido[totalJornadas][partidosPorJornada];

        System.out.print("Clubes: " + totalEquipos);
        if (hayDescanso) System.out.print(" (1 descanso)");
        System.out.println();

        System.out.println("Jornadas: " + totalJornadas + " (Ida " + jornadasIda + " | Vuelta " + jornadasIda + ")");
        System.out.println("Partidos/jornada: " + partidosPorJornada);
        System.out.println("------------------------------------------");

        for (int numJornada = 0; numJornada < jornadasIda; numJornada++) {

            for (int numPartido = 0; numPartido < partidosPorJornada; numPartido++) {
                Club equipoA = ordenEquipos[numPartido];
                Club equipoB = ordenEquipos[n - 1 - numPartido];

                if (equipoA == null || equipoB == null) {
                    jornadas[numJornada][numPartido] = null;
                } else {
                    boolean invertirLocalia = false;
                    if (numJornada % 2 != 0) invertirLocalia = true;

                    Club local;
                    Club visitante;

                    if (invertirLocalia) {
                        local = equipoB;
                        visitante = equipoA;
                    } else {
                        local = equipoA;
                        visitante = equipoB;
                    }

                    jornadas[numJornada][numPartido] = new Partido(local, visitante);
                }
            }

            rotarOrden(ordenEquipos);
        }

        for (int numJornada = 0; numJornada < jornadasIda; numJornada++) {
            for (int numPartido = 0; numPartido < partidosPorJornada; numPartido++) {
                Partido partidoIda = jornadas[numJornada][numPartido];

                if (partidoIda == null) {
                    jornadas[jornadasIda + numJornada][numPartido] = null;
                } else {
                    jornadas[jornadasIda + numJornada][numPartido] =
                            new Partido(partidoIda.getEquipoVisitante(), partidoIda.getEquipoLocal());
                }
            }
        }
        this.ganadoresUltimaJornada = new Club[partidosPorJornada];
        this.numGanadoresUltimaJornada = 0;
        this.resultadosUltimaJornada = new String[partidosPorJornada];
        this.numResultadosUltimaJornada = 0;

        this.jornadaEnCurso = 0;
        reiniciarTabla();

        setGenerada(true);
        setTerminada(false);

        System.out.println("Calendario generado (ida/vuelta).");
        System.out.println("Listo para simular jornadas.");
        System.out.println("==========================================\n");
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        if (!isGenerada()) generar();
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

        System.out.println("\n------------------------------------------");
        System.out.println(getNombre().toUpperCase() + " | JORNADA " + (jornadaEnCurso + 1) + "/" + totalJornadas);
        System.out.println("------------------------------------------");

        Partido[] listaPartidos = jornadas[jornadaEnCurso];
        numResultadosUltimaJornada = 0;

        if (listaPartidos != null) {
            for (int i = 0; i < listaPartidos.length; i++) {
                Partido partido = listaPartidos[i];
                if (partido == null) continue;

                partido.simular(verEnDirecto);
                actualizarTabla(partido);
                registrarGanador(partido);

                if (numResultadosUltimaJornada < resultadosUltimaJornada.length) {
                    resultadosUltimaJornada[numResultadosUltimaJornada] = partido.toString();
                    numResultadosUltimaJornada++;
                }
            }
        }

        System.out.println("\nRESULTADOS:");
        for (int i = 0; i < numResultadosUltimaJornada; i++) {
            System.out.println(" - " + resultadosUltimaJornada[i]);
        }

        jornadaEnCurso++;

        if (jornadaEnCurso >= totalJornadas) {
            setTerminada(true);
            System.out.println("\nFin de temporada: se han jugado todas las jornadas.");
        }

        return true;
    }

    public boolean simularRonda(Club clubSeguido, boolean verEnDirectoSeguido) {

        if (!isGenerada()) generar();
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

        System.out.println("\n------------------------------------------");
        System.out.println(getNombre().toUpperCase() + " | JORNADA " + (jornadaEnCurso + 1) + "/" + totalJornadas);
        if (clubSeguido != null) {
            System.out.println("MODO CARRERA | Equipo seguido: " + clubSeguido.getNombre());
        }
        System.out.println("------------------------------------------");

        Partido[] listaPartidos = jornadas[jornadaEnCurso];
        numResultadosUltimaJornada = 0;

        if (listaPartidos != null) {
            for (int i = 0; i < listaPartidos.length; i++) {
                Partido partido = listaPartidos[i];
                if (partido == null) continue;

                boolean verEsteEnDirecto = false;
                if (verEnDirectoSeguido && clubSeguido != null && partido.participa(clubSeguido)) {
                    verEsteEnDirecto = true;
                }

                partido.simular(verEsteEnDirecto);
                actualizarTabla(partido);
                registrarGanador(partido);

                if (numResultadosUltimaJornada < resultadosUltimaJornada.length) {
                    String texto = partido.toString();
                    if (clubSeguido != null && partido.participa(clubSeguido)) {
                        texto = "SEGUIDO - " + texto;
                    }
                    resultadosUltimaJornada[numResultadosUltimaJornada] = texto;
                    numResultadosUltimaJornada++;
                }
            }
        }

        System.out.println("\nRESULTADOS:");
        for (int i = 0; i < numResultadosUltimaJornada; i++) {
            System.out.println(" - " + resultadosUltimaJornada[i]);
        }

        jornadaEnCurso++;

        if (jornadaEnCurso >= totalJornadas) {
            setTerminada(true);
            System.out.println("\nFin de temporada: se han jugado todas las jornadas.");
        }

        return true;
    }

    @Override
    public void mostrarUltimosResultados() {
        if (numResultadosUltimaJornada <= 0) {
            System.out.println("No hay resultados guardados todavía.");
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("ULTIMA JORNADA - " + getNombre().toUpperCase());
        System.out.println("==========================================");

        for (int i = 0; i < numResultadosUltimaJornada; i++) {
            System.out.println(" - " + resultadosUltimaJornada[i]);
        }

        System.out.println("==========================================\n");
    }

    @Override
    public boolean haTerminado() {
        return isTerminada();
    }

    public void mostrarClasificacion() {
        System.out.println("\n==============================================================");
        System.out.println("CLASIFICACION - " + getNombre().toUpperCase()
                + " (Jornada " + jornadaEnCurso + "/" + totalJornadas + ")");
        System.out.println("==============================================================");

        System.out.printf("%-3s %-22s %3s %3s %3s %3s %4s %4s %4s%n",
                "#", "CLUB", "PJ", "PG", "PE", "PP", "GF", "GC", "PTS");

        int[] orden = new int[totalEquipos];
        for (int i = 0; i < totalEquipos; i++) orden[i] = i;

        for (int i = 0; i < totalEquipos - 1; i++) {
            int mejor = i;
            for (int j = i + 1; j < totalEquipos; j++) {
                if (esMejor(orden[j], orden[mejor])) mejor = j;
            }
            int aux = orden[i];
            orden[i] = orden[mejor];
            orden[mejor] = aux;
        }

        for (int posicion = 0; posicion < totalEquipos; posicion++) {
            int idx = orden[posicion];
            System.out.printf("%-3d %-22s %3d %3d %3d %3d %4d %4d %4d%n",
                    (posicion + 1),
                    recortar(equipos[idx].getNombre(), 22),
                    jugados[idx], ganados[idx], empatados[idx], perdidos[idx],
                    golesFavor[idx], golesContra[idx], puntos[idx]
            );
        }

        System.out.println("==============================================================\n");
    }

    private boolean esMejor(int a, int b) {
        if (puntos[a] != puntos[b]) return puntos[a] > puntos[b];

        int difA = golesFavor[a] - golesContra[a];
        int difB = golesFavor[b] - golesContra[b];
        if (difA != difB) return difA > difB;

        if (golesFavor[a] != golesFavor[b]) return golesFavor[a] > golesFavor[b];

        return equipos[a].getNombre().compareToIgnoreCase(equipos[b].getNombre()) < 0;
    }

    private void actualizarTabla(Partido partido) {
        Club local = partido.getEquipoLocal();
        Club visitante = partido.getEquipoVisitante();

        int idxLocal = indiceEquipo(local);
        int idxVisitante = indiceEquipo(visitante);

        if (idxLocal < 0 || idxVisitante < 0) return;

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
        if (equipo == null) return -1;

        for (int i = 0; i < totalEquipos; i++) {
            if (equipos[i] == equipo) return i;
        }

        String nombre = equipo.getNombre();
        if (nombre == null) return -1;

        for (int i = 0; i < totalEquipos; i++) {
            if (equipos[i] != null && equipos[i].getNombre() != null) {
                if (equipos[i].getNombre().equalsIgnoreCase(nombre)) return i;
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
        if (lista.length <= 2) return;

        Club ultimo = lista[lista.length - 1];
        for (int i = lista.length - 1; i > 1; i--) {
            lista[i] = lista[i - 1];
        }
        lista[1] = ultimo;
    }

    private String recortar(String s, int max) {
        if (s == null) return "";
        if (s.length() <= max) return s;
        return s.substring(0, max);
    }

    private void registrarGanador(Partido partido) {
        if (partido == null) return;

        Club ganador = null;

        if (partido.getGolesDelLocal() > partido.getGolesDelVisitante()) {
            ganador = partido.getEquipoLocal();
        } else if (partido.getGolesDelLocal() < partido.getGolesDelVisitante()) {
            ganador = partido.getEquipoVisitante();
        }

        if (ganador == null) return;
        if (ganadoresUltimaJornada == null) return;
        if (numGanadoresUltimaJornada >= ganadoresUltimaJornada.length) return;

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
        if (o == null) return false;
        if (!(o instanceof Liga)) return false;

        Liga otra = (Liga) o;

        if (getNombre() == null && otra.getNombre() == null) return true;
        if (getNombre() == null || otra.getNombre() == null) return false;

        return getNombre().equalsIgnoreCase(otra.getNombre());
    }
}
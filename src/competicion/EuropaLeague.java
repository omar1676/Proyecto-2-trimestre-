package competicion;

import clubes.Club;
import partido.Partido;

import java.util.Random;

public class EuropaLeague extends Competicion {

    private Club[] participantes;
    private int totalParticipantes;

    private Jornada[] rondas;
    private int rondaEnCurso;

    private String[] resultadosUltimaRonda;
    private int numResultadosUltimaRonda;

    private Club[] ganadoresUltimaRonda;
    private int numGanadoresUltimaRonda;

    private Club campeon;

    private Random rnd;

    public EuropaLeague(Club[] clubes) {
        super("Europa League");
        this.rnd = new Random();

        if (clubes == null) {
            this.participantes = new Club[0];
            this.totalParticipantes = 0;
        } else {
            this.participantes = new Club[clubes.length];
            this.totalParticipantes = 0;

            for (int i = 0; i < clubes.length; i++) {
                if (clubes[i] != null) {
                    this.participantes[this.totalParticipantes] = clubes[i];
                    this.totalParticipantes++;
                }
            }
        }

        this.rondas = new Jornada[4];
        this.rondaEnCurso = 0;

        this.resultadosUltimaRonda = new String[0];
        this.numResultadosUltimaRonda = 0;

        this.ganadoresUltimaRonda = new Club[0];
        this.numGanadoresUltimaRonda = 0;

        this.campeon = null;
    }

    public int getRondaEnCurso() {
        return rondaEnCurso;
    }

    public String getNombreRondaActual() {
        return nombreRonda(rondaEnCurso);
    }

    @Override
    public void generar() {
        if (isGenerada()) {
            System.out.println("Ya estaba generada: " + getNombre());
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("GENERANDO EUROPA LEAGUE: " + getNombre().toUpperCase());
        System.out.println("==========================================");

        if (totalParticipantes < 16) {
            this.rondas = new Jornada[0];
            this.rondaEnCurso = 0;
            setGenerada(true);
            setTerminada(true);
            System.out.println("No hay clubes suficientes. Se necesitan mínimo 16.");
            System.out.println("==========================================\n");
            return;
        }

        Club[] lista = new Club[16];
        for (int i = 0; i < 16; i++) {
            lista[i] = participantes[i];
        }

        mezclar(lista);

        Partido[] octavos = new Partido[8];
        int p = 0;
        int idx = 0;
        while (p < octavos.length) {
            Club a = lista[idx];
            Club b = lista[idx + 1];
            octavos[p] = new Partido(a, b);
            p++;
            idx += 2;
        }

        this.rondas = new Jornada[4];
        this.rondas[0] = new Jornada(1, octavos);
        this.rondas[1] = null;
        this.rondas[2] = null;
        this.rondas[3] = null;

        this.resultadosUltimaRonda = new String[octavos.length];
        this.numResultadosUltimaRonda = 0;

        this.ganadoresUltimaRonda = new Club[octavos.length];
        this.numGanadoresUltimaRonda = 0;

        this.rondaEnCurso = 0;

        setGenerada(true);
        setTerminada(false);
        this.campeon = null;

        System.out.println("Cuadro generado: Octavos -> Cuartos -> Semis -> Final");
        System.out.println("==========================================\n");
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            System.out.println("La Europa League ya terminó.");
            return false;
        }

        if (rondas == null || rondas.length == 0) {
            setTerminada(true);
            return false;
        }

        if (rondaEnCurso < 0 || rondaEnCurso >= rondas.length) {
            setTerminada(true);
            return false;
        }

        Jornada ronda = rondas[rondaEnCurso];
        if (ronda == null) {
            setTerminada(true);
            return false;
        }

        Partido[] partidos = ronda.getPartidos();
        if (partidos == null || partidos.length == 0) {
            setTerminada(true);
            return false;
        }

        resultadosUltimaRonda = new String[partidos.length];
        numResultadosUltimaRonda = 0;

        ganadoresUltimaRonda = new Club[partidos.length];
        numGanadoresUltimaRonda = 0;

        System.out.println(getNombre().toUpperCase() + " | " + nombreRonda(rondaEnCurso));

        for (int i = 0; i < partidos.length; i++) {
            Partido eliminatoria = partidos[i];
            if (eliminatoria == null) {
                continue;
            }

            if (rondaEnCurso >= 3) {
                if (eliminatoria.isJugado()) {
                    continue;
                }

                eliminatoria.simular(verEnDirecto);

                if (numResultadosUltimaRonda < resultadosUltimaRonda.length) {
                    resultadosUltimaRonda[numResultadosUltimaRonda] = eliminatoria.toString();
                    numResultadosUltimaRonda++;
                }

                Club ganadorFinal = resolverGanador(eliminatoria);
                if (ganadorFinal != null && numGanadoresUltimaRonda < ganadoresUltimaRonda.length) {
                    ganadoresUltimaRonda[numGanadoresUltimaRonda] = ganadorFinal;
                    numGanadoresUltimaRonda++;
                }

                continue;
            }

            if (eliminatoria.isJugado()) {
                continue;
            }

            Club a = eliminatoria.getEquipoLocal();
            Club b = eliminatoria.getEquipoVisitante();

            Partido ida = eliminatoria;
            Partido vuelta = new Partido(b, a);

            ida.simular(verEnDirecto);
            vuelta.simular(verEnDirecto);

            int golesA = ida.getGolesDelLocal() + vuelta.getGolesDelVisitante();
            int golesB = ida.getGolesDelVisitante() + vuelta.getGolesDelLocal();

            String resumen = "IDA: " + ida.toString() + " | VUELTA: " + vuelta.toString() + " | GLOBAL " + a.getNombre() + " " + golesA + " - " + golesB + " " + b.getNombre();

            if (numResultadosUltimaRonda < resultadosUltimaRonda.length) {
                resultadosUltimaRonda[numResultadosUltimaRonda] = resumen;
                numResultadosUltimaRonda++;
            }

            Club ganador = null;
            if (golesA > golesB) {
                ganador = a;
            } else if (golesB > golesA) {
                ganador = b;
            } else {
                int x = rnd.nextInt(2);
                if (x == 0) {
                    ganador = a;
                } else {
                    ganador = b;
                }
            }

            if (ganador != null && numGanadoresUltimaRonda < ganadoresUltimaRonda.length) {
                ganadoresUltimaRonda[numGanadoresUltimaRonda] = ganador;
                numGanadoresUltimaRonda++;
            }
        }

        System.out.println("\nRESULTADOS:");
        for (int i = 0; i < numResultadosUltimaRonda; i++) {
            System.out.println(" - " + resultadosUltimaRonda[i]);
        }

        prepararSiguienteRonda();
        rondaEnCurso++;

        if (rondaEnCurso >= rondas.length) {
            setTerminada(true);

            if (numGanadoresUltimaRonda > 0) {
                campeon = ganadoresUltimaRonda[0];
            }

            Club c = campeon;
            if (c != null) {
                System.out.println("\nCAMPEÓN: " + c.getNombre());
                c.ganarEuropaLeague();
            } else {
                System.out.println("\nCAMPEÓN: Desconocido");
            }
        }

        return true;
    }

    private void prepararSiguienteRonda() {
        if (rondaEnCurso >= 3) {
            return;
        }

        int n = numGanadoresUltimaRonda;
        if (n < 2) {
            return;
        }

        int partidosSiguiente = n / 2;
        Partido[] siguientes = new Partido[partidosSiguiente];

        int i = 0;
        int p = 0;
        while (p < siguientes.length) {
            Club a = ganadoresUltimaRonda[i];
            Club b = ganadoresUltimaRonda[i + 1];
            siguientes[p] = new Partido(a, b);
            p++;
            i += 2;
        }

        rondas[rondaEnCurso + 1] = new Jornada(rondaEnCurso + 2, siguientes);
    }

    private Club resolverGanador(Partido partido) {
        int gl = partido.getGolesDelLocal();
        int gv = partido.getGolesDelVisitante();

        if (gl > gv) {
            return partido.getEquipoLocal();
        }
        if (gv > gl) {
            return partido.getEquipoVisitante();
        }

        int x = rnd.nextInt(2);
        if (x == 0) {
            return partido.getEquipoLocal();
        }
        return partido.getEquipoVisitante();
    }

    public Club getCampeon() {
        return campeon;
    }

    private String nombreRonda(int r) {
        if (r == 0) {
            return "OCTAVOS";
        }
        if (r == 1) {
            return "CUARTOS";
        }
        if (r == 2) {
            return "SEMIFINALES";
        }
        if (r == 3) {
            return "FINAL";
        }
        return "RONDA";
    }

    public void mostrarCuadro() {
        if (!isGenerada()) {
            System.out.println("Primero genera el cuadro.");
            return;
        }

        if (rondas == null || rondas.length == 0) {
            System.out.println("No hay rondas para mostrar.");
            return;
        }

        System.out.println("\n===== CUADRO: " + getNombre().toUpperCase() + " =====");

        for (int i = 0; i < rondas.length; i++) {
            System.out.println("\n--- " + nombreRonda(i) + " ---");
            Jornada j = rondas[i];
            if (j == null) {
                System.out.println("(Aún no generada)");
            } else {
                j.mostrarPartidos();
            }
        }
    }

    public void mostrarCalendario() {
        mostrarCuadro();
    }

    @Override
    public void mostrarUltimosResultados() {
        if (numResultadosUltimaRonda <= 0) {
            System.out.println("No hay resultados guardados todavía.");
            return;
        }

        System.out.println("ÚLTIMA RONDA - " + getNombre().toUpperCase());
        for (int i = 0; i < numResultadosUltimaRonda; i++) {
            System.out.println(" - " + resultadosUltimaRonda[i]);
        }
    }

    @Override
    public boolean haTerminado() {
        return isTerminada();
    }

    @Override
    public Club[] getGanadoresUltimaJornada() {
        Club[] res = new Club[numGanadoresUltimaRonda];
        for (int i = 0; i < numGanadoresUltimaRonda; i++) {
            res[i] = ganadoresUltimaRonda[i];
        }
        return res;
    }

    public String[] listarPartidosDisponibles() {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            return new String[0];
        }
        if (rondas == null || rondas.length == 0) {
            return new String[0];
        }
        if (rondaEnCurso < 0 || rondaEnCurso >= rondas.length) {
            return new String[0];
        }

        Jornada ronda = rondas[rondaEnCurso];
        if (ronda == null) {
            return new String[0];
        }

        Partido[] ps = ronda.getPartidos();
        if (ps == null || ps.length == 0) {
            return new String[0];
        }

        int total = 0;
        for (int i = 0; i < ps.length; i++) {
            if (ps[i] == null) {
                continue;
            }
            if (ps[i].isJugado()) {
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

        for (int i = 0; i < ps.length; i++) {
            Partido p = ps[i];
            if (p == null) {
                continue;
            }
            if (p.isJugado()) {
                continue;
            }

            String nombre = nombreRonda(rondaEnCurso);
            String texto = num + ") " + nombre + " - " + p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre();
            lineas[pos] = texto;
            pos++;
            num++;
        }

        return lineas;
    }

    public boolean simularPartidoEnVivo(int indiceSeleccion) {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            System.out.println("La Europa League ya termino.");
            return false;
        }

        if (rondas == null || rondas.length == 0) {
            return false;
        }
        if (rondaEnCurso < 0 || rondaEnCurso >= rondas.length) {
            return false;
        }

        Jornada ronda = rondas[rondaEnCurso];
        if (ronda == null) {
            return false;
        }

        Partido[] ps = ronda.getPartidos();
        if (ps == null || ps.length == 0) {
            return false;
        }

        int[] indices = new int[ps.length];
        int total = 0;

        for (int i = 0; i < ps.length; i++) {
            if (ps[i] == null) {
                continue;
            }
            if (ps[i].isJugado()) {
                continue;
            }
            indices[total] = i;
            total++;
        }

        if (total == 0) {
            System.out.println("No hay eliminatorias disponibles en la ronda actual.");
            return false;
        }

        if (indiceSeleccion < 1) {
            indiceSeleccion = 1;
        }
        if (indiceSeleccion > total) {
            indiceSeleccion = total;
        }

        int indiceReal = indices[indiceSeleccion - 1];
        Partido elegido = ps[indiceReal];
        if (elegido == null) {
            return false;
        }

        resultadosUltimaRonda = new String[ps.length];
        numResultadosUltimaRonda = 0;
        ganadoresUltimaRonda = new Club[ps.length];
        numGanadoresUltimaRonda = 0;

        System.out.println(getNombre().toUpperCase() + " | " + nombreRonda(rondaEnCurso));

        if (rondaEnCurso >= 3) {
            if (!elegido.isJugado()) {
                elegido.simular(true);
            }

            if (numResultadosUltimaRonda < resultadosUltimaRonda.length) {
                resultadosUltimaRonda[numResultadosUltimaRonda] = elegido.toString();
                numResultadosUltimaRonda++;
            }

            Club ganadorFinal = resolverGanador(elegido);
            if (ganadorFinal != null && numGanadoresUltimaRonda < ganadoresUltimaRonda.length) {
                ganadoresUltimaRonda[numGanadoresUltimaRonda] = ganadorFinal;
                numGanadoresUltimaRonda++;
            }
        } else {
            if (!elegido.isJugado()) {
                Club a = elegido.getEquipoLocal();
                Club b = elegido.getEquipoVisitante();

                Partido ida = elegido;
                Partido vuelta = new Partido(b, a);

                ida.simular(true);
                vuelta.simular(true);

                int golesA = ida.getGolesDelLocal() + vuelta.getGolesDelVisitante();
                int golesB = ida.getGolesDelVisitante() + vuelta.getGolesDelLocal();

                String resumen = "IDA: " + ida.toString() + " | VUELTA: " + vuelta.toString() + " | GLOBAL " + a.getNombre() + " " + golesA + " - " + golesB + " " + b.getNombre();

                if (numResultadosUltimaRonda < resultadosUltimaRonda.length) {
                    resultadosUltimaRonda[numResultadosUltimaRonda] = resumen;
                    numResultadosUltimaRonda++;
                }

                Club ganador = null;
                if (golesA > golesB) {
                    ganador = a;
                } else if (golesB > golesA) {
                    ganador = b;
                } else {
                    int x = rnd.nextInt(2);
                    if (x == 0) {
                        ganador = a;
                    } else {
                        ganador = b;
                    }
                }

                if (ganador != null && numGanadoresUltimaRonda < ganadoresUltimaRonda.length) {
                    ganadoresUltimaRonda[numGanadoresUltimaRonda] = ganador;
                    numGanadoresUltimaRonda++;
                }
            }
        }

        System.out.println("\nRESULTADOS:");
        for (int i = 0; i < numResultadosUltimaRonda; i++) {
            System.out.println(" - " + resultadosUltimaRonda[i]);
        }

        boolean quedan = false;
        for (int i = 0; i < ps.length; i++) {
            if (ps[i] != null && !ps[i].isJugado()) {
                quedan = true;
                break;
            }
        }

        if (!quedan) {
            prepararSiguienteRonda();
            rondaEnCurso++;

            if (rondaEnCurso >= rondas.length) {
                setTerminada(true);

                if (numGanadoresUltimaRonda > 0) {
                    campeon = ganadoresUltimaRonda[0];
                }

                Club c = campeon;
                if (c != null) {
                    System.out.println("\nCAMPEON: " + c.getNombre());
                    c.ganarEuropaLeague();
                } else {
                    System.out.println("\nCAMPEON: Desconocido");
                }
            }
        }

        return true;
    }

    private void mezclar(Club[] lista) {
        if (lista == null) {
            return;
        }
        for (int i = lista.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Club tmp = lista[i];
            lista[i] = lista[j];
            lista[j] = tmp;
        }
    }
}
package competicion;

import clubes.Club;
import partido.Partido;

import java.util.Random;

public class Supercopa extends Competicion {

    private Club[] participantes;
    private int totalParticipantes;

    private Partido semi1;
    private Partido semi2;
    private Partido granFinal;

    private Club ganadorSemi1;
    private Club ganadorSemi2;
    private Club campeonSupercopa;

    private int faseActual;
    private Random rnd;

    public Supercopa(String nombre, Club[] clubes) {
        super(nombre);

        this.rnd = new Random();
        this.faseActual = 0;

        this.participantes = new Club[0];
        this.totalParticipantes = 0;

        if (clubes != null) {
            this.participantes = new Club[clubes.length];

            int i = 0;
            while (i < clubes.length) {
                if (clubes[i] != null) {
                    this.participantes[this.totalParticipantes] = clubes[i];
                    this.totalParticipantes++;
                }
                i++;
            }
        }
    }

    @Override
    public void generar() {

        if (isGenerada()) {
            System.out.println("Ya estaba generada: " + getNombre());
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("GENERANDO: " + getNombre().toUpperCase());
        System.out.println("==========================================");

        if (totalParticipantes < 4) {
            System.out.println("Error: Se requieren 4 equipos.");
            setGenerada(true);
            setTerminada(true);
            return;
        }

        this.semi1 = new Partido(participantes[0], participantes[3]);
        this.semi2 = new Partido(participantes[1], participantes[2]);

        this.ganadorSemi1 = null;
        this.ganadorSemi2 = null;
        this.campeonSupercopa = null;

        this.granFinal = null;

        this.faseActual = 0;

        setGenerada(true);
        setTerminada(false);

        System.out.println("Semifinal 1: " + participantes[0].getNombre() + " vs " + participantes[3].getNombre());
        System.out.println("Semifinal 2: " + participantes[1].getNombre() + " vs " + participantes[2].getNombre());
        System.out.println("------------------------------------------");
    }

    public boolean simularRonda(Club seguido, boolean verEnDirectoSeguido) {

        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            System.out.println("La competición ya ha finalizado.");
            return false;
        }

        if (faseActual == 0) {

            System.out.println("\n------------------------------------------");
            System.out.println("SEMIFINALES - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            boolean verS1 = false;
            boolean verS2 = false;

            if (verEnDirectoSeguido && seguido != null) {
                if (semi1 != null && semi1.participa(seguido)) {
                    verS1 = true;
                }
                if (semi2 != null && semi2.participa(seguido)) {
                    verS2 = true;
                }
            }

            this.ganadorSemi1 = jugarPartidoUnico(semi1, verS1);
            this.ganadorSemi2 = jugarPartidoUnico(semi2, verS2);

            System.out.println("\nRESULTADOS SEMIFINALES:");
            if (semi1 != null) {
                System.out.println(" - " + semi1);
            }
            if (semi2 != null) {
                System.out.println(" - " + semi2);
            }

            this.granFinal = new Partido(ganadorSemi1, ganadorSemi2);
            this.faseActual = 1;

            System.out.println("\nFinalistas: " + ganadorSemi1.getNombre() + " y " + ganadorSemi2.getNombre());
            return true;
        }

        if (faseActual == 1) {

            System.out.println("\n------------------------------------------");
            System.out.println("FINAL - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            boolean verF = false;
            if (verEnDirectoSeguido && seguido != null) {
                if (granFinal != null && granFinal.participa(seguido)) {
                    verF = true;
                }
            }

            this.campeonSupercopa = jugarPartidoUnico(granFinal, verF);

            System.out.println("\nRESULTADO FINAL:");
            if (granFinal != null) {
                System.out.println(" - " + granFinal);
            }

            this.faseActual = 2;
            setTerminada(true);

            System.out.println("\n¡" + campeonSupercopa.getNombre().toUpperCase() + " ES EL CAMPEÓN!");
            System.out.println("------------------------------------------\n");
            return true;
        }

        return false;
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        return simularRonda(null, verEnDirecto);
    }

    public String[] listarPartidosDisponibles() {
        if (!isGenerada()) {
            generar();
        }
        if (haTerminado()) {
            return new String[0];
        }

        if (faseActual == 0) {

            int total = 0;
            if (semi1 != null && !semi1.isJugado()) {
                total++;
            }
            if (semi2 != null && !semi2.isJugado()) {
                total++;
            }

            if (total == 0) {
                return new String[0];
            }

            String[] res = new String[total];
            int pos = 0;
            int num = 1;

            if (semi1 != null && !semi1.isJugado()) {
                res[pos] = num + ") SEMIFINAL 1 - " + semi1.getEquipoLocal().getNombre() + " vs " + semi1.getEquipoVisitante().getNombre();
                pos++;
                num++;
            }
            if (semi2 != null && !semi2.isJugado()) {
                res[pos] = num + ") SEMIFINAL 2 - " + semi2.getEquipoLocal().getNombre() + " vs " + semi2.getEquipoVisitante().getNombre();
            }

            return res;
        }

        if (faseActual == 1) {
            if (granFinal == null) {
                return new String[0];
            }
            if (granFinal.isJugado()) {
                return new String[0];
            }

            String[] res = new String[1];
            res[0] = "1) FINAL - " + granFinal.getEquipoLocal().getNombre() + " vs " + granFinal.getEquipoVisitante().getNombre();
            return res;
        }

        return new String[0];
    }

    public boolean simularPartidoEnVivo(int indiceSeleccion) {
        if (!isGenerada()) {
            generar();
        }

        if (haTerminado()) {
            System.out.println("La Supercopa ya termino.");
            return false;
        }

        if (faseActual == 0) {

            Partido[] lista = new Partido[2];
            lista[0] = semi1;
            lista[1] = semi2;

            int[] indices = new int[2];
            int total = 0;

            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null && !lista[i].isJugado()) {
                    indices[total] = i;
                    total++;
                }
            }

            if (total == 0) {
                System.out.println("No hay semifinales disponibles.");
                return false;
            }

            if (indiceSeleccion < 1) {
                indiceSeleccion = 1;
            }
            if (indiceSeleccion > total) {
                indiceSeleccion = total;
            }

            int idxReal = indices[indiceSeleccion - 1];
            Partido elegido = lista[idxReal];

            System.out.println("\n------------------------------------------");
            System.out.println("SEMIFINALES - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            Club ganador = jugarPartidoUnico(elegido, true);

            if (elegido == semi1) {
                ganadorSemi1 = ganador;
            } else if (elegido == semi2) {
                ganadorSemi2 = ganador;
            }

            boolean semisTerminadas = true;
            if (semi1 != null && !semi1.isJugado()) {
                semisTerminadas = false;
            }
            if (semi2 != null && !semi2.isJugado()) {
                semisTerminadas = false;
            }

            if (semisTerminadas) {
                granFinal = new Partido(ganadorSemi1, ganadorSemi2);
                faseActual = 1;
                System.out.println("\nFinal creada: " + ganadorSemi1.getNombre() + " vs " + ganadorSemi2.getNombre());
            }

            return true;
        }

        if (faseActual == 1) {
            if (granFinal == null) {
                System.out.println("No hay final creada.");
                return false;
            }
            if (granFinal.isJugado()) {
                System.out.println("La final ya esta jugada.");
                return false;
            }

            if (indiceSeleccion != 1) {
                indiceSeleccion = 1;
            }

            System.out.println("\n------------------------------------------");
            System.out.println("FINAL - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            campeonSupercopa = jugarPartidoUnico(granFinal, true);

            faseActual = 2;
            setTerminada(true);

            System.out.println("\n¡" + campeonSupercopa.getNombre().toUpperCase() + " ES EL CAMPEÓN!");
            System.out.println("------------------------------------------\n");

            return true;
        }

        return false;
    }

    @Override
    public void mostrarUltimosResultados() {

        System.out.println("\n==========================================");
        System.out.println("RESULTADOS: " + getNombre().toUpperCase());
        System.out.println("==========================================");

        if (semi1 != null && semi1.isJugado()) {
            System.out.println(" - Semifinal 1: " + semi1);
        }
        if (semi2 != null && semi2.isJugado()) {
            System.out.println(" - Semifinal 2: " + semi2);
        }
        if (granFinal != null && granFinal.isJugado()) {
            System.out.println(" - Final:       " + granFinal);
        }

        System.out.println("==========================================\n");
    }

    @Override
    public boolean haTerminado() {
        return isTerminada();
    }

    @Override
    public Club[] getGanadoresUltimaJornada() {

        Club[] ganadores = new Club[2];
        ganadores[0] = null;
        ganadores[1] = null;

        if (faseActual == 0) {
            return ganadores;
        }

        if (ganadorSemi1 != null) {
            ganadores[0] = ganadorSemi1;
        }
        if (ganadorSemi2 != null) {
            ganadores[1] = ganadorSemi2;
        }

        if (faseActual >= 2 && campeonSupercopa != null) {
            ganadores[0] = campeonSupercopa;
            ganadores[1] = null;
        }

        return ganadores;
    }

    public Club getCampeon() {
        return campeonSupercopa;
    }

    private Club jugarPartidoUnico(Partido p, boolean directo) {

        if (p == null) {
            return null;
        }

        p.simular(directo);

        int gL = p.getGolesDelLocal();
        int gV = p.getGolesDelVisitante();

        if (gL > gV) {
            return p.getEquipoLocal();
        }
        if (gV > gL) {
            return p.getEquipoVisitante();
        }

        System.out.print("Empate (" + gL + "-" + gV + "). Penaltis... ");

        if (rnd.nextBoolean()) {
            System.out.println("Pasa " + p.getEquipoLocal().getNombre());
            return p.getEquipoLocal();
        } else {
            System.out.println("Pasa " + p.getEquipoVisitante().getNombre());
            return p.getEquipoVisitante();
        }
    }
}
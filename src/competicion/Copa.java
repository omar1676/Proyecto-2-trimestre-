package competicion;

import clubes.Club;
import partido.Partido;
import java.util.Random;

public class Copa extends Competicion {

    private Club[] participantes;
    private int totalParticipantes;
    
    private Partido[] ronda1; // Previa
    private Partido[] ronda2; // 1/16
    private Partido[] ronda3; // 1/8
    private Partido[] ronda4; // 1/4
    private Partido[] semisIda;
    private Partido[] semisVuelta;
    private Partido granFinal;
    
    private Club[] ganadoresRonda1, exentosRonda1;
    private Club[] clasificadosRonda2, clasificadosRonda3, clasificadosRonda4, clasificadosRonda5;
    private Club[] finalistas;
    private Club campeonCopa;
    
    private int faseActual; // 0: Previa, 1: 1/16, 2: 1/8, 3: 1/4, 4: Semis Ida, 5: Semis Vuelta, 6: Final, 7: Fin
    private Random rnd;

    public Copa(String nombre, Club[] clubes) {
        super(nombre);
        this.rnd = new Random();
        this.faseActual = 0;

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
    }

    @Override
    public void generar() {
        if (isGenerada()) return;

        System.out.println("\n==========================================");
        System.out.println("GENERANDO COPA - " + totalParticipantes + " EQUIPOS");
        System.out.println("==========================================");

        mezclar(participantes);

        int potencia = 1;
        while (potencia * 2 <= totalParticipantes) potencia *= 2;
        
        int numPartidosPrevia = totalParticipantes - potencia;
        int numEquiposPrevia = numPartidosPrevia * 2;
        int numExentos = totalParticipantes - numEquiposPrevia;

        this.ronda1 = new Partido[numPartidosPrevia];
        this.ganadoresRonda1 = new Club[numPartidosPrevia];
        this.exentosRonda1 = new Club[numExentos];
        this.clasificadosRonda2 = new Club[potencia];

        for (int i = 0; i < numPartidosPrevia; i++) {
            ronda1[i] = new Partido(participantes[i*2], participantes[i*2 + 1]);
        }
        for (int i = 0; i < numExentos; i++) {
            exentosRonda1[i] = participantes[numEquiposPrevia + i];
        }

        setGenerada(true);
        System.out.println("Sorteo completado satisfactoriamente.");
    }

    public boolean simularRonda(Club seguido, boolean verEnDirectoSeguido) {
        if (!isGenerada()) generar();
        if (haTerminado()) return false;

        switch (faseActual) {
            case 0:
                simularFaseEliminatoria("RONDA PREVIA", ronda1, ganadoresRonda1, seguido, verEnDirectoSeguido);
                prepararSiguienteFase(1);
                faseActual = 1;
                break;
            case 1:
                simularFaseEliminatoria("DIECISEISAVOS DE FINAL", ronda2, clasificadosRonda3, seguido, verEnDirectoSeguido);
                prepararSiguienteFase(2);
                faseActual = 2;
                break;
            case 2:
                simularFaseEliminatoria("OCTAVOS DE FINAL", ronda3, clasificadosRonda4, seguido, verEnDirectoSeguido);
                prepararSiguienteFase(3);
                faseActual = 3;
                break;
            case 3:
                simularFaseEliminatoria("CUARTOS DE FINAL", ronda4, clasificadosRonda5, seguido, verEnDirectoSeguido);
                prepararSiguienteFase(4);
                faseActual = 4;
                break;
            case 4: // SEMIS IDA
                System.out.println("\n------------------------------------------");
                System.out.println("SEMIFINALES (IDA) - " + getNombre().toUpperCase());
                System.out.println("------------------------------------------");
                for (int i = 0; i < semisIda.length; i++) {
                    boolean ver = verEnDirectoSeguido && seguido != null && semisIda[i].participa(seguido);
                    semisIda[i].simular(ver);
                    System.out.println(" - " + semisIda[i]);
                }
                faseActual = 5;
                break;
            case 5: // SEMIS VUELTA
                System.out.println("\n------------------------------------------");
                System.out.println("SEMIFINALES (VUELTA) - " + getNombre().toUpperCase());
                System.out.println("------------------------------------------");
                finalistas = new Club[2];
                for (int i = 0; i < semisVuelta.length; i++) {
                    boolean ver = verEnDirectoSeguido && seguido != null && semisVuelta[i].participa(seguido);
                    semisVuelta[i].simular(ver);
                    
                    int gTotalL = semisIda[i].getGolesDelLocal() + semisVuelta[i].getGolesDelVisitante();
                    int gTotalV = semisIda[i].getGolesDelVisitante() + semisVuelta[i].getGolesDelLocal();
                    
                    System.out.print(" - " + semisVuelta[i] + " (Global: " + gTotalV + "-" + gTotalL + ") ");
                    
                    if (gTotalV > gTotalL) {
                        finalistas[i] = semisVuelta[i].getEquipoLocal();
                    } else if (gTotalL > gTotalV) {
                        finalistas[i] = semisVuelta[i].getEquipoVisitante();
                    } else {
                        System.out.print("¡Empate global! Penaltis... ");
                        finalistas[i] = rnd.nextBoolean() ? semisVuelta[i].getEquipoLocal() : semisVuelta[i].getEquipoVisitante();
                    }
                    System.out.println("-> Pasa " + finalistas[i].getNombre());
                }
                granFinal = new Partido(finalistas[0], finalistas[1]);
                faseActual = 6;
                break;
            case 6:
                System.out.println("\n------------------------------------------");
                System.out.println("¡LA GRAN FINAL DE COPA!");
                System.out.println("------------------------------------------");
                boolean verFinal = verEnDirectoSeguido || (seguido != null && granFinal.participa(seguido));
                campeonCopa = jugarPartidoUnico(granFinal, verFinal);
                System.out.println("\nRESULTADO FINAL: " + granFinal);
                setTerminada(true);
                faseActual = 7;
                System.out.println("\n🏆 ¡" + campeonCopa.getNombre().toUpperCase() + " CAMPEÓN DE COPA! 🏆");
                break;
        }
        return true;
    }

    private void simularFaseEliminatoria(String titulo, Partido[] partidos, Club[] ganadores, Club seguido, boolean directo) {
        System.out.println("\n------------------------------------------");
        System.out.println(titulo + " - " + getNombre().toUpperCase());
        System.out.println("------------------------------------------");
        
        for (int i = 0; i < partidos.length; i++) {
            boolean verEste = directo && (seguido != null && partidos[i].participa(seguido));
            ganadores[i] = jugarPartidoUnico(partidos[i], verEste);
        }
        
        System.out.println("\nRESULTADOS " + titulo + ":");
        for (Partido p : partidos) System.out.println(" - " + p);
    }

    private void prepararSiguienteFase(int fase) {
        if (fase == 1) {
            for (int i = 0; i < ganadoresRonda1.length; i++) clasificadosRonda2[i] = ganadoresRonda1[i];
            for (int i = 0; i < exentosRonda1.length; i++) clasificadosRonda2[ganadoresRonda1.length + i] = exentosRonda1[i];
            mezclar(clasificadosRonda2);
            ronda2 = new Partido[16];
            clasificadosRonda3 = new Club[16];
            for (int i = 0; i < 16; i++) ronda2[i] = new Partido(clasificadosRonda2[i*2], clasificadosRonda2[i*2 + 1]);
        } else if (fase == 2) {
            mezclar(clasificadosRonda3);
            ronda3 = new Partido[8];
            clasificadosRonda4 = new Club[8];
            for (int i = 0; i < 8; i++) ronda3[i] = new Partido(clasificadosRonda3[i*2], clasificadosRonda3[i*2 + 1]);
        } else if (fase == 3) {
            mezclar(clasificadosRonda4);
            ronda4 = new Partido[4];
            clasificadosRonda5 = new Club[4];
            for (int i = 0; i < 4; i++) ronda4[i] = new Partido(clasificadosRonda4[i*2], clasificadosRonda4[i*2 + 1]);
        } else if (fase == 4) {
            mezclar(clasificadosRonda5);
            semisIda = new Partido[2];
            semisVuelta = new Partido[2];
            for (int i = 0; i < 2; i++) {
                semisIda[i] = new Partido(clasificadosRonda5[i*2], clasificadosRonda5[i*2 + 1]);
                semisVuelta[i] = new Partido(clasificadosRonda5[i*2 + 1], clasificadosRonda5[i*2]);
            }
        }
    }

    private Club jugarPartidoUnico(Partido p, boolean directo) {
        p.simular(directo);
        int gL = p.getGolesDelLocal();
        int gV = p.getGolesDelVisitante();
        if (gL > gV) return p.getEquipoLocal();
        if (gV > gL) return p.getEquipoVisitante();
        System.out.print("Empate (" + gL + "-" + gV + "). Penaltis... ");
        Club g = rnd.nextBoolean() ? p.getEquipoLocal() : p.getEquipoVisitante();
        System.out.println("Gana " + g.getNombre());
        return g;
    }

    private void mezclar(Club[] lista) {
        if (lista == null) return;
        for (int i = lista.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Club tmp = lista[i];
            lista[i] = lista[j];
            lista[j] = tmp;
        }
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        return simularRonda(null, verEnDirecto);
    }

    @Override
    public void mostrarUltimosResultados() {
        System.out.println("\n==========================================");
        System.out.println("RESULTADOS COPA: " + getNombre().toUpperCase());
        System.out.println("==========================================");
        imprimirPartidos("Previa", ronda1);
        imprimirPartidos("1/16", ronda2);
        imprimirPartidos("1/8", ronda3);
        imprimirPartidos("1/4", ronda4);
        imprimirPartidos("Semis Ida", semisIda);
        imprimirPartidos("Semis Vuelta", semisVuelta);
        if (granFinal != null && granFinal.isYaJugado()) System.out.println("FINAL: " + granFinal);
        System.out.println("==========================================\n");
    }

    private void imprimirPartidos(String fase, Partido[] lista) {
        if (lista == null || lista.length == 0 || lista[0] == null || !lista[0].isYaJugado()) return;
        System.out.println("--- " + fase + " ---");
        for (Partido p : lista) System.out.println(" " + p);
    }

    public Club getCampeon() { return campeonCopa; }
    public Club getSubcampeon() { 
        if (finalistas == null || finalistas.length < 2) return null;
        return (finalistas[0] == campeonCopa) ? finalistas[1] : finalistas[0];
    }
    
    public boolean sigueVivo(Club c) {
        if (c == null) return false;
        if (haTerminado()) return c == campeonCopa;

        switch (faseActual) {
            case 0: return true;
            case 1: 
                for (Club g : ganadoresRonda1) if (g == c) return true;
                for (Club e : exentosRonda1) if (e == c) return true;
                return false;
            case 2:
                for (Club g : clasificadosRonda3) if (g == c) return true;
                return false;
            case 3:
                for (Club g : clasificadosRonda4) if (g == c) return true;
                return false;
            case 4:
                for (Club g : clasificadosRonda5) if (g == c) return true;
                return false;
            case 5:
                for (Club g : clasificadosRonda5) if (g == c) return true;
                return false;
            case 6:
                for (Club g : finalistas) if (g == c) return true;
                return false;
            default: return false;
        }
    }
}

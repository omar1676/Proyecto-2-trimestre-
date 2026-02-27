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

        setGenerada(true);
        setTerminada(false);
        
        System.out.println("Cuadro definido satisfactoriamente.");
        System.out.println("------------------------------------------");
    }

    public boolean simularRonda(Club seguido, boolean verEnDirectoSeguido) {
        if (!isGenerada()) generar();

        if (haTerminado()) {
            System.out.println("La competición ya ha finalizado.");
            return false;
        }

        if (faseActual == 0) {
            System.out.println("\n------------------------------------------");
            System.out.println("SEMIFINALES - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            boolean verS1 = verEnDirectoSeguido && (seguido != null && semi1.participa(seguido));
            boolean verS2 = verEnDirectoSeguido && (seguido != null && semi2.participa(seguido));

            this.ganadorSemi1 = jugarPartidoUnico(semi1, verS1);
            this.ganadorSemi2 = jugarPartidoUnico(semi2, verS2);
            
            System.out.println("\nRESULTADOS SEMIFINALES:");
            System.out.println(" - " + semi1);
            System.out.println(" - " + semi2);

            this.granFinal = new Partido(ganadorSemi1, ganadorSemi2);
            this.faseActual = 1;

            System.out.println("\nFinalistas: " + ganadorSemi1.getNombre() + " y " + ganadorSemi2.getNombre());
            return true;

        } else if (faseActual == 1) {
            System.out.println("\n------------------------------------------");
            System.out.println("GRAN FINAL - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            boolean verF = verEnDirectoSeguido && (seguido != null && granFinal.participa(seguido));
            this.campeonSupercopa = jugarPartidoUnico(granFinal, verF);
            
            System.out.println("\nRESULTADO FINAL:");
            System.out.println(" - " + granFinal);
            
            this.faseActual = 2;
            setTerminada(true);

            System.out.println("\n🏆 ¡" + campeonSupercopa.getNombre().toUpperCase() + " ES EL CAMPEÓN! 🏆");
            System.out.println("------------------------------------------\n");
            return true;
        }

        return false;
    }

    @Override
    public boolean simularRonda(boolean verEnDirecto) {
        return simularRonda(null, verEnDirecto);
    }

    public boolean sigueVivo(Club c) {
        if (c == null) return false;
        if (haTerminado()) return c == campeonSupercopa;

        if (faseActual == 0) return true; // No han jugado semis
        if (faseActual == 1) { // Ya jugaron semis, comprobar si ganó
            return (c == ganadorSemi1 || c == ganadorSemi2);
        }
        return false;
    }

    private Club jugarPartidoUnico(Partido p, boolean directo) {
        p.simular(directo);
        
        int gL = p.getGolesDelLocal();
        int gV = p.getGolesDelVisitante();

        if (gL > gV) {
            return p.getEquipoLocal();
        } else if (gV > gL) {
            return p.getEquipoVisitante();
        } else {
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

    @Override
    public void mostrarUltimosResultados() {
        System.out.println("\n==========================================");
        System.out.println("RESULTADOS: " + getNombre().toUpperCase());
        System.out.println("==========================================");

        if (semi1 != null && semi1.isYaJugado()) System.out.println(" - Semi 1: " + semi1);
        if (semi2 != null && semi2.isYaJugado()) System.out.println(" - Semi 2: " + semi2);
        if (granFinal != null && granFinal.isYaJugado()) System.out.println(" - FINAL:  " + granFinal);
        
        System.out.println("==========================================\n");
    }
}

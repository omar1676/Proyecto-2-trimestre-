package partido;

import clubes.Club;
import java.util.Random;

public class Partido {

    private Club equipoLocal;
    private Club equipoVisitante;

    private int golesDelLocal;
    private int golesDelVisitante;

    private boolean yaJugado;

    private String[] listaEventos;
    private int totalEventos;

    private Random rnd;

    public Partido(Club local, Club visitante) {
        this.rnd = new Random();

        if (!validarClubs(local, visitante)) {
            throw new IllegalArgumentException("Partido invalido: local/visitante null o iguales.");
        }

        this.equipoLocal = local;
        this.equipoVisitante = visitante;

        this.golesDelLocal = 0;
        this.golesDelVisitante = 0;
        this.yaJugado = false;

        this.listaEventos = new String[25];
        this.totalEventos = 0;
    }

    public void simular(boolean verEnDirecto) {
        if (yaJugado) return;

        golesDelLocal = 0;
        golesDelVisitante = 0;
        totalEventos = 0;

        if (verEnDirecto) {
            System.out.println("\n==========================================");
            System.out.println(equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());
            System.out.println("==========================================");
        }

        for (int minuto = 1; minuto <= 90; minuto++) {

            int tirada = rnd.nextInt(100);

            if (tirada < 6) {
                boolean marcaLocal = rnd.nextBoolean();

                if (marcaLocal) {
                    golesDelLocal++;
                    guardarEvento("GOL " + equipoLocal.getNombre() + " (" + minuto + "') -> " + toString());
                    if (verEnDirecto) System.out.println(minuto + "'  GOL " + equipoLocal.getNombre() + " -> " + golesDelLocal + "-" + golesDelVisitante);
                } else {
                    golesDelVisitante++;
                    guardarEvento("GOL " + equipoVisitante.getNombre() + " (" + minuto + "') -> " + toString());
                    if (verEnDirecto) System.out.println(minuto + "'  GOL " + equipoVisitante.getNombre() + " -> " + golesDelLocal + "-" + golesDelVisitante);
                }

            } else if (tirada < 8) {
                boolean esParaLocal = rnd.nextBoolean();
                String equipo = esParaLocal ? equipoLocal.getNombre() : equipoVisitante.getNombre();

                guardarEvento("Penalti para " + equipo + " (" + minuto + "')");
                if (verEnDirecto) System.out.println(minuto + "'  Penalti para " + equipo);

                boolean marca = rnd.nextInt(100) < 75;
                if (marca) {
                    if (esParaLocal) golesDelLocal++;
                    else golesDelVisitante++;

                    guardarEvento("Penalti GOL " + equipo + " (" + minuto + "') -> " + toString());
                    if (verEnDirecto) System.out.println(minuto + "'  Penalti GOL -> " + golesDelLocal + "-" + golesDelVisitante);
                } else {
                    guardarEvento("Penalti fallado por " + equipo + " (" + minuto + "')");
                    if (verEnDirecto) System.out.println(minuto + "'  Penalti fallado");
                }

            } else if (tirada < 12) {
                boolean aLocal = rnd.nextBoolean();
                String equipo = aLocal ? equipoLocal.getNombre() : equipoVisitante.getNombre();

                boolean esRoja = rnd.nextInt(100) < 10;
                if (esRoja) {
                    guardarEvento("Roja para " + equipo + " (" + minuto + "')");
                    if (verEnDirecto) System.out.println(minuto + "'  Roja para " + equipo);
                } else {
                    guardarEvento("Amarilla para " + equipo + " (" + minuto + "')");
                    if (verEnDirecto) System.out.println(minuto + "'  Amarilla para " + equipo);
                }
            }
        }

        yaJugado = true;

        if (verEnDirecto) {
            System.out.println("\nFINAL");
            System.out.println(toString());
            System.out.println("==========================================\n");
        }
    }

    private void guardarEvento(String texto) {
        if (texto == null) return;
        if (totalEventos >= listaEventos.length) return;

        listaEventos[totalEventos] = texto;
        totalEventos++;
    }

    public static boolean validarClubs(Club local, Club visitante) {
        return local != null && visitante != null && local != visitante;
    }

    public Club getEquipoLocal() {
        return equipoLocal;
    }

    public Club getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesDelLocal() {
        return golesDelLocal;
    }

    public int getGolesDelVisitante() {
        return golesDelVisitante;
    }

    public boolean isYaJugado() {
        return yaJugado;
    }

    public boolean participa(Club club) {
        if (club == null) return false;

        if (equipoLocal == club || equipoVisitante == club) return true;

        String nombre = club.getNombre();
        if (nombre == null) return false;

        return (equipoLocal != null && nombre.equalsIgnoreCase(equipoLocal.getNombre()))
                || (equipoVisitante != null && nombre.equalsIgnoreCase(equipoVisitante.getNombre()));
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();
    }
}
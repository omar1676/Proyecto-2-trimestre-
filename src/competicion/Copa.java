package competicion;

import clubes.Club;
import partido.Partido;

import java.util.Random;

public class Copa extends Competicion {

    private Club[] participantes;
    private int totalParticipantes;

    private Partido[] ronda1;
    private Partido[] ronda2;
    private Partido[] ronda3;
    private Partido[] ronda4;
    private Partido[] semisIda;
    private Partido[] semisVuelta;
    private Partido granFinal;

    private Club[] ganadoresRonda1;
    private Club[] exentosRonda1;

    private Club[] clasificadosRonda2;
    private Club[] clasificadosRonda3;
    private Club[] clasificadosRonda4;
    private Club[] clasificadosRonda5;

    private Club[] finalistas;
    private Club campeonCopa;

    private int faseActual;
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
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("GENERANDO COPA - " + totalParticipantes + " EQUIPOS");
        System.out.println("==========================================");

        mezclar(participantes);

        int potencia = 1;
        while (potencia * 2 <= totalParticipantes) {
            potencia *= 2;
        }

        int numPartidosPrevia = totalParticipantes - potencia;
        int numEquiposPrevia = numPartidosPrevia * 2;
        int numExentos = totalParticipantes - numEquiposPrevia;

        this.ronda1 = new Partido[numPartidosPrevia];
        this.ganadoresRonda1 = new Club[numPartidosPrevia];
        this.exentosRonda1 = new Club[numExentos];
        this.clasificadosRonda2 = new Club[potencia];

        int i = 0;
        while (i < numPartidosPrevia) {
            ronda1[i] = new Partido(participantes[i * 2], participantes[i * 2 + 1]);
            ganadoresRonda1[i] = null;
            i++;
        }

        i = 0;
        while (i < numExentos) {
            exentosRonda1[i] = participantes[numEquiposPrevia + i];
            i++;
        }

        ronda2 = null;
        ronda3 = null;
        ronda4 = null;
        semisIda = null;
        semisVuelta = null;
        granFinal = null;

        clasificadosRonda3 = null;
        clasificadosRonda4 = null;
        clasificadosRonda5 = null;

        finalistas = null;
        campeonCopa = null;

        faseActual = 0;

        setGenerada(true);
        setTerminada(false);

        System.out.println("Sorteo completado satisfactoriamente.");
        System.out.println("------------------------------------------");
    }

    public boolean simularRonda(Club seguido, boolean verEnDirectoSeguido) {

        if (!isGenerada()) {
            generar();
        }
        if (haTerminado()) {
            return false;
        }

        if (faseActual == 0) {
            simularFaseEliminatoria("RONDA PREVIA", ronda1, ganadoresRonda1, seguido, verEnDirectoSeguido);
            prepararSiguienteFase(1);
            faseActual = 1;
            return true;
        }

        if (faseActual == 1) {
            simularFaseEliminatoria("DIECISEISAVOS DE FINAL", ronda2, clasificadosRonda3, seguido, verEnDirectoSeguido);
            prepararSiguienteFase(2);
            faseActual = 2;
            return true;
        }

        if (faseActual == 2) {
            simularFaseEliminatoria("OCTAVOS DE FINAL", ronda3, clasificadosRonda4, seguido, verEnDirectoSeguido);
            prepararSiguienteFase(3);
            faseActual = 3;
            return true;
        }

        if (faseActual == 3) {
            simularFaseEliminatoria("CUARTOS DE FINAL", ronda4, clasificadosRonda5, seguido, verEnDirectoSeguido);
            prepararSiguienteFase(4);
            faseActual = 4;
            return true;
        }

        if (faseActual == 4) {

            System.out.println("\n------------------------------------------");
            System.out.println("SEMIFINALES (IDA) - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            int i = 0;
            while (i < semisIda.length) {
                boolean ver = false;
                if (verEnDirectoSeguido && seguido != null && semisIda[i] != null && semisIda[i].participa(seguido)) {
                    ver = true;
                }

                semisIda[i].simular(ver);
                System.out.println(" - " + semisIda[i]);
                i++;
            }

            faseActual = 5;
            return true;
        }

        if (faseActual == 5) {

            System.out.println("\n------------------------------------------");
            System.out.println("SEMIFINALES (VUELTA) - " + getNombre().toUpperCase());
            System.out.println("------------------------------------------");

            finalistas = new Club[2];

            int i = 0;
            while (i < semisVuelta.length) {
                boolean ver = false;
                if (verEnDirectoSeguido && seguido != null && semisVuelta[i] != null && semisVuelta[i].participa(seguido)) {
                    ver = true;
                }

                semisVuelta[i].simular(ver);

                int gTotalLocal = semisIda[i].getGolesDelLocal() + semisVuelta[i].getGolesDelVisitante();
                int gTotalVisi = semisIda[i].getGolesDelVisitante() + semisVuelta[i].getGolesDelLocal();

                System.out.print(" - " + semisVuelta[i] + " (Global: " + gTotalVisi + "-" + gTotalLocal + ") ");

                if (gTotalVisi > gTotalLocal) {
                    finalistas[i] = semisVuelta[i].getEquipoLocal();
                } else if (gTotalLocal > gTotalVisi) {
                    finalistas[i] = semisVuelta[i].getEquipoVisitante();
                } else {
                    System.out.print("Empate global. Penaltis... ");
                    if (rnd.nextBoolean()) {
                        finalistas[i] = semisVuelta[i].getEquipoLocal();
                    } else {
                        finalistas[i] = semisVuelta[i].getEquipoVisitante();
                    }
                }

                System.out.println("-> Pasa " + finalistas[i].getNombre());
                i++;
            }

            granFinal = new Partido(finalistas[0], finalistas[1]);
            faseActual = 6;
            return true;
        }

        if (faseActual == 6) {

            System.out.println("\n------------------------------------------");
            System.out.println("¡LA GRAN FINAL DE COPA!");
            System.out.println("------------------------------------------");

            boolean verFinal = false;
            if (verEnDirectoSeguido) {
                verFinal = true;
            }
            if (!verFinal && seguido != null && granFinal != null && granFinal.participa(seguido)) {
                verFinal = true;
            }

            campeonCopa = jugarPartidoUnico(granFinal, verFinal);

            System.out.println("\nRESULTADO FINAL: " + granFinal);

            setTerminada(true);
            faseActual = 7;

            System.out.println("\n¡" + campeonCopa.getNombre().toUpperCase() + " CAMPEÓN DE COPA!");
            System.out.println("------------------------------------------");
            return true;
        }

        return false;
    }

    private void simularFaseEliminatoria(String titulo, Partido[] partidos, Club[] ganadores, Club seguido, boolean directo) {

        System.out.println("\n------------------------------------------");
        System.out.println(titulo + " - " + getNombre().toUpperCase());
        System.out.println("------------------------------------------");

        int i = 0;
        while (i < partidos.length) {
            boolean verEste = false;
            if (directo && seguido != null && partidos[i] != null && partidos[i].participa(seguido)) {
                verEste = true;
            }

            ganadores[i] = jugarPartidoUnico(partidos[i], verEste);
            i++;
        }

        System.out.println("\nRESULTADOS " + titulo + ":");
        i = 0;
        while (i < partidos.length) {
            System.out.println(" - " + partidos[i]);
            i++;
        }
    }

    private void prepararSiguienteFase(int fase) {

        if (fase == 1) {

            int i = 0;
            while (i < ganadoresRonda1.length) {
                clasificadosRonda2[i] = ganadoresRonda1[i];
                i++;
            }

            i = 0;
            while (i < exentosRonda1.length) {
                clasificadosRonda2[ganadoresRonda1.length + i] = exentosRonda1[i];
                i++;
            }

            mezclar(clasificadosRonda2);

            ronda2 = new Partido[16];
            clasificadosRonda3 = new Club[16];

            i = 0;
            while (i < 16) {
                ronda2[i] = new Partido(clasificadosRonda2[i * 2], clasificadosRonda2[i * 2 + 1]);
                clasificadosRonda3[i] = null;
                i++;
            }

        } else if (fase == 2) {

            mezclar(clasificadosRonda3);

            ronda3 = new Partido[8];
            clasificadosRonda4 = new Club[8];

            int i = 0;
            while (i < 8) {
                ronda3[i] = new Partido(clasificadosRonda3[i * 2], clasificadosRonda3[i * 2 + 1]);
                clasificadosRonda4[i] = null;
                i++;
            }

        } else if (fase == 3) {

            mezclar(clasificadosRonda4);

            ronda4 = new Partido[4];
            clasificadosRonda5 = new Club[4];

            int i = 0;
            while (i < 4) {
                ronda4[i] = new Partido(clasificadosRonda4[i * 2], clasificadosRonda4[i * 2 + 1]);
                clasificadosRonda5[i] = null;
                i++;
            }

        } else if (fase == 4) {

            mezclar(clasificadosRonda5);

            semisIda = new Partido[2];
            semisVuelta = new Partido[2];

            int i = 0;
            while (i < 2) {
                semisIda[i] = new Partido(clasificadosRonda5[i * 2], clasificadosRonda5[i * 2 + 1]);
                semisVuelta[i] = new Partido(clasificadosRonda5[i * 2 + 1], clasificadosRonda5[i * 2]);
                i++;
            }
        }
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

        Club g;
        if (rnd.nextBoolean()) {
            g = p.getEquipoLocal();
        } else {
            g = p.getEquipoVisitante();
        }

        System.out.println("Gana " + g.getNombre());
        return g;
    }

    private void mezclar(Club[] lista) {
        if (lista == null) {
            return;
        }

        int i = lista.length - 1;
        while (i > 0) {
            int j = rnd.nextInt(i + 1);

            Club tmp = lista[i];
            lista[i] = lista[j];
            lista[j] = tmp;

            i--;
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

        if (granFinal != null && granFinal.isJugado()) {
            System.out.println("FINAL: " + granFinal);
        }

        System.out.println("==========================================\n");
    }

    public void mostrarEstadoCopa() {

        if (!isGenerada()) {
            System.out.println("Primero genera la copa.");
            return;
        }

        System.out.println("\n==========================================");
        System.out.println("COPA: " + getNombre().toUpperCase());
        System.out.println("FASE: " + nombreFaseActual());
        System.out.println("==========================================");

        imprimirEstadoFase("RONDA PREVIA", ronda1);
        imprimirEstadoFase("DIECISEISAVOS", ronda2);
        imprimirEstadoFase("OCTAVOS", ronda3);
        imprimirEstadoFase("CUARTOS", ronda4);
        imprimirEstadoFase("SEMIS (IDA)", semisIda);
        imprimirEstadoFase("SEMIS (VUELTA)", semisVuelta);

        if (granFinal != null) {
            System.out.println("\n--- FINAL ---");
            System.out.println(" - " + textoPartido(granFinal));
        }

        System.out.println("==========================================\n");
    }

    private void imprimirEstadoFase(String fase, Partido[] lista) {
        if (lista == null || lista.length == 0) {
            return;
        }

        System.out.println("\n--- " + fase + " ---");

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println(" - " + textoPartido(lista[i]));
            }
        }
    }

    private String textoPartido(Partido p) {
        if (p == null) {
            return "(sin partido)";
        }

        String local = "?";
        String visi = "?";

        if (p.getEquipoLocal() != null) {
            local = p.getEquipoLocal().getNombre();
        }
        if (p.getEquipoVisitante() != null) {
            visi = p.getEquipoVisitante().getNombre();
        }

        if (p.isJugado()) {
            return local + " " + p.getGolesDelLocal() + " - " + p.getGolesDelVisitante() + " " + visi;
        }

        return local + " vs " + visi + " (pendiente)";
    }

    private String nombreFaseActual() {
        if (faseActual == 0) {
            return "RONDA PREVIA";
        }
        if (faseActual == 1) {
            return "DIECISEISAVOS";
        }
        if (faseActual == 2) {
            return "OCTAVOS";
        }
        if (faseActual == 3) {
            return "CUARTOS";
        }
        if (faseActual == 4) {
            return "SEMIS (IDA)";
        }
        if (faseActual == 5) {
            return "SEMIS (VUELTA)";
        }
        if (faseActual == 6) {
            return "FINAL";
        }
        return "TERMINADA";
    }

    private void imprimirPartidos(String fase, Partido[] lista) {

        if (lista == null) {
            return;
        }
        if (lista.length == 0) {
            return;
        }
        if (lista[0] == null) {
            return;
        }
        if (!lista[0].isJugado()) {
            return;
        }

        System.out.println("--- " + fase + " ---");

        int i = 0;
        while (i < lista.length) {
            System.out.println(" " + lista[i]);
            i++;
        }
    }

    @Override
    public boolean haTerminado() {
        return isTerminada();
    }

    @Override
    public Club[] getGanadoresUltimaJornada() {

        if (faseActual == 0) {
            return new Club[0];
        }

        if (faseActual == 1) {
            return copiarArray(ganadoresRonda1);
        }
        if (faseActual == 2) {
            return copiarArray(clasificadosRonda3);
        }
        if (faseActual == 3) {
            return copiarArray(clasificadosRonda4);
        }
        if (faseActual == 4) {
            return copiarArray(clasificadosRonda5);
        }

        if (faseActual == 5) {
            return copiarArray(clasificadosRonda5);
        }

        if (faseActual == 6) {
            return copiarArray(finalistas);
        }

        if (faseActual >= 7) {
            Club[] uno = new Club[1];
            uno[0] = campeonCopa;
            return uno;
        }

        return new Club[0];
    }

    private Club[] copiarArray(Club[] a) {
        if (a == null) {
            return new Club[0];
        }

        Club[] res = new Club[a.length];
        int i = 0;
        while (i < a.length) {
            res[i] = a[i];
            i++;
        }
        return res;
    }

    public Club getCampeon() {
        return campeonCopa;
    }

    public Club getSubcampeon() {

        if (finalistas == null) {
            return null;
        }
        if (finalistas.length < 2) {
            return null;
        }

        if (campeonCopa == null) {
            return null;
        }

        if (finalistas[0] == campeonCopa) {
            return finalistas[1];
        }
        return finalistas[0];
    }

    public boolean sigueVivo(Club c) {

        if (c == null) {
            return false;
        }
        if (haTerminado()) {
            return c == campeonCopa;
        }

        if (faseActual == 0) {
            return true;
        }

        if (faseActual == 1) {
            int i = 0;
            while (i < ganadoresRonda1.length) {
                if (ganadoresRonda1[i] == c) {
                    return true;
                }
                i++;
            }
            i = 0;
            while (i < exentosRonda1.length) {
                if (exentosRonda1[i] == c) {
                    return true;
                }
                i++;
            }
            return false;
        }

        if (faseActual == 2) {
            int i = 0;
            while (i < clasificadosRonda3.length) {
                if (clasificadosRonda3[i] == c) {
                    return true;
                }
                i++;
            }
            return false;
        }

        if (faseActual == 3) {
            int i = 0;
            while (i < clasificadosRonda4.length) {
                if (clasificadosRonda4[i] == c) {
                    return true;
                }
                i++;
            }
            return false;
        }

        if (faseActual == 4 || faseActual == 5) {
            int i = 0;
            while (i < clasificadosRonda5.length) {
                if (clasificadosRonda5[i] == c) {
                    return true;
                }
                i++;
            }
            return false;
        }

        if (faseActual == 6) {
            int i = 0;
            while (i < finalistas.length) {
                if (finalistas[i] == c) {
                    return true;
                }
                i++;
            }
            return false;
        }

        return false;
    }

    public String[] listarPartidosDisponibles() {
        if (!isGenerada()) {
            generar();
        }
        if (haTerminado()) {
            return new String[0];
        }

        Partido[] lista = listaPartidosFaseActual();
        if (lista == null || lista.length == 0) {
            return new String[0];
        }

        int total = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && !lista[i].isJugado()) {
                total++;
            }
        }

        if (total == 0) {
            return new String[0];
        }

        String[] lineas = new String[total];
        int pos = 0;
        int num = 1;

        for (int i = 0; i < lista.length; i++) {
            Partido p = lista[i];
            if (p == null) {
                continue;
            }
            if (p.isJugado()) {
                continue;
            }

            String local = "?";
            String visi = "?";

            if (p.getEquipoLocal() != null) {
                local = p.getEquipoLocal().getNombre();
            }
            if (p.getEquipoVisitante() != null) {
                visi = p.getEquipoVisitante().getNombre();
            }

            lineas[pos] = num + ") " + nombreFaseActual() + " - " + local + " vs " + visi;
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
            System.out.println("La copa ya termino.");
            return false;
        }

        Partido[] lista = listaPartidosFaseActual();
        if (lista == null || lista.length == 0) {
            System.out.println("No hay partidos en esta fase.");
            return false;
        }

        int[] indices = new int[lista.length];
        int total = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && !lista[i].isJugado()) {
                indices[total] = i;
                total++;
            }
        }

        if (total == 0) {
            System.out.println("No hay partidos disponibles en esta fase.");
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

        if (elegido == null) {
            return false;
        }

        System.out.println("\n------------------------------------------");
        System.out.println(nombreFaseActual() + " - " + getNombre().toUpperCase());
        System.out.println("------------------------------------------");

        Club ganador = jugarPartidoUnico(elegido, true);

        guardarGanadorFaseActual(idxReal, ganador);

        System.out.println("\nRESULTADO: " + elegido);

        if (faseTerminada(lista)) {
            avanzarFaseSiToca();
        }

        return true;
    }

    private Partido[] listaPartidosFaseActual() {
        if (faseActual == 0) {
            return ronda1;
        }
        if (faseActual == 1) {
            return ronda2;
        }
        if (faseActual == 2) {
            return ronda3;
        }
        if (faseActual == 3) {
            return ronda4;
        }
        if (faseActual == 4) {
            return semisIda;
        }
        if (faseActual == 5) {
            return semisVuelta;
        }

        Partido[] uno = new Partido[1];
        uno[0] = granFinal;

        if (faseActual == 6) {
            return uno;
        }

        return new Partido[0];
    }

    private void guardarGanadorFaseActual(int idxReal, Club ganador) {
        if (ganador == null) {
            return;
        }

        if (faseActual == 0) {
            if (ganadoresRonda1 != null && idxReal >= 0 && idxReal < ganadoresRonda1.length) {
                ganadoresRonda1[idxReal] = ganador;
            }
            return;
        }

        if (faseActual == 1) {
            if (clasificadosRonda3 != null && idxReal >= 0 && idxReal < clasificadosRonda3.length) {
                clasificadosRonda3[idxReal] = ganador;
            }
            return;
        }

        if (faseActual == 2) {
            if (clasificadosRonda4 != null && idxReal >= 0 && idxReal < clasificadosRonda4.length) {
                clasificadosRonda4[idxReal] = ganador;
            }
            return;
        }

        if (faseActual == 3) {
            if (clasificadosRonda5 != null && idxReal >= 0 && idxReal < clasificadosRonda5.length) {
                clasificadosRonda5[idxReal] = ganador;
            }
            return;
        }

        if (faseActual == 6) {
            campeonCopa = ganador;
        }
    }

    private boolean faseTerminada(Partido[] lista) {
        if (lista == null || lista.length == 0) {
            return true;
        }

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && !lista[i].isJugado()) {
                return false;
            }
        }

        return true;
    }

    private void avanzarFaseSiToca() {

        if (faseActual == 0) {
            prepararSiguienteFase(1);
            faseActual = 1;
            return;
        }

        if (faseActual == 1) {
            prepararSiguienteFase(2);
            faseActual = 2;
            return;
        }

        if (faseActual == 2) {
            prepararSiguienteFase(3);
            faseActual = 3;
            return;
        }

        if (faseActual == 3) {
            prepararSiguienteFase(4);
            faseActual = 4;
            return;
        }

        if (faseActual == 4) {
            faseActual = 5;
            return;
        }

        if (faseActual == 5) {

            finalistas = new Club[2];

            int i = 0;
            while (i < semisVuelta.length) {
                int gTotalLocal = semisIda[i].getGolesDelLocal() + semisVuelta[i].getGolesDelVisitante();
                int gTotalVisi = semisIda[i].getGolesDelVisitante() + semisVuelta[i].getGolesDelLocal();

                if (gTotalVisi > gTotalLocal) {
                    finalistas[i] = semisVuelta[i].getEquipoLocal();
                } else if (gTotalLocal > gTotalVisi) {
                    finalistas[i] = semisVuelta[i].getEquipoVisitante();
                } else {
                    if (rnd.nextBoolean()) {
                        finalistas[i] = semisVuelta[i].getEquipoLocal();
                    } else {
                        finalistas[i] = semisVuelta[i].getEquipoVisitante();
                    }
                }
                i++;
            }

            granFinal = new Partido(finalistas[0], finalistas[1]);
            faseActual = 6;
            return;
        }

        if (faseActual == 6) {
            setTerminada(true);
            faseActual = 7;
        }
    }
}
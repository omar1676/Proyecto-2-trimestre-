package partido;

import clubes.Club;
import extra.Utilidades;
import jugadores.Jugador;
import jugadores.Posicion;

import java.util.Random;

public class Partido {

    private Club equipoLocal;
    private Club equipoVisitante;

    private int golesDelLocal;
    private int golesDelVisitante;

    private boolean jugado;

    private Random rnd;

    public Partido(Club local, Club visitante) {
        this.rnd = new Random();
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesDelLocal = 0;
        this.golesDelVisitante = 0;
        this.jugado = false;
    }

    public Club getEquipoLocal() { return equipoLocal; }
    public Club getEquipoVisitante() { return equipoVisitante; }

    public int getGolesDelLocal() { return golesDelLocal; }
    public int getGolesDelVisitante() { return golesDelVisitante; }

    public boolean isJugado() {
        return jugado;
    }

    public boolean participa(Club c) {
        if (c == null) return false;
        return c == equipoLocal || c == equipoVisitante;
    }

    public void simular(boolean verEnDirecto) {
        if (jugado) {
            return;
        }

        if (!verEnDirecto) {
            simularRapidoConProbabilidad();
            jugado = true;
            return;
        }

        simularEnDirectoConMinutos();
        jugado = true;
    }

    private void imprimirMarcadorColor() {
        String marcador = equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();

        if (golesDelLocal > golesDelVisitante) {
            Utilidades.escribirLineaLentaColor(Utilidades.VERDE, marcador);
        } else if (golesDelLocal < golesDelVisitante) {
            Utilidades.escribirLineaLentaColor(Utilidades.ROJO, marcador);
        } else {
            Utilidades.escribirLineaLentaColor(Utilidades.AMAR, marcador);
        }
    }

    private int golesRealistas(Random r, boolean esLocal) {
        int x = r.nextInt(100);

        int g;
        if (x < 28) g = 0;
        else if (x < 62) g = 1;
        else if (x < 82) g = 2;
        else if (x < 92) g = 3;
        else if (x < 97) g = 4;
        else if (x < 99) g = 5;
        else g = 6;

        if (esLocal && r.nextInt(100) < 10 && g < 6) g++;

        return g;
    }    private void simularRapidoConProbabilidad() {
        double lambdaLocal = calcularMediaGoles(equipoLocal, equipoVisitante, true);
        double lambdaVisit = calcularMediaGoles(equipoVisitante, equipoLocal, false);

        golesDelLocal = muestrearPoisson(lambdaLocal);
        golesDelVisitante = muestrearPoisson(lambdaVisit);


        for (int i = 0; i < golesDelLocal; i++) {
            Jugador goleador = elegirGoleador(equipoLocal);
            Jugador asistente = elegirAsistente(equipoLocal, goleador);

            if (goleador != null) {
                goleador.setGoles(goleador.getGoles() + 1);
            }
            if (asistente != null) {
                asistente.setAsistencias(asistente.getAsistencias() + 1);
            }
        }

        for (int i = 0; i < golesDelVisitante; i++) {
            Jugador goleador = elegirGoleador(equipoVisitante);
            Jugador asistente = elegirAsistente(equipoVisitante, goleador);

            if (goleador != null) {
                goleador.setGoles(goleador.getGoles() + 1);
            }
            if (asistente != null) {
                asistente.setAsistencias(asistente.getAsistencias() + 1);
            }
        }

        aplicarTarjetas(equipoLocal, false);
        aplicarTarjetas(equipoVisitante, false);

        actualizarPorteriasACero();
    }

    private void simularEnDirectoConMinutos() {
        Utilidades.escribirLineaLentaColor(Utilidades.CIAN, "");
        Utilidades.escribirLineaLentaColor(Utilidades.CIAN, equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());
        Utilidades.escribirLineaLenta("Suena el pitido inicial... vamos alla.");

        double lambdaLocal = calcularMediaGoles(equipoLocal, equipoVisitante, true);
        double lambdaVisit = calcularMediaGoles(equipoVisitante, equipoLocal, false);

        double pGolLocalBase = lambdaLocal / 90.0;
        double pGolVisitBase = lambdaVisit / 90.0;

        for (int minuto = 1; minuto <= 45; minuto++) {
            tickMinuto(minuto, pGolLocalBase, pGolVisitBase);
        }

        Utilidades.escribirLineaLentaColor(Utilidades.GRIS, "Descanso. " + marcadorActual());
        Utilidades.dormir(500);

        aplicarTarjetas(equipoLocal, true);
        aplicarTarjetas(equipoVisitante, true);

        for (int minuto = 46; minuto <= 90; minuto++) {
            tickMinuto(minuto, pGolLocalBase, pGolVisitBase);
        }

        int descuento = 1 + rnd.nextInt(5);
        for (int i = 1; i <= descuento; i++) {
            int minuto = 90 + i;
            tickMinuto(minuto, pGolLocalBase * 1.10, pGolVisitBase * 1.10);
        }

        Utilidades.escribirLineaLentaColor(Utilidades.CIAN, "Final del partido. " + marcadorFinal());
        actualizarPorteriasACero();
    }

    private void tickMinuto(int minuto, double pGolLocalBase, double pGolVisitBase) {

        if (minuto % 5 == 0) {
            Utilidades.escribirLineaLentaColor(Utilidades.GRIS, "[" + minuto + "'] " + marcadorActual());
        }

        double factorMomento = 1.0;
        if (minuto <= 10) {
            factorMomento = 0.85;
        } else if (minuto >= 75) {
            factorMomento = 1.20;
        }

        double pLocal = pGolLocalBase * factorMomento;
        if (rnd.nextDouble() < pLocal) {
            registrarGol(equipoLocal, true, minuto);
        }

        double pVisit = pGolVisitBase * factorMomento;
        if (rnd.nextDouble() < pVisit) {
            registrarGol(equipoVisitante, false, minuto);
        }

        Utilidades.dormir(80);
    }

    private void registrarGol(Club equipo, boolean esLocal, int minuto) {
        Jugador goleador = elegirGoleador(equipo);
        Jugador asistente = elegirAsistente(equipo, goleador);

        if (esLocal) {
            golesDelLocal++;
        } else {
            golesDelVisitante++;
        }

        if (goleador != null) {
            goleador.setGoles(goleador.getGoles() + 1);
        }
        if (asistente != null) {
            asistente.setAsistencias(asistente.getAsistencias() + 1);
        }

        String nombreGoleador = nombreJugador(goleador);

        Utilidades.escribirLineaLentaColor(Utilidades.VERDE,
                "[" + minuto + "'] GOL de " + equipo.getNombre() + " -> " + nombreGoleador);

        if (asistente != null) {
            Utilidades.escribirLineaLentaColor(Utilidades.GRIS, "   Asistencia: " + asistente.getNombre());
        }

        Utilidades.escribirLineaLentaColor(Utilidades.CIAN, "   " + marcadorActual());
    }

    private String marcadorActual() {
        return equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();
    }

    private String marcadorFinal() {
        return equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();
    }

    private void actualizarPorteriasACero() {
        if (golesDelVisitante == 0) {
            Jugador porteroLocal = buscarPortero(equipoLocal);
            if (porteroLocal != null) {
                porteroLocal.setPorteriasCero(porteroLocal.getPorteriasCero() + 1);
            }
        }
        if (golesDelLocal == 0) {
            Jugador porteroVisit = buscarPortero(equipoVisitante);
            if (porteroVisit != null) {
                porteroVisit.setPorteriasCero(porteroVisit.getPorteriasCero() + 1);
            }
        }
    }

    private Jugador buscarPortero(Club club) {
        if (club == null) {
            return null;
        }

        int n = club.getNumPrimerEquipo();
        for (int i = 0; i < n; i++) {
            Jugador j = club.getJugadorPrimerEquipo(i);
            if (j != null && j.getPosicion() == Posicion.POR) {
                return j;
            }
        }

        int m = club.getNumCantera();
        for (int i = 0; i < m; i++) {
            Jugador j = club.getJugadorCantera(i);
            if (j != null && j.getPosicion() == Posicion.POR) {
                return j;
            }
        }

        return null;
    }

    private double calcularMediaGoles(Club equipo, Club rival, boolean esLocal) {
        int nivelEquipo = 50;
        int nivelRival = 50;

        if (equipo != null) {
            nivelEquipo = equipo.getNivel();
        }
        if (rival != null) {
            nivelRival = rival.getNivel();
        }

        int diferencia = nivelEquipo - nivelRival;

        double media = 1.15 + (diferencia * 0.015);

        if (esLocal) {
            media = media + 0.18;
        }

        if (media < 0.20) {
            media = 0.20;
        }
        if (media > 3.20) {
            media = 3.20;
        }

        return media;
    }

    private int muestrearPoisson(double lambda) {

        double l = Math.exp(-lambda);
        int k = 0;
        double p = 1.0;

        do {
            k++;
            p = p * rnd.nextDouble();
        } while (p > l);

        int goles = k - 1;

        if (goles > 6) {
            goles = 6;
        }
        if (goles < 0) {
            goles = 0;
        }
        return goles;
    }



    private int minutoGol() {
        int m = 1 + rnd.nextInt(90);
        if (rnd.nextInt(100) < 8) m = 90 + rnd.nextInt(6);
        return m;
    }

    private void aplicarTarjetas(Club equipo, boolean verEnDirecto) {
        int amarillas = rnd.nextInt(3);
        int rojas;
        if (rnd.nextInt(100) < 7) rojas = 1;
        else rojas = 0;

        for (int i = 0; i < amarillas; i++) {
            Jugador j = elegirJugadorDeCampo(equipo);
            if (j != null) {
                j.setAmarillas(j.getAmarillas() + 1);
                if (verEnDirecto && rnd.nextInt(100) < 40) {
                    Utilidades.escribirLineaLentaColor(Utilidades.AMAR, "Tarjeta amarilla para " + equipo.getNombre() + " - " + j.getNombre());
                }
            }
        }

        for (int i = 0; i < rojas; i++) {
            Jugador j = elegirJugadorDeCampo(equipo);
            if (j != null) {
                j.setRojas(j.getRojas() + 1);
                if (verEnDirecto) {
                    Utilidades.escribirLineaLentaColor(Utilidades.ROJO, "Tarjeta roja para " + equipo.getNombre() + " - " + j.getNombre());
                }
            }
        }
    }

    private void aplicarPorteriaCero(Club equipo, int golesRecibidos) {
        if (golesRecibidos != 0) return;
        Jugador por = elegirPortero(equipo);
        if (por != null) por.setPorteriasCero(por.getPorteriasCero() + 1);
    }

    private Jugador elegirPortero(Club club) {
        if (club == null) return null;
        for (int i = 0; i < club.getNumPrimerEquipo(); i++) {
            Jugador j = club.getJugadorPrimerEquipo(i);
            if (j != null && j.getPosicion() == Posicion.POR) return j;
        }
        return null;
    }

    private Jugador elegirGoleador(Club club) {
        Jugador j = elegirPorPosiciones(club, new Posicion[]{Posicion.DC, Posicion.EI, Posicion.ED, Posicion.MCO, Posicion.MC});
        if (j != null) return j;
        return elegirJugadorDeCampo(club);
    }

    private Jugador elegirAsistente(Club club, Jugador goleador) {
        Jugador j = elegirPorPosiciones(club, new Posicion[]{Posicion.MCO, Posicion.MC, Posicion.EI, Posicion.ED, Posicion.LD, Posicion.LI});
        if (j != null && j != goleador) return j;
        return null;
    }

    private Jugador elegirJugadorDeCampo(Club club) {
        if (club == null) return null;

        int intentos = 15;
        while (intentos > 0) {
            int i = rnd.nextInt(Math.max(1, club.getNumPrimerEquipo()));
            Jugador j = club.getJugadorPrimerEquipo(i);
            if (j != null && j.getPosicion() != Posicion.POR) return j;
            intentos--;
        }
        return null;
    }

    private Jugador elegirPorPosiciones(Club club, Posicion[] posiciones) {
        if (club == null || posiciones == null || posiciones.length == 0) return null;

        int intentos = 20;
        while (intentos > 0) {
            int i = rnd.nextInt(Math.max(1, club.getNumPrimerEquipo()));
            Jugador j = club.getJugadorPrimerEquipo(i);
            if (j != null) {
                for (int k = 0; k < posiciones.length; k++) {
                    if (j.getPosicion() == posiciones[k]) return j;
                }
            }
            intentos--;
        }
        return null;
    }

    private String nombreJugador(Jugador j) {
        if (j == null) return "Jugador";
        return j.getNombre();
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();
    }
}
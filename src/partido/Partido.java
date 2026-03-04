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

    private Random aleatorio;

    public Partido(Club local, Club visitante) {
        this.aleatorio = new Random();
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
        if (jugado) return;

        golesDelLocal = golesRealistas(aleatorio, true);
        golesDelVisitante = golesRealistas(aleatorio, false);

        if (verEnDirecto) {
            Utilidades.printlnColor(Utilidades.CIAN, "\n" + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());
            Utilidades.escribirLento("Comienza el partido", 10);
        }

        for (int i = 0; i < golesDelLocal; i++) {
            int minuto = minutoGol();
            Jugador goleador = elegirGoleador(equipoLocal);
            Jugador asistente = elegirAsistente(equipoLocal, goleador);

            if (goleador != null) goleador.setGoles(goleador.getGoles() + 1);
            if (asistente != null) asistente.setAsistencias(asistente.getAsistencias() + 1);

            if (verEnDirecto) {
                String msg = "[" + minuto + "'] GOL " + equipoLocal.getNombre() + " - " + nombreJugador(goleador);
                Utilidades.printlnColor(Utilidades.VERDE, msg);
                if (asistente != null) {
                    Utilidades.printlnColor(Utilidades.GRIS, "   Asistencia: " + asistente.getNombre());
                }
                Utilidades.dormir(150);
            }
        }

        for (int i = 0; i < golesDelVisitante; i++) {
            int minuto = minutoGol();
            Jugador goleador = elegirGoleador(equipoVisitante);
            Jugador asistente = elegirAsistente(equipoVisitante, goleador);

            if (goleador != null) goleador.setGoles(goleador.getGoles() + 1);
            if (asistente != null) asistente.setAsistencias(asistente.getAsistencias() + 1);

            if (verEnDirecto) {
                String msg = "[" + minuto + "'] GOL " + equipoVisitante.getNombre() + " - " + nombreJugador(goleador);
                Utilidades.printlnColor(Utilidades.VERDE, msg);
                if (asistente != null) {
                    Utilidades.printlnColor(Utilidades.GRIS, "   Asistencia: " + asistente.getNombre());
                }
                Utilidades.dormir(150);
            }
        }

        aplicarTarjetas(equipoLocal, verEnDirecto);
        aplicarTarjetas(equipoVisitante, verEnDirecto);

        aplicarPorteriaCero(equipoLocal, golesDelVisitante);
        aplicarPorteriaCero(equipoVisitante, golesDelLocal);

        if (verEnDirecto) {
            Utilidades.escribirLento("Final del partido...", 10);
            imprimirMarcadorColor();
        }

        jugado = true;
    }

    private void imprimirMarcadorColor() {
        String marcador = equipoLocal.getNombre() + " " + golesDelLocal + " - " + golesDelVisitante + " " + equipoVisitante.getNombre();

        if (golesDelLocal > golesDelVisitante) Utilidades.printlnColor(Utilidades.VERDE, marcador);
        else if (golesDelLocal < golesDelVisitante) Utilidades.printlnColor(Utilidades.ROJO, marcador);
        else Utilidades.printlnColor(Utilidades.AMAR, marcador);
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
    }

    private int minutoGol() {
        int m = 1 + aleatorio.nextInt(90);
        if (aleatorio.nextInt(100) < 8) m = 90 + aleatorio.nextInt(6);
        return m;
    }

    private void aplicarTarjetas(Club equipo, boolean verEnDirecto) {
        int amarillas = aleatorio.nextInt(3);
        int rojas;
        if (aleatorio.nextInt(100) < 7) rojas = 1;
        else rojas = 0;

        for (int i = 0; i < amarillas; i++) {
            Jugador j = elegirJugadorDeCampo(equipo);
            if (j != null) {
                j.setAmarillas(j.getAmarillas() + 1);
                if (verEnDirecto && aleatorio.nextInt(100) < 40) {
                    Utilidades.printlnColor(Utilidades.AMAR, "Tarjeta amarilla para " + equipo.getNombre() + " - " + j.getNombre());
                }
            }
        }

        for (int i = 0; i < rojas; i++) {
            Jugador j = elegirJugadorDeCampo(equipo);
            if (j != null) {
                j.setRojas(j.getRojas() + 1);
                if (verEnDirecto) {
                    Utilidades.printlnColor(Utilidades.ROJO, "Tarjeta roja para " + equipo.getNombre() + " - " + j.getNombre());
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
            int i = aleatorio.nextInt(Math.max(1, club.getNumPrimerEquipo()));
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
            int i = aleatorio.nextInt(Math.max(1, club.getNumPrimerEquipo()));
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
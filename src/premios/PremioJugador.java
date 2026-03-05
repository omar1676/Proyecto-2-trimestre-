package premios;

import clubes.Club;
import jugadores.Jugador;

public class PremioJugador {

    private TipoPremio tipo;
    private Jugador jugador;
    private Club club;
    private int valor;

    public PremioJugador(TipoPremio tipo, Jugador jugador, Club club, int valor) {
        this.tipo = tipo;
        this.jugador = jugador;
        this.club = club;
        this.valor = valor;
    }

    public TipoPremio getTipo() {
        return tipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Club getClub() {
        return club;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String nomJ = "Jugador";
        if (jugador != null && jugador.getNombre() != null) {
            nomJ = jugador.getNombre();
        }

        String nomC = "Club";
        if (club != null && club.getNombre() != null) {
            nomC = club.getNombre();
        }

        return tipo + ": " + nomJ + " (" + nomC + ") -> " + valor;
    }
}
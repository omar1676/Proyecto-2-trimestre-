package premios;

import clubes.Club;
import jugadores.Jugador;
import jugadores.Posicion;

public final class Premiador {

    private Premiador() {
    }

    public static boolean hayClubesValidos(Club[] clubes) {
        if (clubes == null) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < clubes.length; i++) {
            if (clubes[i] != null) {
                count++;
            }
        }

        return count > 0;
    }

    public static PremioJugador[] calcularPremios(Club[] clubes) {
        PremioJugador[] premios = new PremioJugador[5];

        if (!hayClubesValidos(clubes)) {
            return premios;
        }

        PremioJugador pichichi = buscarMax(clubes, TipoPremio.PICHICHI);
        PremioJugador asist = buscarMax(clubes, TipoPremio.ASISTENCIAS);
        PremioJugador zamora = buscarMax(clubes, TipoPremio.ZAMORA);
        PremioJugador mvp = buscarMax(clubes, TipoPremio.MVP);
        PremioJugador fair = buscarMinFairPlay(clubes);

        premios[0] = pichichi;
        premios[1] = asist;
        premios[2] = zamora;
        premios[3] = fair;
        premios[4] = mvp;

        return premios;
    }

    private static PremioJugador buscarMax(Club[] clubes, TipoPremio tipo) {
        Jugador mejor = null;
        Club clubMejor = null;
        int mejorValor = -1;

        for (int i = 0; i < clubes.length; i++) {
            Club c = clubes[i];
            if (c == null) {
                continue;
            }

            for (int j = 0; j < c.getNumPrimerEquipo(); j++) {
                Jugador jug = c.getJugadorPrimerEquipo(j);
                if (jug == null) {
                    continue;
                }

                int v = valorPorTipo(jug, tipo);

                if (v > mejorValor) {
                    mejorValor = v;
                    mejor = jug;
                    clubMejor = c;
                } else if (v == mejorValor && mejor != null) {
                    if (jug.getValoracion() > mejor.getValoracion()) {
                        mejor = jug;
                        clubMejor = c;
                    } else if (jug.getValoracion() == mejor.getValoracion()) {
                        String a = jug.getNombre();
                        String b = mejor.getNombre();

                        if (a != null && b != null) {
                            if (a.compareToIgnoreCase(b) < 0) {
                                mejor = jug;
                                clubMejor = c;
                            }
                        }
                    }
                }
            }
        }

        if (mejor == null) {
            return null;
        }

        return new PremioJugador(tipo, mejor, clubMejor, mejorValor);
    }

    private static int valorPorTipo(Jugador j, TipoPremio tipo) {
        if (j == null) {
            return 0;
        }

        if (tipo == TipoPremio.PICHICHI) {
            return j.getGoles();
        }
        if (tipo == TipoPremio.ASISTENCIAS) {
            return j.getAsistencias();
        }
        if (tipo == TipoPremio.ZAMORA) {
            if (j.getPosicion() != Posicion.POR) {
                return -1;
            }
            return j.getPorteriasCero();
        }
        if (tipo == TipoPremio.MVP) {
            return j.getValoracion();
        }

        return 0;
    }

    private static PremioJugador buscarMinFairPlay(Club[] clubes) {
        Jugador mejor = null;
        Club clubMejor = null;
        int mejorValor = Integer.MAX_VALUE;

        for (int i = 0; i < clubes.length; i++) {
            Club c = clubes[i];
            if (c == null) {
                continue;
            }

            for (int j = 0; j < c.getNumPrimerEquipo(); j++) {
                Jugador jug = c.getJugadorPrimerEquipo(j);
                if (jug == null) {
                    continue;
                }

                int tarjetas = jug.getAmarillas() + (jug.getRojas() * 3);

                if (tarjetas < mejorValor) {
                    mejorValor = tarjetas;
                    mejor = jug;
                    clubMejor = c;
                }
            }
        }

        if (mejor == null) {
            return null;
        }

        return new PremioJugador(TipoPremio.FAIR_PLAY, mejor, clubMejor, mejorValor);
    }
}
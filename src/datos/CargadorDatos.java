package datos;

import clubes.Club;
import jugadores.Jugador;
import jugadores.Posicion;

import java.util.Random;

public final class CargadorDatos {

    private CargadorDatos() {
    }

    public static void cargarPlantillasAleatorias(Club[] clubes, int numPrimerEquipo, int numCantera, String temporada) {
        if (clubes == null) {
            return;
        }

        for (int i = 0; i < clubes.length; i++) {
            Club c = clubes[i];
            if (c == null) {
                continue;
            }
            if (c.getNumPrimerEquipo() <= 0) {
                generarPlantillaAleatoria(c, numPrimerEquipo, numCantera, temporada);
            }
        }
    }

    public static Club[] crearClubesLaLiga() {
        Club alaves = new Club(1, "Deportivo Alaves", 1921, "Presidente", 40, 68);
        Club athletic = new Club(2, "Athletic Club", 1898, "Presidente", 95, 83);
        Club atletico = new Club(3, "Atletico de Madrid", 1903, "Presidente", 180, 88);
        Club barcelona = new Club(4, "FC Barcelona", 1899, "Presidente", 240, 92);
        Club celta = new Club(5, "Celta de Vigo", 1923, "Presidente", 60, 74);
        Club elche = new Club(6, "Elche", 1923, "Presidente", 28, 64);
        Club espanyol = new Club(7, "Espanyol", 1900, "Presidente", 45, 69);
        Club getafe = new Club(8, "Getafe", 1983, "Presidente", 55, 73);
        Club girona = new Club(9, "Girona", 1930, "Presidente", 55, 75);
        Club levante = new Club(10, "Levante", 1909, "Presidente", 25, 63);
        Club mallorca = new Club(11, "Real Mallorca", 1916, "Presidente", 45, 70);
        Club osasuna = new Club(12, "Osasuna", 1920, "Presidente", 50, 71);
        Club rayo = new Club(13, "Rayo Vallecano", 1924, "Presidente", 45, 70);
        Club betis = new Club(14, "Real Betis", 1907, "Presidente", 90, 81);
        Club madrid = new Club(15, "Real Madrid", 1902, "Presidente", 280, 95);
        Club oviedo = new Club(16, "Real Oviedo", 1926, "Presidente", 22, 62);
        Club sociedad = new Club(17, "Real Sociedad", 1909, "Presidente", 85, 82);
        Club sevilla = new Club(18, "Sevilla", 1890, "Presidente", 75, 78);
        Club valencia = new Club(19, "Valencia", 1919, "Presidente", 75, 77);
        Club villarreal = new Club(20, "Villarreal", 1923, "Presidente", 85, 80);

        alaves.setPalmares(0, 0, 0, 0, 0);
        athletic.setPalmares(8, 24, 0, 3, 0);
        atletico.setPalmares(11, 10, 0, 2, 1);
        barcelona.setPalmares(28, 32, 5, 15, 3);
        celta.setPalmares(0, 0, 0, 0, 0);
        elche.setPalmares(0, 0, 0, 0, 0);
        espanyol.setPalmares(0, 4, 0, 0, 0);
        getafe.setPalmares(0, 0, 0, 0, 0);
        girona.setPalmares(0, 0, 0, 0, 0);
        levante.setPalmares(0, 0, 0, 0, 0);
        mallorca.setPalmares(0, 1, 0, 1, 0);
        osasuna.setPalmares(0, 0, 0, 0, 0);
        rayo.setPalmares(0, 0, 0, 0, 0);
        betis.setPalmares(1, 3, 0, 0, 0);
        madrid.setPalmares(36, 20, 15, 13, 5);
        oviedo.setPalmares(0, 0, 0, 0, 0);
        sociedad.setPalmares(2, 2, 0, 1, 0);
        sevilla.setPalmares(1, 5, 0, 1, 0);
        valencia.setPalmares(6, 8, 0, 1, 0);
        villarreal.setPalmares(0, 0, 0, 0, 0);

        return new Club[]{
                alaves, athletic, atletico, barcelona, celta,
                elche, espanyol, getafe, girona, levante,
                mallorca, osasuna, rayo, betis, madrid,
                oviedo, sociedad, sevilla, valencia, villarreal
        };
    }

    public static Club[] crearClubesHypermotion() {
        Club[] clubes = new Club[22];

        clubes[0] = new Club(901, "Real Zaragoza", 1932, "Presidente", 28, 64);
        clubes[1] = new Club(902, "Sporting de Gijon", 1905, "Presidente", 26, 63);
        clubes[2] = new Club(903, "Racing de Santander", 1913, "Presidente", 24, 62);
        clubes[3] = new Club(904, "Real Valladolid", 1928, "Presidente", 32, 66);
        clubes[4] = new Club(905, "Eibar", 1940, "Presidente", 24, 62);
        clubes[5] = new Club(906, "Albacete", 1940, "Presidente", 20, 60);
        clubes[6] = new Club(907, "Tenerife", 1922, "Presidente", 20, 60);
        clubes[7] = new Club(908, "Levante", 1909, "Presidente", 28, 64);
        clubes[8] = new Club(909, "Granada", 1931, "Presidente", 30, 65);
        clubes[9] = new Club(910, "Cadiz", 1910, "Presidente", 28, 64);
        clubes[10] = new Club(911, "Elche", 1923, "Presidente", 26, 63);
        clubes[11] = new Club(912, "Leganes", 1928, "Presidente", 26, 63);
        clubes[12] = new Club(913, "Burgos", 1936, "Presidente", 18, 59);
        clubes[13] = new Club(914, "Mirandes", 1927, "Presidente", 16, 58);
        clubes[14] = new Club(915, "Huesca", 1960, "Presidente", 16, 58);
        clubes[15] = new Club(916, "Almeria", 1989, "Presidente", 30, 65);
        clubes[16] = new Club(917, "Cordoba", 1954, "Presidente", 15, 57);
        clubes[17] = new Club(918, "Malaga", 1904, "Presidente", 18, 59);
        clubes[18] = new Club(919, "Cartagena", 1995, "Presidente", 16, 58);
        clubes[19] = new Club(920, "Racing Ferrol", 1919, "Presidente", 14, 56);
        clubes[20] = new Club(921, "Oviedo", 1926, "Presidente", 22, 61);
        clubes[21] = new Club(922, "Las Palmas", 1949, "Presidente", 26, 63);

        return clubes;
    }

    public static Club[] crearClubesEuropaLeague() {

        Club[] laliga = crearClubesLaLiga();
        Club[] premier = crearClubesPremierLeague();
        Club[] serieA = crearClubesSerieA();
        Club[] bundes = crearClubesBundesliga();
        Club[] ligue1 = crearClubesLigue1();

        ordenarPorNivelDesc(laliga);
        ordenarPorNivelDesc(premier);
        ordenarPorNivelDesc(serieA);
        ordenarPorNivelDesc(bundes);
        ordenarPorNivelDesc(ligue1);

        Club[] bolsa = new Club[0];
        bolsa = unir5(
                recortarDesde(laliga, 3),
                recortarDesde(premier, 3),
                recortarDesde(serieA, 3),
                recortarDesde(bundes, 3),
                recortarDesde(ligue1, 3)
        );

        ordenarPorNivelDesc(bolsa);

        Club[] res = new Club[16];
        int pos = 0;
        int i = 0;
        while (pos < res.length && i < bolsa.length) {
            if (bolsa[i] != null && !estaEn(res, pos, bolsa[i])) {
                res[pos] = bolsa[i];
                pos++;
            }
            i++;
        }

        cargarPlantillasAleatorias(res, 22, 6, "2024/25");
        return res;
    }

    private static Club[] recortarDesde(Club[] clubes, int desde) {
        if (clubes == null) {
            return null;
        }
        if (desde < 0) {
            desde = 0;
        }
        if (desde >= clubes.length) {
            return new Club[0];
        }

        Club[] res = new Club[clubes.length - desde];
        int pos = 0;

        for (int i = desde; i < clubes.length; i++) {
            res[pos] = clubes[i];
            pos++;
        }

        return res;
    }

    public static Club[] crearClubesPremierLeague() {
        Club arsenal = new Club(101, "Arsenal", 1886, "Presidente", 210, 88);
        Club astonVilla = new Club(102, "Aston Villa", 1874, "Presidente", 140, 80);
        Club bournemouth = new Club(103, "AFC Bournemouth", 1899, "Presidente", 70, 72);
        Club brentford = new Club(104, "Brentford", 1889, "Presidente", 70, 72);
        Club brighton = new Club(105, "Brighton & Hove Albion", 1901, "Presidente", 95, 76);
        Club chelsea = new Club(106, "Chelsea", 1905, "Presidente", 200, 85);
        Club crystalPalace = new Club(107, "Crystal Palace", 1905, "Presidente", 85, 74);
        Club everton = new Club(108, "Everton", 1878, "Presidente", 95, 75);
        Club fulham = new Club(109, "Fulham", 1879, "Presidente", 80, 73);
        Club ipswich = new Club(110, "Ipswich Town", 1878, "Presidente", 55, 68);
        Club leicester = new Club(111, "Leicester City", 1884, "Presidente", 80, 73);
        Club liverpool = new Club(112, "Liverpool", 1892, "Presidente", 230, 90);
        Club manCity = new Club(113, "Manchester City", 1880, "Presidente", 260, 93);
        Club manUnited = new Club(114, "Manchester United", 1878, "Presidente", 220, 86);
        Club newcastle = new Club(115, "Newcastle United", 1892, "Presidente", 150, 81);
        Club nottinghamForest = new Club(116, "Nottingham Forest", 1865, "Presidente", 75, 72);
        Club southampton = new Club(117, "Southampton", 1885, "Presidente", 60, 69);
        Club tottenham = new Club(118, "Tottenham Hotspur", 1882, "Presidente", 190, 84);
        Club westHam = new Club(119, "West Ham United", 1895, "Presidente", 120, 78);
        Club wolves = new Club(120, "Wolverhampton Wanderers", 1877, "Presidente", 95, 75);

        return new Club[]{
                arsenal, astonVilla, bournemouth, brentford, brighton,
                chelsea, crystalPalace, everton, fulham, ipswich,
                leicester, liverpool, manCity, manUnited, newcastle,
                nottinghamForest, southampton, tottenham, westHam, wolves
        };
    }

    public static Club[] crearClubesSerieA() {
        Club[] clubes = new Club[20];

        clubes[0] = new Club(201, "Atalanta", 1907, "Presidente", 95, 79);
        clubes[1] = new Club(202, "Bologna", 1909, "Presidente", 65, 72);
        clubes[2] = new Club(203, "Cagliari", 1920, "Presidente", 45, 67);
        clubes[3] = new Club(204, "Empoli", 1920, "Presidente", 45, 66);
        clubes[4] = new Club(205, "Fiorentina", 1926, "Presidente", 90, 76);
        clubes[5] = new Club(206, "Genoa", 1893, "Presidente", 55, 69);
        clubes[6] = new Club(207, "Inter", 1908, "Presidente", 180, 86);
        clubes[7] = new Club(208, "Juventus", 1897, "Presidente", 170, 85);
        clubes[8] = new Club(209, "Lazio", 1900, "Presidente", 110, 78);
        clubes[9] = new Club(210, "Lecce", 1908, "Presidente", 40, 65);
        clubes[10] = new Club(211, "Milan", 1899, "Presidente", 165, 84);
        clubes[11] = new Club(212, "Monza", 1912, "Presidente", 50, 68);
        clubes[12] = new Club(213, "Napoli", 1926, "Presidente", 150, 83);
        clubes[13] = new Club(214, "Roma", 1927, "Presidente", 120, 80);
        clubes[14] = new Club(215, "Salernitana", 1919, "Presidente", 35, 64);
        clubes[15] = new Club(216, "Sassuolo", 1920, "Presidente", 55, 69);
        clubes[16] = new Club(217, "Torino", 1906, "Presidente", 65, 71);
        clubes[17] = new Club(218, "Udinese", 1896, "Presidente", 55, 69);
        clubes[18] = new Club(219, "Verona", 1903, "Presidente", 45, 66);
        clubes[19] = new Club(220, "Venezia", 1907, "Presidente", 35, 64);

        return clubes;
    }

    public static Club[] crearClubesBundesliga() {
        Club[] clubes = new Club[18];

        clubes[0] = new Club(301, "Bayern", 1900, "Präsident", 250, 92);
        clubes[1] = new Club(302, "Dortmund", 1909, "Präsident", 170, 85);
        clubes[2] = new Club(303, "Leipzig", 2009, "Präsident", 150, 83);
        clubes[3] = new Club(304, "Leverkusen", 1904, "Präsident", 160, 84);
        clubes[4] = new Club(305, "Frankfurt", 1899, "Präsident", 110, 78);
        clubes[5] = new Club(306, "Stuttgart", 1893, "Präsident", 85, 75);
        clubes[6] = new Club(307, "Wolfsburg", 1945, "Präsident", 85, 74);
        clubes[7] = new Club(308, "Gladbach", 1900, "Präsident", 80, 73);
        clubes[8] = new Club(309, "Freiburg", 1904, "Präsident", 70, 72);
        clubes[9] = new Club(310, "Mainz", 1905, "Präsident", 60, 70);
        clubes[10] = new Club(311, "Augsburg", 1907, "Präsident", 55, 69);
        clubes[11] = new Club(312, "Bremen", 1899, "Präsident", 70, 71);
        clubes[12] = new Club(313, "Hoffenheim", 1899, "Präsident", 65, 70);
        clubes[13] = new Club(314, "Union Berlin", 1966, "Präsident", 75, 72);
        clubes[14] = new Club(315, "Bochum", 1848, "Präsident", 45, 66);
        clubes[15] = new Club(316, "Heidenheim", 1846, "Präsident", 35, 64);
        clubes[16] = new Club(317, "St. Pauli", 1910, "Präsident", 40, 65);
        clubes[17] = new Club(318, "Hamburg", 1887, "Präsident", 60, 69);

        return clubes;
    }

    public static Club[] crearClubesLigue1() {
        Club[] clubes = new Club[18];

        clubes[0] = new Club(401, "PSG", 1970, "Président", 260, 92);
        clubes[1] = new Club(402, "Marseille", 1899, "Président", 140, 81);
        clubes[2] = new Club(403, "Lyon", 1950, "Président", 120, 78);
        clubes[3] = new Club(404, "Monaco", 1924, "Président", 150, 82);
        clubes[4] = new Club(405, "Lille", 1944, "Président", 115, 79);
        clubes[5] = new Club(406, "Rennes", 1901, "Président", 105, 77);
        clubes[6] = new Club(407, "Nice", 1904, "Président", 100, 76);
        clubes[7] = new Club(408, "Lens", 1906, "Président", 85, 74);
        clubes[8] = new Club(409, "Nantes", 1943, "Président", 65, 70);
        clubes[9] = new Club(410, "Montpellier", 1919, "Président", 60, 69);
        clubes[10] = new Club(411, "Strasbourg", 1906, "Président", 75, 72);
        clubes[11] = new Club(412, "Reims", 1931, "Président", 65, 70);
        clubes[12] = new Club(413, "Toulouse", 1937, "Président", 60, 69);
        clubes[13] = new Club(414, "Brest", 1950, "Président", 55, 68);
        clubes[14] = new Club(415, "Angers", 1919, "Président", 40, 65);
        clubes[15] = new Club(416, "Auxerre", 1905, "Président", 45, 66);
        clubes[16] = new Club(417, "Le Havre", 1872, "Président", 35, 64);
        clubes[17] = new Club(418, "Metz", 1932, "Président", 35, 64);

        return clubes;
    }

    private static void generarPlantillaAleatoria(Club club, int numPrimerEquipo, int numCantera, String temporada) {
        if (club == null) {
            return;
        }

        Random r = new Random();

        String[] nombres = {
                "Antonio", "Raul", "Carlos", "Lucas", "Daniel", "Sergio", "Mario", "Jorge", "Adrian", "Pablo", "Hector", "Ivan",
                "Alejandro", "Nacho", "Alvaro", "Gonzalo", "David", "Miguel", "Ruben", "Oscar", "Javier", "Fran", "Marcos", "Victor",
                "Iker", "Unai", "Aitor", "Ander", "Mikel", "Asier", "Eneko", "Xabier", "Julen", "Gaizka",
                "Manuel", "Jose", "Juan", "Pedro", "Luis", "Ramon", "Fernando", "Joaquin", "Angel", "Andres", "Enrique", "Alfonso",
                "Diego", "Mateo", "Nicolas", "Sebastian", "Agustin", "Facundo", "Santiago", "Emiliano", "Julian", "Tomas", "Martin",
                "Valentin", "Lautaro", "Thiago", "Bruno", "Benjamin", "Felipe", "Cristian", "Federico", "Rodrigo", "Maximo",
                "Leonardo", "Matias", "Kevin", "Axel", "Alan", "Dylan", "Izan", "Hugo", "Eric", "Alex",
                "Pau", "Pol", "Oriol", "Sergi", "Gerard", "Marc", "Roger", "Xavi", "Carles", "Joan",
                "Nuno", "Tiago", "Joao", "Andre", "Rui", "Bruno", "Diogo", "Goncalo",
                "Marco", "Luca", "Matteo", "Alessandro", "Andrea", "Federico", "Giovanni", "Nicolo", "Davide", "Simone",
                "Pierre", "Louis", "Theo", "Antoine", "Mathis", "Baptiste", "Romain",
                "Max", "Jonas", "Felix", "Niklas", "Timo", "Julian", "Leon", "Noah", "Finn",
                "Adam", "Oskar", "Kacper", "Milan", "Artem", "Denis", "Dusan", "Marko", "Luka", "Nikola"
        };

        String[] apellidos = {
                "Garcia", "Fernandez", "Lopez", "Gonzalez", "Rodriguez", "Sanchez", "Perez", "Martin", "Gomez", "Ruiz", "Hernandez", "Diaz",
                "Moreno", "Muñoz", "Alonso", "Romero", "Navarro", "Torres", "Dominguez", "Vazquez", "Ramos", "Serrano", "Molina", "Ortega",
                "Delgado", "Castro", "Suarez", "Iglesias", "Navas", "Campos", "Crespo", "Calvo", "Vidal", "Santos", "Cano", "Flores",
                "Herrera", "Marin", "Prieto", "Mendez", "Leon", "Gallardo", "Pascual", "Rey", "Cortes", "Guerrero", "Rojas", "Silva",
                "Paredes", "Medina", "Aguilar", "Figueroa", "Carrasco", "Pineda", "Salazar", "Mendoza", "Valdez", "Cabrera", "Montoya",
                "Benitez", "Peralta", "Zamora", "Quintero", "Escobar", "Araya", "Bravo", "Cifuentes", "Jaramillo", "Villalba", "Cardozo",
                "Costa", "Pereira", "Ferreira", "Carvalho", "Araujo", "Neves", "Dias", "Teixeira", "Gomes",
                "Rossi", "Bianchi", "Conti", "Romano", "Gallo", "Ferrari", "Greco", "Moretti", "Lombardi", "Ricci",
                "Dubois", "Lefevre", "Moreau", "Laurent", "Bernard", "Thomas", "Roux", "Fournier",
                "Muller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Hoffmann",
                "Nowak", "Kowalski", "Wojcik", "Zielinski", "Jankowski",
                "Petrov", "Ivanov", "Smirnov", "Sokolov", "Popov", "Volkov",
                "Markovic", "Jovanovic", "Nikolic", "Stojanovic", "Dimitrov", "Kovacevic"
        };

        Posicion[] rotacion = {
                Posicion.POR, Posicion.POR,
                Posicion.LD, Posicion.DFC, Posicion.DFC, Posicion.LI,
                Posicion.MCD, Posicion.MC, Posicion.MC, Posicion.MCO,
                Posicion.EI, Posicion.ED,
                Posicion.DC, Posicion.DC
        };

        for (int i = 0; i < numPrimerEquipo; i++) {
            int dorsal = i + 1;
            if (dorsal > 25) {
                dorsal = 25;
            }

            String nombre = nombreAleatorio(nombres, apellidos, r);
            int edad = 18 + r.nextInt(18);
            Posicion pos = rotacion[i % rotacion.length];

            double valor = valorMercadoAleatorio(pos, r);
            int media = mediaAleatoria(pos, r);

            Jugador j = new Jugador(dorsal, nombre, edad, pos, valor, media);
            j.setTemporada(temporada);

            int partidos = 5 + r.nextInt(26);
            int minutos = partidos * (40 + r.nextInt(55));
            j.setPartidos(partidos);
            j.setMinutos(minutos);

            if (pos == Posicion.POR) {
                j.setPorteriasCero(r.nextInt(11));
                j.setAmarillas(r.nextInt(3));
                j.setRojas(r.nextInt(2));
            } else {
                j.setGoles(golesAleatorios(pos, r));
                j.setAsistencias(asistenciasAleatorias(pos, r));
                j.setAmarillas(r.nextInt(7));
                j.setRojas(r.nextInt(2));
            }

            club.anadirPrimerEquipo(j);
        }

        for (int i = 0; i < numCantera; i++) {
            int dorsal = 31 + i;

            String nombre = nombreAleatorio(nombres, apellidos, r);
            int edad = 16 + r.nextInt(6);
            Posicion pos = rotacion[(i + 3) % rotacion.length];

            double valor = 0.1 + (r.nextInt(20) / 10.0);
            int media = 55 + r.nextInt(16);

            Jugador c = new Jugador(dorsal, nombre, edad, pos, valor, media);
            c.setTemporada(temporada);

            int partidos = r.nextInt(10);
            int minutos = partidos * (20 + r.nextInt(50));
            c.setPartidos(partidos);
            c.setMinutos(minutos);

            if (pos == Posicion.POR) {
                c.setPorteriasCero(r.nextInt(4));
                c.setAmarillas(r.nextInt(3));
            } else {
                c.setGoles(r.nextInt(5));
                c.setAsistencias(r.nextInt(5));
                c.setAmarillas(r.nextInt(4));
            }

            club.anadirCantera(c);
        }
    }

    private static String nombreAleatorio(String[] nombres, String[] apellidos, Random r) {
        String n = nombres[r.nextInt(nombres.length)];
        String a1 = apellidos[r.nextInt(apellidos.length)];
        String a2 = apellidos[r.nextInt(apellidos.length)];

        while (a2.equals(a1)) {
            a2 = apellidos[r.nextInt(apellidos.length)];
        }

        return n + " " + a1 + " " + a2;
    }

    private static double valorMercadoAleatorio(Posicion pos, Random r) {
        double base;

        if (pos == Posicion.DC) {
            base = 20.0 + r.nextInt(180);
        } else if (pos == Posicion.MCO) {
            base = 15.0 + r.nextInt(140);
        } else if (pos == Posicion.EI || pos == Posicion.ED) {
            base = 10.0 + r.nextInt(130);
        } else if (pos == Posicion.POR) {
            base = 5.0 + r.nextInt(60);
        } else if (pos == Posicion.MCD || pos == Posicion.MC) {
            base = 8.0 + r.nextInt(90);
        } else {
            base = 4.0 + r.nextInt(70);
        }

        int dec = (int) (base * 10);
        return dec / 10.0;
    }

    private static int mediaAleatoria(Posicion pos, Random r) {
        int m;

        if (pos == Posicion.DC) {
            m = 70 + r.nextInt(25);
        } else if (pos == Posicion.MCO) {
            m = 68 + r.nextInt(24);
        } else if (pos == Posicion.EI || pos == Posicion.ED) {
            m = 66 + r.nextInt(26);
        } else if (pos == Posicion.POR) {
            m = 65 + r.nextInt(24);
        } else if (pos == Posicion.MCD || pos == Posicion.MC) {
            m = 64 + r.nextInt(24);
        } else {
            m = 62 + r.nextInt(23);
        }

        if (m > 94) {
            m = 94;
        }

        return m;
    }

    private static int golesAleatorios(Posicion pos, Random r) {
        if (pos == Posicion.DC) {
            return r.nextInt(21);
        }
        if (pos == Posicion.EI || pos == Posicion.ED || pos == Posicion.MCO) {
            return r.nextInt(12);
        }
        if (pos == Posicion.MC || pos == Posicion.MCD) {
            return r.nextInt(6);
        }
        return r.nextInt(4);
    }

    private static int asistenciasAleatorias(Posicion pos, Random r) {
        if (pos == Posicion.DC) {
            return r.nextInt(8);
        }
        if (pos == Posicion.EI || pos == Posicion.ED || pos == Posicion.MCO) {
            return r.nextInt(12);
        }
        if (pos == Posicion.MC || pos == Posicion.MCD) {
            return r.nextInt(8);
        }
        return r.nextInt(5);
    }

    public static Club[] crearClubesChampionsTop16() {

        Club[] laliga = crearClubesLaLiga();
        Club[] premier = crearClubesPremierLeague();
        Club[] serieA = crearClubesSerieA();
        Club[] bundes = crearClubesBundesliga();
        Club[] ligue1 = crearClubesLigue1();

        ordenarPorNivelDesc(laliga);
        ordenarPorNivelDesc(premier);
        ordenarPorNivelDesc(serieA);
        ordenarPorNivelDesc(bundes);
        ordenarPorNivelDesc(ligue1);

        Club[] top16 = new Club[16];
        int pos = 0;

        pos = meterTopN(top16, pos, laliga, 3);
        pos = meterTopN(top16, pos, premier, 3);
        pos = meterTopN(top16, pos, serieA, 3);
        pos = meterTopN(top16, pos, bundes, 3);
        pos = meterTopN(top16, pos, ligue1, 3);

        Club[] bolsa = unir5(laliga, premier, serieA, bundes, ligue1);
        ordenarPorNivelDesc(bolsa);

        int i = 0;
        while (pos < top16.length && i < bolsa.length) {
            if (bolsa[i] != null && !estaEn(top16, pos, bolsa[i])) {
                top16[pos] = bolsa[i];
                pos++;
            }
            i++;
        }

        cargarPlantillasAleatorias(top16, 22, 6, "2024/25");
        return top16;
    }

    public static Club[] crearClubesEuropaLeagueTop16() {

        Club[] laliga = crearClubesLaLiga();
        Club[] premier = crearClubesPremierLeague();
        Club[] serieA = crearClubesSerieA();
        Club[] bundes = crearClubesBundesliga();
        Club[] ligue1 = crearClubesLigue1();

        Club[] bolsa = unir5(laliga, premier, serieA, bundes, ligue1);
        ordenarPorNivelDesc(bolsa);

        Club[] res = new Club[16];

        int pos = 0;
        int i = 16;

        while (pos < res.length && i < bolsa.length) {
            if (bolsa[i] != null && !estaEn(res, pos, bolsa[i])) {
                res[pos] = bolsa[i];
                pos++;
            }
            i++;
        }

        cargarPlantillasAleatorias(res, 22, 6, "2025/26");
        return res;
    }

    private static void ordenarPorNivelDesc(Club[] clubes) {
        if (clubes == null) {
            return;
        }

        boolean cambio = true;
        while (cambio) {
            cambio = false;

            for (int i = 0; i < clubes.length - 1; i++) {
                Club a = clubes[i];
                Club b = clubes[i + 1];

                int nivelA = -1;
                int nivelB = -1;

                if (a != null) {
                    nivelA = a.getNivel();
                }
                if (b != null) {
                    nivelB = b.getNivel();
                }

                if (nivelA < nivelB) {
                    clubes[i] = b;
                    clubes[i + 1] = a;
                    cambio = true;
                }
            }
        }
    }

    private static Club[] unir5(Club[] a, Club[] b, Club[] c, Club[] d, Club[] e) {
        int total = 0;

        if (a != null) {
            total += a.length;
        }
        if (b != null) {
            total += b.length;
        }
        if (c != null) {
            total += c.length;
        }
        if (d != null) {
            total += d.length;
        }
        if (e != null) {
            total += e.length;
        }

        Club[] res = new Club[total];
        int pos = 0;

        pos = copiar(res, pos, a);
        pos = copiar(res, pos, b);
        pos = copiar(res, pos, c);
        pos = copiar(res, pos, d);
        pos = copiar(res, pos, e);

        return res;
    }

    private static int copiar(Club[] destino, int pos, Club[] origen) {
        if (destino == null) {
            return pos;
        }
        if (origen == null) {
            return pos;
        }

        for (int i = 0; i < origen.length && pos < destino.length; i++) {
            destino[pos] = origen[i];
            pos++;
        }

        return pos;
    }

    private static int meterTopN(Club[] destino, int pos, Club[] origen, int n) {
        if (destino == null) {
            return pos;
        }
        if (origen == null) {
            return pos;
        }

        int i = 0;
        while (i < origen.length && n > 0 && pos < destino.length) {
            if (origen[i] != null) {
                destino[pos] = origen[i];
                pos++;
                n--;
            }
            i++;
        }

        return pos;
    }

    private static boolean estaEn(Club[] lista, int usados, Club c) {
        if (lista == null) {
            return false;
        }
        if (c == null) {
            return false;
        }

        int i = 0;
        while (i < usados) {
            if (lista[i] == c) {
                return true;
            }
            i++;
        }

        return false;
    }
}
package datos;

import clubes.Club;
import jugadores.Jugador;
import jugadores.Posicion;

import java.util.Random;

public final class CargadorDatos {

    private CargadorDatos() {}

    public static Club[] crearTodosLosClubes() {
        Club[] todos = new Club[96];
        int i = 0;

        todos[i] = new Club(1, "Deportivo Alaves", 1921, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(2, "Athletic Club", 1898, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(3, "Atletico de Madrid", 1903, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(4, "FC Barcelona", 1899, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(5, "Celta de Vigo", 1923, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(6, "Elche", 1923, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(7, "Espanyol", 1900, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(8, "Getafe", 1983, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(9, "Girona", 1930, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(10, "Levante", 1909, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(11, "Real Mallorca", 1916, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(12, "Osasuna", 1920, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(13, "Rayo Vallecano", 1924, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(14, "Real Betis", 1907, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(15, "Real Madrid", 1902, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(16, "Real Oviedo", 1926, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(17, "Real Sociedad", 1909, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(18, "Sevilla", 1890, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(19, "Valencia", 1919, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(20, "Villarreal", 1923, "Presidente", 30, 50);
        todos[i].setLiga("LaLiga");
        i++;

        todos[i] = new Club(101, "Arsenal", 1886, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(102, "Aston Villa", 1874, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(103, "AFC Bournemouth", 1899, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(104, "Brentford", 1889, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(105, "Brighton & Hove Albion", 1901, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(106, "Chelsea", 1905, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(107, "Crystal Palace", 1905, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(108, "Everton", 1878, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(109, "Fulham", 1879, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(110, "Ipswich Town", 1878, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(111, "Leicester City", 1884, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(112, "Liverpool", 1892, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(113, "Manchester City", 1880, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(114, "Manchester United", 1878, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(115, "Newcastle United", 1892, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(116, "Nottingham Forest", 1865, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(117, "Southampton", 1885, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(118, "Tottenham Hotspur", 1882, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(119, "West Ham United", 1895, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(120, "Wolverhampton Wanderers", 1877, "Presidente", 30, 50);
        todos[i].setLiga("Premier League");
        i++;

        todos[i] = new Club(201, "Atalanta", 1907, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(202, "Bologna", 1909, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(203, "Cagliari", 1920, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(204, "Empoli", 1920, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(205, "Fiorentina", 1926, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(206, "Genoa", 1893, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(207, "Inter", 1908, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(208, "Juventus", 1897, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(209, "Lazio", 1900, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(210, "Lecce", 1908, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(211, "Milan", 1899, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(212, "Monza", 1912, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(213, "Napoli", 1926, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(214, "Roma", 1927, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(215, "Salernitana", 1919, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(216, "Sassuolo", 1920, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(217, "Torino", 1906, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(218, "Udinese", 1896, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(219, "Verona", 1903, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(220, "Venezia", 1907, "Presidente", 30, 50);
        todos[i].setLiga("Serie A");
        i++;

        todos[i] = new Club(301, "Bayern", 1900, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(302, "Dortmund", 1909, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(303, "Leipzig", 2009, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(304, "Leverkusen", 1904, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(305, "Frankfurt", 1899, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(306, "Stuttgart", 1893, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(307, "Wolfsburg", 1945, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(308, "Gladbach", 1900, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(309, "Freiburg", 1904, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(310, "Mainz", 1905, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(311, "Augsburg", 1907, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(312, "Bremen", 1899, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(313, "Hoffenheim", 1899, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(314, "Union Berlin", 1966, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(315, "Bochum", 1848, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(316, "Heidenheim", 1846, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(317, "St. Pauli", 1910, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(318, "Hamburg", 1887, "Präsident", 30, 50);
        todos[i].setLiga("Bundesliga");
        i++;

        todos[i] = new Club(401, "PSG", 1970, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(402, "Marseille", 1899, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(403, "Lyon", 1950, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(404, "Monaco", 1924, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(405, "Lille", 1944, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(406, "Rennes", 1901, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(407, "Nice", 1904, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(408, "Lens", 1906, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(409, "Nantes", 1943, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(410, "Montpellier", 1919, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(411, "Strasbourg", 1906, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(412, "Reims", 1931, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(413, "Toulouse", 1937, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(414, "Brest", 1950, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(415, "Angers", 1919, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(416, "Auxerre", 1905, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(417, "Le Havre", 1872, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        todos[i] = new Club(418, "Metz", 1932, "Président", 30, 50);
        todos[i].setLiga("Ligue 1");
        i++;

        return todos;
    }


    public static Club[] clubesDeLiga(Club[] todos, String liga, int max) {
        if (max <= 0) {
            return new Club[0];
        }

        Club[] lista = new Club[max];
        int cont = 0;

        if (todos == null || liga == null) {
            return lista;
        }

        for (int i = 0; i < todos.length; i++) {
            Club c = todos[i];
            if (c != null && liga.equals(c.getLiga())) {
                if (cont < lista.length) {
                    lista[cont] = c;
                    cont++;
                }
            }
        }

        return lista;
    }


    public static Club[] top16(Club[] todos) {
        Club[] top = new Club[16];

        if (todos == null) {
            return top;
        }

        for (int i = 0; i < todos.length; i++) {
            Club c = todos[i];
            if (c != null) {
                meterEnTop(top, c);
            }
        }

        return top;
    }

    private static void meterEnTop(Club[] top, Club c) {
        int pos = -1;

        for (int i = 0; i < top.length; i++) {
            if (top[i] == null) {
                pos = i;
                break;
            }
            if (c.getNivel() > top[i].getNivel()) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return;
        }

        for (int j = top.length - 1; j > pos; j--) {
            top[j] = top[j - 1];
        }
        top[pos] = c;
    }

    public static Club[] crearClubesChampionsTop16() {
        Club[] todos = crearTodosLosClubes();
        cargarPlantillasAleatorias(todos, 22, 6, "2024/25");
        return top16(todos);
    }

    public static void cargarPlantillasAleatorias(Club[] clubes, int numPrimerEquipo, int numCantera, String temporada) {
            if (clubes == null) return;
            for (int i = 0; i < clubes.length; i++) {
                Club c = clubes[i];
                if (c == null) continue;
                if (c.getNumPrimerEquipo() <= 0) {
                    generarPlantillaAleatoria(c, numPrimerEquipo, numCantera, temporada);
                }
            }
        }

    private static void generarPlantillaAleatoria(Club club, int numPrimerEquipo, int numCantera, String temporada) {
            if (club == null) return;

            Random r = new Random();

            String[] nombres = {
                    "Antonio","Raul","Carlos","Lucas","Daniel","Sergio","Mario","Jorge","Adrian","Pablo","Hector","Ivan",
                    "Alejandro","Nacho","Alvaro","Gonzalo","David","Miguel","Ruben","Oscar","Javier","Fran","Marcos","Victor",
                    "Iker","Unai","Aitor","Ander","Mikel","Asier","Eneko","Xabier","Julen","Gaizka",
                    "Manuel","Jose","Juan","Pedro","Luis","Ramon","Fernando","Joaquin","Angel","Andres","Enrique","Alfonso",
                    "Diego","Mateo","Nicolas","Sebastian","Agustin","Facundo","Santiago","Emiliano","Julian","Tomas","Martin",
                    "Valentin","Lautaro","Thiago","Bruno","Benjamin","Felipe","Cristian","Federico","Rodrigo","Maximo",
                    "Leonardo","Matias","Kevin","Axel","Alan","Dylan","Izan","Hugo","Eric","Alex",
                    "Pau","Pol","Oriol","Sergi","Gerard","Marc","Roger","Xavi","Carles","Joan",
                    "Nuno","Tiago","Joao","Andre","Rui","Bruno","Diogo","Goncalo",
                    "Marco","Luca","Matteo","Alessandro","Andrea","Federico","Giovanni","Nicolo","Davide","Simone",
                    "Pierre","Louis","Theo","Antoine","Mathis","Baptiste","Romain",
                    "Max","Jonas","Felix","Niklas","Timo","Julian","Leon","Noah","Finn",
                    "Adam","Oskar","Kacper","Milan","Artem","Denis","Dusan","Marko","Luka","Nikola"
            };

            String[] apellidos = {
                    "Garcia","Fernandez","Lopez","Gonzalez","Rodriguez","Sanchez","Perez","Martin","Gomez","Ruiz","Hernandez","Diaz",
                    "Moreno","Muñoz","Alonso","Romero","Navarro","Torres","Dominguez","Vazquez","Ramos","Serrano","Molina","Ortega",
                    "Delgado","Castro","Suarez","Iglesias","Navas","Campos","Crespo","Calvo","Vidal","Santos","Cano","Flores",
                    "Herrera","Marin","Prieto","Mendez","Leon","Gallardo","Pascual","Rey","Cortes","Guerrero","Rojas","Silva",
                    "Paredes","Medina","Aguilar","Figueroa","Carrasco","Pineda","Salazar","Mendoza","Valdez","Cabrera","Montoya",
                    "Benitez","Peralta","Zamora","Quintero","Escobar","Araya","Bravo","Cifuentes","Jaramillo","Villalba","Cardozo",
                    "Costa","Pereira","Ferreira","Carvalho","Araujo","Neves","Dias","Teixeira","Gomes",
                    "Rossi","Bianchi","Conti","Romano","Gallo","Ferrari","Greco","Moretti","Lombardi","Ricci",
                    "Dubois","Lefevre","Moreau","Laurent","Bernard","Thomas","Roux","Fournier",
                    "Muller","Schmidt","Schneider","Fischer","Weber","Meyer","Wagner","Becker","Hoffmann",
                    "Nowak","Kowalski","Wojcik","Zielinski","Jankowski",
                    "Petrov","Ivanov","Smirnov","Sokolov","Popov","Volkov",
                    "Markovic","Jovanovic","Nikolic","Stojanovic","Dimitrov","Kovacevic"
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
                if (dorsal > 25) dorsal = 25;

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

                club.anadirCantera(c);    }
        }

        private static String nombreAleatorio(String[] nombres, String[] apellidos, Random r) {
            String n = nombres[r.nextInt(nombres.length)];
            String a1 = apellidos[r.nextInt(apellidos.length)];
            String a2 = apellidos[r.nextInt(apellidos.length)];
            while (a2.equals(a1)) a2 = apellidos[r.nextInt(apellidos.length)];
            return n + " " + a1 + " " + a2;
        }

        private static double valorMercadoAleatorio(Posicion pos, Random r) {
            double base;
            if (pos == Posicion.DC) base = 20.0 + r.nextInt(180);
            else if (pos == Posicion.MCO) base = 15.0 + r.nextInt(140);
            else if (pos == Posicion.EI || pos == Posicion.ED) base = 10.0 + r.nextInt(130);
            else if (pos == Posicion.POR) base = 5.0 + r.nextInt(60);
            else if (pos == Posicion.MCD || pos == Posicion.MC) base = 8.0 + r.nextInt(90);
            else base = 4.0 + r.nextInt(70);

            int dec = (int) (base * 10);
            return dec / 10.0;
        }

        private static int mediaAleatoria(Posicion pos, Random r) {
            int m;
            if (pos == Posicion.DC) m = 70 + r.nextInt(25);
            else if (pos == Posicion.MCO) m = 68 + r.nextInt(24);
            else if (pos == Posicion.EI || pos == Posicion.ED) m = 66 + r.nextInt(26);
            else if (pos == Posicion.POR) m = 65 + r.nextInt(24);
            else if (pos == Posicion.MCD || pos == Posicion.MC) m = 64 + r.nextInt(24);
            else m = 62 + r.nextInt(23);

            if (m > 94) m = 94;
            return m;
        }

        private static int golesAleatorios(Posicion pos, Random r) {
            if (pos == Posicion.DC) return r.nextInt(21);
            if (pos == Posicion.EI || pos == Posicion.ED || pos == Posicion.MCO) return r.nextInt(12);
            if (pos == Posicion.MC || pos == Posicion.MCD) return r.nextInt(6);
            return r.nextInt(4);
        }

        private static int asistenciasAleatorias(Posicion pos, Random r) {
            if (pos == Posicion.DC) return r.nextInt(8);
            if (pos == Posicion.EI || pos == Posicion.ED || pos == Posicion.MCO) return r.nextInt(12);
            if (pos == Posicion.MC || pos == Posicion.MCD) return r.nextInt(8);
            return r.nextInt(5);
        }



}

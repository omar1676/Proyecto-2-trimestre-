package cubles;


import java.util.Arrays;

public class ListaClubs {

    public static void main(String[] args) {
        Cubles [] club = new Cubles[20];
        club[0] = new Cubles(1, "Alavés", 1921, "Alfonso Fernández de Trocóniz", 3, 26);
        club[1] = new Cubles(2, "Athletic Club", 1898, "Jon Uriarte", 18, 26);
        club[2] = new Cubles(3, "Atlético de Madrid", 1903, "Enrique Cerezo", 5, 26 );
        club[3] = new Cubles(4, "Barcelona", 1899, "Joan Laporta", 9, 26);


        String[][] Jugadores = new String[20][2];
        Jugadores[0][0] = "Marcelo";
        Jugadores[0][1] = "Messi";
        Jugadores[1][0] = "Juan";
        Jugadores[1][1] = "Mengano";


        for (int i = 0; i < club.length; i++){
            System.out.println(club[i].toString());
            for (int j = 0 ; j < Jugadores.length; j++){
                if (j == 2){
                    break;
                }
                System.out.println(Jugadores[i][j]);
            }
        }
    }
}

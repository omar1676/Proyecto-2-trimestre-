package clubs;


public class ListaClubs {

    public static void main(String[] args) {
        Clubs [] club = new Clubs[20];
        club[0] = new Clubs(1, "Alavés", 1921, "Alfonso Fernández de Trocóniz", 3, 26, 110000000);
        club[1] = new Clubs(2, "Athletic Club", 1898, "Jon Uriarte", 18, 26, 256000000);
        club[2] = new Clubs(3, "Atlético de Madrid", 1903, "Enrique Cerezo", 5, 26, 2500000000L);
        club[3] = new Clubs(4, "Barcelona", 1899, "Joan Laporta", 9, 26, 256000000);
        club[4] = new Clubs(5, "Celta de Vigo", 1923, "Carlos Mouriño / Grupo Corporativo Ges", 7 , 31, 256000000);
        club[5] = new Clubs(6, "Elche CF", 1923, "Christian Bragarnik", 3, 25, 256000000);
        club[6] = new Clubs(7, "Espanyol", 1900, "Chen Yansheng / Rastar Group", 9, 33, 256000000);
        club[7] = new Clubs(8, "Getafe CF", 1983, "Ángel Torres Sánchez", 3, 25, 256000000);
        club[8] = new Clubs(9, "Girona FC", 1930, "DelfíGeli / City Football Group", 4, 25, 256000000);
        club[9] = new Clubs(10, "Levante UD",1909, "Pablo Sánchez", 5, 25 , 256000000);


        for (int i = 0; i < club.length; i++){
            System.out.println(club[i].toString());
        }
    }
}

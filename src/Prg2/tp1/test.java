package Prg2.tp1;

public class test {
    public static void main(String[] args) {
        Grille g1, g2 ;
        int hauteur, largeur ;

        hauteur = 33 ;
        largeur = 55 ;
        g1 = new Grille(hauteur, largeur) ;
        g2 = new Grille(hauteur+1, largeur+1) ;
        System.out.println("Test de " + g1.getClass().getName()) ;
        g1.fillRandom();
        g1.printGrille();
        System.out.println(g1);

    }
}

package Prg2.tp1;
//import Tools.Print;
import java.util.Random;

public class Grille {
    /*Variables d’instance*/
    // hauteur : nombre de lignes
    private final int hauteur;
    // largeur : nombre de colonnes
    private final int largeur;
    // tab : tableau de chaînes de caractères à deux dimensions,
    private final String[][] tab;

    /**
     * Constructeur permettant d'obtenir une grille dotée d'un tableau de dimensions conforme aux valeurs respectives
     * de hauteur et de largeur, dont tous les éléments contiennent la valeur null.
     * Précontidion : hauteur ≥ 0 et largeur ≥ 0
     * @param hauteur integer above 0
     * @param largeur integer above 0
     * */
    public Grille (int hauteur, int largeur) {
        assert hauteur >= 0 && largeur >= 0;
        this.hauteur = hauteur;
        this.largeur = largeur;
        tab = new String[hauteur][largeur];
    }

    // Accesseurs (getters)
    /**
     * @return number of lines in Grille
     */
    public int getHauteur() {
        return hauteur;
    }
    /**
     * @return number if columns in Grille
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Validité des coordonnées
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @return true seulement si lig (resp. col) est compris entre 1 et getHauteur() (resp. getlargeur())
     */
    public boolean coordCorrectes(int lig, int col) {
        return lig >= 1 &&
                col >= 1 &&
                lig <= this.getHauteur() &&
                col <= this.getLargeur();
    }

    /**
     * Pre : coordCorrectes(lig, col)
     * @return Valeur de la cellule ayant pour coordonnées (lig, col) */
    public String getCellule(int lig, int col) {
        if (coordCorrectes(lig,col)) {
            return tab[lig-1][col-1];
        }
        return "";
    }

    /**
     * Modification de la cellule de coordonnées (lig, col)
     * Précondition (assert) : coordCorrectes(lig, col)
     * @param lig Numéro de la ligne a insérer
     * @param col Numéro de la colone a insérer
     * @param ch  Contenu a insérer
     */
    public void setCellule(int lig, int col, String ch) {
        assert coordCorrectes(lig,col);
        tab[lig-1][col-1] = ch;
    }

    /**
     * Texte sur “hauteur” lignes, colonnes séparées par des |
     * @return La grille en entier sous forme d'un string avec des \n a la fin de chaque ligne
     */
    @Override
    public String toString() {
        String grilleString = "" ;

        for (String[] line : tab) {
            grilleString += "|";
            for (String cell : line) {
                grilleString += cell + "|";
            }
            grilleString += "\n";
        }
        return grilleString;
    }

    /**
     * Display Grille
     */
    public void printGrille() {
//        Print.printTab(tab);
    }

    /**
     * Fill the grille with random chars for test purposes
     */
    public void fillRandom() {
        Random randy = new Random();

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                tab[i][j] = Character.toString((char)(randy.nextInt(26)+65));
            }
        }

        /*for (String[] line : tab) {
            for (String cell : line) {
                cell = Character.toString((char)(randy.nextInt(26)+65));
            }
        }*/
    }
}
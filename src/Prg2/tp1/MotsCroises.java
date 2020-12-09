package Prg2.tp1;

public class MotsCroises {
    // Variables d’instance
    Grille solution,proposition,horizontal,vertical;
    int hauteur,largeur;

    /**Constructeur créant une instance de MotsCroises
     * dotée de 4 instances de Grille, suivant les
     * spécifications données ci-dessous :
     */
    public MotsCroises (int hauteur, int largeur) {
        solution    = new Grille(hauteur,largeur);
        proposition = new Grille(hauteur,largeur);
        horizontal  = new Grille(hauteur,largeur);
        vertical    = new Grille(hauteur,largeur);
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**Nombre de rangées
     * @return nombre de lignes de la grille*/
    public int getHauteur(){
        return hauteur;
    }

    /**Nombre de colonnes
     * @return nombre de colonnes de la grille*/
    public int getLargeur(){
        return largeur;
    }

    /**Validité des coordonnées, désignent une cellule existante de la grille
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

    // Accesseurs aux cases noires
    /**Test si une case est "noire"
     * Précondition (assert) : coordCorrectes(lig, col)
     * @return true si la case est null
     */
    public boolean estCaseNoire(int lig, int col) {
        assert coordCorrectes(lig,col);
        return solution.getCellule(lig, col) == null;
    }

    /** Défini une case comme noire ou blanche
     * Précondition (assert) : coordCorrectes(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @param noire true to set the case to black, false to set the case to white
     */
    public void setCaseNoire(int lig, int col, boolean noire) {
        assert coordCorrectes(lig,col);
        if (noire) {
            solution.setCellule(lig,col,null);
            proposition.setCellule(lig,col,null);
            horizontal.setCellule(lig,col,null);
            vertical.setCellule(lig,col,null);
        }
        else {solution.setCellule(lig,col,"");}
    }

    // Accesseurs à la grille de solution
    /** Donne le contenu d'une case de la grille solution
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @return Character in the requested position
     */
    public char getSolution(int lig, int col) {
        assert !estCaseNoire(lig,col);
        return solution.getCellule(lig,col).charAt(0);
    }

    /** Défini le contenu d'une case de la grille solution
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @param sol Char to write in the cell
     */
    public void setSolution(int lig, int col, char sol) {
        assert !estCaseNoire(lig,col);
        solution.setCellule(lig,col,Character.toString(sol));
    }

    // Accesseurs à la grille du joueur
    /** Donne le contenu d'une case de la grille du joueur (proposition)
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @return Character in the requested position
     */
    public char getProposition(int lig, int col) {
        assert !estCaseNoire(lig,col);
        return proposition.getCellule(lig,col).charAt(0);
    }

    /** Défini le contenu d'une case de la grille du joueur (proposition)
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @param prop Char to write in the cell
     */
    public void setProposition(int lig, int col, char prop) {
        assert !estCaseNoire(lig,col);
        proposition.setCellule(lig,col,Character.toString(prop));
    }

    // Accesseurs aux définitions.
    /** Donne le contenu d'une case de la grille du horizontale ou verticale en fonction du booléen horiz
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @param horiz true get value from horizontal, false get value from vertical
     * @return The definition stored in the cell
     */
    public String getDefinition(int lig, int col, boolean horiz) {
        assert !estCaseNoire(lig,col);
        if (horiz) {return horizontal.getCellule(lig, col);}
        return vertical.getCellule(lig, col);
    }

    /** Défini le contenu d'une case de la grille du horizontale ou verticale en fonction du booléen horiz
     *  Préconditions (assert) :
     *      coordCorrectes(lig, col)
     *      !estCaseNoire(lig, col)
     * @param lig Integer in the range of the tab [1..hauteur]
     * @param col Integer in the range of the tab [1..largeur]
     * @param horiz true set value from horizontal, false set value from vertical
     */
    public void setDefinition(int lig, int col, boolean horiz, String def) {
        assert !estCaseNoire(lig,col);
        if (horiz) {horizontal.setCellule(lig, col, def);}
        else {vertical.setCellule(lig,col,def);}
    }
}

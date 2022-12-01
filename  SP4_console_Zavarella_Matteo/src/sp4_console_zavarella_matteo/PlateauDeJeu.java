/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;

/**
 *
 * @author matte
 */
public class PlateauDeJeu {
    // attribut
    CelluleDeGrille[][] Grille = new CelluleDeGrille[6][7]; // tableau de 6 par 7 objets
    
    // Constructeur permetant de mettre un objet dans les grilles
    public PlateauDeJeu() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                Grille[lignes][colonnes] = new CelluleDeGrille();
            }
        }
    }
    
    //ajoute un jeton passé en paramètre dans la colonne dont l’indice est 
    //aussi passé en paramètre, sur la cellule vide la plus basse    
    public void ajouterJetonDansColonne(Jeton j, int a) {
        for (int i = 0; i<6; i++) {
            if (Grille[i][a].presenceJeton() == false) {
                Grille[i][a].affecterJeton(j);
                break;
            }
        }
    }
     
    public boolean grilleRemplie() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if (Grille[lignes][colonnes] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /*
    public void viderGrille(Joueur R, Joueur J) {
        for (int i = 0; i<6 ; i++) {
            for (int j = 0; j<7; j++) {
                Jeton jetontmp() = grille[i][j].recupererJeton();
                if (jetontmp.lireCouleur() == "Rouge") {
                    R.ajouterJeton();
                }
                else {
                    J.ajouterJeton();
                }
            }
        }
    }
    */
    
    // affiche la grille sur la console
    public void afficherGrilleSurConsole(){
        System.out.print("\n" + "|");
        for (int lignes = 5; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if ("rouge".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("R|");
                } 
                else if ("jaune".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("J|");
                } 
                else {
                    System.out.print("-|");
                }
            }
            if (lignes > 0) {
                System.out.print("\n|");
            } else {
                System.out.println("");
            }
        }
    }
    
    // renvoie true si la cellule de coordonnées [x][y] est occupée par un jeton, et false sinon.  
    public boolean presenceJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne] != null;
    }

    
    //renvoie la couleur du jeton de la cellule ciblée par les coodonnées
    public String lireCouleurDuJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].lireCouleurDuJeton();
    }
    
    // methode principal qui va renvoyer un boolean pour savoir qui à gagné
    public boolean etreGagnantePourCouleur(String z) {
        if (ligneGagnantePourCouleur(z) == true || colonneGagnantePourCouleur(z) == true || diagonaleMontanteGagnantePourCouleur(z) == true || diagonaleDescendanteGagnantePourCouleur(z) == true) {
            return true;
        }
        else {
            return false;
        }
    }
    // methode nous permettant de verifier si le joueur à 4 jetons aligné  
    public boolean ligneGagnantePourCouleur(String z) {
        int cpt = 0;
        boolean res = false;
        for (int i = 0; i<6; i++) {
            for (int j = 0; j<7; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == z) {
                    cpt += 1;
                    if (cpt == 4) {
                        res = true;                       
                        return res;                        
                    }
                }
                else {
                    cpt = 0;
                }
            }
        }
        return res;
    }
    // methode nous permettant de verifier si le joueur à 4 jetons aligné en colonne
    public boolean colonneGagnantePourCouleur(String z) {
        int cpt = 0;
        boolean res = false;
        for (int j = 0; j<7; j++) { // booucle for imbriqué l'une dans l'autre
            for (int i = 0; i<6; i++) {
                if (Grille[i][j].lireCouleurDuJeton() == z) {
                    cpt += 1;
                    if (cpt == 4) {
                        res = true;                       
                        return res;                        
                    }
                }
                else {
                    cpt = 0;
                }
            }
        }
        return res;

        
    }
     // methode nous permettant de verifier si le joueur à 4 jetons aligné en diagonal montante
    public boolean diagonaleMontanteGagnantePourCouleur(String z) {
        boolean res = false;
        for (int i = 3; i<6; i++) {
            for (int j = 0; j<4; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == z) {
                    if (Grille[i-1][j+1].lireCouleurDuJeton() == z && Grille[i-2][j+2].lireCouleurDuJeton() == z && Grille[i-3][j+3].lireCouleurDuJeton() == z) {
                        res = true;
                        return res;
                    }
                }
            }
        }
        return res;
    }
    // methode nous permettant de verifier si le joueur à 4 jetons aligné en diagonal Descendante
    public boolean diagonaleDescendanteGagnantePourCouleur(String z) {
        boolean res = false;
        for (int i = 3; i<6; i++) {
            for (int j = 3; j<7; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == z) {
                    if (Grille[i-1][j-1].lireCouleurDuJeton() == z && Grille[i-2][j-2].lireCouleurDuJeton() == z && Grille[i-3][j-3].lireCouleurDuJeton() == z){
                        res = true;
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public boolean colonneRemplie(int a) {
        boolean res = true;
        for (int i = 0; i<6; i++) {
            if (Grille[i][a-1].presenceJeton() == false) {
                res = false;
                return res;
            }
        }
        return res;
    }
}

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
    public boolean ajouterJetonDansColonne(Jeton unJeton, int unecolonne) {
        for (int i = 0; i < 6; i++) {
            if (Grille[i][unecolonne].affecterJeton(unJeton) == true) {
                return true;
            }
        }
        return false;
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
    
    // vide la grille et redistribut les jetons aux joueurs
    public void viderGrille() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                Grille[lignes][colonnes] = null;
            }
        }
    }
    
    // affiche la grille sur la console
    public void afficherGrilleSurConsole(){
        System.out.print("\n" + "|");
        for (int lignes = 5; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if ("R".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("R|");
                } 
                else if ("J".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
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
    public boolean celluleOccupee(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne] != null;
    }
    
    //renvoie la couleur du jeton de la cellule ciblée par les coodonnées
    public String lireCouleurDuJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].lireCouleurDuJeton();
    }

    
}

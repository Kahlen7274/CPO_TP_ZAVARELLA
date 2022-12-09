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
    public boolean ajouterJetonDansColonne(Jeton j, int a) {
        for (int i = 0; i<6; i++) {
            if (Grille[i][a].presenceJeton() == false) {
                Grille[i][a].affecterJeton(j);
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
    
    
    public void viderGrille(joueur R, joueur J) {
        for (int i = 0; i<6 ; i++) {
            for (int j = 0; j<7; j++) {
                Jeton jetontmp = Grille[i][j].recupererJeton();
                if (jetontmp != null) {
                    if (jetontmp.lireCouleur() == "rouge") {
                        R.ajouterJeton(jetontmp);
                    }
                    else {
                        J.ajouterJeton(jetontmp);
                    }
                }
            }
        }
    }
    
    
    // affiche la grille sur la console
   
     public void afficherGrilleSurConsole() {
        System.out.print("\n" + "|");
        for (int lignes = 5; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if ("rouge".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("R|");
                } else if ("jaune".equals(Grille[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("J|");
                } else if (Grille[lignes][colonnes].presenceTrouNoir() == true) {
                    System.out.print("@|");
                } else if (Grille[lignes][colonnes].presenceDesintegrateur() == true) {
                    //if(CellulesJeu[lignes][colonnes].presenceTrouNoir()==true){

                    // }
                    System.out.print("D|");
                } else {
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
                if (Grille[i][j].lireCouleurDuJeton().equals(z)) {
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
                if (Grille[i][j].lireCouleurDuJeton().equals(z)) {
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
                if (Grille[i][j].lireCouleurDuJeton().equals(z)) {
                    if (Grille[i-1][j+1].lireCouleurDuJeton().equals(z) && Grille[i-2][j+2].lireCouleurDuJeton().equals(z) && Grille[i-3][j+3].lireCouleurDuJeton().equals(z)) {
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
                if (Grille[i][j].lireCouleurDuJeton().equals(z)) {
                    if (Grille[i-1][j-1].lireCouleurDuJeton().equals(z) && Grille[i-2][j-2].lireCouleurDuJeton() == z && Grille[i-3][j-3].lireCouleurDuJeton() == z){
                        res = true;
                        return res;
                    }
                }
            }
        }
        return res;
    }
    
    // lorsqu’un jeton est capturé ou détruit, décale d’une ligne vers le bas les jetons situés au dessus de la cellule libérée.
    public void tasserColonne(int unecolonne) {
        int lignes = 0;
        while (Grille[lignes][unecolonne].jetonCourant != null) {
                lignes++;
            
        }
        for (int i = lignes; i < 5; i++) {
            Grille[i][unecolonne].jetonCourant = Grille[i + 1][unecolonne].jetonCourant;
            Grille[i+1][unecolonne].jetonCourant = null;
        }
        Grille[5][unecolonne].jetonCourant = null;
    }
    
    public void tasserGrille(){
        for(int i = 0; i<7 ;i++){
            tasserColonne(i);
        }
    }
    
    // renvoie true si la colonne dont l’indice est passé en paramètre est remplie
    public boolean colonneRemplie(int a) {
        boolean res = true;
        for (int i = 0; i<6; i++) {
            if (Grille[i][a].presenceJeton() == false) {
                res = false;
                return res;
            }
        }
        return res;
    }
    
    // Cette méthode appelle tout simplement la méthode presenceTrouNoir() de l’objet CelluleDeGrille
    public boolean presenceTrouNoir(int m, int z) {
        return Grille[m-1][z-1].presenceTrouNoir() == true;
    }
    
    // Cette méthode appelle tout simplement la méthode presenceTrouNoir() de l’objet CelluleDeGrille présent sur la grille aux coordonnées [x][y].
    public boolean placerTrouNoir(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].placerTrouNoir();
    }
    
    // supprime un trou noir à l’endroit indiqué
    public boolean suppprimerTrouNoir(int x, int y) {
        boolean res = false;
        if (Grille[x][y].presenceTrouNoir() == true) {
            Grille[x][y].supprimerTrouNoir();
            res = true;
            System.out.println("Trou noir, jeton absorbé");
            return res;
        }
        return res;
    }
    
    // ajoute un désintégrateur à l’endroit indiqué.
    public boolean placerDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].placerDesintegrateur();
    }
    
    // supprime un désintégrateur à l’endroit indiqué
    public boolean supprimerDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].supprimerDesintegrateur();
    }

    // retourne true si la cellule dont les coordonnées sont passées en paramètre contient un désintegrateur, et false sinon
    public boolean précenseDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].presenceDesintegrateur();
    }

    // supprime le jeton de la cellule visée
    public boolean supprimerJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].supprimerJeton();
    }

    // enlève le jeton de la cellule visée et renvoie une référence vers ce jeton.
    public Jeton recupererJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].recupererJeton();
    }
}

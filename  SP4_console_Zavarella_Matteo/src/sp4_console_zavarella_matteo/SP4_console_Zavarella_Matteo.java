/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_zavarella_matteo;

/**
 *
 * @author matte
 */
public class SP4_console_Zavarella_Matteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Test méthode Jeton
        Jeton j1 = new Jeton("rouge");
        Jeton j2 = new Jeton("rouge");
        Jeton j3 = new Jeton("Jaune");
        Jeton j4 = new Jeton("rouge");
        Jeton j5 = new Jeton("Jaune");
        Jeton j6 = new Jeton("rouge");
        System.out.println(j1);
        
        // Création d'un tableau de 42 case vide
        PlateauDeJeu grille = new PlateauDeJeu();
        
        // test ajout de jeton
        grille.ajouterJetonDansColonne(j1, 4);
        grille.ajouterJetonDansColonne(j2, 4);
        grille.ajouterJetonDansColonne(j4, 4);
        grille.ajouterJetonDansColonne(j6, 4);
        grille.afficherGrilleSurConsole();
        
       
        // Test de grille remplie
        boolean r = grille.colonneRemplie(2);

        if (r == true) {
            System.out.println("colonne remplie");
        }
        else {
            System.out.println("Colonne pas remplie");
        }

        grille.afficherGrilleSurConsole();
        

        // test methode être gagnant
        boolean k = grille.etreGagnantePourCouleur("rouge");
        
        if (k ==true) {
            System.out.println("Winner");
        }
        else {
            System.out.println("looser");
        }
      
        
    }
    
   
    
}

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
        System.out.println(j1);
        
        // Création d'un tableau de 42 case vide
        PlateauDeJeu grille = new PlateauDeJeu();
        
        // test ajout de jeton
        grille.ajouterJetonDansColonne(j1, 5);
        grille.afficherGrilleSurConsole();
    }
    
}

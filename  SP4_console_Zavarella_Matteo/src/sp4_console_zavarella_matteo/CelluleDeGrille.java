/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;

/**
 *
 * @author matte
 */
public class CelluleDeGrille {
    // attribut de la classe
    private Jeton jetonCourant;
      //boolean TrouNoir;
      //boolean Desintegrateur;
    
    // Constructeur
    public CelluleDeGrille(){
        jetonCourant = null;
        //TrouNoir = false;
        //Desintegrateur = false;
    }
    
    // Teste la présence des jetons 
    public boolean affecterJeton(Jeton Jeton){ // affecte le jeton en paramètre ou retourne faux si cellule pleine 
        if (jetonCourant == null) {
            jetonCourant = Jeton;
            return true;
        } 
        else {
            System.out.print("Cellule pleine");
            return false;
        }
    }
    
    // renvoie la couleur du joueur 
    public String lireCouleurDuJeton(){
        if (jetonCourant == null) {
            return "vide";
        } 
        else {
            return jetonCourant.lireCouleur();
        }
    }

    public Jeton recupererJeton() {
        return jetonCourant;
    }
    
}

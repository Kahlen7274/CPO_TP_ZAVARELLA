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
      //private boolean TrouNoir;
      //private boolean Desintegrateur;
    
    // Constructeur
    public CelluleDeGrille(){
        jetonCourant = null;
        //TrouNoir = false;
        //Desintegrateur = false;
    }
    
    // verifie si la cellule est pleine   
    public boolean presenceJeton() {
        if (jetonCourant == null) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void affecterJeton(Jeton J) {
        jetonCourant = J;
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
        if(jetonCourant != null){
            Jeton x = jetonCourant;
            jetonCourant = null;
            return x;
        }
        else{
            return (null);
        }
    }
    
}

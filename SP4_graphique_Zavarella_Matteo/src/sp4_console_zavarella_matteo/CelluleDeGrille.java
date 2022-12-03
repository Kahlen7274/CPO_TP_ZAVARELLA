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
    
    Jeton jetonCourant;
    private boolean TrouNoir;
    private boolean Desintegrateur;
    
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
    
    // méthode qui place les troues noir
    public boolean placerTrouNoir() {
        if (TrouNoir == false) {
            TrouNoir = true;
            //System.out.println("Ajout de Trou Noir effectuÃ©");
            return true;
        } else {
            //System.out.println("Trou Noir deja present");
            return false;
        }
    }
    
    // Teste la présence des troues Noir 
    public boolean presenceTrouNoir() {
        if (TrouNoir == false) {
            return false;
        } else {
            return true;
        }
    }
    
    public void supprimerTrouNoir() {
        TrouNoir = false;
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
    
    // Supprime le jeton visé 
    public boolean supprimerJeton() {
        if (jetonCourant == null) {
            //System.out.print("Jeton innexistant");
            return false;
        } else {
            jetonCourant = null;
            return true;
        }
    }
    
    // méthode qui place les désintégrateurs 
    public boolean placerDesintegrateur() {
        if (Desintegrateur == false) {
            Desintegrateur = true;
            //System.out.println("Ajout du desintegrateur effectué");
            return true;
        } else {
            //System.out.println("desintegrateur deja present");
            return false;
        }

    }
    
    // teste la présence des désintégrateurs 
    public boolean presenceDesintegrateur() {
        if (Desintegrateur == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean recupererDesintegrateur() {
        if(Desintegrateur == false){
            return false;
        }
        else{
            Desintegrateur = false;
            return true;
        }
    }
    // supprime le désintégrateur présent de la cellule
    public boolean supprimerDesintegrateur() {
        if (Desintegrateur == true) {
            Desintegrateur = false;
            //System.out.println("Suppression du desintegrateur effectué");
            return true;
        } else {
            //System.out.println("pas de desintegrateur present");
            return false;
        }
    }
    
    // passe un troue noir en actif 
    public boolean activerTrouNoir() {
        if (TrouNoir == true) {
            jetonCourant = null; // vide la cellule
            TrouNoir = false; // disparition du Trou Noir
            //System.out.println("Activation du Trou Noir");
            return true;
        } else {
            //System.out.println("Pas de Trou Noir dans cette cellule");
            return false;
        }
    }
    
    @Override
    public String toString() {
        if (this.presenceJeton() == true) {
            if (this.jetonCourant.lireCouleur() == "rouge") {
                return "R";
            }
            else {
                return "J";
            }
        }
        if (this.TrouNoir == true) {
            return "@";
        }
        if (this.Desintegrateur == true && this.TrouNoir == false) {
            return "D";
        }
        else {
            return ".";
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;
import java.util.ArrayList;

/**
 *
 * @author matte
 */
public class joueur {
    
    // attribut de la class
    private String nom;
    String couleur;
    ArrayList<Jeton> reserveJeton = new ArrayList<Jeton>(); // tableau dynamique de jeton
    int nombreJetonRestants = reserveJeton.size(); // on recupère sa taille
    //int nombreDesintegrateurs;
    
    // Constructeur
    public joueur(String jo) {
        nom = jo;
    }
    
    // affecte couleur passé en paramètre 
    public void affecterCouleur(String a) {
        couleur = a;
    }
    
    // ajoute le jeton passé en paramètre à la réserve de jetons
    public void ajouterJeton(Jeton jeton) {
        reserveJeton.add(jeton);
    }
    
   
    @Override
    public String toString() {
        return this.nom;
    }
    
}

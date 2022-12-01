/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author matte
 */
public class Partie {
    
    // Attribut
    joueur[] ListeJoueurs = new joueur[2]; // tableau de joueur (ligne)
    joueur joueurCourant = ListeJoueurs[0];
    PlateauDeJeu plateau = new PlateauDeJeu(); //creation d'objet
    
    // constructeur
    public Partie(joueur joueur1, joueur joueur2) {
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        joueurCourant = null;
    }
    
    // méthode qui distribue une couleur aléatoire aux deux joueurs, rouge ou jaune
    public void attribuerCouleursAuxJoueurs() {
        // couleur Jaune attribué à 0
        // couleur Jaune attribué à 1 
        Random r = new Random();
        int n = r.nextInt(1);
        if (n == 0) {
            ListeJoueurs[0].couleur = "jaune";
            ListeJoueurs[1].couleur = "rouge";
        } else {
            ListeJoueurs[0].couleur = "rouge";
            ListeJoueurs[1].couleur = "jaune";
        }
    }
    
    
   
}

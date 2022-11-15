/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heritage.classe.abstraite.pkginterface;

/**
 *
 * @author matte
 */
public class Personnage {
    
    // On définit les attributs de la classe BouteilleBiere
    String Nom;
    int Vie;
    
    public Personnage(String unNom, int nvVie) {
        // Ajout du constructeur
           Nom = unNom;
           Vie = nvVie;
 
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = "personnage: "+ Nom + "\n" + "niveau de vie: " + Vie;
        return chaine_a_retourner ;
    }
    
}

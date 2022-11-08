package tp3_heritage.classe.abstraite.pkginterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matte
 */
public class Arme {
    
    // On définit les attributs de la classe BouteilleBiere
    String Nom;
    int ATQ;
    
    public Arme(String unNom, int nivATQ) {
        // Ajout du constructeur
        Nom = unNom;
        ATQ = nivATQ;
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = Nom + " de niveau: " + ATQ;
        return chaine_a_retourner ;
    }
    
}

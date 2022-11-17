package Armes;
import Personnage.Personnage;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matte
 */
public class Arme {
    
    // On définit les attributs de la classe Arme
    public String Nom;
    int ATQ;
    public Personnage proprietaire;

    public int getLvlATQ() {
        return ATQ;
    }
    
    // methode permettant de modifier la valeur de l'attaque
    public void set_ATQ(int nvATQ) {
        if (nvATQ < 0) {
            this.ATQ = 0;
        }
        else if(nvATQ > 100) {
            this.ATQ = 100;
        }
        else {
            this.ATQ = nvATQ;
        }
    }
     
    // Constructeur
    public Arme(String unNom, int nvATQ) {
        Nom = unNom;
        ATQ = nvATQ;
    }
    
      
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = Nom + " de niveau: " + ATQ;
        return chaine_a_retourner ;
    }
    
}

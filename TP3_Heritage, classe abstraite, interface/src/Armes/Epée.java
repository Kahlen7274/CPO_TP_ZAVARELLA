/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

import Armes.Arme;

/**
 *
 * @author matte
 */
public class Epée extends Arme{
    int finesse;
    
     public int getFinesse() {
        return finesse;
    }
    
    public Epée(String nom, int ATQ, int f){
        super(nom, ATQ);
        if(f > 100) this.finesse = 99;
        else this.finesse = f;
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = "Epee " + Nom + " de niveau " + ATQ + " et de finesse " + finesse;
        return chaine_a_retourner ;
    }
}

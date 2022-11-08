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
public class Baton extends Arme{
    int age;
    
    public Baton(String nom, int ATQ, int a){
        super(nom, ATQ);
        if(a > 100) age = 99;
        else age = a;
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = "Baton " + Nom + " de niveau " + ATQ + " et d'age " + age;;
        return chaine_a_retourner ;
    }
}

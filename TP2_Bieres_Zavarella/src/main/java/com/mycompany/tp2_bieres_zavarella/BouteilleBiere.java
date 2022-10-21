/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2_bieres_zavarella;
/**
 *
 * @author matte
 */
public class BouteilleBiere {
    // On définit les attributs de la classe BouteilleBiere
    String Nom;
    Double degreAlcool;
    String brasserie;
    Boolean ouverte;

    
public void lireEtiquette(){
    System.out.println("Bouteille de " + Nom + " (" + degreAlcool + "degres) \nBrasserie : " + brasserie);
}  

public void Décapsuler(){
    if (ouverte == true) {
        System.out.println("La biere est déjà ouverte");
    }
    if (ouverte == false ) {
        ouverte = true;
        System.out.println("La biere a été ouverte");
    }
}

public BouteilleBiere(String unNom, double unDegre, String uneBrasserie) {
    Nom = unNom;
    degreAlcool = unDegre;
    brasserie = uneBrasserie;
    ouverte = false;
    
}
@Override

public String toString() {
    String chaine_a_retourner ;
    chaine_a_retourner = Nom + " (" + degreAlcool + " degres) Ouverte ?";
    if (ouverte == true) chaine_a_retourner += "oui" ;
    else chaine_a_retourner += "non";
    return chaine_a_retourner ;
    
}
}


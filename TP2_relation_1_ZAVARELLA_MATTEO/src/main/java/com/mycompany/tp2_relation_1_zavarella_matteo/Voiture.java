package com.mycompany.tp2_relation_1_zavarella_matteo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matte
 */
public class Voiture {
    
    // On défini les attributs
    String modele;
    String marque;
    int PuissanceCV;
    Personne Proprietaire;

    // Méthode permettant de créer un objet et initialiser ses paramètres en une ligne
    public Voiture(String mod, String mar, int CV) {
        
        modele = mod;
        marque = mar;
        PuissanceCV = CV;
        Proprietaire = null;
    }

    // Méthode permettant de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
    @Override
    public String toString() {
        
        String a;
        a = "\nmodele: "+  modele +"\nmarque: " +  marque + "\nnbCV: " +  PuissanceCV ;
        return a ;
    }
    
}

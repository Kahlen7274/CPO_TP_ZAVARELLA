package com.mycompany.tp2_relation_1_zavarella_matteo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matte
 */
public class Personne {
    
    // On défini les attributs
    String nom;
    String prenom;
    int nbVoitures ;
    Voiture [] liste_voitures ;

    // Méthode permettant de créer un objet et initialiser ses paramètres en une ligne
    public Personne(String surname, String name) {       
        nom = surname;
        prenom = name;
        liste_voitures = new Voiture [3] ; // réserve la mémoire du tableau
        nbVoitures = 0; 
    }
 
    // Méthode qui renvoit un booléen indiquant si l’ajout s’est bien passé ou pas.
    public boolean ajouter_voiture (Voiture voiture_a_ajouter){       
        if (voiture_a_ajouter.Proprietaire == null){
            return true; 
        }  
        else{
            return false;
        }
    } 

    @Override
    public String toString() {
        return null;
     }    
}

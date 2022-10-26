/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp2_relation_1_zavarella_matteo;

/**
 *
 * @author matte
 */
public class TP2_relation_1_ZAVARELLA_MATTEO {

    public static void main(String[] args) {
        
        // Création et manipulation des objets
        
        Voiture uneClio = new Voiture ("Clio", "Renault", 5 ) ;
        Voiture uneAutreClio = new Voiture ("Clio", "Renault", 5 ) ;
        Voiture une2008 = new Voiture ("2008", "Peugeot", 6 ) ;
        Voiture uneMicra = new Voiture ("Micra", "Nissan", 4 ) ;
        
        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno = new Personne("Reno", "Raines");
        
        // Affichage 
        System.out.println("liste des voitures disponibles "+ uneClio + 
                "\n" + uneAutreClio + "\n" + une2008 + "\n" + uneMicra ) ;

        System.out.println("\n");
        
        // Bob est propriétaire d’une Clio
        bob.liste_voitures[0] = uneClio ;

        if (bob.ajouter_voiture(uneClio)==true){
            bob.nbVoitures+= 1 ;
            uneClio.Proprietaire = bob ;
            System.out.println("la premiere voiture de Bob est " + bob.liste_voitures[0]) ;
        }
        else{
            bob.liste_voitures[0]= null;
            System.out.println("cette voiture a deja un proprietaire");
        }

        System.out.println("\n");
        
        // Bob est propriétaire d'une 2008
        bob.liste_voitures[1] = une2008 ;
        
        if (bob.ajouter_voiture(une2008)==true){
            bob.nbVoitures+= 1 ;
            une2008.Proprietaire = bob ;
            System.out.println("la deuxieme voiture de Bob est " + bob.liste_voitures[1] ) ;
        }
        else{
            bob.liste_voitures[1]= null;
            System.out.println("cette voiture a deja un proprietaire");
        }   
        
        System.out.println("\n");
        
        // Reno est propriétaire d'une 2008
        reno.liste_voitures[0] = une2008 ;
        
        if (reno.ajouter_voiture(une2008)==true){
            reno.nbVoitures = 1 ;
            une2008.Proprietaire = reno ;
            System.out.println("la premiere voiture de reno est " + reno.liste_voitures[0] ) ;
        }
        else{
            reno.liste_voitures[0]=null;
            System.out.println("cette voiture a deja un proprietaire");
        }

        System.out.println("\n");
        
        // Reno est propriétaire d'une micra
        reno.liste_voitures[1] = uneMicra ;
        
        if (reno.ajouter_voiture(uneMicra)==true){
            reno.nbVoitures = 2 ;
            uneMicra.Proprietaire = reno ;
            System.out.println("la deuxieme voiture de reno est " + reno.liste_voitures[1] ) ;
        }
        else{
            reno.liste_voitures[1]=null;
            System.out.println("cette voiture a deja un proprietaire");
        }
    }
}   


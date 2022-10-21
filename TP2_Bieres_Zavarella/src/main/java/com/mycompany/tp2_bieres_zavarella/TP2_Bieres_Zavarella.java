/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp2_bieres_zavarella;

/**
 *
 * @author matte
 */
public class TP2_Bieres_Zavarella {

    public static void main(String[] args) {
        
       BouteilleBiere uneBiere = new BouteilleBiere();
       uneBiere.Nom = "Cuvee des Trolls";
       uneBiere.degreAlcool = 7.0;
       uneBiere.brasserie = "Dubuisson";
       uneBiere.ouverte = false;
       
       
       BouteilleBiere uneBiere2 = new BouteilleBiere();
       uneBiere2.Nom = "leffe";
       uneBiere2.degreAlcool = 6.6;
       uneBiere2.brasserie = "Abbaye de Leffe";
       uneBiere2.ouverte = false;
       uneBiere2.lireEtiquette();
       
    }
}

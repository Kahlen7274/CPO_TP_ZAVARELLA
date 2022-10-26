/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp2_manip_zavarella_matteo;

/**
 *
 * @author matte
 */
public class TP2_manip_ZAVARELLA_MATTEO {

    public static void main(String[] args) {
        
        // On crée des tartiflettes
        Tartiflette assiette1 = new Tartiflette(500);
        Tartiflette assiette2 = new Tartiflette(600);       
        Tartiflette assiette3 = assiette2 ; 
        
        // On affiche le nombre de calories
        System.out.println("nb de calories de Assiette 1 : " + assiette1.nbCalories);
        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
        System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);
        
        
        // On crée un tableau de 10 références de Moussaka
        Moussaka[] tab;
        tab = new Moussaka[10];
        for (int i = 1; i <= 10; i++) {
            tab[i] = new Moussaka(i);

        }
    }
}

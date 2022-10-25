/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp1_convertisseur_zavarella_matteo;

import java.util.Scanner;

/**
 *
 * @author matte
 */
public class TP1_convertisseur_ZAVARELLA_MATTEO {
    //création de la classe Scanner
    static Scanner sc = new Scanner(System.in);
            

    public static void main(String[] args) {
        
        // Affichage utilisateur
        System.out.println("Entrer une temperature: ");
        Double Temp = sc.nextDouble(); // Stock la valeur saisie
        
        // Appelle de la classe convertisseur
        Convertisseurtemp TempConv = new Convertisseurtemp();
        //TempConv.CelsiusVersKelvin(Temp);
        //TempConv.FahrenheitVersCelsius(Temp);
        //TempConv.CelsiusVersFahrenheit(Temp);
        //TempConv.KelvinVersFahrenheit(Temp);
        //TempConv.FahrenheitVersKelvin(Temp);
         
    }
}

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
        System.out.println("""
                           Saisissez la conversion que vous souhaiter effectuer : 
                            1) De Celsius vers Kelvin 
                            2) De Kelvin vers Celsius 
                            3) De Farenheit vers Kelvin
                            4) De Kelvin vers Fahrenheit
                            5) De Fahrenheit vers Celsius
                            6) De Celsius vers Fahrenheit
                           """);
        int Conv = sc.nextInt();
        
        // Appelle de la classe convertisseur
        Convertisseurtemp TempConv = new Convertisseurtemp();
             
        // Condition de conversion et choix utilisateur
        
        if (Conv == 1){
           double k;
           k = TempConv.CelsiusVersKelvin(Temp);
           System.out.println(Temp + " degré celsius est égal à " + k +" degré kelvin");
        }
        
        if (Conv == 2){
            double c;
            c = TempConv.KelvinVersCelsius(Temp);
            System.out.println(Temp + " degré kelvin est égal à " + c +" degré celsius");
        }
        
        if (Conv == 3){
           double k;
           k = TempConv.FahrenheitVersKelvin(Temp);
           System.out.println(Temp + " degré fahrenheit est égal à " + k +" degré kelvin");
        }
        
        if (Conv == 4){
           double f;
           f = TempConv.KelvinVersFahrenheit(Temp);
           System.out.println(Temp + " degré kelvin est égal à " + f +" degré fahrenhiet");
        }
        
        if (Conv == 5){
           double c;
           c = TempConv.FahrenheitVersCelsius(Temp);
           System.out.println(Temp + " degré fahrenheit est égal à " + c +" degré celsius");
        }
        
        if (Conv == 6){
           double f;
           f = TempConv.CelsiusVersFahrenheit(Temp);
           System.out.println(Temp + " degré celsius est égal à " + f +" degré fahrenheit");
        }
        
        // Affichage de la variable compteur
        String Comp;
        Comp = TempConv.toString();
        System.out.println(Comp);
        
        //TempConv.CelsiusVersKelvin(Temp);
        //TempConv.FahrenheitVersCelsius(Temp);
        //TempConv.CelsiusVersFahrenheit(Temp);
        //TempConv.KelvinVersFahrenheit(Temp);
        //TempConv.FahrenheitVersKelvin(Temp);
         
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_convertisseur_zavarella_matteo;

/**
 *
 * @author matte
 */
public class Convertisseurtemp {
    
    public double CelciusVersKelvin (double tCelcius){ 
        // Methode pour convertir les Celcius en Kelvin
            double K = tCelcius + 273.15;
            System.out.println("Votre temperature en Kelvin est: " + K);
            return K;
        }
    
}

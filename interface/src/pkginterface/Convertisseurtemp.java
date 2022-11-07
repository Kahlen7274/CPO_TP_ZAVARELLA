/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp1_convertisseur_zavarella_matteo;

/**
 *
 * @author matte
 */
// Création de la classe convertisseurtemp
public class Convertisseurtemp { 
    
    // Crétions de la variable compteur dans le constructeur
    public int nbConversion;
    public Convertisseurtemp (){
        nbConversion = 0;
    }
    
    // Methode qui retourne le nombre de conversions effectuées
    @Override
    public String toString() {
        return "nb de conversions " + nbConversion; 
    }
    
    // Methode pour convertir Kelvin en Celsius   
    public double CelsiusVersKelvin(double tCelsius) {
        double K = tCelsius + 273.15;
        System.out.println("Votre temperature en Kelvin est: " + K);
        nbConversion = nbConversion + 1;
        return K;
    }
    
    // Methode pour convertir Celsius en Kelvin
    public double KelvinVersCelsius(double tKelvin) {
        double C = tKelvin - 273.15;
        System.out.println("Votre temperature en Kelvin est: " + C);
        nbConversion = nbConversion + 1;
        return C;
    }

    // Methode pour convertir Fahrenheit en Celsius
    public double FahrenheitVersCelsius(double tFahrenheit) {
        double C = (tFahrenheit - 32) * 5 / 9;
        System.out.println("Votre temperature en Celsius est: " + C);
        nbConversion = nbConversion + 1;
        return C;
    }

    // Methode pour convertir Celcius en Fahrenheit
    public double CelsiusVersFahrenheit(double tCelsius) {
        double F = (tCelsius * 9 / 5) + 32;
        System.out.println("Votre temperature en Fahrenheit est: " + F);
        nbConversion = nbConversion + 1;
        return F;
    }

    // Methode pour convertir Kelvin en Fahrenheit
    public double KelvinVersFahrenheit(double tKelvin) {
        double F = (tKelvin - 273.15) * 9 / 5 + 32;
        System.out.println("Votre temperature en Fahrenheit est: " + F);
        nbConversion = nbConversion + 1;
        return F;
    }

    // Method to convert Fahrenheit to Kelvin
    public double FahrenheitVersKelvin(double tFahrenheit) {
        double K = (tFahrenheit - 32) * 5 / 9 + 273.15;
        System.out.println("Votre temperature en Kelvin est: " + K);
        nbConversion = nbConversion + 1;
        return K;
    }
}

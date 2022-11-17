/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnage;

/**
 *
 * @author matte
 */
public class Guerrier extends Personnage{
    
    String t;
    
    public Guerrier(String nom, int Vie, boolean a){
        super(nom, Vie);
        
        if(a == true){
           t = "à cheval"; 
        }
        else{
            t = "à pied";
        }
        
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        if (this.Arme_en_main == null) {
            chaine_a_retourner = "Guerrier: "+ Nom + "\n" + "niveau de vie: " + Vie + "\n" + t;
            return chaine_a_retourner ;
        }
        else{
            chaine_a_retourner = "Guerrier: "+ Nom + "\n" + "niveau de vie: " + Vie + "\n" + t + "\n" + "Armement: " + Arme_en_main;
            return chaine_a_retourner ;    
        }
    }    
}

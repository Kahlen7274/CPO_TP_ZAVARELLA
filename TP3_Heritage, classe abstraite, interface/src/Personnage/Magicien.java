/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnage;


/**
 *
 * @author matte
 */
public class Magicien extends Personnage{
    
    String a;
    
    public Magicien(String nom, int Vie, boolean c){
        super(nom, Vie);
        
        if(c == true){
           a = "confirme"; 
        }
        if(c == false){
            a = "novice";
        }
        
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        if (this.Arme_en_main == null) {
            chaine_a_retourner = "Magicien: "+ Nom + "\n" + "niveau de vie: " + Vie + "\n" + a;
            return chaine_a_retourner ;
        }
        else{
            chaine_a_retourner = "Magicien: "+ Nom + "\n" + "niveau de vie: " + Vie + "\n" + a + "\n" + "équipement: " + Arme_en_main;
            return chaine_a_retourner ;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heritage.classe.abstraite.pkginterface;

/**
 *
 * @author matte
 */
public class Guerrier extends Personnage{
    
    boolean Acheval;
    
    public Guerrier(String nom, int Vie, boolean a){
        super(nom, Vie);
        
        if(a = true){
           Acheval = a; 
        }
        else{
            Acheval = a;
        }
        
    }
    
    @Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = "Guerrier: "+ Nom + "\n" + "niveau de vie: " + Vie + "\n" + "A cheval: " + Acheval;
        return chaine_a_retourner ;
    }
    
}

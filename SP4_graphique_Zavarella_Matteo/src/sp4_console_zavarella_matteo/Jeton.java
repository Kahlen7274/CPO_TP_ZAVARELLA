package sp4_console_zavarella_matteo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matte
 */
public class Jeton {
    // On définit les attributs
    
    String couleur; // variable qui permet de renvoyer la couleur jaune ou rouge
    
    // Constructeur
    public Jeton(String unecouleur){
        couleur = unecouleur;
    }
    
    // renvoi la couleur du jeton
    public String lireCouleur(){
        return couleur;
    }
     
    @Override
    // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
    public String toString() {
        String chaine_a_retourner ;
        if (couleur == "rouge"){
            chaine_a_retourner = "R";
            return chaine_a_retourner;
        }
        else{
            chaine_a_retourner = "J";
            return chaine_a_retourner;
        }
    }       
}

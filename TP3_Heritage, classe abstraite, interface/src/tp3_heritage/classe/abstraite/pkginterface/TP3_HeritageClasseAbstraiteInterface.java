/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3_heritage.classe.abstraite.pkginterface;

/**
 *
 * @author matte
 */
import java.util.ArrayList; // import la classe arraylist

public class TP3_HeritageClasseAbstraiteInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Epée arme1 = new Epée("Excalibur", 7,5);
        //System.out.println(arme1);
        
        Epée arme2 = new Epée("Durandal", 4,7);
        //System.out.println(arme2);
        
        Baton arme3 = new Baton("Chene",4,5);
        //System.out.println(arme3);
        
        Baton arme4 = new Baton("Charme",5,6);
        //System.out.println(arme4);
        
        
        ArrayList<Arme> Tab = new ArrayList<Arme>();
        Tab.add(arme1);
        Tab.add(arme2);
        Tab.add(arme3);
        Tab.add(arme4);
        System.out.println(Tab);
        
        int tailleDeTab = Tab.size(); // on récupère la taille          
        System.out.println("la taille de Tab est " + tailleDeTab); 
        
    }
    
}

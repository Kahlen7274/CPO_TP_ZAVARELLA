/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heritage.classe.abstraite.pkginterface;

/**
 *
 * @author matte
 */
public class Baton extends Arme{
    int age;
    
    public Baton(String nom, int ATQ, int a){
        super(nom, ATQ);
        if(a > 100) age = 99;
        else age = a;
    }
    
}

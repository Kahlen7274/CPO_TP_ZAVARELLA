/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heritage.classe.abstraite.pkginterface;

/**
 *
 * @author matte
 */
public class Epée extends Arme{
    int finesse;
    
    public Epée(String nom, int ATQ, int f){
        super(nom, ATQ);
        if(f > 100) finesse = 99;
        else finesse = f;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *
 * @author matte
 */
public class CelluleDeGrille_Graphique extends JButton{
    CelluleDeGrille celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/Desintegrateur (1).png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_TrouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/TrouNoir (2).png"));
    
    public CelluleDeGrille_Graphique(CelluleDeGrille uneCellule) {
        celluleAssociee = uneCellule;
        
    }
    
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        
        if (celluleAssociee.presenceTrouNoir() == true) {
            setIcon(img_TrouNoir);
        }
        else if (celluleAssociee.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "rouge" -> setIcon(img_jetonRouge);
                case "jaune" -> setIcon(img_jetonJaune);
                case "vide" -> setIcon(img_vide);
            }
        }
    }
}

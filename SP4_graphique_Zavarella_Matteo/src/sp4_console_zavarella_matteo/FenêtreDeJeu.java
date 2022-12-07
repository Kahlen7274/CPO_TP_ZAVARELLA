/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_console_zavarella_matteo;

import java.util.Random;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



/**
 *
 * @author matte
 */
public class FenêtreDeJeu extends javax.swing.JFrame {
    
    joueur[] ListeJoueurs = new joueur[2]; // tableau de joueur (ligne)
    joueur joueurCourant;
    PlateauDeJeu plateau = new PlateauDeJeu(); //creation d'objet

    /**
     * Creates new form FenêtreDeJeu
     */
    public FenêtreDeJeu() {
        initComponents();
        panneau_info_joueur.setVisible(false);
        panneau_info_partie.setVisible(false);
        
        for (int i = 5; i>=0; i--) {
            for (int j = 0; j<7; j++) {
                CelluleDeGrille_Graphique cellGraph;
                cellGraph = new CelluleDeGrille_Graphique(plateau.Grille[i][j]);
                
                cellGraph.addActionListener(new java.awt.event.ActionListener(){
                    
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                    CelluleDeGrille c = cellGraph.celluleAssociee;
                    
                    if (c.jetonCourant == null) {
                            return;
                        }

                        if (c.jetonCourant.couleur.equals(joueurCourant.couleur)) {
                            textemessage.setText(joueurCourant.nom + " récupère un de ces jetons");
                            Jeton jrecup = c.recupererJeton();
                            c.supprimerJeton();
                            PlayMusic("directory.wav");
                            joueurCourant.ajouterJeton(jrecup);
                            joueurSuivant();
                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                textemessage.setText(joueurCourant.nom + " a désintégré un jeton");
                                PlayMusic("hammer-of-sol_2.wav");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                joueurSuivant();
                            } else {
                                return;
                            }

                        }
                        plateau.tasserGrille();
                        panneau_grille.repaint();

                        lbl_j1_nbdesint.setText(ListeJoueurs[0].nombreDesintegrateurs + "");
                        lbl_j2_nbdesint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");

                        boolean vict_j1 = plateau.etreGagnantePourCouleur("rouge");
                        boolean vict_j2 = plateau.etreGagnantePourCouleur("jaune");

                        if (vict_j1 && !vict_j2) {
                            textemessage.setText("Victoire de " + ListeJoueurs[0].nom);
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
                        }
                        if (vict_j2 && !vict_j1) {
                            textemessage.setText("Victoire de " + ListeJoueurs[1].nom);
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
                        }

                        if (vict_j1 && vict_j2) {
                            if (joueurCourant == ListeJoueurs[0]) {
                                textemessage.setText("Victoire de " + ListeJoueurs[1].nom + " faute de jeu de l'autre joueur");
                                btn_col0.setEnabled(false);
                                btn_col1.setEnabled(false);
                                btn_col2.setEnabled(false);
                                btn_col3.setEnabled(false);
                                btn_col4.setEnabled(false);
                                btn_col5.setEnabled(false);
                                btn_col6.setEnabled(false);
                                Panel_Victoire Fin = new Panel_Victoire();
                                FenêtreDeJeu.super.dispose();
                                Fin.setVisible(true);
                            } else {
                                textemessage.setText("Victoire de " + ListeJoueurs[0].nom + " faute de jeu de l'autre joueur");
                                btn_col0.setEnabled(false);
                                btn_col1.setEnabled(false);
                                btn_col2.setEnabled(false);
                                btn_col3.setEnabled(false);
                                btn_col4.setEnabled(false);
                                btn_col5.setEnabled(false);
                                btn_col6.setEnabled(false);
                                Panel_Victoire Fin = new Panel_Victoire();
                                FenêtreDeJeu.super.dispose();
                                Fin.setVisible(true);
                            }
                        }
                }
                });
                panneau_grille.add(cellGraph);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur1 = new javax.swing.JTextField();
        nom_joueur2 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        textemessage = new javax.swing.JTextArea();
        panneau_info_joueur = new javax.swing.JPanel();
        lbl_j1_nbdesint = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_j2_nbdesint = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_col0 = new javax.swing.JButton();
        btn_col1 = new javax.swing.JButton();
        btn_col2 = new javax.swing.JButton();
        btn_col3 = new javax.swing.JButton();
        btn_col4 = new javax.swing.JButton();
        btn_col5 = new javax.swing.JButton();
        btn_col6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(51, 255, 51));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 672, 576));

        panneau_creation_partie.setBackground(new java.awt.Color(51, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom Joueur 2 : ");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel2.setText("Nom Joueur 1 : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 130, -1));

        nom_joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 130, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 330, 110));

        panneau_info_partie.setBackground(new java.awt.Color(51, 255, 204));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Eras Light ITC", 3, 18)); // NOI18N
        jLabel3.setText("info jeu");
        panneau_info_partie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lbl_jcourant.setText("nom joueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel12.setText("joueur courant :");
        panneau_info_partie.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        textemessage.setColumns(20);
        textemessage.setRows(5);
        message.setViewportView(textemessage);

        panneau_info_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 310, 80));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 520, 330, 230));

        panneau_info_joueur.setBackground(new java.awt.Color(51, 255, 204));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_nbdesint.setText("nb desint joueur1");
        panneau_info_joueur.add(lbl_j1_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel5.setText("Couleur : ");
        panneau_info_joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel6.setText("Désintegrateur :");
        panneau_info_joueur.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setText("Joueur 1 : ");
        panneau_info_joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbl_j1_nom.setText("nom joueur 1");
        panneau_info_joueur.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        lbl_j1_couleur.setText("couleur joueur 1");
        panneau_info_joueur.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 255));
        panneau_info_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 50));

        lbl_j2_nbdesint.setText("nb desint joueur2");
        panneau_info_joueur.add(lbl_j2_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel8.setText("Couleur : ");
        panneau_info_joueur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel10.setText("Joueur 2 : ");
        panneau_info_joueur.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lbl_j2_nom.setText("nom joueur 2");
        panneau_info_joueur.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        lbl_j2_couleur.setText("couleur joueur 2");
        panneau_info_joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Eras Light ITC", 3, 18)); // NOI18N
        jLabel4.setText("info joueur ");
        panneau_info_joueur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        jLabel11.setText("Désintegrateur :");
        panneau_info_joueur.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, 330, 270));

        btn_col0.setText("1");
        btn_col0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        btn_col1.setText("2");
        btn_col1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        btn_col2.setText("3");
        btn_col2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        btn_col3.setText("4");
        btn_col3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        btn_col4.setText("5");
        btn_col4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        btn_col5.setText("6");
        btn_col5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        btn_col6.setText("7");
        btn_col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, -1, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 255));
        jLabel15.setText("Super puissance 4 Destiny");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 590, 80));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destiny-2-bungie-concept-art-ryan-demita-class5-1050x1622.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 0, 900, 1450));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destiny-2-bungie-concept-art-ryan-demita-class7-1050x1622.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 1500, 1420));

        setBounds(0, 0, 1352, 783);
    }// </editor-fold>//GEN-END:initComponents

    private void nom_joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur2ActionPerformed

    private void btn_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col4ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(4);
        if (plateau.colonneRemplie(6) == true) {
            btn_col4.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col4ActionPerformed

    private void btn_col3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col3ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(3);
        if (plateau.colonneRemplie(6) == true) {
            btn_col3.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col3ActionPerformed

    private void btn_col0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col0ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(0);
        if (plateau.colonneRemplie(6) == true) {
            btn_col0.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col0ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        panneau_info_joueur.setVisible(true);
        panneau_info_partie.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        btn_start.setEnabled(false);
        PlayMusic("Main.wav");
        
        
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col6ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(6);
        if (plateau.colonneRemplie(6) == true) {
            btn_col6.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col6ActionPerformed

    private void btn_col1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col1ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(1);
        if (plateau.colonneRemplie(6) == true) {
            btn_col1.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col1ActionPerformed

    private void btn_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col2ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(2);
        if (plateau.colonneRemplie(6) == true) {
            btn_col2.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col2ActionPerformed

    private void btn_col5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col5ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(5);
        if (plateau.colonneRemplie(6) == true) {
            btn_col5.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col5ActionPerformed

    public boolean jouerDansColonne(int indice_colonne){
        int i = 0;
        while (plateau.Grille[i][indice_colonne].jetonCourant != null) {
            i++;
            if (i == 5) {
                break;
            }
        }
        if (plateau.Grille[i][indice_colonne].presenceDesintegrateur() == true) {
            plateau.Grille[i][indice_colonne].recupererDesintegrateur();
            textemessage.setText(joueurCourant.nom + " a récupéré un désintegrateur");
            PlayMusic("super-charged.wav");
            joueurCourant.nombreDesintegrateurs++;
        }
        joueurCourant.nb++;
        boolean result;
        result = plateau.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nb), indice_colonne);
        panneau_grille.repaint();
        lbl_j1_nbdesint.setText(ListeJoueurs[0].nombreDesintegrateurs+"");
        lbl_j2_nbdesint.setText(ListeJoueurs[1].nombreDesintegrateurs+"");
        
        if (plateau.Grille[i][indice_colonne].presenceTrouNoir() == true) {
                        plateau.supprimerJeton(i,indice_colonne);
                        PlayMusic("nova-bomb.wav");
                        plateau.suppprimerTrouNoir(i, indice_colonne);
                        textemessage.setText("la bombe nova à détruit le jeton de " +joueurCourant.nom);
                       
                    }

        boolean vict_j1 = plateau.etreGagnantePourCouleur("rouge");
        boolean vict_j2 = plateau.etreGagnantePourCouleur("jaune");

        if (vict_j1 && !vict_j2) {
            textemessage.setText("Victoire de " + ListeJoueurs[0].nom);
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
        }
        if (vict_j2 && !vict_j1) {
            textemessage.setText("Victoire de " + ListeJoueurs[1].nom);
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
        }

        if (vict_j1 && vict_j2) {
            if (joueurCourant == ListeJoueurs[0]) {
                textemessage.setText("Victoire de " + ListeJoueurs[1].nom + " faute de jeu de l'autre joueur");
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
            } else {
                textemessage.setText("Victoire de " + ListeJoueurs[0].nom + " faute de jeu de l'autre joueur");
                            btn_col0.setEnabled(false);
                            btn_col1.setEnabled(false);
                            btn_col2.setEnabled(false);
                            btn_col3.setEnabled(false);
                            btn_col4.setEnabled(false);
                            btn_col5.setEnabled(false);
                            btn_col6.setEnabled(false);
                            Panel_Victoire Fin = new Panel_Victoire();
                            FenêtreDeJeu.super.dispose();
                            Fin.setVisible(true);
            }
        }
        plateau.afficherGrilleSurConsole();
        if (result == true) {
            return true;
        } else {
            return false;
        }
    }
    public void joueurSuivant() {
        if (joueurCourant == ListeJoueurs[0]) {
            joueurCourant = ListeJoueurs[1];
            lbl_jcourant.setText(joueurCourant.toString());
        }
        else {
            joueurCourant = ListeJoueurs[0];
            lbl_jcourant.setText(joueurCourant.toString());
        }
    }
    
     public static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else {
                System.out.println("Trouve pas le fichier");
            }
        }catch(Exception e) {
            
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenêtreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenêtreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenêtreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenêtreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenêtreDeJeu().setVisible(true);
            }
        });
    }
    
    //Initilisation d'une partie  
    public void initialiserPartie() {
        
        // affichage

        String nomJoueur1 = nom_joueur1.getText();
        joueur joueur1 = new joueur(nomJoueur1);
        
        String nomJoueur2 = nom_joueur2.getText();
        joueur joueur2 = new joueur(nomJoueur2);
        
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j2_nom.setText(nomJoueur2);
        
        
        lbl_j1_nbdesint.setText(joueur1.nombreDesintegrateurs+"");
        lbl_j2_nbdesint.setText(joueur2.nombreDesintegrateurs+"");
        
        
        attribuerCouleursAuxJoueurs();
        
        lbl_j1_couleur.setText(joueur1.couleur);
        lbl_j2_couleur.setText(joueur2.couleur);
        
        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        
        if (alea == 1) {
            joueurCourant = ListeJoueurs[0];
            System.out.println(ListeJoueurs[0].nom + " commence");
        } else {
            joueurCourant = ListeJoueurs[1];
            System.out.println(ListeJoueurs[1].nom + " commence");
        }
        
        lbl_jcourant.setText(joueurCourant.nom);

        for (int i = 0; i < 21; i++) { //donner les jetons aux joueurs
            Jeton unJeton = new Jeton(ListeJoueurs[0].couleur);
            ListeJoueurs[0].ajouterJeton(unJeton);
            Jeton unJeton2 = new Jeton(ListeJoueurs[1].couleur);
            ListeJoueurs[1].ajouterJeton(unJeton2);

        }

        
        // on place les trous noirs et desintegrateurs
        Random position = new Random();
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int lig = position.nextInt(5);
            int col = position.nextInt(6);
            if (compteur < 2) {
                if (!plateau.placerDesintegrateur(lig, col)) {
                    compteur--;
                }
                compteur++;
            }
            if (!plateau.placerTrouNoir(lig, col)) {
                i--;
            }
        }
        for (int i = 0; i < 3; i++) {
            int lig = position.nextInt(5);
            int col = position.nextInt(6);
            if (!plateau.placerDesintegrateur(lig, col)) {
                i--;
            }
        }
    }   
    
    // méthode qui distribue une couleur aléatoire aux deux joueurs, rouge ou jaune
    public void attribuerCouleursAuxJoueurs() {
        // couleur Jaune attribué à 0
        // couleur Jaune attribué à 1       
        ListeJoueurs[0].couleur = "rouge";
        ListeJoueurs[1].couleur = "jaune";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col0;
    private javax.swing.JButton btn_col1;
    private javax.swing.JButton btn_col2;
    private javax.swing.JButton btn_col3;
    private javax.swing.JButton btn_col4;
    private javax.swing.JButton btn_col5;
    private javax.swing.JButton btn_col6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_nbdesint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_nbdesint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueur;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JTextArea textemessage;
    // End of variables declaration//GEN-END:variables
}

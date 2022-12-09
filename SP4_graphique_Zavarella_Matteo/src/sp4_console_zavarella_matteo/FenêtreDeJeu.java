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
        panneau_info_joueur2.setVisible(false);
        panneau_info_joueur1.setVisible(false);
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
                        DebloquerBoutonColonne();
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
        btn_col0 = new javax.swing.JButton();
        btn_col1 = new javax.swing.JButton();
        btn_col2 = new javax.swing.JButton();
        btn_col3 = new javax.swing.JButton();
        btn_col4 = new javax.swing.JButton();
        btn_col5 = new javax.swing.JButton();
        btn_col6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panneau_info_joueur1 = new javax.swing.JPanel();
        lbl_j2_nbdesint = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panneau_info_joueur2 = new javax.swing.JPanel();
        lbl_j1_nbdesint = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 672, 576));

        panneau_creation_partie.setBackground(new java.awt.Color(0, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Gardien 2 : ");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Gardien 1 : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 130, -1));

        nom_joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 330, 110));

        panneau_info_partie.setBackground(new java.awt.Color(153, 0, 153));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Eras Light ITC", 3, 24)); // NOI18N
        jLabel3.setText("info jeu");
        panneau_info_partie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lbl_jcourant.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lbl_jcourant.setText("nom joueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 46, 120, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel12.setText("joueur courant :");
        panneau_info_partie.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        textemessage.setColumns(20);
        textemessage.setRows(5);
        message.setViewportView(textemessage);

        panneau_info_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 310, 80));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 560, 330, 230));

        btn_col0.setText("1");
        btn_col0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col0, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        btn_col1.setText("2");
        btn_col1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        btn_col2.setText("3");
        btn_col2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        btn_col3.setText("4");
        btn_col3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        btn_col4.setText("5");
        btn_col4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, -1, -1));

        btn_col5.setText("6");
        btn_col5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        btn_col6.setText("7");
        btn_col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, -1, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel15.setText("Super puissance 4 Destiny");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 570, 80));

        panneau_info_joueur1.setBackground(new java.awt.Color(153, 0, 204));
        panneau_info_joueur1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j2_nbdesint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j2_nbdesint.setText("nb desint joueur2");
        panneau_info_joueur1.add(lbl_j2_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 176, 120, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setText("Couleur : ");
        panneau_info_joueur1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel18.setText("Gardien 2 : ");
        panneau_info_joueur1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbl_j2_nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j2_nom.setText("nom joueur 2");
        panneau_info_joueur1.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 100, 50));

        lbl_j2_couleur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j2_couleur.setText("couleur joueur 2");
        panneau_info_joueur1.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 106, 110, 50));

        jLabel19.setFont(new java.awt.Font("Eras Light ITC", 3, 24)); // NOI18N
        jLabel19.setText("info joueur abyssal");
        panneau_info_joueur1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel20.setText("Désintegrateur :");
        panneau_info_joueur1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        getContentPane().add(panneau_info_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 210, -1, 250));

        panneau_info_joueur2.setBackground(new java.awt.Color(255, 153, 0));
        panneau_info_joueur2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_nbdesint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j1_nbdesint.setText("nb desint joueur1");
        panneau_info_joueur2.add(lbl_j1_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 100, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Couleur : ");
        panneau_info_joueur2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("Désintegrateur :");
        panneau_info_joueur2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setText("Gardien 1 : ");
        panneau_info_joueur2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbl_j1_nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j1_nom.setText("nom joueur 1");
        panneau_info_joueur2.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 110, 30));

        lbl_j1_couleur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_j1_couleur.setText("couleur joueur 1");
        panneau_info_joueur2.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 30));

        jLabel4.setFont(new java.awt.Font("Eras Light ITC", 3, 24)); // NOI18N
        jLabel4.setText("info joueur solaire");
        panneau_info_joueur2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        getContentPane().add(panneau_info_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 250));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destiny-2-bungie-concept-art-ryan-demita-class5-1050x1622.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 0, 930, 1580));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/destiny-2-bungie-concept-art-ryan-demita-class7-1050x1622.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 0, 1220, -1));

        setBounds(0, 0, 1609, 898);
    }// </editor-fold>//GEN-END:initComponents

    private void nom_joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur2ActionPerformed

    private void btn_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col4ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(4);
        if (plateau.colonneRemplie(4) == true) {
            btn_col4.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col4ActionPerformed

    private void btn_col3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col3ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(3);
        if (plateau.colonneRemplie(3) == true) {
            btn_col3.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col3ActionPerformed

    private void btn_col0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col0ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(0);
        if (plateau.colonneRemplie(0) == true) {
            btn_col0.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col0ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        panneau_info_joueur2.setVisible(true);
        panneau_info_joueur1.setVisible(true);
        panneau_info_partie.setVisible(true);
        panneau_creation_partie.setVisible(false);
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
        if (plateau.colonneRemplie(1) == true) {
            btn_col1.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col1ActionPerformed

    private void btn_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col2ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(2);
        if (plateau.colonneRemplie(2) == true) {
            btn_col2.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col2ActionPerformed

    private void btn_col5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col5ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(5);
        if (plateau.colonneRemplie(5) == true) {
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

         Random r = new Random();
         
        //placer les trous noir 
        int cpt1 = 0;
        while (cpt1 < 5) {
            int a = r.nextInt(5);    //tirer aleatoirement un entier  
            int b = r.nextInt(6);
            if (plateau.Grille[a][b].TrouNoir == false) {
                plateau.placerTrouNoir(a, b);
                cpt1 += 1;

            }

        }

        //placer les desintegrateurs
        int cpt = 0;
        while (cpt < 2) {

            int x = r.nextInt(5);    //tirer aleatoirement un entier  
            int y = r.nextInt(6);
            if ((plateau.Grille[x][y].  TrouNoir == true) && (plateau.Grille[x][y].presenceDesintegrateur() == false)) {
                plateau.placerDesintegrateur(x, y);
                cpt += 1;
            }

        }
        int cpt2 = 0;

        while (cpt2 < 3) {

            int x = r.nextInt(5);    //tirer aleatoirement un entier  
            int y = r.nextInt(6);
            if ((plateau.Grille[x][y].TrouNoir == false) && (plateau.Grille[x][y].presenceDesintegrateur() == false)) {
                plateau.placerDesintegrateur(x, y);
                cpt2 += 1;
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
    
     public void DebloquerBoutonColonne() {
        for (int i = 0; i<7; i++) {
            if (plateau.colonneRemplie(i) == false) {
                if (i == 0) {
                    if (btn_col0.isEnabled() == true) {
                        btn_col0.setEnabled(false);
                    }
                }
                if (i == 1) {
                    if (btn_col1.isEnabled() == false) {
                        btn_col1.setEnabled(true);
                    }
                }
                if (i == 2) {
                    if (btn_col2.isEnabled() == false) {
                        btn_col2.setEnabled(true);
                    }
                }
                if (i == 3) {
                    if (btn_col3.isEnabled() == false) {
                        btn_col3.setEnabled(true);
                    }
                }
                if (i == 4) {
                    if (btn_col4.isEnabled() == false) {
                        btn_col4.setEnabled(true);
                    }
                }
                if (i == 5) {
                    if (btn_col5.isEnabled() == false) {
                        btn_col5.setEnabled(true);
                    }
                }
                if (i == 6) {
                    if (btn_col6.isEnabled() == false) {
                        btn_col6.setEnabled(true);
                    }
                }
            }
        }
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel panneau_info_joueur1;
    private javax.swing.JPanel panneau_info_joueur2;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JTextArea textemessage;
    // End of variables declaration//GEN-END:variables
}

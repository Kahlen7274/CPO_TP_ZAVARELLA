/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_zavarella_matteo;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author matte
 */
public class Partie {
    
    // Attribut
    joueur[] ListeJoueurs = new joueur[2]; // tableau de joueur (ligne)
    joueur joueurCourant;
    PlateauDeJeu plateau = new PlateauDeJeu(); //creation d'objet
    
    // constructeur
    public Partie(joueur joueur1, joueur joueur2) {
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        joueurCourant = null;
    }
    
    // méthode qui distribue une couleur aléatoire aux deux joueurs, rouge ou jaune
    public void attribuerCouleursAuxJoueurs() {
        // couleur Jaune attribué à 0
        // couleur Jaune attribué à 1 
        Random r = new Random();
        int n = r.nextInt(1);
        if (n == 0) {
            ListeJoueurs[0].couleur = "jaune";
            ListeJoueurs[1].couleur = "rouge";
        } else {
            ListeJoueurs[0].couleur = "rouge";
            ListeJoueurs[1].couleur = "jaune";
        }
    }
    
    //Initilisation d'une partie  
    public void initialiserPartie() {
        
        // affichage
        
        plateau.viderGrille(joueurCourant , joueurCourant ); // créé et afficher grille

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du premier joueur :");
        joueur joueur1 = new joueur(sc.nextLine());
        System.out.println("Entrer le nom du deuxiéme joueur :");
        joueur joueur2 = new joueur(sc.nextLine());
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        plateau = new PlateauDeJeu();
        Random r = new Random();

        //grilleJeu.afficherGrilleSurConsole();
        attribuerCouleursAuxJoueurs();

        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        if (alea == 1) {
            joueurCourant = ListeJoueurs[0];
            System.out.println(ListeJoueurs[0].nom + " commence");
        } else {
            joueurCourant = ListeJoueurs[1];
            System.out.println(ListeJoueurs[1].nom + " commence");
        }

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
    
    public void débuterPartie() {
        
        initialiserPartie();
        String J0 = ListeJoueurs[0].toString();
        String J1 = ListeJoueurs[0].toString();
        while ((plateau.etreGagnantePourCouleur(J0) == false) && (plateau.grilleRemplie() == false) && (plateau.etreGagnantePourCouleur(J1) == false)) {

            plateau.afficherGrilleSurConsole();
            System.out.println("1) Pose un jeton");
            System.out.println("2) Désintégrer un jeton");
            System.out.println("3) Récupérer un jeton");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            
            while (action < 1 && action > 3) {
                System.out.println("Erreur, il faut une des 3 actions");
                action = sc.nextInt();
            }
            
            if (action == 2) {
                if (joueurCourant.nombreDesintegrateurs == 0) {
                    System.out.println("Action non valide, plus de désintégrateur");
                    while (action != 1 && action != 3) {
                        System.out.println("Erreur, il faut choisir entre 1 et 3");
                        action = sc.nextInt();
                    }
                }
            }
            
            switch (action) {
              
                case 1 -> {
                    boolean result;
                    System.out.println("Quelle colonne jouer ? ");
                    int col = sc.nextInt() - 1;
                    while (col < 0 || col > 6) {
                        System.out.println("Erreur, saisir une colonne");
                        col = sc.nextInt() - 1;
                    }
                    
                    joueurCourant.nb--;
                    
                    int i = 0;
                    while (plateau.Grille[i][col].jetonCourant != null) {
                        i++;
                        if (i==5){
                            break;
                        }
                    }
                    if (plateau.Grille[i][col].presenceDesintegrateur() == true) {
                        plateau.Grille[i][col].recupererDesintegrateur();
                        joueurCourant.nombreDesintegrateurs++;
                    }
                    
                    result = plateau.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nb), col);
                    while (result == false) {
                        System.out.println("Colonne pleine, choisissez une autre colonne");
                        col = sc.nextInt() - 1;
                        result = plateau.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nb), col);
                    }
                 
                    // regarder si on a un désintégrateur sur (i,col)

                    plateau.afficherGrilleSurConsole();
                }

                case 2 -> {
                    // désintégrer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col2 = sc.nextInt() - 1;
                    while (plateau.Grille[lig2][col2].lireCouleurDuJeton() == joueurCourant.couleur) {
                        System.out.println("Le jeton est de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig2 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col2 = sc.nextInt() - 1;
                    }
                    plateau.supprimerJeton(lig2, col2);
                    plateau.tasserColonne(col2);
                    plateau.afficherGrilleSurConsole();
                    joueurCourant.nombreDesintegrateurs--;
                    System.out.println("Nombre de désintégrateur : " + joueurCourant.nombreDesintegrateurs + "du " + joueurCourant);
                }

                case 3 -> {
                    // récupérer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col3 = sc.nextInt() - 1;
                    while (plateau.Grille[lig3][col3].lireCouleurDuJeton() != joueurCourant.couleur) {
                        System.out.println("Le jeton n'est pas de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig3 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col3 = sc.nextInt() - 1;
                    }
                    //joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3, col3));
                    plateau.supprimerJeton(lig3, col3);
                    plateau.tasserColonne(col3);
                    plateau.afficherGrilleSurConsole();
                }
            }
            
            String J = joueurCourant.toString();
            
            if (plateau.etreGagnantePourCouleur(J) == false) {
                if (ListeJoueurs[0] == joueurCourant) {
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }

                System.out.println("Tour suivant :" + joueurCourant.nom);
                System.out.println("Nombre de jeton de " + joueurCourant.nom + " est : " + joueurCourant.nb);
                System.out.println("Nombre de désintégrateur de " + joueurCourant.nom + " est : " + joueurCourant.nombreDesintegrateurs);
            }

        }
        System.out.println(joueurCourant.nom + " a gagné, le jeu est terminé.");
    }
}

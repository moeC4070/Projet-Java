import service.Authentification;
import service.GererCommande;
import service.GererStock;
import service.GererVente;
import service.Rapport;
import Models.Utilisateur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Authentification auth = new Authentification();

        System.out.println("===== GESTION PHARMACIE =====");

        System.out.print("Login : ");
        String login = sc.nextLine();

        System.out.print("Mot de passe : ");
        String pwd = sc.nextLine();

        Utilisateur user = auth.login(login, pwd);

        if (user == null) {
            return; // stop if authentication failed
        }

        if (user.getRole().equalsIgnoreCase("PHARMACIEN")) {
            menuPharmacien(sc, user);
        } else if (user.getRole().equalsIgnoreCase("GESTIONNAIRE")) {
            menuGestionnaire(sc, user);
        } else {
            System.out.println("Rôle inconnu.");
        }
    }
    private static void menuPharmacien(Scanner sc, Utilisateur user) {

        int choix;

        do {
            System.out.println("\n--- MENU PHARMACIEN ---");
            System.out.println("1. Enregistrer une vente");
            System.out.println("2. Annuler une vente");
            System.out.println("3. Consulter toutes les ventes");
            System.out.println("4. Consulter ventes par critère");
            System.out.println("5. Consulter le profil");
            System.out.println("0. Déconnexion");

            System.out.print("Choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    GererVente.enregistrerVente(user.getId());
                    break;

                case 2:
                    GererVente.annulerVente();
                    break;

                case 3:
                    GererVente.consulterVentes();
                    break;

                case 4:
                    GererVente.consulterVentesParCritere();
                    break;

                case 5:
                    afficherProfil(user);
                    break;

                case 0:
                    System.out.println("Déconnexion...");
                    break;

                default:
                    System.out.println("Choix invalide");
            }

        } while (choix != 0);
    }

    private static void menuGestionnaire(Scanner sc, Utilisateur user) {

        int choix;

        do {
            System.out.println("\n--- MENU GESTIONNAIRE ---");
            System.out.println("1. Ajouter médicament");
            System.out.println("2. Mettre à jour stock");
            System.out.println("3. Consulter stock critique");
            System.out.println("4. Consulter profil");
            System.out.println("5. Passer une commande");
            System.out.println("6. Consulter les commandes");
            System.out.println("7. Consulter historique du stock");
            System.out.println("8. Rapports statistiques (ventes)");
            System.out.println("0. Déconnexion");

            System.out.print("Choix : ");
            choix = sc.nextInt();

            switch (choix) {

                case 1:
                    GererStock.ajouterStock();
                    break;

                case 2:
                    System.out.print("ID médicament : ");
                    int id = sc.nextInt();
                    System.out.print("Nouveau stock : ");
                    int stock = sc.nextInt();
                    GererStock.miseAJourStock(id, stock);
                    break;

                case 3:
                    GererStock.verifierStockCritique();
                    break;

                case 4:
                    afficherProfil(user);
                    break;

                case 5:
                    GererCommande.ajouterCommande(user.getId());
                    break;

                case 6:
                    GererCommande.consulterCommandes();
                    break;

                case 7:
                    System.out.print("ID médicament : ");
                    int idMed = sc.nextInt();
                    try (var conn = JDBC.JDBConnection.getConnection()) {
                        new BD.StockHistoriqueBD(conn).printHistoryByMedicament(idMed);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    Rapport.ventesParMedicament();
                    break;

                case 0:
                    System.out.println("Déconnexion...");
                    break;

                default:
                    System.out.println("Choix invalide");
            }

        } while (choix != 0);
    }

    private static void afficherProfil(Utilisateur user) {

        System.out.println("\n--- PROFIL UTILISATEUR ---");
        System.out.println("Nom : " + user.getNom());
        System.out.println("Prénom : " + user.getPrenom());
        System.out.println("Rôle : " + user.getRole());
    }
}

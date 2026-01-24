import service.Authentification;
import service.GererCommande;
import service.GererStock;
import Models.Utilisateur;
import service.GererVente;

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

    // ================= PHARMACIEN =================
    private static void menuPharmacien(Scanner sc, Utilisateur user) {

        int choix;

        do {
            System.out.println("1. Enregistrer une vente");
            System.out.println("2. Annuler une vente");
            System.out.println("3. Consulter les ventes");
            System.out.println("4. Consulter le profil");
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

    // ================= GESTIONNAIRE =================
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

                    if (BD.MedicamentBD.miseStock(id, stock)) {
                        System.out.println("✅ Stock mis à jour");
                    } else {
                        System.out.println("❌ Échec mise à jour");
                    }
                    break;

                case 3:
                    System.out.println("➡️ Stock critique (à afficher)");
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
                case 0:
                    System.out.println("Déconnexion...");
                    break;

                default:
                    System.out.println("Choix invalide");
            }

        } while (choix != 0);
    }

    // ================= PROFIL =================
    private static void afficherProfil(Utilisateur user) {

        System.out.println("\n--- PROFIL UTILISATEUR ---");
        System.out.println("Nom : " + user.getNom());
        System.out.println("Prénom : " + user.getPrenom());
        System.out.println("Rôle : " + user.getRole());
    }
}

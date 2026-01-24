package service;

import BD.CommandeBD;
import Models.Commande;

import java.util.List;
import java.util.Scanner;

public class GererCommande {

    public static void ajouterCommande(int idGestionnaire) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID médicament : ");
        int idMed = sc.nextInt();

        System.out.print("Quantité à commander : ");
        int qte = sc.nextInt();

        Commande c = new Commande();
        c.setIdGestionnaire(idGestionnaire);
        c.setIdMedicament(idMed);
        c.setQuantite(qte);

        if (CommandeBD.ajouterCommande(c)) {
            System.out.println("✅ Commande ajoutée (ID = " + c.getIdCommande() + ")");
        } else {
            System.out.println("❌ Erreur lors de la commande");
        }
    }

    public static void consulterCommandes() {

        List<Commande> commandes = CommandeBD.getAllCommandes();

        System.out.println("\n--- LISTE DES COMMANDES ---");

        if (commandes.isEmpty()) {
            System.out.println("Aucune commande.");
            return;
        }

        for (Commande c : commandes) {
            System.out.println(
                    "Commande #" + c.getIdCommande() +
                            " | Médicament: " + c.getIdMedicament() +
                            " | Quantité: " + c.getQuantite() +
                            " | Date: " + c.getDate()
            );
        }
    }
}

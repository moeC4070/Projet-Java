package service;

import BD.ClientBD;
import BD.VenteBD;
import Models.Client;
import Models.Vente;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GererVente {

    public static void enregistrerVente(int idPharmacien) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID client : ");
        int idClient = sc.nextInt();

        Client client = ClientBD.getClientById(idClient);
        if (client == null) {
            System.out.println("❌ Client introuvable !");
            return;
        }

        System.out.print("ID médicament : ");
        int idMed = sc.nextInt();

        System.out.print("Quantité : ");
        int qte = sc.nextInt();

        Vente v = new Vente();
        v.setIdPharmacien(idPharmacien);
        v.setIdClient(idClient);
        v.setIdMedicament(idMed);
        v.setQuantite(qte);

        if (VenteBD.enregistrerVente(v)) {
            System.out.println("✅ Vente enregistrée (ID = " + v.getIdVente() + ")");
        } else {
            System.out.println("❌ Erreur lors de la vente");
        }
    }

    public static void annulerVente() {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID de la vente à annuler : ");
        int idVente = sc.nextInt();

        if (VenteBD.annulerVente(idVente)) {
            System.out.println("✅ Vente annulée");
        } else {
            System.out.println("❌ Vente introuvable");
        }
    }

    public static void consulterVentes() {

        List<Vente> ventes = VenteBD.getAllVentes();

        System.out.println("\n--- LISTE DES VENTES ---");

        if (ventes.isEmpty()) {
            System.out.println("Aucune vente.");
            return;
        }

        for (Vente v : ventes) {
            System.out.println(
                    "Vente #" + v.getIdVente() +
                            " | Médicament: " + v.getIdMedicament() +
                            " | Client: " + v.getIdClient() +
                            " | Quantité: " + v.getQuantite() +
                            " | Date: " + v.getDate()
            );
        }

    }
    public static void consulterVentesParCritere() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Par client");
        System.out.println("2. Par médicament");
        System.out.println("3. Par période");
        System.out.print("Choix : ");
        int choix = sc.nextInt();

        List<Vente> ventes = new ArrayList<>();
        switch (choix) {
            case 1:
                System.out.print("ID Client : ");
                int idClient = sc.nextInt();
                ventes = VenteBD.getVentesByClient(idClient);
                break;
            case 2:
                System.out.print("ID Médicament : ");
                int idMed = sc.nextInt();
                ventes = VenteBD.getVentesByMedicament(idMed);
                break;
            case 3:
                System.out.print("Date début (yyyy-mm-dd) : ");
                String d1 = sc.next();
                System.out.print("Date fin (yyyy-mm-dd) : ");
                String d2 = sc.next();
                ventes = VenteBD.getVentesByDateRange(Date.valueOf(d1), Date.valueOf(d2));
                break;
            default:
                System.out.println("Choix invalide");
                return;
        }

        if (ventes.isEmpty()) {
            System.out.println("Aucune vente trouvée.");
            return;
        }

        for (Vente v : ventes) {
            System.out.println(
                    "Vente #" + v.getIdVente() +
                            " | Médicament: " + v.getIdMedicament() +
                            " | Client: " + v.getIdClient() +
                            " | Quantité: " + v.getQuantite() +
                            " | Date: " + v.getDate()
            );
        }
    }

}

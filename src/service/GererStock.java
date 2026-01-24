package service;

import BD.MedicamentBD;
import BD.StockHistoriqueBD;
import Models.Medicament;
import Models.StockHistorique;
import JDBC.JDBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GererStock {

    // ================= Ajouter un nouveau médicament =================
    public static void ajouterStock() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Dosage : ");
        float dosage = sc.nextFloat();

        System.out.print("Stock : ");
        int stock = sc.nextInt();

        System.out.print("Prix : ");
        float prix = sc.nextFloat();

        Medicament med = new Medicament();
        med.setNom(nom);
        med.setDosage(dosage);
        med.setStock(stock);
        med.setPrixUnitaire(prix);

        if (MedicamentBD.ajouterMed(med)) {
            System.out.println("✅ Médicament ajouté (ID = " + med.getIdMedicament() + ")");
        } else {
            System.out.println("❌ Erreur lors de l'ajout");
        }
    }

    // ================= Mettre à jour le stock et enregistrer dans StockHistorique =================
    public static void miseAJourStock(int idMedicament, int newStock) {
        if (MedicamentBD.miseStock(idMedicament, newStock)) {
            System.out.println("✅ Stock mis à jour");

            // Log stock update in StockHistorique
            try (Connection conn = JDBConnection.getConnection()) {
                StockHistoriqueBD shbd = new StockHistoriqueBD(conn);
                shbd.addStockHistorique(new StockHistorique(idMedicament, newStock, LocalDate.now()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("❌ Échec mise à jour");
        }
    }

    // ================= Vérifier stock critique =================
    public static void verifierStockCritique() {
        int seuil = 5; // seuil critique
        List<Medicament> meds = MedicamentBD.getCriticalStock(seuil);

        if (meds.isEmpty()) {
            System.out.println("✅ Aucun médicament en stock critique");
            return;
        }

        System.out.println("⚠️ Médicaments en stock critique :");
        for (Medicament m : meds) {
            System.out.println("- " + m.getNom() + " | Stock actuel : " + m.getStock());
        }
    }
}

package BD;

import JDBC.JDBConnection;
import Models.StockHistorique;
import java.sql.*;
import java.time.LocalDate;

public class StockHistoriqueBD {

    private Connection connection;

    public StockHistoriqueBD(Connection connection) {
        this.connection = connection;
    }

    // Add a new stock history entry
    public void addStockHistorique(StockHistorique sh) {
        String sql = "INSERT INTO StockHistorique (id_medicament, quantite, date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, sh.getIdMedicament());
            ps.setInt(2, sh.getQuantite());
            ps.setDate(3, Date.valueOf(sh.getDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: get all history for a medicine
    public void printHistoryByMedicament(int idMedicament) {
        String sql = "SELECT * FROM StockHistorique WHERE id_medicament = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idMedicament);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("idMedicament=" + rs.getInt("id_medicament") +
                        ", quantite=" + rs.getInt("quantite") +
                        ", date=" + rs.getDate("date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void miseAJourStock(int idMed, int newStock) {
        if(MedicamentBD.miseStock(idMed, newStock)) {
            System.out.println("✅ Stock mis à jour");
            try (Connection conn = JDBConnection.getConnection()) {
                StockHistoriqueBD shbd = new StockHistoriqueBD(conn);
                shbd.addStockHistorique(new StockHistorique(idMed, newStock, LocalDate.now()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Échec mise à jour");
        }
    }

}

package BD;

import JDBC.JDBConnection;
import Models.StockHistorique;
import java.sql.*;

public class StockHistoriqueBD {

    private Connection connection;


    public StockHistoriqueBD(Connection connection) {
        this.connection = connection;
    }

    // Add a new stock history entry
    public void addStockHistorique(StockHistorique sh) {
        String sql = "INSERT INTO StockHistorique (idMedicament, qte, date) VALUES (?, ?, ?)";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sh.getIdMedicament());
            ps.setInt(2, sh.getQuantite());
            ps.setDate(3, java.sql.Date.valueOf(sh.getDate()));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example: get all history for a medicine
    public void printHistoryByMedicament(int idMedicament) {
        String sql = "SELECT * FROM StockHistorique WHERE idMedicament = ?";
        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMedicament);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("idMedicament=" + rs.getInt("idMedicament") +
                        ", quantite=" + rs.getInt("qte") +
                        ", date=" + rs.getDate("date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

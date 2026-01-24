package BD;

import JDBC.JDBConnection;
import Models.Vente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VenteBD {

    public static boolean enregistrerVente(Vente v) {

        String sql =
                "INSERT INTO vente " +
                        "(id_vente, id_pharmacien, id_client, id_medicament, quantite, date) " +
                        "VALUES (?, ?, ?, ?, ?, CURDATE())";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int nextId = getNextId();

            ps.setInt(1, nextId);
            ps.setInt(2, v.getIdPharmacien());
            ps.setInt(3, v.getIdClient());
            ps.setInt(4, v.getIdMedicament());
            ps.setInt(5, v.getQuantite());

            v.setIdVente(nextId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean annulerVente(int idVente) {

        String sql = "DELETE FROM vente WHERE id_vente = ?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idVente);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Vente> getAllVentes() {

        List<Vente> list = new ArrayList<>();
        String sql = "SELECT * FROM vente";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Vente(
                        rs.getInt("idVente"),
                        rs.getInt("idPharmacien"),
                        rs.getInt("idClient"),
                        rs.getInt("idMedicament"),
                        rs.getInt("quantite"),
                        rs.getDate("date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int getNextId() {

        String sql = "SELECT MAX(id_vente) FROM vente";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    // Get ventes by client
    public static List<Vente> getVentesByClient(int idClient) {
        List<Vente> list = new ArrayList<>();
        String sql = "SELECT * FROM vente WHERE id_client = ?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vente(
                        rs.getInt("id_vente"),
                        rs.getInt("id_pharmacien"),
                        rs.getInt("id_client"),
                        rs.getInt("id_medicament"),
                        rs.getInt("quantite"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get ventes by medicament
    public static List<Vente> getVentesByMedicament(int idMedicament) {
        List<Vente> list = new ArrayList<>();
        String sql = "SELECT * FROM vente WHERE id_medicament = ?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMedicament);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vente(
                        rs.getInt("id_vente"),
                        rs.getInt("id_pharmacien"),
                        rs.getInt("id_client"),
                        rs.getInt("id_medicament"),
                        rs.getInt("quantite"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get ventes by date range
    public static List<Vente> getVentesByDateRange(Date start, Date end) {
        List<Vente> list = new ArrayList<>();
        String sql = "SELECT * FROM vente WHERE date BETWEEN ? AND ?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vente(
                        rs.getInt("id_vente"),
                        rs.getInt("id_pharmacien"),
                        rs.getInt("id_client"),
                        rs.getInt("id_medicament"),
                        rs.getInt("quantite"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

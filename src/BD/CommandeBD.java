package BD;

import JDBC.JDBConnection;
import Models.Commande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeBD {

    public static boolean ajouterCommande(Commande c) {

        String sql =
                "INSERT INTO commande " +
                        "(idCommande, idGestionnaire, idMedicament, qte, date) " +
                        "VALUES (?, ?, ?, ?, CURDATE())";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int nextId = getNextId();

            ps.setInt(1, nextId);
            ps.setInt(2, c.getIdGestionnaire());
            ps.setInt(3, c.getIdMedicament());
            ps.setInt(4, c.getQuantite());

            c.setIdCommande(nextId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Commande> getAllCommandes() {

        List<Commande> list = new ArrayList<>();
        String sql = "SELECT * FROM commande";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Commande(
                        rs.getInt("idCommande"),
                        rs.getInt("idGestionnaire"),
                        rs.getInt("idMedicament"),
                        rs.getInt("qte"),
                        rs.getDate("date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int getNextId() {

        String sql = "SELECT MAX(idCommande) FROM commande";

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
}

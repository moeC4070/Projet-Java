package BD;

import Models.Medicament;
import JDBC.JDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentBD {

    public static boolean ajouterMed(Medicament med) {

        String sql =
                "INSERT INTO medicament " +
                        "(idMedicament, nom, dosage, stock, prix_uni) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int nextId = getNextId();
            ps.setInt(1, nextId);
            ps.setString(2, med.getNom());
            ps.setFloat(3, med.getDosage());
            ps.setInt(4, med.getStock());
            ps.setFloat(5, med.getPrixUnitaire());

            med.setIdMedicament(nextId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean miseStock(int idMedicament, int newStock) {

        String sql =
                "UPDATE medicament SET stock=? WHERE idMedicament=?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newStock);
            ps.setInt(2, idMedicament);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Medicament> getCriticalStock(int threshold) {

        List<Medicament> list = new ArrayList<>();
        String sql =
                "SELECT * FROM medicament WHERE stock <= ?";

        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, threshold);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Medicament(
                        rs.getInt("idMedicament"),
                        rs.getString("nom"),
                        rs.getFloat("dosage"),
                        rs.getInt("stock"),
                        rs.getFloat("prix_uni")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getNextId() {

        String sql = "SELECT MAX(idMedicament) FROM medicament";

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

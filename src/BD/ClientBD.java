package BD;

import Models.Client;
import JDBC.JDBConnection;
import java.sql.*;

public class ClientBD {

    public static Client getClientById(int idClient) {
        String sql = "SELECT * FROM client WHERE idClient = ?";
        try (Connection conn = JDBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Client(
                        rs.getInt("idClient"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("adresse")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

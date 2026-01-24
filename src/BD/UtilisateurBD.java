package BD;

import Models.Gestionnaire;
import Models.Pharmacien;
import Models.Utilisateur;
import JDBC.JDBConnection;

import java.sql.*;


public class UtilisateurBD {

    public static Utilisateur authenticate(String login, String pwd) {
        try (Connection connection = JDBConnection.getConnection()) {

            String sqlPharm = "SELECT * FROM Pharmacien WHERE login = ? AND pwd = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlPharm)) {
                ps.setString(1, login);
                ps.setString(2, pwd);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new Pharmacien(
                            rs.getInt("idPharmacien"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("login"),
                            rs.getString("pwd")
                    );
                }
            }

            String sqlGest = "SELECT * FROM Gestionnaire WHERE login = ? AND pwd = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlGest)) {
                ps.setString(1, login);
                ps.setString(2, pwd);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new Gestionnaire(
                            rs.getInt("idGestionnaire"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("login"),
                            rs.getString("pwd")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // utilisateur non trouvé
    }
}

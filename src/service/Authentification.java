package service;

import Models.Utilisateur;
import BD.UtilisateurBD;

public class Authentification {

    public Utilisateur login(String login, String password) {

        Utilisateur user = UtilisateurBD.authenticate(login, password);

        if (user == null) {
            System.out.println("❌ Login ou mot de passe incorrect");
            return null;
        }

        System.out.println("✅ Connexion réussie : "
                + user.getNom() + " " + user.getPrenom());
        System.out.println("Rôle : " + user.getRole());

        return user;
    }
}

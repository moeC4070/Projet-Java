package Models;

public class Gestionnaire extends Utilisateur {

    public Gestionnaire(int id, String nom, String prenom, String login, String pwd) {
        super(id, nom, prenom, login, pwd);
    }

    public String getRole() {
        return "GESTIONNAIRE";
    }


    public String toString() {
        return "Gestionnaire{" +
                "idGestionnaire=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

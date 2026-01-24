package Models;

public class Pharmacien extends Utilisateur {
    public Pharmacien(int id, String nom, String prenom, String login, String pwd) {
        super(id, nom, prenom, login, pwd);
    }

    public String getRole() {
        return "PHARMACIEN";
    }


    public String toString() {
        return "Pharmacien{" +
                "idPharmacien=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

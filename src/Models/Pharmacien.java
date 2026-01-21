package Models;

public class Pharmacien extends Utilisateur {

    private int idPharmacien;
    private String login;
    private String pwd;

    // Default constructor
    public Pharmacien() {
        super();
    }

    // Constructor with all fields
    public Pharmacien(int idPharmacien, String nom, String prenom, String login, String pwd) {
        super(nom, prenom);
        this.idPharmacien = idPharmacien;
        this.login = login;
        this.pwd = pwd;
    }

    public String getRole() {
        return "PHARMACIEN";
    }

    // Getters & Setters
    public int getIdPharmacien() { return idPharmacien; }
    public void setIdPharmacien(int idPharmacien) { this.idPharmacien = idPharmacien; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String toString() {
        return "Pharmacien{" +
                "idPharmacien=" + idPharmacien +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

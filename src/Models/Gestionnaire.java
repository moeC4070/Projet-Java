package Models;

public class Gestionnaire extends Utilisateur {

    private int idGestionnaire;
    private String login;
    private String pwd;

    public Gestionnaire() {
        super();
    }

    public Gestionnaire(int idGestionnaire, String nom, String prenom, String login, String pwd) {
        super(nom, prenom);
        this.idGestionnaire = idGestionnaire;
        this.login = login;
        this.pwd = pwd;
    }

    public String getRole() {
        return "GESTIONNAIRE";
    }

    // Getters & Setters
    public int getIdGestionnaire() { return idGestionnaire; }
    public void setIdGestionnaire(int idGestionnaire) { this.idGestionnaire = idGestionnaire; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String toString() {
        return "Gestionnaire{" +
                "idGestionnaire=" + idGestionnaire +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

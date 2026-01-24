package Models;

public abstract class Utilisateur {

    protected int id;
    protected String nom;
    protected String prenom;
    protected String login;
    protected String pwd;

    public Utilisateur(int id, String nom, String prenom, String login, String pwd) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.pwd = pwd;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public abstract String getRole();
}

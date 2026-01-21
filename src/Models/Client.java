package Models;

public class Client extends Utilisateur {

    private int idClient;
    private String email;
    private String adresse;

    public Client() {
        super();
    }

    public Client(int idClient, String nom, String prenom, String email, String addresse) {
        super(nom, prenom);
        this.idClient = idClient;
        this.email = email;
        this.adresse = addresse;
    }

    public String getRole() {
        return "Client";
    }

    // Getters & Setters
    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}

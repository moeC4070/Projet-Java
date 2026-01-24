package Models;

public class Client {

    private int idClient;
    private String nom;
    private String prenom;
    private String email;
    private String address;


    public Client() {
        super();
    }

    public Client(int idClient, String nom, String prenom, String email, String addresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.idClient = idClient;
        this.email = email;
        this.address = addresse;
    }

    public String getRole() {
        return "Client";
    }

    // Getters & Setters
    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

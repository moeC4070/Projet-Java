package Models;

public class Client {

    private final int idClient;
    private final String nom;
    private final String prenom;
    private final String email;
    private final String address;


    public Client(int idClient, String nom, String prenom, String email, String addresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.idClient = idClient;
        this.email = email;
        this.address = addresse;
    }

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

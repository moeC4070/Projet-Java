package Models;

import java.time.LocalDate;
import java.util.Date;

public class Commande {

    private int idCommande;
    private int idGestionnaire;
    private int idMedicament;
    private int quantite;
    private Date date;

    public Commande() {}

    public Commande(int idCommande, int idGestionnaire, int idMedicament, int quantite, Date date) {
        this.idCommande = idCommande;
        this.idGestionnaire = idGestionnaire;
        this.idMedicament = idMedicament;
        this.quantite = quantite;
        this.date = date;
    }

    public int getIdCommande() { return idCommande; }
    public void setIdCommande(int idCommande) { this.idCommande = idCommande; }

    public int getIdGestionnaire() { return idGestionnaire; }
    public void setIdGestionnaire(int idGestionnaire) { this.idGestionnaire = idGestionnaire; }

    public int getIdMedicament() { return idMedicament; }
    public void setIdMedicament(int idMedicament) { this.idMedicament = idMedicament; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", idGestionnaire=" + idGestionnaire +
                ", idMedicament=" + idMedicament +
                ", quantite=" + quantite +
                ", date=" + date +
                '}';
    }
}

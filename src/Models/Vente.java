package Models;

import java.time.LocalDate;

public class Vente {

    private int idVente;
    private int idPharmacien;
    private int idClient;
    private int idMedicament;
    private int quantite;
    private LocalDate date;

    public Vente() {}

    public Vente(int idVente, int idPharmacien, int idClient, int idMedicament, int quantite, LocalDate date) {
        this.idVente = idVente;
        this.idPharmacien = idPharmacien;
        this.idClient = idClient;
        this.idMedicament = idMedicament;
        this.quantite = quantite;
        this.date = date;
    }

    public int getIdVente() { return idVente; }
    public void setIdVente(int idVente) { this.idVente = idVente; }

    public int getIdPharmacien() { return idPharmacien; }
    public void setIdPharmacien(int idPharmacien) { this.idPharmacien = idPharmacien; }

    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public int getIdMedicament() { return idMedicament; }
    public void setIdMedicament(int idMedicament) { this.idMedicament = idMedicament; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String toString() {
        return "Vente{" +
                "idVente=" + idVente +
                ", idPharmacien=" + idPharmacien +
                ", idClient=" + idClient +
                ", idMedicament=" + idMedicament +
                ", quantite=" + quantite +
                ", date=" + date +
                '}';
    }
}

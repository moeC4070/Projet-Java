package Models;

import java.time.LocalDate;

public class StockHistorique {

    private int idMedicament;
    private int quantite;
    private LocalDate date;

    public StockHistorique() {}

    public StockHistorique(int idMedicament, int quantite, LocalDate date) {
        this.idMedicament = idMedicament;
        this.quantite = quantite;
        this.date = date;
    }

    public int getIdMedicament() { return idMedicament; }
    public void setIdMedicament(int idMedicament) { this.idMedicament = idMedicament; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String toString() {
        return "StockHistorique{" +
                "idMedicament=" + idMedicament +
                ", quantite=" + quantite +
                ", date=" + date +
                '}';
    }
}

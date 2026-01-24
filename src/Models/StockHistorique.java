package Models;

import java.time.LocalDate;

public class StockHistorique {

    private final int idMedicament;
    private final int quantite;
    private final LocalDate date;


    public StockHistorique(int idMedicament, int quantite, LocalDate date) {
        this.idMedicament = idMedicament;
        this.quantite = quantite;
        this.date = date;
    }

    public int getIdMedicament() { return idMedicament; }

    public int getQuantite() { return quantite; }

    public LocalDate getDate() { return date; }

    public String toString() {
        return "StockHistorique{" +
                "idMedicament=" + idMedicament +
                ", quantite=" + quantite +
                ", date=" + date +
                '}';
    }
}

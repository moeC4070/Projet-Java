package Models;

public class Medicament {

    private int idMedicament;
    private String nom;
    private float dosage;
    private int stock;
    private float prixUnitaire;

    public Medicament() {}

    public Medicament(int idMedicament, String nom, float dosage, int stock, float prixUnitaire) {
        this.idMedicament = idMedicament;
        this.nom = nom;
        this.dosage = dosage;
        this.stock = stock;
        this.prixUnitaire = prixUnitaire;
    }
    public void setIdMedicament(int id) {this.idMedicament = id;}
    public int getIdMedicament() {return this.idMedicament;}
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public float getDosage() { return dosage; }
    public void setDosage(float dosage) { this.dosage = dosage; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public float getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(float prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public String toString() {
        return "Medicament{" +
                "idMedicament=" + idMedicament +
                ", nom='" + nom + '\'' +
                ", dosage='" + dosage + '\'' +
                ", stock=" + stock +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }

}

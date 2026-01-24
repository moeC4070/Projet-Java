package service;

import BD.VenteBD;
import Models.Vente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rapport {

    public static void ventesParMedicament() {
        List<Vente> ventes = VenteBD.getAllVentes();
        if (ventes.isEmpty()) {
            System.out.println("Aucune vente.");
            return;
        }

        // Count quantities per medicament
        Map<Integer, Integer> map = new HashMap<>();
        for (Vente v : ventes) {
            map.put(v.getIdMedicament(), map.getOrDefault(v.getIdMedicament(), 0) + v.getQuantite());
        }

        System.out.println("=== Ventes par médicament ===");
        for (Integer idMed : map.keySet()) {
            System.out.println("Médicament ID " + idMed + " : " + map.get(idMed) + " ventes");
        }
    }
}

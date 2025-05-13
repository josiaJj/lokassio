package school.hei.model;

import java.time.LocalDate;

public class Item {
    String nom;
    LocalDate dispoLe;
    public Item(String nom) {
        this.nom = nom;
        this.dispoLe = LocalDate.now();
    }

    public boolean estDisponible() {
        return LocalDate.now().isAfter(dispoLe.minusDays(1));
    }

    public void reserver(int jours) {
        //if (jours < 1) throw new IllegalAccessException("Durée minimum 1 jour");
    }
}

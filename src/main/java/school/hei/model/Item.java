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

    public void reserver(int jours) throws IllegalAccessException {
        if (jours < 1) throw new IllegalAccessException("Durée minimum 1 jour");
        if (!estDisponible()) throw new IllegalAccessException("Déjà reservé jusqu'au " + dispoLe);
        dispoLe = LocalDate.now().plusDays(jours);
        System.out.println(nom + " reservé jusqu'au " + dispoLe);
    }

    public class LocationApp {
        public static void main(String[] args) {

        }
    }
}

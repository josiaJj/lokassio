package school.hei;

import school.hei.model.Item;

public class Main {
    public static void main(String[] args) {

        Item voiture = new Item("Voiture");
        try {
            voiture.reserver(3);
            voiture.reserver(2); // renvoyant une erreur
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
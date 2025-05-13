class Item {
    constructor(nom) {
        this.nom = nom;
        this.dispoLe = new Date();
    }

    estDisponible() {
        return new Date() >= this.dispoLe;
    }

    reserver(jours) {
        if (jours < 1) throw "Durée minimum : 1 jour";
        if (!this.estDisponible()) throw `${this.nom} est déjà réservé jusqu’au ${this.dispoLe.toDateString()}`;
        this.dispoLe = new Date(Date.now() + jours * 86400000);
        console.log(`${this.nom} réservé jusqu’au ${this.dispoLe.toDateString()}`);
    }
}

const item = new Item("Voiture");
try {
    item.reserver(2);
    item.reserver(1); // Erreur
} catch (e) {
    console.log("Erreur :", e);
}

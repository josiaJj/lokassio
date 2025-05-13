from datetime import datetime, timedelta

class Item:
    def __init__(self, nom):
        self.nom = nom
        self.dispo_le = datetime.now()

    def est_disponible(self):
        return datetime.now() >= self.dispo_le

    def reserver(self, jours):
        if jours < 1:
            raise ValueError("Durée minimum : 1 jour")
        if not self.est_disponible():
            raise Exception(f"{self.nom} déjà réservé jusqu'au {self.dispo_le}")
        self.dispo_le = datetime.now() + timedelta(days=jours)
        print(f"{self.nom} réservé jusqu'au {self.dispo_le.date()}")

voiture = Item("Voiture")
try:
    voiture.reserver(2)
    voiture.reserver(1)  # Erreur
except Exception as e:
    print("Erreur :", e)

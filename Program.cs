using System;

class Item
{
    public string Nom { get; set; }
    public DateTime DispoLe { get; set; }

    public Item(string nom)
    {
        Nom = nom;
        DispoLe = DateTime.Now;
    }

    public bool EstDisponible()
    {
        return DateTime.Now >= DispoLe;
    }

    public void Reserver(int jours)
    {
        if (jours < 1) throw new ArgumentException("Durée minimum : 1 jour");
        if (!EstDisponible()) throw new InvalidOperationException($"{Nom} est déjà réservé jusqu’au {DispoLe.ToShortDateString()}");
        DispoLe = DateTime.Now.AddDays(jours);
        Console.WriteLine($"{Nom} réservé jusqu’au {DispoLe.ToShortDateString()}");
    }
}

class Program
{
    static void Main()
    {
        var voiture = new Item("Voiture");
        try
        {
            voiture.Reserver(2);
            voiture.Reserver(1); // Renvoie l'erreur
        }
        catch (Exception e)
        {
            Console.WriteLine("Erreur : " + e.Message);
        }
    }
}
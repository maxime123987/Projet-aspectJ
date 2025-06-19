package client;

public class Pret {

    private Client client;
    private float montant; // Montant du prêt
    private float taux; // Taux d'intérêt annuel
    private int duree; // Durée en mois

    public Pret(Client client, float montant, float taux, int duree) {
        this.client = client;
        this.montant = montant;
        this.taux = taux;
        this.duree = duree;
    }

    public float calculerMontantRemboursement() {
        // Formule du montant total à rembourser : montant * (1 + taux * durée / 12)
        return montant * (1 + (taux * duree / 12));
    }

    public float montantParMois() {
        // Montant mensuel = montant total à rembourser / durée en mois
        return calculerMontantRemboursement() / duree;
    }

    // Méthode toString pour afficher les informations du prêt
    @Override
    public String toString() {
        return "Prêt de " + montant + " euros à " + taux * 100 + "% sur " + duree + " mois.";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}

package client;

public class Compte {

    private final long numero;
    private float solde;
    private final Client client;

    public Compte(Client c, long numero) {
        this.numero = numero;
        this.solde = 0;
        this.client = c;
    }

    public float getSolde() {
        return solde;
    }

    public long getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

    public void credit(float montant) {
        this.solde = this.solde + montant;
    }

    public void debit(float montant) {
        this.solde = this.solde - montant;
    }

    @Override
    public String toString() {
        return ("le compte numero : " + numero + " a pour solde : " + solde + " le nom du client est " + client.getNom());
    }

}

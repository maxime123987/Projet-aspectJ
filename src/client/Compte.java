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

    public static void main(String[] args) {
        Client c1 = new Client(1, "Gold");
        Client c2 = new Client(2,"silver");
        Compte gold = new Compte(c1, 1);
        Compte silver = new Compte(c2, 2);
        System.out.println(gold);
        gold.credit(1000);
        System.out.println(silver);
        System.out.println(gold);
        gold.debit(1500);
        System.out.println(gold);

    }

}

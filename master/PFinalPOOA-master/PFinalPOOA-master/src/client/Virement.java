package client;

public class Virement extends Operation {

    private Compte compteDestinataire;
    private float montant;

    public Virement(Compte compteSource, Compte compteDestinataire, float montant) {
        super(compteSource);
        this.compteDestinataire = compteDestinataire;
        this.montant = montant;
    }

    @Override
    public boolean isOperationValid(Operation operation) {
        if (this.compte.getSolde() >= montant) {
            return true;
        }
        return false;
    }

    @Override
    public void executer(float montant) {
        if (isOperationValid(this)) {
            this.compte.debit(montant); 
            this.compteDestinataire.credit(montant); 
            System.out.println("Virement de " + montant + " effectué vers le compte " + compteDestinataire.getNumero());
        } else {
            System.out.println("Erreur : Solde insuffisant pour effectuer le virement.");
        }
    }
}

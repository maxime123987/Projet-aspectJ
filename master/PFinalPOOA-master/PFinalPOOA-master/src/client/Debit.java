package client;

public class Debit extends Operation {

    public Debit() {
        super();
    }

    @Override
    public boolean isOperationValid(Operation operation) {
        if (this.compte.getSolde() >= operation.compte.getSolde()) {
            return true;
        }
        return false;
    }

    @Override
    public void executer(float montant) {
        if (isOperationValid(this)) {
            this.compte.debit(montant);
            System.out.println("Débit de " + montant + " effectué sur le compte " + compte.getNumero());
        } else {
            System.out.println("Erreur : Solde insuffisant pour effectuer le débit.");
        }
    }
}

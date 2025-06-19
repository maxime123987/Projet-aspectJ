package client;

public class Credit extends Operation {

    public Credit() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
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
            this.compte.credit(montant);
            System.out.println("Crédit de " + montant + " effectué sur le compte " + compte.getNumero());
        }
        else{
            System.out.println("Erreur : Solde insuffisant pour effectuer le crédit.");
        }
    }
}

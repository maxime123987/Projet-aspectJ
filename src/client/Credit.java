package client;

public class Credit extends Operation {

    public Credit() {
        super();
    }

    @Override
    public boolean isOperationValid(Operation operation) {
        return true;
    }

    @Override
    public void executer(float montant) {
        this.compte.credit(montant);
        System.out.println("Crédit de " + montant + " effectué sur le compte " + compte.getNumero());
    }
}

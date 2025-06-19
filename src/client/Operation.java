package client;

public abstract class Operation {

    protected Compte compte;

    public Operation() {}

    public Operation(Compte compte) {
        this.compte = compte;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public abstract boolean isOperationValid(Operation operation);

    public abstract void executer(float montant);
}

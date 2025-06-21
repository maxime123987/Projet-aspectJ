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

    //tostring that returns the account and operation type (debit, credit)
    @Override
    public String toString() {
        return ("Operation sur le compte numero : " + compte.getNumero() + ", de type : " + this.getClass().getSimpleName());
    }
}

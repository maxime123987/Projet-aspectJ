package client;

public class VirementInternational extends Operation {

    private final Compte compteDestinataire;
    private final float montant;
    private final String deviseCible; // "CAD" ou autre

    public VirementInternational(Compte source, Compte destinataire, float montant, String deviseCible) {
        super(source);
        this.compteDestinataire = destinataire;
        this.montant = montant;
        this.deviseCible = deviseCible;
    }

    @Override
    public boolean isOperationValid(Operation operation) {
        return (compte.getSolde() >= montant);
    }

    @Override
    public void executer(float montant) {
        if (!isOperationValid(this)) {
            System.out.println("Solde insuffisant pour effectuer le virement international.");
            return;
        }

        float montantConverti;

        if (deviseCible.equals("CAD")) {
            montantConverti = CurrencyConverter.convertEuroToCAD(montant);
        } else {
            System.out.println("Devise non supportée pour le moment.");
            return;
        }

        compte.debit(montant); // en euros
        compteDestinataire.credit(montantConverti); // en CAD
        System.out.println("Virement international exécuté : " + montant + " EUR => " + montantConverti + " " + deviseCible);
    }
}


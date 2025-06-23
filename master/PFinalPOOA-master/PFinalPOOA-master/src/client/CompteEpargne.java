package client;

public class CompteEpargne extends Compte {

    private float tauxInteret; //  Il faut écrire le taux en pourcentage, ex: 2.5 pour 2.5%

    public CompteEpargne(Client client, long numero, float tauxInteret) {
        super(client, numero);
        this.tauxInteret = tauxInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public float calculerSoldeAvecInterets() {
        return getSolde() * (1 + (tauxInteret / 100));
    }

    @Override
    public String toString() {
        return super.toString() + " [Compte Épargne avec taux: " + tauxInteret + "%]";
    }
}


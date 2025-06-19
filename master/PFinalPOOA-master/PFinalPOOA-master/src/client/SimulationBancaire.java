package client;

public class SimulationBancaire {
    public static void main(String[] args) {
        // Étape 1 : Créer les clients
        Client client1 = new Client(1, "Gold");
        Client client2 = new Client(2, "Silver");

        // Étape 2 : Créer des comptes pour chaque client
        Compte compteGold = new Compte(client1, 101);
        Compte compteSilver = new Compte(client2, 102);

        // Ajouter les comptes aux clients
        client1.addCompte(compteGold);
        client2.addCompte(compteSilver);

        // Étape 3 : Effectuer des opérations
        System.out.println("\n=== Opérations Bancaires ===\n");

        // Crédits
        System.out.println("Créditer le compte Gold de 2000 euros");
        Credit credit = new Credit();
        credit.setCompte(compteGold);
        credit.executer(2000);
        System.out.println(compteGold);

        System.out.println("Créditer le compte Silver de 1500 euros");
        credit.setCompte(compteSilver);
        credit.executer(1500);
        System.out.println(compteSilver);

        // Débits
        System.out.println("Débiter le compte Gold de 500 euros");
        Debit debit = new Debit();
        debit.setCompte(compteGold);
        debit.executer(500);
        System.out.println(compteGold);

        // Virement
        System.out.println("Effectuer un virement de 700 euros du compte Gold vers le compte Silver");
        Virement virement = new Virement(compteGold, compteSilver, 700);
        virement.executer(700); // Appel à la méthode executer du virement
        System.out.println(compteGold);
        System.out.println(compteSilver);

        // Étape 4 : Ajouter un prêt pour le client Gold
        System.out.println("\n=== Gestion des Prêts ===\n");
        Pret pretGold = new Pret(client1, 10000, 0.04f, 36);
        System.out.println("Informations sur le prêt :");
        System.out.println(pretGold);

        System.out.println("Montant total à rembourser : " + String.format("%.2f", pretGold.calculerMontantRemboursement()));
        System.out.println("Montant à rembourser par mois : " + String.format("%.2f", pretGold.montantParMois()));

        // Étape 5 : Afficher les informations finales des clients
        System.out.println("\n=== Informations finales ===\n");
        System.out.println("Client 1 : " + client1);
        System.out.println("Comptes de Client 1 : " + client1.getComptes());
        System.out.println("Prêts de Client 1 : " + client1.getPrets());

        System.out.println("Client 2 : " + client2);
        System.out.println("Comptes de Client 2 : " + client2.getComptes());
    }
}

package client;

public class SimulationBancaire {
    public static void main(String[] args) {
        // Création des clients
        Client client1 = new Client(1, "Axel");
        Client client2 = new Client(2, "Philippe");
        Client client3 = new Client(3, "Canadien", "CAD");

        // Création des comptes pour chaque client
        Compte compteAxel = new Compte(client1, 101);
        Compte comptePhilippe = new Compte(client2, 102);
        Compte compteCanadien = new Compte(client3, 103);

        // Ajouter les comptes aux clients
        client1.addCompte(compteAxel);
        client2.addCompte(comptePhilippe);
        client3.addCompte(compteCanadien);

        // Création d'un compte épargne
        CompteEpargne compteEpargne = new CompteEpargne(client1, 201, 2.5f); // 2.5% d'intérêt
        client1.addCompte(compteEpargne);


        // Effectuer des opérations
        System.out.println("\n=== Opérations Bancaires ===\n");

        // Crédits
        System.out.println("Créditer le compte d'Axel de 5000 euros");
        Credit credit = new Credit();
        credit.setCompte(compteAxel);
        credit.executer(5000);
        System.out.println(compteAxel);

        System.out.println("Créditer le compte de Philippe de 3800 euros");
        credit.setCompte(comptePhilippe);
        credit.executer(3800);
        System.out.println(comptePhilippe);

        System.out.println("Créditer 2000 euros sur le compte épargne");
        credit.setCompte(compteEpargne);
        credit.executer(2000);
        System.out.println(compteEpargne);
        System.out.println("Solde prévisionnel avec intérêts : " + compteEpargne.calculerSoldeAvecInterets() + " euros");


        // Débits
        System.out.println("Débiter le compte d'Axel de 500 euros");
        Debit debit = new Debit();
        debit.setCompte(compteAxel);
        debit.executer(500);
        System.out.println(compteAxel);

        // Virement
        System.out.println("Effectuer un virement de 900 euros du compte d'Axel vers le compte de Philippe");
        Virement virement = new Virement(compteAxel, comptePhilippe, 900);
        virement.executer(700); // Appel à la méthode executer du virement
        System.out.println(compteAxel);
        System.out.println(comptePhilippe);

        // Virement international
        System.out.println("Effectuer un virement international de 300 euros du compte d'Axel vers le compte Canadien");
        VirementInternational virementInternational = new VirementInternational(compteAxel, compteCanadien, 300, "CAD");
        virementInternational.executer(300); // Appel à la méthode executer du virement international
        System.out.println(compteAxel);
        System.out.println(compteCanadien);


        // Afficher les informations finales des clients
        System.out.println("\n=== Informations finales des clients ===\n");
        System.out.println("\nClient étranger : " + client1 + " (Devise : " + client1.getDevise() + ")");
        for (Compte compte : client1.getComptes()) {
            System.out.println("  - " + compte.toString());
        }

        System.out.println("\nClient étranger : " + client2 + " (Devise : " + client2.getDevise() + ")");
        System.out.println("Comptes de Client 2 :");
        for (Compte compte : client2.getComptes()) {
            System.out.println("  - " + compte.toString());
        }

        System.out.println("\nClient étranger : " + client3 + " (Devise : " + client3.getDevise() + ")");
        System.out.println("Comptes de Client étranger :");
        for (Compte compte : client3.getComptes()) {
            System.out.println("  - " + compte.toString());
        }
    }
}

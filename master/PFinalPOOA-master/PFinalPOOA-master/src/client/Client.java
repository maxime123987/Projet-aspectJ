package client;

import java.util.ArrayList;

public class Client {

    private long numero;
    private String nom;
    private ArrayList<Compte> comptes;
    private String devise = "EUR"; // par défaut


    public Client(long numero, String nom) {
        this(numero, nom, "EUR");
    }

    public Client(long numero, String nom, String devise) {
        this.comptes = new ArrayList<>();
        this.numero = numero;
        this.nom = nom;
        this.devise = devise;
    }


    public long getNumero() {
        return numero;
    }

    public String getDevise() {
        return devise;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addCompte(Compte c) {
        this.comptes.add(c);
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    @Override
    public String toString() {
        return ("le client qui a pour numero " + numero + " a pour nom " + nom);
    }
}

package client;

import java.util.ArrayList;

public class Client {

    private long numero;
    private String nom;
    private ArrayList<Compte> comptes;
    private ArrayList<Pret> prets;

    public Client(long numero, String nom) {
        this.prets = new ArrayList<>();
        this.comptes = new ArrayList<Compte>();
        this.numero = numero;
        this.nom = nom;
    }

    public long getNumero() {
        return numero;
    }

    public void addPret(Pret pret) {
        this.prets.add(pret);
    }

    public ArrayList<Pret> getPrets() {
        return prets;
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

    public static void main(String[] args) {
        Client c1 = new Client(1, "Gold");
        Client c2 = new Client(2, "Silver");
        System.out.println(c1);
        System.out.println(c2);
        c2.setNom("Platinium");
        System.out.println(c2);
    }
}

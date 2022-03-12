package com.zshocker.ObjectsinSockets;

import java.io.Serializable;
import java.util.Objects;

public class Etudiant implements Serializable
{
    static int count=0;
    String Nom;
    String prenom;
    int numero;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom) {
        Nom = nom;
        this.prenom = prenom;
        numero=++count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return numero == etudiant.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Etudiant Clone(){
        Etudiant etudiant=new Etudiant();
        etudiant.setNumero(numero);
        etudiant.setPrenom(prenom);
        etudiant.setNom(getNom());
        return etudiant;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "Nom='" + Nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero=" + numero +
                '}';
    }
}

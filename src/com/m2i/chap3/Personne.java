package com.m2i.chap3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Personne {
    private String nom;
    private String prenom;
    private GregorianCalendar date_nais;
    private int numero = 0;
    private static int numInstance;

    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        nom = n.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String p) {
        prenom = p.toLowerCase();
    }

    public GregorianCalendar getDate_nais() {
        return date_nais;
    }

    public void setDate_nais(GregorianCalendar date_nais) {
        this.date_nais = date_nais;
    }

    public int getNumero() {
        return numero;
    }

    public static int getNbInstances() {
        return numInstance;
    }

    public Personne() {
        nom = "";
        prenom = "";
        date_nais = new GregorianCalendar(1900, 01, 01);
        numInstance++;
        numero = numInstance;
    }

    public Personne(String n, String p, GregorianCalendar d) {
        nom = n;
        prenom = p;
        date_nais = d;
        numInstance++;
        numero = numInstance;
    }

    // @Override
    // protected void finalize() throws Throwable
    // {
    //     System.out.print("\u2020");
    //     super.finalize();
    // }

    @Override
    public String toString() {
        Date dateNais = date_nais.getTime();
        SimpleDateFormat formattedDateNais = new SimpleDateFormat("dd/MMM/YYYY");
        String dateNaisFormatted = formattedDateNais.format(dateNais);

        final StringBuilder sb = new StringBuilder("Personne{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", date_nais=").append(dateNaisFormatted);
        sb.append(", numero=").append(numero);
        sb.append('}');
        return sb.toString();
    }
}

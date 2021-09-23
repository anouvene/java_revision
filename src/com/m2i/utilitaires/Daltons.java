package com.m2i.utilitaires;

public enum Daltons {
    JOE(1.40, 52),
    WILLIAM(1.68, 72),
    JACK(1.93, 83),
    AVERELL(2.13, 89);

    private final double taille;
    private final double poids;

    private Daltons(double t, double p) {
        this.taille = t;
        this.poids = p;
    }

    public double getTaille() {
        return taille;
    }

    public double getPoids() {
        return poids;
    }

    public double imc() {
        return this.poids / 2 * this.taille;
    }
}

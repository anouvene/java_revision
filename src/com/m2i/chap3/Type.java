package com.m2i.chap3;

public enum Type {
    P("Particulier"),
    E("Entreprise"),
    F("Fournisseur");

    private String nomType;

    Type(String nomType) {
        this.nomType = nomType;
    }

    public String getNomType() {
        return nomType;
    }

}

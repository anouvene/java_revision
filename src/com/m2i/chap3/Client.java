package com.m2i.chap3;

import java.util.GregorianCalendar;

public class Client extends Personne {
    public Type clientType;

    public Client(String n, String p, GregorianCalendar d, String type) {
        super(n, p, d);
        this.clientType = Type.valueOf(type);
    }

    public Type getClientType() {
        return clientType;
    }

    public void setClientType(Type clientType) {
        this.clientType = clientType;
    }

    @Override
    public boolean equals(Object obj) {
        Client c;
        // verification si obj est null ou refÈrence une instance
        // d'une autre classe
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            c = (Client) obj;
            // verification des criteres d'egalite sur
            // - le nom
            // - le prenom
            // - la date de naissance
            // - le type de client
            if (c.getNom().equals(getNom())
                    & c.getPrenom().equals(getPrenom())
                    & c.getDate_nais().equals(getDate_nais())
                    & c.getClientType() == getClientType()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return this.getNom().hashCode()
                + this.getPrenom().hashCode()
                + this.getDate_nais().hashCode()
                + this.getClientType().hashCode();
    }


    @Override
    public String toString() {
        StringBuilder p = new StringBuilder(super.toString());
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("clientType=").append(clientType.name());
        sb.append('}');
        return p.append("\n").toString().concat(sb.toString());
    }
}

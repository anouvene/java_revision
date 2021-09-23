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
    public String toString() {
        StringBuilder p = new StringBuilder(super.toString());
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("clientType=").append(clientType.name());
        sb.append('}');
        return p.append("\n").toString().concat(sb.toString());
    }
}

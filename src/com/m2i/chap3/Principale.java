package com.m2i.chap3;

import java.util.GregorianCalendar;

public class Principale {
    public static void main(String[] args) throws CloneNotSupportedException {
        Client c;
        c = new Client("ENI","", new GregorianCalendar(1981,05,15),"E");

        // Affichage infos client
        System.out.println(c);

        // Creation et initialisation d'une commande
        Commande cmd1, cmd2;
        cmd1 = new Commande();
        cmd1.setLeClient(c);

        System.out.println("hashCode de la commande cmd1 : " +cmd1.hashCode());
        System.out.println("hashCode du Client de cmd1 : " +cmd1.getLeClient().hashCode());
        System.out.println("hashCode des lignes de commandes liées à cmd1 : " +cmd1.getLesLignes().hashCode() + "\n");

        // Commande cmd2 est une clone de cmd1
        cmd2 = (Commande) cmd1.clone();
        System.out.println("hashCode cmd2 clone de cdm1 : " +cmd2.hashCode());
        System.out.println("hashCode du Client de cmd2 : " +cmd2.getLeClient().hashCode());
        System.out.println("hashCode des lignes de commandes clonées et liées à cmd2 : "+cmd2.getLesLignes().hashCode());

    }
}

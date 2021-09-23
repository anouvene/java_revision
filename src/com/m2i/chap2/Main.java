package com.m2i.chap2;

import com.m2i.utilitaires.Daltons;

import java.time.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //=====================
        // ENUMERATION
        // Test de la classe Enum (java.lang.Enum)
        //=====================

        // Méthode toString
        System.out.println("le plus petit des daltons est : " + Daltons.JOE); // JOE

        // Méthode valueOf, maniere plus elegante d'acceder a un element de l'enum
        Daltons joe = Daltons.valueOf("JOE");
        System.out.println("\nInfos sur " + joe.toString() + " : "); // JOE
        System.out.println("- Taille : " + joe.getTaille()); // 1.4
        System.out.println("- Poids : " + joe.getPoids()); // 52.0

        // Méthode values, tableau contenant toutes les valeurs de l'enum
        System.out.println("\nTous les daltons :");
        for(Daltons d : Daltons.values()) {
            System.out.println(d);
        }

        //=====================
        // TABLEAUX
        //=====================
        // Declaration
        int[] chiffeAffaire;

        // Initialisation et affectation
        chiffeAffaire = new int[5];
        chiffeAffaire[0] = 1234;
        chiffeAffaire[1] = 563;


        // Declaration bis + Initialisation + affectation
        int[] chiffeAffaireBis = {1234, 563};

        // Afficher les elems d'un tableau avec Arrays.toString()
        System.out.println("Chiffre d'affaire : " + Arrays.toString(chiffeAffaire)); // [1234, 563, 0, 0, 0]
        System.out.println("Chiffre d'affaire bis: " + Arrays.toString(chiffeAffaireBis)); // [1234, 563]

        // Une exception de type ArrayIndexOutOfBoundException peut se declencher si depassement

        // Tableau a plusieurs dimension
        // Declaration tableau a 2 dimensions
        double[][] taillesPoids = new double[2][4]; // 2 lignes & 3 colonnes
        // Remplir 4 colonnes de la ligne 0
        taillesPoids[0][0] = 1.40;
        taillesPoids[0][1] = 1.68;
        taillesPoids[0][2] = 1.93;
        taillesPoids[0][3] = 2.13;
        // Remplir 4 colonnes de la ligne 1
        taillesPoids[1][0] = 52;
        taillesPoids[1][1] = 72;
        taillesPoids[1][2] = 83;
        taillesPoids[1][3] = 89;
        // Afficher les elems d'un tableau 2D avec Arrays.deepToString()
        System.out.println("\nTailles  et poids: " + Arrays.deepToString(taillesPoids)); // [[1.4, 1.68, 1.93, 2.13], [52.0, 72.0, 83.0, 89.0]]
        // Taille du tableau
        System.out.println("\nTailles du tableau: " + taillesPoids.length); // 2

        // Declaration simplifiee d'un tableau 2D
        double[][] taillesPoidsBis = {{1.40, 1.68, 1.93}, {52, 72, 83, 89}};
        System.out.println("\nTailles et poids bis : " + Arrays.deepToString(taillesPoidsBis)); // [[1.4, 1.68, 1.93, 2.13], [52.0, 72.0, 83.0, 89.0]]
        System.out.println(String.format("Nb elements sur la ligne 0 du tableau est %d: ", taillesPoidsBis[1].length));

        //=====================
        // STRING
        //=====================
        String ch1 = new String("Bonjour le monde");
        ch1 = "toto";
        System.out.println(ch1);

        String chaine = "Une chaine de caractères";
        Boolean booleen = true;
        int entier = 2;
        double decimal = 3.9;

        String chaine_format = String.format("Voici une chaine formatée:  %n" +
                "%s %n" +
                "%b %n" +
                "%d %n" +
                "%f %n", chaine, booleen, entier, decimal );
        System.out.println(chaine_format);


        //=====================
        // DATE HEURE
        //=====================
        LocalDateTime maintenant = LocalDateTime.now();
        System.out.println("Date heure sans fuseau: " + maintenant);

        OffsetDateTime ajourdhui = OffsetDateTime.of(maintenant, ZoneOffset.UTC);
        System.out.println("Date heure avec fuseau: " + ajourdhui);

        ZoneId zoneFR = ZoneId.of("Europe/Paris");
        ZonedDateTime zdt = ZonedDateTime.of(maintenant, zoneFR);
        System.out.println("Date Zone FR: " + zdt);

        // Opérateurs
        LocalTime horloge = LocalTime.parse("10:10:20");
        LocalTime nouvelleHeure = horloge.withHour(6); // 06:10:20
        System.out.println(nouvelleHeure);

        LocalDate aujourdhui = LocalDate.of(2021, 9, 19);
        LocalDate dateDansDouzeJours = aujourdhui.plusDays(12);
        System.out.println(dateDansDouzeJours);

        LocalDate jourMatch = LocalDate.of(2015, 12, 20);
        LocalTime heureMatch = LocalTime.of(21, 00);
        LocalDateTime match = jourMatch.atTime(heureMatch);
        System.out.println(match);

    }
}
